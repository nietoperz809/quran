/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.statement;

import com.basic.*;

import java.io.InputStream;
import java.io.PrintStream;

/**

 *
 * @author Administrator
 */
public class CLSStatement extends Statement
{
    /**
     * CLC command
     * @param lt
     * @throws BASICSyntaxError
     */
    public CLSStatement (LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(com.basic.KeyWords.CLS);
    }

    @Override
    public Statement doit (Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        pgm.area.setText("");
        return pgm.nextStatement(this);
    }

    @Override
    public String unparse ()
    {
        return keyword.name();
    }
}
