/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.statement;

import java.io.InputStream;
import java.io.PrintStream;

import com.basic.*;
import midisystem.Notes;

/**
 *
 * @author Administrator
 */
class NOTESStatement extends Statement
{
    /**
     * CLC command
     * @param lt
     * @throws BASICSyntaxError
     */
    NOTESStatement(LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(KeyWords.NOTES);
    }

    @Override
    Statement doit(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        out.println (new Notes().toString());
        return pgm.nextStatement(this);
    }

    @Override
    String unparse()
    {
        return "NOTES";
    }
}
