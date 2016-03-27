/*
 * GOTOStatement.java - Implement the GOTO Statement.
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

import com.basic.*;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * The GOTO statement.
 *
 * The GOTO statement unconditionally tranfers control to a non-linear sequence
 * in the program. The destination is indicated by a line number.
 *
 * Syntax : GOTO line
 *
 * Syntax Errors: Line number required.
 *
 * Runtime Errors: Non-existent line number.
 */
class GOTOStatement extends Statement
{
    // This is the line number to transfer control too.
    int lineTarget;

    GOTOStatement(LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(KeyWords.GOTO);

        parse(this, lt);
    }

    @Override
    Statement doit(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        Statement s;
        s = pgm.getStatement(lineTarget);
        if (s != null)
        {
            return s;
        }
        throw new BASICRuntimeError("GOTO non-existent line " + lineTarget + ".");
    }

    @Override
    String unparse()
    {
        return "GOTO " + lineTarget;
    }

    /**
     * Parse GOTO Statement.
     */
    private static void parse(GOTOStatement s, LexicalTokenizer lt) throws BASICSyntaxError
    {
        Token t = lt.nextToken();
        if (t.typeNum() != KeyWords.CONSTANT)
        {
            throw new BASICSyntaxError("Line number required after GOTO.");
        }
        s.lineTarget = (int) t.numValue();
    }

}
