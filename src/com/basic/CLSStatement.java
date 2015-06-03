/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic;

import java.io.InputStream;
import java.io.PrintStream;

/**
 *
 * @author Administrator
 */
class CLSStatement extends Statement
{
    /**
     * CLC command
     * @param lt
     * @throws BASICSyntaxError 
     */
    CLSStatement(LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(KeyWords.CLS);
    }

    @Override
    Statement doit(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        pgm.area.setText("");
        return pgm.nextStatement(this);
    }

    @Override
    String unparse()
    {
        return "CLS";
    }
}
