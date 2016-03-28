/*
 * BASICError.java
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

/**
 * This is the base class for errors thrown by BASIC. If you catch it
 * then you will catch all exceptions possible.
 *
 * @see BASICSyntaxError
 * @see BASICRuntimeError
 */
class BASICError extends Exception implements Ser
{
    private String msg = "None.";
    private Statement s = null;

    /** A new runtime error with message <i>errorMessage</i>.
     * @param errorMessage */
    BASICError(String errorMessage) {
        super(errorMessage);
        msg = errorMessage;
    }

    /**
     * A runtime error that occurred in <i>thisStatement</i>.
     */
    BASICError(Statement thisStatement, String errorMessage) {
        super(errorMessage);
        msg = errorMessage;
        s = thisStatement;
    }

    /**
     * Once caught, you can use this method to get a string representation
     * of the error you've caught.
     * @return 
     */
    String getMsg() {
        if (s != null)
            return (msg+"\n At line :"+s.asString());
        return msg;
    }
}