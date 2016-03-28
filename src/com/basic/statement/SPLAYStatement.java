/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.statement;

import java.io.InputStream;
import java.io.PrintStream;

import com.basic.*;
import midisystem.MidiSynthSystem;

/**
 *
 * @author Administrator
 */
public class SPLAYStatement extends Statement
{
    int repeats = 0;
    /**
     * CLC command
     * @param lt
     * @throws BASICSyntaxError
     */
    public SPLAYStatement (LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(KeyWords.SPLAY);
        if (lt.getBuffer() != null)
        {
            Token t = lt.nextToken();
            if (t.type == KeyWords.EOL)
                return;
            if (t.type == KeyWords.CONSTANT)
                repeats = (int) t.nValue - 1;
            System.out.println(t);
        }
    }

    @Override
    public Statement doit(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        if (repeats > 0)
            MidiSynthSystem.get().setLoops(repeats);
        MidiSynthSystem.get().start();
        try
        {
            MidiSynthSystem.get().waitUntilEnd();
        }
        catch (InterruptedException ex)
        {
            throw new BASICRuntimeError ("WaitUntilEnd failed");
        }
        return pgm.nextStatement(this);
    }

    @Override
    public String unparse()
    {
        return "SPLAY";
    }
}
