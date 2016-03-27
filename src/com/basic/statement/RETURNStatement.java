/*
 * RETURNStatement.java - Implement the RETURN Statement.
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
 * The RETURN statement.
 *
 * The RETURN statement transfers control to the first statement following the
 * last GOSUB to be executed. Note that if the GOSUB used a colon to combine
 * statements on a line, it is that statement that control returns to.
 *
 * Syntax: RETURN
 *
 * Syntax Errors: Extra stuff past the end of the statement.
 *
 * Runtime Errors: Return without GOSUB.
 */
class RETURNStatement extends Statement
{

    RETURNStatement(LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(KeyWords.RETURN);
    }

    @Override
    Statement doit(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        Statement s;
        try
        {
            do
            {
                s = pgm.pop();
                if ((s.keyword == KeyWords.GOSUB) || (s.keyword == KeyWords.ON_GOSUB))
                {
                    break;
                }
            }
            while (s != null);
        }
        catch (Exception ex)
        {
            throw new BASICRuntimeError("RETURN without GOSUB");
        }
        return pgm.nextStatement(s);
    }

    String unparse()
    {
        return "RETURN";
    }
}
