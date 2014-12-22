package com.basic;

import java.io.InputStream;
import java.io.PrintStream;
import midisystem.MidiSynthSystem;
import midisystem.TrackMaker;

/**
 * SEQ based on DATA Statement
 */
class SEQStatement extends Statement
{
    String arg;
    VariableExpression ve;
    
    SEQStatement(LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(SEQ);

        parse(this, lt);
    }

    @Override
    Statement doit(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        if (ve != null)
            arg = ve.stringValue(pgm);
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
     * Parse SEQ Statement.
     */
    private static void parse(SEQStatement s, LexicalTokenizer lt) throws BASICSyntaxError
    {
        Token t = lt.nextToken();
        System.out.println (t);
        if (t.typeNum() == Token.STRING)
        {
            s.arg = t.stringValue();
            return;
        }
        else if (t.typeNum() == Token.VARIABLE)
        {
            s.ve = new VariableExpression((Variable)t);
            return;
        }
        throw new BASICSyntaxError("Only Sound String allowed.");
    }
}
