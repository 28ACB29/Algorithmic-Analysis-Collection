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
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T>
{

    /**
     *
     */
    public BinarySearchTree()
    {
        super();
    }

    /**
     *
     * @param node
     */
    public BinarySearchTree(T node)
    {
        super(node);
    }

    /**
     *
     * @param left
     * @param right
     */
    public BinarySearchTree(BinarySearchTree<T> left, BinarySearchTree<T> right)
    {
        super(left, right);
    }

    @Override
    public BinarySearchTree<T> getLeft()
    {
        return (BinarySearchTree<T>) super.getLeft();
    }

    @Override
    public BinarySearchTree<T> getRight()
    {
        return (BinarySearchTree<T>) super.getRight();
    }

    private void getWithinRangeHelper(ArrayList<T> rangeQuery, T lower, T upper)
    {
        if(this.getLeft() != null)
        {
            this.getLeft().getWithinRangeHelper(rangeQuery, lower, upper);
        }
        if(this.getNode().compareTo(lower) > -1 && this.getNode().compareTo(upper) < 1)
        {
            rangeQuery.add(this.getNode());
        }
        if(this.getRight() != null)
        {
            this.getRight().getWithinRangeHelper(rangeQuery, lower, upper);
        }
    }

    /**
     *
     * @param lower
     * @param upper
     * @return
     */
    public ArrayList<T> getWithinRange(T lower, T upper)
    {
        ArrayList<T> rangeQuery;
        rangeQuery = new ArrayList<T>();
        if(lower.compareTo(upper) > -1)
        {
            if(this.getLeft() != null)
            {
                this.getLeft().getWithinRangeHelper(rangeQuery, lower, upper);
            }
            if(this.getNode().compareTo(lower) > -1 && this.getNode().compareTo(upper) < 1)
            {
                rangeQuery.add(this.getNode());
            }
            if(this.getRight() != null)
            {
                this.getRight().getWithinRangeHelper(rangeQuery, lower, upper);
            }
        }
        return rangeQuery;
    }

    /**
     *
     * @param value
     */
    public void insert(T value)
    {
        if(value.compareTo(super.getNode()) < 0)
        {
            if(this.getLeft() != null)
            {
                this.getLeft().insert(value);
            }
            else
            {
                this.setLeft(new BinarySearchTree<T>(value));
            }
        }
        else
        {
            if(this.getRight() != null)
            {
                this.getRight().insert(value);
            }
            else
            {
                this.setRight(new BinarySearchTree<T>(value));
            }
        }
    }

    /**
     *
     * @return
     */
    public T maximum()
    {
        BinarySearchTree<T> cursor;
        cursor = this;
        while(cursor.getRight() != null)
        {
            cursor = cursor.getRight();
        }
        return cursor.getNode();
    }

    /**
     *
     * @return
     */
    public T minimum()
    {
        BinarySearchTree<T> cursor;
        cursor = this;
        while(cursor.getLeft() != null)
        {
            cursor = cursor.getLeft();
        }
        return cursor.getNode();
    }

    /**
     *
     * @param value
     * @return
     */
    public boolean search(T value)
    {
        boolean isFound;
        isFound = false;
        if(value.compareTo(super.getNode()) < 0)
        {
            if(this.getLeft() != null)
            {
                isFound = this.getLeft().search(value);
            }
        }
        else if(value.compareTo(super.getNode()) > 0)
        {
            if(this.getRight() != null)
            {
                isFound = this.getRight().search(value);
            }
        }
        else
        {
            isFound = true;
        }
        return isFound;
    }

    private BinarySearchTree<T> removeHelper(BinarySearchTree<T> originalNode)
    {
        BinarySearchTree<T> newNode;
        BinarySearchTree<T> cursor;
        T temp;
        if(originalNode.getLeft() != null && originalNode.getRight() != null)
        {
            cursor = originalNode;
            if(originalNode.getSafeCount(originalNode.getLeft()) > originalNode.getSafeCount(originalNode.getRight()))
            {
                while(cursor.getRight() != null)
                {
                    cursor = cursor.getRight();
                }
                temp = cursor.getNode();
                cursor.setNode(originalNode.getNode());
                originalNode.setNode(temp);
                cursor.setRight(originalNode.removeHelper(cursor.getRight()));
            }
            else
            {
                while(cursor.getLeft() != null)
                {
                    cursor = cursor.getLeft();
                }
                temp = cursor.getNode();
                cursor.setNode(originalNode.getNode());
                originalNode.setNode(temp);
                cursor.setLeft(originalNode.removeHelper(cursor.getLeft()));
            }
            newNode = originalNode;
        }
        else if(originalNode.getRight() != null)
        {
            newNode = originalNode.getRight();
        }
        else if(originalNode.getLeft() != null)
        {
            newNode = originalNode.getLeft();
        }
        else// if(original.getLeft() = null && original.getRight()= null)
        {
            newNode = null;
        }
        return newNode;
    }

    /**
     *
     * @param value
     * @return
     */
    public boolean remove(T value)
    {
        boolean isFound;
        isFound = false;
        if(value.compareTo(super.getNode()) < 0)
        {
            if(this.getLeft() != null)
            {
                this.getLeft().remove(value);
            }
            else
            {
                isFound = false;
            }
        }
        else if(value.compareTo(super.getNode()) > 0)
        {
            if(this.getRight() != null)
            {
                this.getRight().remove(value);
            }
            else
            {
                isFound = false;
            }
        }
        else
        {
            this.removeHelper(this);
            isFound = true;
        }
        return isFound;
    }
}
