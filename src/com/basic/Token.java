/*
 * Token.java = one basic token.
 *
 * Copyright (c) 1996 Chuck McManis, All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL purposes and without
 * fee is hereby granted provided that this copyright notice
 * appears in all copies.
 *
 * CHUCK MCMANIS MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
 * SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. CHUCK MCMANIS
 * SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT
 * OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
package com.basic;

import java.io.Serializable;

/**
 * This class is the representation of a single token in the BASIC environment.
 */
public class Token implements Serializable
{
    /**
     *
     */
    public static final long serialVersionUID = 1L;
    
    static boolean isSymbol(Token t, char s)
    {
        return ((t != null) && (t.typeNum() == KeyWords.SYMBOL) && (t.numValue() == s));
    }

    /**
     *
     */
    protected KeyWords type;     // this token's type

    /**
     *
     */
    protected double nValue;     // Its numeric value (if it has one)

    /**
     *
     */
    protected String sValue;     // Its string value (if it has one)

    protected KeyWords kwValue;
    
    /**
     *
     */
    protected Token()
    {
    }

    /**
     * Create a token with a numeric value.
     */
    Token (KeyWords t, double nv)
    {
        type = t;
        nValue = nv;
    }

    /**
     * Create a token with a string value.
     */
    Token (KeyWords t, String sv)
    {
        type = t;
        sValue = sv;
    }

    /**
     * For operators, create token with numeric value.
     */
    Token (KeyWords t, int v)
    {
        type = t;
        nValue = v;
    }

    /**
     * Create a token with both a string and a numeric value.
     */
    Token (KeyWords t, String sv, int iv)
    {
        type = t;
        sValue = sv;
        nValue = iv;
    }

    Token (KeyWords t, KeyWords kw)
    {
        type = t;
        kwValue = kw;
        sValue = kw.toString();
        nValue = kw.ordinal();
    }
    
    double numValue()
    {
        return nValue;
    }

    String stringValue()
    {
        return sValue;
    }

    KeyWords typeNum()
    {
        return type;
    }

    String typeString()
    {
        return type.toString();
    }

    String unparse()
    {
        switch (type)
        {
            case STRING:
                return "\"" + sValue + "\"";
            case CONSTANT:
                return "" + nValue;
            default:
                return "Token (" + type.toString() + ")";
        }
    }

    @Override
    public String toString()
    {
        return ("TOKEN: Type=" + type.toString() + ", Numeric Value = " + nValue + ", String Value = '" + sValue + "'");
    }

    boolean isSymbol(char c)
    {
        return isSymbol(this, c);
    }

    boolean isOp(KeyWords op)
    {
        return ((type == KeyWords.OPERATOR) && kwValue == op); //((int) nValue == op));
    }

    void negate()
    {
        if (type != KeyWords.CONSTANT)
        {
            return;
        }
        nValue = -nValue;
    }

}
