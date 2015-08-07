/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.tree;

import java.util.ArrayList;

/**
 *
 * @author Arthur C. Baroi
 */
public class Tree<T>
{

    private T Node;

    private ArrayList<Tree> children;

    /**
     *
     */
    public Tree()
    {
        this.Node = null;
        this.children = new ArrayList<Tree>();
    }

    /**
     *
     */
    public Tree(T node)
    {
        this.Node = node;
        this.children = new ArrayList<Tree>();
    }

    /**
     *
     */
    public Tree(int i)
    {
        this.Node = null;
        this.children = new ArrayList<Tree>(i);
    }


}
