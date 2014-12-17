/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.util;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/**
 * This is the enumerator class. It implements the enumeration interface and is
 * very straightforward.
 *
 * Note that there is a race condition whereby an enumerator becomes "invalid"
 * should the tree be changed while it is held.
 */
public class RedBlackTreeEnumerator implements Enumeration
{
    // state for the enumerator
    private boolean keys;
    private RedBlackTree tree;
    private RedBlackTreeNode x;
    private long generation;

    /**
     * Create a new enumerator.
     */
    RedBlackTreeEnumerator(RedBlackTree tree, boolean keys)
    {
        this.tree = tree;
        this.keys = keys;
        this.x = tree.minimum();
        this.generation = tree.generation();
    }

    /**
     * Returns true if there is another element in the list.
     */
    @Override
    public boolean hasMoreElements()
    {
        return (x != null);
    }

    /**
     * Returns the next element.
     *
     * @exception NoSuchElementException thrown if it is out of elements.
     * @exception Exception thrown if the tree has been modified.
     */
    @Override
    public Object nextElement()
    {
        RedBlackTreeNode y = x;

        if (x == null)
        {
            throw new NoSuchElementException("RedBlackTreeEnumerator");
        }
        if (generation != tree.generation())
        {
            throw new NoSuchElementException(
                    "RedBlackTreeEnumerator: Tree modified during enumeration");
        }

        x = tree.successor(x);
        return ((keys) ? y.key : y.value);
    }
}
