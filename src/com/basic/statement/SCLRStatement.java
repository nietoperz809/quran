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
public class SCLRStatement extends Statement
{
    /**
     * CLC command
     * @param lt
     * @throws BASICSyntaxError
     */
    public SCLRStatement (LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(KeyWords.SCLR);
    }

    @Override
    public Statement doit(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
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

    public String unparse()
    {
        return "SCLR";
    }
}
