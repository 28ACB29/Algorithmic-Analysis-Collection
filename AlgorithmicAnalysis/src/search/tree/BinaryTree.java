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
public class BinaryTree<T>
{

    private T Node;

    private BinaryTree<T> left;

    private BinaryTree<T> right;

    /**
     *
     */
    public BinaryTree()
    {
        this.left = null;
        this.right = null;
    }

    /**
     *
     * @param node
     */
    public BinaryTree(T node)
    {
        this.Node = node;
        this.left = null;
        this.right = null;
    }

    /**
     *
     * @param left
     * @param right
     */
    public BinaryTree(BinaryTree<T> left, BinaryTree<T> right)
    {
        this.left = left;
        this.right = right;
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
     * @return the left
     */
    public BinaryTree<T> getLeft()
    {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(BinaryTree<T> left)
    {
        this.left = left;
    }

    /**
     * @return the right
     */
    public BinaryTree<T> getRight()
    {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(BinaryTree<T> right)
    {
        this.right = right;
    }

    public boolean isLeaf()
    {
        return this.left == null && this.right == null;
    }

    /**
     *
     * @return
     */
    public int getCount()
    {
        int leftCount;
        int rightCount;
        leftCount = this.getSafeCount(this.left);
        rightCount = this.getSafeCount(this.right);
        return 1 + leftCount + rightCount;
    }

    /**
     *
     * @param tree
     * @return
     */
    protected int getSafeCount(BinaryTree<T> tree)
    {
        return tree == null ? 0 : tree.getCount();
    }

    /**
     *
     * @return
     */
    public int getDepth()
    {
        int leftDepth;
        int rightDepth;
        if(this.left == null)
        {
            leftDepth = 0;
        }
        else
        {
            leftDepth = this.left.getCount();
        }
        if(this.right == null)
        {
            rightDepth = 0;
        }
        else
        {
            rightDepth = this.right.getCount();
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }

    /**
     *
     * @return
     */
    public int getNumberOfPaths()
    {
        int paths;
        int leftPaths;
        int rightPaths;
        if(this.left == null)
        {
            leftPaths = 0;
        }
        else
        {
            leftPaths = this.left.getNumberOfPaths() > 1 ? this.left.getNumberOfPaths() : 1;
        }
        if(this.right == null)
        {
            rightPaths = 0;
        }
        else
        {
            rightPaths = this.right.getNumberOfPaths() > 1 ? this.right.getNumberOfPaths() : 1;
        }
        paths = leftPaths + rightPaths;
        return paths;
    }

    private void inOrderTraversalHelper(ArrayList<T> nodes)
    {
        if(this.left != null)
        {
            this.left.inOrderTraversalHelper(nodes);
        }
        nodes.add(this.Node);
        if(this.right != null)
        {
            this.right.inOrderTraversalHelper(nodes);
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<T> inOrderTraversal()
    {
        ArrayList<T> nodes;
        nodes = new ArrayList<T>(this.getCount());
        if(this.left != null)
        {
            this.left.inOrderTraversalHelper(nodes);
        }
        nodes.add(this.Node);
        if(this.right != null)
        {
            this.right.inOrderTraversalHelper(nodes);
        }
        return nodes;
    }

    private void preOrderTraversalHelper(ArrayList<T> nodes)
    {
        nodes.add(this.Node);
        if(this.left != null)
        {
            this.left.preOrderTraversalHelper(nodes);
        }
        if(this.right != null)
        {
            this.right.preOrderTraversalHelper(nodes);
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<T> preOrderTraversal()
    {
        ArrayList<T> nodes;
        nodes = new ArrayList<T>(this.getCount());
        nodes.add(this.Node);
        if(this.left != null)
        {
            this.left.preOrderTraversalHelper(nodes);
        }
        if(this.right != null)
        {
            this.right.preOrderTraversalHelper(nodes);
        }
        return nodes;
    }

    private void postOrderTraversalHelper(ArrayList<T> nodes)
    {
        if(this.left != null)
        {
            this.left.postOrderTraversalHelper(nodes);
        }
        if(this.right != null)
        {
            this.right.postOrderTraversalHelper(nodes);
        }
        nodes.add(this.Node);
    }

    /**
     *
     * @return
     */
    public ArrayList<T> postOrderTraversal()
    {
        ArrayList<T> nodes;
        nodes = new ArrayList<T>(this.getCount());
        if(this.left != null)
        {
            this.left.postOrderTraversalHelper(nodes);
        }
        if(this.right != null)
        {
            this.right.postOrderTraversalHelper(nodes);
        }
        nodes.add(this.Node);
        return nodes;
    }

    public BinaryTree<T> leastCommonAncestor(BinaryTree<T> root, T v1, T v2)
    {
        BinaryTree<T> ancestor;
        BinaryTree<T> leftDescendant;
        BinaryTree<T> rightDescendant;
        if(root == null)
        {
            ancestor = null;
        }
        else
        {
            leftDescendant = leastCommonAncestor(root.left, v1, v2);
            rightDescendant = leastCommonAncestor(root.right, v1, v2);
            if(root.Node == v1 || root.Node == v2)
            {
                ancestor = root;
            }
            else if(root.left == null && root.right == null)
            {
                ancestor = null;
            }
            else if(root.right == null)
            {
                ancestor = leftDescendant;
            }
            else if(root.left == null)
            {
                ancestor = rightDescendant;
            }
            else
            {
                if(leftDescendant == null && rightDescendant == null)
                {
                    ancestor = null;
                }
                else if(rightDescendant == null)
                {
                    ancestor = leftDescendant;
                }
                else if(leftDescendant == null)
                {
                    ancestor = rightDescendant;
                }
                else
                {
                    ancestor = root;
                }
            }
        }
        return ancestor;
    }
}
