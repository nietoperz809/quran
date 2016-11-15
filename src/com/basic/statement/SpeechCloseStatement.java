package com.basic.statement;

import com.basic.*;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by Administrator on 6/10/2016.
 */
public class SpeechCloseStatement extends Statement
{
    /**
     * CLC command
     * @param lt
     * @throws BASICSyntaxError
     */
    public SpeechCloseStatement (LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(com.basic.KeyWords.SPCLOSE);
    }

    @Override
    public Statement doit (Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        pgm.unsetVoiceFilename();
        return pgm.nextStatement(this);
    }
}
