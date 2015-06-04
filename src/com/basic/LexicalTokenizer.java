/*
 * LexicalTokenizer.java -  Parse the input stream into tokens.
 *
 * Copyright (c) 1996 Chuck McManis, All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL purposes and without
 * fee is hereby granted provided that this copyright notice
 * appears in all copies.
 *
 * CHUCK MCMANIS MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
 * SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. CHUCK MCMANIS
 * SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT
 * OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
package com.basic;

import java.io.Serializable;
import java.util.EnumSet;
import java.util.Vector;

/**
 * This class parses the keywords and symbols out of a line of BASIC code (or
 * command line) and returns them as tokens. Each tokenizer maintains state on
 * where it is in the process.
 */
public class LexicalTokenizer implements Serializable
{
    public static final long serialVersionUID = 1L;
    // multiple expressions can be chained with these operators
    
    final public static EnumSet<KeyWords> boolTokens = 
            EnumSet.of(KeyWords.OP_BAND, KeyWords.OP_BIOR, KeyWords.OP_BXOR, KeyWords.OP_BNOT);    

    /**
     * return true if char is between a-z or A=Z
     */
    static boolean isLetter(char c)
    {
        return (((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z')));
    }

    /**
     * Return true if char is between 0 and 9
     */
    static boolean isDigit(char c)
    {
        return ((c >= '0') && (c <= '9'));
    }

    /**
     * Return true if char is whitespace.
     */
    static boolean isSpace(char c)
    {
        return ((c == ' ') || (c == '\t'));
    }

    int currentPos = 0;
    int previousPos = 0;
    int markPos = 0;
    char buffer[];
    // we just keep this around 'cuz we return it a lot.
    Token EOLToken = new Token(Token.EOL, 0);

    public LexicalTokenizer(char data[])
    {
        buffer = data;
        currentPos = 0;
    }

    /**
     * Returns true if there are more tokens to be returned.
     */
    boolean hasMoreTokens()
    {
        return currentPos < buffer.length;
    }

    /**
     * Set's the current "mark" so that the line can be re-parsed from this
     * point.
     */
    void mark()
    {
        markPos = currentPos;
    }

    /**
     * Reset the line pointer to the mark for reparsing.
     */
    void resetToMark()
    {
        currentPos = markPos;
    }

    /**
     * Reset the tokenizer with a new data buffer.
     */
    void reset(char buf[])
    {
        buffer = buf;
        currentPos = 0;
    }

    /**
     * Reset the current buffer to zero.
     */
    void reset()
    {
        currentPos = 0;
    }

    /**
     * Reset the tokenizer by first filling its data buffer with the passed in
     * string, then reset the mark to zero for parsing.
     */
    void reset(String x)
    {
        int l = x.length();
        for (int i = 0; i < l; i++)
        {
            buffer[i] = x.charAt(i);
        }
        buffer[l] = '\n'; // mark the end of the line.
        currentPos = 0;
    }

    /**
     * Given that there has been an error, return the string in the buffer and a
     * line of dashes (-) followed by a caret (^) at the current position. This
     * indicates where the tokenizer was when the error occured.
     */
    String showError()
    {
        int errorPos = previousPos;
        currentPos = 0;
        String txt = asString();
        StringBuilder sb = new StringBuilder();
        sb.append(txt).append("\n");
        for (int i = 0; i < errorPos; i++)
        {
            sb.append('-');
        }
        sb.append('^');
        return sb.toString();
    }

    /**
     * Give back the last token, basically a reset to this token's start. This
     * function is used extensively by the parser to "peek" ahead in the input
     * stream.
     */
    void unGetToken()
    {
        if (currentPos != previousPos)
        {
            currentPos = previousPos;
        }
    }


    /**
     * Check the input stream to see if it is one of the boolean operations.
     */
//    Token parseBooleanOp()
//    {
//        int oldPos = currentPos;
//        StringBuffer sb = new StringBuffer();
//        int len = 0;
//        Token r = null;
//
//        if (buffer[currentPos] != '.')
//        {
//            return null;
//        }
//        sb.append('.');
//        currentPos++;
//        do
//        {
//            sb.append(buffer[currentPos + len]);
//            len++;
//        }
//        while ((len < 7) && isLetter(buffer[currentPos + len]));
//        if (buffer[currentPos + len] == '.')
//        {
//            sb.append('.');
//            len++;
//            String x = sb.toString();
//            for (int i = 0; i < boolOps.length; i++)
//            {
//                if (x.equalsIgnoreCase(boolOps[i]))
//                {
//                    r = new Token(Token.OPERATOR, boolOps[i], boolTokens[i]);
//                    break;
//                }
//            }
//            if (r != null)
//            {
//                currentPos += len;
//                return r;
//            }
//        }
//        currentPos = oldPos;
//        return null;
//    }
    Token parseBooleanOp()
    {
        int oldPos = currentPos;
        StringBuilder sb = new StringBuilder();
        int len = 0;
        Token r = null;

        do
        {
            sb.append(buffer[currentPos + len]);
            len++;
        }
        while (isLetter(buffer[currentPos + len]));
        if (true)
        {
            String x = sb.toString();
            for (KeyWords k : boolTokens)
            {
                if (x.equalsIgnoreCase(k.toString()))
                {
                    r = new Token(Token.OPERATOR, k.toString(), k.ordinal());
                    break;
                }
            }
            if (r != null)
            {
                currentPos += len;
                return r;
            }
        }
        currentPos = oldPos;
        return null;
    }

    /**
     * This method will attempt to parse out a numeric constant. A numeric
     * constant satisfies the form: 999.888e777 where '999' is the optional
     * integral part. where '888' is the optional fractional part. and '777' is
     * the optional exponential part. The '.' and 'E' are required if the
     * fractional or exponential part are present, there can be no internal
     * spaces in the number. Note that unary minuses are always stripped as a
     * symbol.
     *
     * Also note that until the second character is read .5 and .and. appear to
     * start similarly.
     */
    Token parseNumericConstant()
    {
        double m = 0;   // Mantissa
        double f = 0;   // Fractional component
        int oldPos = currentPos; // save our place.
        boolean wasNeg = false;
        boolean isConstant = false;
        //Token r = null;

        // Look for the integral part.
        while (isDigit(buffer[currentPos]))
        {
            isConstant = true;
            m = (m * 10.0) + (buffer[currentPos++] - '0');
        }

        // Now look for the fractional part.
        if (buffer[currentPos] == '.')
        {
            currentPos++;
            double t = .1;
            while (isDigit(buffer[currentPos]))
            {
                isConstant = true;
                f += (t * (buffer[currentPos++] - '0'));
                t /= 10.0;
            }
        }

        m = (m + f);
        /*
         * If we parse no mantissa and no fractional digits, it can't be a
         * numeric constant now can it?
         */
        if (!isConstant)
        {
            currentPos = oldPos;
            return null;
        }

        // so it was a number, perhaps we are done with it.
        if ((buffer[currentPos] != 'E') && (buffer[currentPos] != 'e'))
        {
            return new Token(Token.CONSTANT, m); // no exponent return value.
        }
        currentPos++; // skip over the 'e'

        int p = 0;
        double e;
        wasNeg = false;

        // check for negative exponent.
        if (buffer[currentPos] == '-')
        {
            wasNeg = true;
            currentPos++;
        }
        else if (buffer[currentPos] == '+')
        {
            currentPos++;
        }

        while (isDigit(buffer[currentPos]))
        {
            p = (p * 10) + (buffer[currentPos++] - '0');
        }

        try
        {
            e = Math.pow(10, p);
        }
        catch (ArithmeticException zzz)
        {
            return new Token(Token.ERROR, "Illegal numeric constant.");
        }

        if (wasNeg)
        {
            e = 1 / e;
        }
        return new Token(Token.CONSTANT, (m + f) * e);
    }

    /**
     * This is the meat of this class, return the "next" token from the current
     * tokenizer buffer. If the token isn't recognized an ERROR token will be
     * returned.
     */
    Token nextToken()
    {
        Token r;
        // if we recurse then we need to know what the position was
        int savePos = currentPos;
        /*
        * Always return a token, even if it is just EOL
        */
        if (currentPos >= buffer.length)
        {
            return EOLToken;
        }
        /*
        * Save our previous position for unGetToken() to work.
        */
        previousPos = currentPos;
        /*
        * eat white space.
        */
        while (isSpace(buffer[currentPos]))
        {
            currentPos++;
        }
        /*
         * Start by checking all of the special characters.
         */
        switch (buffer[currentPos])
        {
            // Various lexical symbols that have meaning.
            case '+':
                currentPos++;
                return new Token(Token.OPERATOR, "+", KeyWords.OP_ADD.ordinal());
            case '-':
                currentPos++;
                return new Token(Token.OPERATOR, "-", KeyWords.OP_SUB.ordinal());
            case '*':
                if (buffer[currentPos + 1] == '*')
                {
                    currentPos += 2;
                    return new Token(Token.OPERATOR, "**", KeyWords.OP_EXP.ordinal());
                }
                currentPos++;
                return new Token(Token.OPERATOR, "*", KeyWords.OP_MUL.ordinal());
            case '/':
                currentPos++;
                return new Token(Token.OPERATOR, "/", KeyWords.OP_DIV.ordinal());
            case '^':
                currentPos++;
                return new Token(Token.OPERATOR, "^", KeyWords.OP_XOR.ordinal());
            case '&':
                currentPos++;
                return new Token(Token.OPERATOR, "&", KeyWords.OP_AND.ordinal());
            case '|':
                currentPos++;
                return new Token(Token.OPERATOR, "|", KeyWords.OP_IOR.ordinal());
            case '!':
                currentPos++;
                return new Token(Token.OPERATOR, "!", KeyWords.OP_NOT.ordinal());
            case '=':
                currentPos++;
                return new Token(Token.OPERATOR, "=", KeyWords.OP_EQ.ordinal());
            case '<':
                if (buffer[currentPos + 1] == '=')
                {
                    currentPos += 2;
                    return new Token(Token.OPERATOR, "<=", KeyWords.OP_LE.ordinal());
                }
                else if (buffer[currentPos + 1] == '>')
                {
                    currentPos += 2;
                    return new Token(Token.OPERATOR, "<>", KeyWords.OP_NE.ordinal());
                }
                currentPos++;
                return new Token(Token.OPERATOR, "<", KeyWords.OP_LT.ordinal());
            case '>':
                if (buffer[currentPos + 1] == '=')
                {
                    currentPos += 2;
                    return new Token(Token.OPERATOR, ">=", KeyWords.OP_GE.ordinal());
                }
                else if (buffer[currentPos + 1] == '<')
                {
                    currentPos += 2;
                    return new Token(Token.OPERATOR, "<>", KeyWords.OP_NE.ordinal());
                }
                currentPos++;
                return new Token(Token.OPERATOR, ">", KeyWords.OP_GT.ordinal());
            case '(':
            case '\'':
            case '?':
            case ')':
        case ':':
        case ';':
            case ',':
                return new Token(Token.SYMBOL, buffer[currentPos++]);
                //            case '.':
//                r = parseBooleanOp();
//                if (r != null)
//                {
//                    return r;
//                }
                /* Else we fall through to the next CASE (numeric constant) */
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            r = parseNumericConstant();
            if (r != null)
                {
                    return r;
                }
            return new Token(Token.SYMBOL, buffer[currentPos++]);
            // process EOL characters. (dump <CR><LF> as just EOL)
        case '\r':
        case '\n':
            while (currentPos < buffer.length)
            {
                currentPos++;
                }
                return EOLToken;
        // text enclosed in "quotes" is a string constant.
            case '"':
                StringBuilder sb = new StringBuilder();
                currentPos++;
                while (true)
                {
                    switch (buffer[currentPos])
                    {
                        case '\n':
                            return new Token(Token.ERROR, "Missing end quote.");
                        case '"':
                            if (buffer[currentPos + 1] == '"')
                            {
                                currentPos++;
                                sb.append('"');
                            }
                            else
                            {
                                currentPos++;
                                return new Token(Token.STRING, sb.toString());
                            }
                            break;
                        default:
                            sb.append(buffer[currentPos]);
                    }
                    currentPos++;
                    if (currentPos >= buffer.length)
                    {
                        return new Token(Token.ERROR, "Missing end quote.");
                    }
                }
            default:
                r = parseBooleanOp();
                if (r != null)
                {
                    return r;
                }
                break;
        }
        if (!isLetter(buffer[currentPos]))
        {
            return new Token(Token.ERROR, "Unrecognized input.");
        }
        /* compose an identifier */
        StringBuilder q = new StringBuilder();
        while (isLetter(buffer[currentPos]) || isDigit(buffer[currentPos]))
        {
            q.append(Character.toLowerCase(buffer[currentPos]));
            currentPos++;
        }
        if (buffer[currentPos] == '$' || buffer[currentPos] == '%')
        {
            q.append(buffer[currentPos++]);
        }
        String t = q.toString();
        //
        /* Is it a function name ? */
//        for (int i = 0; i < FunctionExpression.functions.length; i++)
//        {
//            if (t.compareTo(FunctionExpression.functions[i]) == 0)
//            {
//                return new Token(Token.FUNCTION, FunctionExpression.functions[i], i);
//            }
//        }
        for (KeyWords k : KeyWords.functions)
        {
            if (t.compareTo(k.toString()) == 0)
            {
                return new Token(Token.FUNCTION, k.toString(), k.ordinal());
            }
        }
        
        
        /* Is it a BASIC keyword ? */
        for (KeyWords k : KeyWords.keywords)
        {
            if (t.compareTo(k.toString()) == 0)
            {
                return new Token(Token.KEYWORD, k.toString(), k.ordinal());
            }
        }
        
        /* Is it a command ? */
        for (KeyWords k : KeyWords.commands)
        {
            if (t.compareTo(k.toString()) == 0)
            {
                return new Token(Token.COMMAND, k.toString(), k.ordinal());
            }
        }
        /*
        * It must be a variable.
        *
        * If this is an array reference, the variable name
        * will be followed by '(' index ',' index ',' index ')'
        * (one to four indices)
        */
        if (buffer[currentPos] == '(')
        {
            currentPos++;
            Vector expVec = new Vector();
            Expression expn[];

            // This line sets the maximum number of indices.
            for (int i = 0; i < 4; i++)
            {
                Expression thisE = null;
                try
                {
                    thisE = ParseExpression.expression(this);
                }
                catch (BASICSyntaxError bse)
                {
                    return new Token(Token.ERROR, "Error parsing array index.");
                }
                expVec.addElement(thisE);
                if (buffer[currentPos] == ')')
                {
                    currentPos++; // skip past the paren
                    expn = new Expression[expVec.size()]; // this recurses to us
                    for (int k = 0; k < expVec.size(); k++)
                    {
                        expn[k] = (Expression) (expVec.elementAt(k));
                    }
                    previousPos = savePos; // this is so we can "unget"
                    return new Variable(t, expn);
                }
                if (buffer[currentPos] != ',')
                {
                    return new Token(Token.ERROR, "Missing comma in array index.");
                }
                currentPos++;
            }
        }
        return new Variable(t);
    }

    /*
    * Return the buffer from the current position to the end as a string.
    */
    String asString()
    {
        int ndx = currentPos;

        while ((buffer[ndx] != '\n') && (buffer[ndx] != '\r'))
        {
            ndx++;
        }
        String result = new String(buffer, currentPos, ndx - currentPos);
        previousPos = currentPos;
        currentPos = ndx;
        return (result);
    }

}
