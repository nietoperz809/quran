/*
 * PRINTStatement.java - Implement the PRINT Statement.
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
package com.basic.statement;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Vector;

import com.basic.*;
import twitter.TwitTools;

/**
 * The PRINT statement.
 *
 * The PRINT statement writes values out to the output stream. It can print both
 * numeric and string exressions.
 *
 * The syntax of the PRINT statement is : PRINT Expression [, Expression] | [;
 * Expression]
 *
 * Items separated by a semicolon will have no space between them, items
 * separated by a comma will have a tab inserted between them.
 *
 * Syntax Errors: Unexpected symbol in input.
 */
public class TWEETStatement extends Statement
{

    // This is the line number to transfer control too.
    Vector args;

    public TWEETStatement (LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(KeyWords.TWEET);
        if (lt.getBuffer() != null)
            parse(this, lt);
    }

    public Statement doit(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        StringBuilder buff = new StringBuilder();
        PrintItem pi = null;
        int col = 0;
        for (int i = 0; i < args.size(); i++)
        {
            String z;
            pi = (PrintItem) (args.elementAt(i));
            z = pi.value(pgm, col);
            buff.append(z);
            col += z.length();
        }
        if ((pi == null) || pi.needCR())
        {
            buff.append("\n");
        }
        TwitTools.sendLongString (buff.toString());
        return pgm.nextStatement(this);
    }

    public String unparse()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("PRINT ");
        for (int i = 0; i < args.size(); i++)
        {
            PrintItem pi = (PrintItem) (args.elementAt(i));
            sb.append(pi.unparse());
        }
        return sb.toString();
    }

    private static Vector parseStringExpression(LexicalTokenizer lt) throws BASICSyntaxError
    {
        Vector result = new Vector();
        Token t;

        while (true)
        {
            t = lt.nextToken();
            switch (t.typeNum())
            {
                case CONSTANT:
                case FUNCTION:
                case VARIABLE:
                case STRING:
                case OPERATOR:
                    lt.unGetToken();
                    result.addElement(new PrintItem(PrintItem.EXPRESSION, ParseExpression.expression(lt)));
                    break;
                case SYMBOL:
                    switch ((int) t.numValue())
                    {
                        case '(':
                            lt.unGetToken();
                            result.addElement(new PrintItem(PrintItem.EXPRESSION, ParseExpression.expression(lt)));
                            break;
                        case ';':
                            result.addElement(new PrintItem(PrintItem.SEMI, null));
                            break;
                        case ',':
                            result.addElement(new PrintItem(PrintItem.TAB, null));
                            break;
                        default:
                            lt.unGetToken();
                            return result;
                    }
                    break;
                case EOL:
                    return result;
                default:
                    lt.unGetToken();
                    return result;
            }
        }
    }

    private static void parse(TWEETStatement s, LexicalTokenizer lt) throws BASICSyntaxError
    {
        s.args = parseStringExpression(lt);
    }

}