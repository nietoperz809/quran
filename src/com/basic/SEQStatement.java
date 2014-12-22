package com.basic;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import midisystem.MidiSynthSystem;
import midisystem.TrackMaker;

/**
 * SEQ based on DATA Statement
 */
class SEQStatement extends Statement
{
    String arg;
    
    SEQStatement(LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(SEQ);

        parse(this, lt);
    }

    @Override
    Statement doit(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        //System.out.println (arg);
        TrackMaker tm = new TrackMaker (MidiSynthSystem.get());
        try
        {
            tm.fromString(arg);
        }
        catch (Exception ex)
        {
           throw new BASICRuntimeError ("Bogus Sequence string");
        }
        return pgm.nextStatement(this);
    }

    @Override
    String unparse()
    {
        return "SEQ "+arg;
    }

    /**
     * Parse DATA Statement.
     */
    private static void parse(SEQStatement s, LexicalTokenizer lt) throws BASICSyntaxError
    {
        Token t = lt.nextToken();
        if (t.typeNum() != Token.STRING)
        {
            throw new BASICSyntaxError("Only Sound String allowed.");
        }
        s.arg = t.stringValue();
    }
}
