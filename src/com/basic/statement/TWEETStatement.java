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
    private Vector args;

    public TWEETStatement (LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(KeyWords.TWEET);
        if (lt.getBuffer() != null)
            parse(this, lt);
    }

    public Statement doit(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        String sss = StringExParser.printItemsToString (pgm, args);
        TwitTools.sendLongString (sss);
        return pgm.nextStatement(this);
    }

    public String unparse()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(keyword.name());
        sb.append(" ");
        for (int i = 0; i < args.size(); i++)
        {
            PrintItem pi = (PrintItem) (args.elementAt(i));
            sb.append(pi.unparse());
        }
        return sb.toString();
    }


    private static void parse(TWEETStatement s, LexicalTokenizer lt) throws BASICSyntaxError
    {
        s.args = StringExParser.parseStringExpression(lt);
    }

}
