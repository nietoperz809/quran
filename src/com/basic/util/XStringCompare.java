/*
 * StringCompare.java - A comparator for strings.
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
package com.basic.util;

public class XStringCompare implements Comparator
{
    @Override
    public int compare(Object a, Object b)
    {
        return ((String) a).compareTo((String) b);
    }

    @Override
    public boolean equals(Object a, Object b)
    {
        return compare(a, b) == 0;
    }

    @Override
    public boolean lessThan(Object a, Object b)
    {
        return compare(a, b) < 0;
    }

    @Override
    public boolean lessEqual(Object a, Object b)
    {
        return compare(a, b) <= 0;
    }

    @Override
    public boolean greaterThan(Object a, Object b)
    {
        return compare(a, b) > 0;
    }

    @Override
    public boolean greaterEqual(Object a, Object b)
    {
        return compare(a, b) >= 0;
    }
}
