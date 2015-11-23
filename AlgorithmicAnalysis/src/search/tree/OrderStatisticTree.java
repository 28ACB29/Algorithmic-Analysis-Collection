/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.tree;

/**
 *
 * @author Arthur C. Baroi
 * @param <T>
 */
public class OrderStatisticTree<T extends Comparable<T>> extends BinarySearchTree<T>
{

    private int count;

    /**
     *
     */
    public OrderStatisticTree()
    {
        super();
        this.count = 1;
    }

    /**
     *
     * @param node
     */
    public OrderStatisticTree(T node)
    {
        super(node);
        this.count = 1;
    }

    /**
     *
     * @param left
     * @param right
     */
    public OrderStatisticTree(OrderStatisticTree<T> left, OrderStatisticTree<T> right)
    {
        super(left, right);
        this.count = 1 + this.getSafeCount(left) + this.getSafeCount(right);
    }

    @Override
    public int getCount()
    {
        return this.count;
    }

    /**
     *
     * @param left
     */
    public void setLeft(OrderStatisticTree<T> left)
    {
        super.setLeft(left);
        this.count = 1 + this.getSafeCount(left);
    }

    /**
     *
     * @param right
     */
    public void setRight(OrderStatisticTree<T> right)
    {
        super.setRight(right);
        this.count = 1 + this.getSafeCount(right);
    }

    /**
     *
     * @param tree
     * @return
     */
    protected int getSafeCount(OrderStatisticTree<T> tree)
    {
        return tree == null ? 0 : tree.count;
    }

    /**
     *
     * @param i
     * @return
     */
    public T largest(int i)
    {
        T item;
        int leftCount;
        leftCount = this.getLeft().getCount();
        if(i == leftCount)
        {
            item = getNode();
        }
        else if(i > leftCount)
        {
            item = ((OrderStatisticTree<T>) this.getLeft()).largest(i - (leftCount + 1));
        }
        else
        {
            item = ((OrderStatisticTree<T>) this.getRight()).largest(i);
        }
        return item;
    }

    /**
     *
     * @param i
     * @return
     */
    public T smallest(int i)
    {
        T item;
        int rightCount;
        rightCount = this.getRight().getCount();
        if(i == rightCount)
        {
            item = getNode();
        }
        else if(i < rightCount)
        {
            item = ((OrderStatisticTree<T>) this.getLeft()).smallest(i);
        }
        else
        {
            item = ((OrderStatisticTree<T>) this.getRight()).smallest(i - (rightCount + 1));
        }
        return item;
    }
}
