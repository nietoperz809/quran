package com.basic.statement;

import com.basic.*;

import java.io.InputStream;
import java.io.PrintStream;

public class PCLSStatement extends Statement
{
    /**
     * CLC command
     * @param lt
     * @throws BASICSyntaxError
     */
    public PCLSStatement (LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(com.basic.KeyWords.PCLS);
    }

    @Override
    public Statement doit (Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        PLOTStatement.getPlotWindow().clear();
        return pgm.nextStatement(this);
    }

    @Override
    public String unparse ()
    {
        return keyword.name();
    }
}
