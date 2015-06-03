

/*
 */
package com.basic;

import java.io.InputStream;
import java.io.PrintStream;
import javax.sound.midi.InvalidMidiDataException;
import midisystem.MidiSynthSystem;

/**
 */
class SSPEEDStatement extends Statement
{
    // This is the line number to transfer control too.
    int speed;

    SSPEEDStatement(LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(KeyWords.SSPEED);

        parse(this, lt);
    }

    @Override
    Statement doit(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        try
        {
            MidiSynthSystem.get().setSpeed(speed);
        }
        catch (InvalidMidiDataException ex)
        {
           throw new BASICRuntimeError ("Command execution failed");
        }
        return pgm.nextStatement(this);
    }

    @Override
    String unparse()
    {
        return "SSPEED " + speed;
    }

    /**
     * Parse GOTO Statement.
     */
    private static void parse(SSPEEDStatement s, LexicalTokenizer lt) throws BASICSyntaxError
    {
        Token t = lt.nextToken();
        if (t.typeNum() != Token.CONSTANT)
        {
            throw new BASICSyntaxError("number required after SSPEED.");
        }
        s.speed = (int) t.numValue();
    }

}
