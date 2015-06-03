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
public class RATEStatement extends Statement
{
    Expression nExpn;

    RATEStatement(LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(KeyWords.RATE);
        Token t = lt.nextToken();
        switch (t.typeNum())
        {
            case Token.OPERATOR:
            case Token.CONSTANT:
            case Token.VARIABLE:
                lt.unGetToken();
                nExpn = ParseExpression.expression(lt);
            default:
                lt.unGetToken();
        }
    }

    @Override
    Statement doit(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        if (nExpn != null)
        {
            pgm.voice.setRate((float)nExpn.value(pgm));
        }
        return pgm.nextStatement(this);
    }

    String unparse()
    {
        if (nExpn != null)
        {
            return "PITCH " + nExpn.unparse();
        }
        return null;
    }
}
