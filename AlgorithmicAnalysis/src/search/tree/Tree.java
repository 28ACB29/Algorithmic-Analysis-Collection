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

    /**
     *
     * @param Node
     * @param children
     */
    public Tree(T Node, ArrayList<Tree> children)
    {
        this.Node = Node;
        this.children = children;
    }

    /**
     * @return the Node
     */
    public T getNode()
    {
        return Node;
    }

    /**
     * @param Node the Node to set
     */
    public void setNode(T Node)
    {
        this.Node = Node;
    }

    /**
     * @return the children
     */
    public ArrayList<Tree> getChildren()
    {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(ArrayList<Tree> children)
    {
        this.children = children;
    }

    /**
     *
     * @return
     */
    public boolean isLeaf()
    {
        return this.children.isEmpty();
    }

    /**
     *
     * @return
     */
    public int getCount()
    {
        int count;
        count = 0;
        for(Tree child : this.children)
        {
            count += child.getCount();
        }
        return 1 + count;
    }

    /**
     *
     * @return
     */
    public int getDepth()
    {
        int depth;
        depth = Integer.MIN_VALUE;
        for(Tree child : this.children)
        {
            depth = Math.max(depth, child.getDepth());
        }
        return 1 + depth;
    }

    /**
     *
     * @return
     */
    public int getNumberOfPaths()
    {
        int paths;
        paths = 0;
        for(Tree child : this.children)
        {
            paths += child.getNumberOfPaths() > 1 ? child.getNumberOfPaths() : 1;
        }
        return paths;
    }
}
