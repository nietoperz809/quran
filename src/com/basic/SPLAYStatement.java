/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic;

import java.io.InputStream;
import java.io.PrintStream;
import midisystem.MidiSynthSystem;

/**
 *
 * @author Administrator
 */
class SPLAYStatement extends Statement
{
    int repeats = 0;
    /**
     * CLC command
     * @param lt
     * @throws BASICSyntaxError 
     */
    SPLAYStatement(LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(SPLAY);
        Token t = lt.nextToken();
        if (t.type == Token.EOL)
            return;
        if (t.type == Token.CONSTANT)
            repeats = (int)t.nValue - 1;
        System.out.println (t);
    }

    @Override
    Statement doit(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        System.out.println ("Start midi");
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
    String unparse()
    {
        return "SPLAY";
    }
}