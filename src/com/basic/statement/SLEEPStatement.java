/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.statement;

import com.basic.*;

import java.io.InputStream;
import java.io.PrintStream;

public class SLEEPStatement extends Statement
{

    // This is the line number to transfer control too.
    int lineTarget;

    public SLEEPStatement (LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(KeyWords.SLEEP);
        if (lt.getBuffer() != null)
            parse(this, lt);
    }

    @Override
    public Statement doit(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        Statement s;
        s = pgm.nextStatement(this);
        try
        {
            Thread.sleep(lineTarget);
        }
        catch (InterruptedException ex)
        {
            throw new BASICRuntimeError("SLEEP " + ex.toString());
        }
        return s;
    }

    public String unparse()
    {
        return "SLEEP " + lineTarget;
    }

    /**
     * Parse GOTO Statement.
     */
    private static void parse(SLEEPStatement s, LexicalTokenizer lt) throws BASICSyntaxError
    {
        Token t = lt.nextToken();
        if (t.typeNum() != KeyWords.CONSTANT)
        {
            throw new BASICSyntaxError("Line number required after SLEEP.");
        }
        s.lineTarget = (int) t.numValue();
    }

}
