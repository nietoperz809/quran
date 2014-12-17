/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.util;

import java.io.Serializable;

/**
 * This class defines an individual node on the B-tree itself. It is private to
 * btrees and has no methods.
 */
public class RedBlackTreeNode implements Serializable
{
    public static final long serialVersionUID = 1L;
    
    int color;
    Object value;
    Object key;
    RedBlackTreeNode right;
    RedBlackTreeNode left;
    RedBlackTreeNode parent;

    public RedBlackTreeNode(Object nodeKey, Object nodeValue)
    {
        super();
        key = nodeKey;
        value = nodeValue;
    }

    @Override
    public String toString()
    {
        return "K(" + ((color == 0) ? "R" : "B") + "):" + key;
    }
    
}
