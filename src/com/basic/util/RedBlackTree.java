/*
 * @(#)RedBlackTree.java	1.1 95/09/14
 *
 * Copyright (c) 1996 Chuck McManis, All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL purposes and without
 * fee is hereby granted provided that this copyright notice
 * appears in all copies.
 *
 * CHUCK MCMANIS MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY
 * OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. CHUCK MCMANIS SHALL NOT BE
 * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 * MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
package com.basic.util;

import java.util.Dictionary;
import java.util.Enumeration;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * This class implements a Dictionary using a B-tree. This exact type of tree is
 * called a "red-black" tree since it uses a color algorithim to insure that it
 * is always balanced. Note that the key object must be an object of class
 * String for this class. This is because the implementation uses compareTo() to
 * determine if a node should be on the right or left hand branch.
 *
 * @author	Chuck McManis
 * @version	1.1, 14 Sep 1995
 * @param <K>
 * @param <V>
 * @see	Dictionary
 */
public class RedBlackTree<K,V> implements Serializable
{
    public static final long serialVersionUID = 1L;
    private final SortedMap<K,V> map = new TreeMap<>();

    public RedBlackTree(Comparator c)
    {
        //cmp = c;
    }

    public RedBlackTree()
    {
        //cmp = new XStringCompare();
    }

    /**
     * Return an enumeration of the trees keys. This will return the keys in
     * sorted order as it does an inorder walk from the minimum valued key to
     * the maximum valued key.
     */
    public Enumeration keys()
    {
        return Collections.enumeration(map.keySet());        
    }

    /**
     * Return an enumeration of the trees objects. This will return the elements
     * in sorted order as it does an inorder walk from minimum key to the
     * maximum key.
     */
    public Enumeration elements()
    {
        return Collections.enumeration(map.entrySet());        
    }

    /**
     * Return the value for a given key.
     * @param key
     * @return 
     */
    public V get(K key)
    {
        return map.get(key);
    }

    /**
     * Add a new object to the tree. Note that if there is already a node in the
     * tree with this key value, the old value is replaced with the new value.
     * The old value is returned. If no previous node exists, this returns null.
     * @param key
     * @param value
     * @return 
     */
    public V put (K key, V value)
    {
        return map.put(key, value);
    }

    /**
     * Remove an object from the tree. This returns null if the key did not
     * reference an object in the tree.
     * @param key
     * @return 
     */
    public V remove(K key)
    {
        return map.remove(key);
    }

    /**
     * Return the successor object to the named object.
     * @param key
     * @return 
     */
    public V next(K key)
    {
        Set<K> keySet = map.keySet();
        boolean flag = false;
        for (K o : keySet)
        {
            if (flag == true)
                return (V)map.get(o);
            if (o.equals(key))
                flag = true;
        }
        return null;
    }

    /**
     * Return the predecessor value to the named object.
     * @param key
     * @return 
     */
    public V prev(K key)
    {
        Set<K> keySet = map.keySet();
        Object before = null;
        for (K o : keySet)
        {
            if (o.equals(key))
                break;
            before = o;
        }
        return (V)before;
    }
}


