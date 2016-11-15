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
public class PITCHStatement extends Statement
{
    Expression nExpn;

    public PITCHStatement (LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(KeyWords.PITCH);
        if (lt.getBuffer() != null)
        {
            Token t = lt.nextToken();
            switch (t.typeNum())
            {
                case OPERATOR:
                case CONSTANT:
                case VARIABLE:
                    lt.unGetToken();
                    nExpn = ParseExpression.expression(lt);
                default:
                    lt.unGetToken();
            }
        }
    }

    public Statement doit(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        if (nExpn != null)
        {
            pgm.voice.setPitch((float)nExpn.value(pgm));
        }
        return pgm.nextStatement(this);
    }

    public String unparse()
    {
        if (nExpn != null)
        {
            return keyword.name() + " " + nExpn.unparse();
        }
        return null;
    }
}
