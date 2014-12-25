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
class SCLRStatement extends Statement
{
    /**
     * CLC command
     * @param lt
     * @throws BASICSyntaxError 
     */
    SCLRStatement(LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(SCLR);
    }

    @Override
    Statement doit(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        try
        {
            MidiSynthSystem.get().deleteAllTracks();
        }
        catch (Exception ex)
        {
           throw new BASICRuntimeError ("Cannot delete tracks");
        }
        return pgm.nextStatement(this);
    }

    String unparse()
    {
        return "SCLR";
    }
}
