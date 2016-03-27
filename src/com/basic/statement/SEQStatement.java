package com.basic.statement;

import java.io.InputStream;
import java.io.PrintStream;

import com.basic.*;
import midisystem.MidiSynthSystem;
import midisystem.TrackMaker;

/**
 * SEQ based on DATA Statement
 */
class SEQStatement extends Statement
{
    String arg;
    int channel;
    VariableExpression ve;
    
    SEQStatement(LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(KeyWords.SEQ);

        parse(this, lt);
    }

    @Override
    Statement doit(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        if (ve != null)
            arg = ve.stringValue(pgm);
        TrackMaker tm = new TrackMaker (MidiSynthSystem.get(), channel);
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
     * Parse SEQ Statement.
     */
    private static void parse(SEQStatement s, LexicalTokenizer lt) throws BASICSyntaxError
    {
        Token t = lt.nextToken();
        if (t.typeNum() != KeyWords.CONSTANT)
        {
            throw new BASICSyntaxError("Channel number missing.");
        }
        s.channel = (int) t.numValue();
        t = lt.nextToken();
        if (t.typeNum() != KeyWords.SYMBOL || t.nValue != ',')
        {
            throw new BASICSyntaxError("Comma expected.");
        }
        t = lt.nextToken();
        if (t.typeNum() == KeyWords.STRING)
        {
            s.arg = t.stringValue();
            return;
        }
        else if (t.typeNum() == KeyWords.VARIABLE)
        {
            s.ve = new VariableExpression((Variable)t);
            return;
        }
        throw new BASICSyntaxError("Only Sound String allowed.");
    }
}
