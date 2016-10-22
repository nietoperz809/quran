/*
 * ParseStatment.java - Parse valid BASIC statements.
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

import com.basic.statement.*;

import java.io.InputStream;
import java.io.PrintStream;

public class ParseStatement extends Statement
{

    private ParseStatement(KeyWords x)
    {
        super(x);
    }

    final static String extraError = "extra input beyond statement end";

    /**
     * Here we implement the abstract methods of Statement, they all generate
     * errors since ParseStatement isn't a "real" statement.
     */
    public Statement doit (Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        throw new BASICRuntimeError("Attempt to execute a statement parser object.");
    }

    public String unparse ()
    {
        return "THE PARSESTATEMENT OBJECT, NOT A STATEMENT.";
    }

    public void trace(Program pgm, PrintStream ps)
    {
        ps.println("ParseStatement");
    }

    /**
     * Given a 'full' tokenizer buffer, return us a parsed statement.
     */
    public static Statement statement (LexicalTokenizer lt) throws BASICSyntaxError
    {
        // DebugOut.get().out.println("UNPARSE = '"+s.unparse()+"'");
        return doParse(lt);
    }

    /**
     * This method returns a parsed statemnet, it throws an exception if an
     * error occurred.
     */
    static Statement doParse(LexicalTokenizer lt) throws BASICSyntaxError
    {
        Statement s;
        Token t;

        t = lt.nextToken();
        if (t.typeNum() == KeyWords.SYMBOL)
        {
            switch ((int) t.numValue())
            {
                case '?':
                    s = new PRINTStatement(lt);
                    t = lt.nextToken();
                    if ((t == null) || (t.typeNum() == KeyWords.EOL))
                    {
                        return s;
                    }

                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                        return s;
                    }
                    throw new BASICSyntaxError(extraError);
                case '\'':
                    s = new REMStatement(lt);
                    return s;
                default:
                    throw new BASICSyntaxError("Illegal statement symbol start?");
            }
        }

        if (t.typeNum() == KeyWords.KEYWORD)
        {
            switch (KeyWords.values()[(int)t.numValue()])       //((int) t.numValue())
            {
                case TRON:
                    s = new TRONStatement(lt);
                    t = lt.nextToken();
                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                    }
                    else if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }

                    return s;

                case TROFF:
                    s = new TROFFStatement(lt);
                    t = lt.nextToken();
                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                    }
                    else if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }

                    return s;

                case END:
                    s = new ENDStatement(lt);
                    t = lt.nextToken();
                    if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }
                    return s;

                case RANDOMIZE:
                    s = new RANDOMIZEStatement(lt);
                    t = lt.nextToken();
                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                    }
                    else if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }
                    return s;

                case STOP:
                    s = new STOPStatement(lt);
                    t = lt.nextToken();
                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                    }
                    else if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }

                    return s;

                case DIM:
                    s = new DIMStatement(lt);
                    t = lt.nextToken();
                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                    }
                    else if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }
                    return s;

                case GOTO:
                    s = new GOTOStatement(lt);
                    t = lt.nextToken();
                    if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }
                    return s;

                case PITCH:
                    s = new PITCHStatement(lt);
                    t = lt.nextToken();
                    if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }
                    return s;

                case RATE:
                    s = new RATEStatement(lt);
                    t = lt.nextToken();
                    if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }
                    return s;
                    
                    
                case SSPEED:
                    s = new SSPEEDStatement(lt);
                    t = lt.nextToken();
                    if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }
                    return s;

                case WAKEUP:
                    s = new WAKEUPStatement(lt);
                    t = lt.nextToken();
                    if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }
                    return s;

                case SLEEP:
                    s = new SLEEPStatement(lt);
                    t = lt.nextToken();
                    if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }
                    return s;

                case GOSUB:
                    s = new GOSUBStatement(lt);
                    t = lt.nextToken();
                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                    }
                    else if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }
                    return s;

                case NOTES:
                    s = new NOTESStatement(lt);
                    t = lt.nextToken();
                    if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }
                    return s;

                case SPCLOSE:
                    s = new SpeechCloseStatement(lt);
                    t = lt.nextToken();
                    if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }
                    return s;

                case CLS:
                    s = new CLSStatement(lt);
                    t = lt.nextToken();
                    if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }
                    return s;

                case PCLS:
                    s = new PCLSStatement(lt);
                    t = lt.nextToken();
                    if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }
                    return s;

                case SPLAY:
                    s = new SPLAYStatement(lt);
                    t = lt.nextToken();
                    if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }

                    return s;

                case SCLR:
                    s = new SCLRStatement(lt);
                    t = lt.nextToken();
                    if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }

                    return s;

                case RETURN:
                    s = new RETURNStatement(lt);
                    t = lt.nextToken();
                    if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }

                    return s;

                case PRINT:
                    s = new PRINTStatement(lt);
                    t = lt.nextToken();
                    if ((t == null) || (t.typeNum() == KeyWords.EOL))
                    {
                        return s;
                    }

                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                        return s;
                    }
                    throw new BASICSyntaxError(extraError);

                case TWEET:
                    s = new TWEETStatement(lt);
                    t = lt.nextToken();
                    if ((t == null) || (t.typeNum() == KeyWords.EOL))
                    {
                        return s;
                    }

                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                        return s;
                    }
                    throw new BASICSyntaxError(extraError);

                case SPFILE:
                    s = new SpeechSaveStatement(lt);
                    t = lt.nextToken();
                    if ((t == null) || (t.typeNum() == KeyWords.EOL))
                    {
                        return s;
                    }
                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                        return s;
                    }
                    throw new BASICSyntaxError(extraError);

                case SPEAK:
                    s = new SPEAKStatement(lt);
                    t = lt.nextToken();
                    if ((t == null) || (t.typeNum() == KeyWords.EOL))
                    {
                        return s;
                    }
                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                        return s;
                    }
                    throw new BASICSyntaxError(extraError);

                case NAME:
                    s = new NAMEStatement(lt);
                    t = lt.nextToken();
                    if ((t == null) || (t.typeNum() == KeyWords.EOL))
                    {
                        return s;
                    }

                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                        return s;
                    }
                    throw new BASICSyntaxError(extraError);

                case IF:
                    s = new IFStatement(lt);
                    t = lt.nextToken();
                    if ((t != null) && (t.typeNum() != KeyWords.EOL))
                    {
                        throw new BASICSyntaxError(extraError);
                    }
                    return s;

                case PLOT:
                    s = new PLOTStatement(lt);
                    t = lt.nextToken();
                    if ((t == null) || (t.typeNum() == KeyWords.EOL))
                    {
                        return s;
                    }
                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                        return s;
                    }
                    throw new BASICSyntaxError(extraError);

                case PCIRCLE:
                    s = new PCIRCLEStatement(lt);
                    t = lt.nextToken();
                    if ((t == null) || (t.typeNum() == KeyWords.EOL))
                    {
                        return s;
                    }
                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                        return s;
                    }
                    throw new BASICSyntaxError(extraError);

                case PSQUARE:
                    s = new PSQUAREStatement(lt);
                    t = lt.nextToken();
                    if ((t == null) || (t.typeNum() == KeyWords.EOL))
                    {
                        return s;
                    }
                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                        return s;
                    }
                    throw new BASICSyntaxError(extraError);

                case PLINE:
                    s = new PLINEStatement(lt);
                    t = lt.nextToken();
                    if ((t == null) || (t.typeNum() == KeyWords.EOL))
                    {
                        return s;
                    }
                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                        return s;
                    }
                    throw new BASICSyntaxError(extraError);

                case PPRINT:
                    s = new PPRINTStatement(lt);
                    t = lt.nextToken();
                    if ((t == null) || (t.typeNum() == KeyWords.EOL))
                    {
                        return s;
                    }

                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                        return s;
                    }
                    throw new BASICSyntaxError(extraError);

                case PCOLOR:
                    s = new PCOLORStatement(lt);
                    t = lt.nextToken();
                    if ((t == null) || (t.typeNum() == KeyWords.EOL))
                    {
                        return s;
                    }

                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                        return s;
                    }
                    throw new BASICSyntaxError(extraError);

                case DATA:
                    s = new DATAStatement(lt);
                    t = lt.nextToken();
                    if ((t == null) || (t.typeNum() == KeyWords.EOL))
                    {
                        return s;
                    }

                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                        return s;
                    }
                    throw new BASICSyntaxError(extraError);

                case SEQ:
                    s = new SEQStatement(lt);
                    t = lt.nextToken();
                    if ((t == null) || (t.typeNum() == KeyWords.EOL))
                    {
                        return s;
                    }

                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                        return s;
                    }
                    throw new BASICSyntaxError(extraError);

                case RESTORE:
                    s = new RESTOREStatement(lt);
                    t = lt.nextToken();
                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                    }
                    else if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }

                    return s;

                case READ:
                    s = new READStatement(lt);
                    t = lt.nextToken();
                    if ((t == null) || (t.typeNum() == KeyWords.EOL))
                    {
                        return s;
                    }
                    else if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                        return s;
                    }
                    throw new BASICSyntaxError(extraError);

                case ON:
                    s = new ONStatement(lt);
                    t = lt.nextToken();
                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                    }
                    else if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }

                    return s;

                case REM:
                    s = new REMStatement(lt);
                    return s;

                case FOR:
                    s = new FORStatement(lt);
                    t = lt.nextToken();
                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                    }
                    else if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }

                    return s;

                case NEXT:
                    s = new NEXTStatement(lt);
                    t = lt.nextToken();
                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                    }
                    else if (t.typeNum() != KeyWords.EOL)
                    {
                        throw new BASICSyntaxError(extraError);
                    }
                    return s;

                case LET:
                    s = new LETStatement(lt);
                    t = lt.nextToken();
                    if (t.typeNum() == KeyWords.EOL)
                    {
                        return s;
                    }
                    else if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                        return s;
                    }
                    else if (t.isSymbol(')'))
                    {
                        throw new BASICSyntaxError("Mismatched parenthesis in LET statement.");
                    }
                    throw new BASICSyntaxError("Unexpected text following LET statement.");

                case INPUT:
                    s = new INPUTStatement(lt);
                    t = lt.nextToken();
                    if ((t == null) || (t.typeNum() == KeyWords.EOL))
                    {
                        return s;
                    }
                    if (t.isSymbol(':'))
                    {
                        s.nxt = statement(lt);
                        return s;
                    }
                    throw new BASICSyntaxError(extraError);

                default:
                    throw new BASICSyntaxError("Invalid keyword");
            }
        }
        else if (t.typeNum() == KeyWords.VARIABLE)
        {
            lt.unGetToken();
            s = new LETStatement(lt);
            t = lt.nextToken();
            if ((t == null) || (t.typeNum() == KeyWords.EOL))
            {
                return s;
            }
            else if (t.isSymbol(':'))
            {
                s.nxt = statement(lt);
                return s;
            }
            throw new BASICSyntaxError(extraError);

        }
        throw new BASICSyntaxError("Unrecognized statement");
    }
}
