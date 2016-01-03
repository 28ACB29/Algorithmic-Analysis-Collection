package hash;

import constants.Constants;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Arthur C. Baroi
 */
public class MultiplicationHashTable<T>
{

    /**
     * Constant suggested by Knuth equal to 0.6180339887
     */
    public static final double knuthContant = (Math.sqrt(5) - 1) / 2;

    /**
     * Table of Lists
     */
    private Node<T>[] table;

    /**
     * Constructor
     *
     * @param size
     */
    public MultiplicationHashTable(int size)
    {
        this.table = (Node<T>[]) new Object[size];
    }

    /**
     * Deletes a key from the Table
     *
     * @param key
     */
    public void delete(T key)
    {
        final int index;
        Node<T> cursor;
        Node<T> next;
        index = hashFunction(key);
        cursor = this.table[index];
        next = null;
        if(cursor != null)
        {
            next = cursor.getNext();
        }

        //Find the node with the Key value
        while(cursor != null && cursor.getKey() != key)
        {
            cursor = next;
            if(cursor != null)
            {
                next = cursor.getNext();
            }
        }

        //If the correct node is found remove it from the list
        if(cursor != null && cursor.getKey() == key)
        {
            if(cursor.getPrevious() != null)
            {
                cursor.getPrevious().setNext(cursor.getNext());
            }
            if(cursor.getNext() != null)
            {
                cursor.getNext().setPrevious(cursor.getPrevious());
            }
            cursor = null;
        }
    }

    /**
     * Helper function used to extract the Fraction
     *
     * @param value
     * @return The Fraction
     */
    public static double extractFraction(double value)
    {
        final int integer;
        final double fraction;
        integer = (int) value;
        fraction = value - integer;
        return (fraction);
    }

    /**
     * Gets the node at the Index given
     *
     * @param index
     * @return The node at the Index given
     */
    public Node<T> get(int index)
    {
        return this.table[index];
    }

    /**
     * Gets the Size
     *
     * @return the Size
     */
    public int getSize()
    {
        return this.table.length;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();
        output.append(Constants.multiplicationHashTableTitle).append(Constants.newline).append(Constants.newline);
        for(int i = 0; i < this.table.length; i++)
        {
            output.append(Constants.element).append(i).append(Node.formatList(this.table[i]));
        }
        return output.append(Constants.newline).toString();
    }

    /**
     * Hash function for the Table
     *
     * @param key
     * @return Hash
     */
    public int hashFunction(T key)
    {
        final double fraction;
        final double index;
        fraction = extractFraction(MultiplicationHashTable.knuthContant * (double) key.hashCode());
        index = (double) this.table.length * fraction;
        return (int) (index);
    }

    /**
     * Inserts a key into the Table
     *
     * @param key
     */
    public void insert(T key)
    {
        final int index;
        Node<T> cursor;
        Node<T> next;
        index = hashFunction(key);
        cursor = this.table[index];
        next = null;
        if(cursor != null)
        {
            next = cursor.getNext();
        }

        //If the correct node is found remove it from the list
        while(cursor != null && next != null)
        {
            cursor = next;
            next = cursor.getNext();
        }
        if(cursor == null)
        {
            this.table[index] = new Node(key);
        }
        else /*if (next == null) */

        {
            cursor.setNext(new Node(key, cursor, null));
        }
    }

    /**
     * Searches the Table for the Key
     *
     * @param key
     * @return The Key
     */
    public Node search(T key)
    {
        final int index;
        Node<T> cursor;
        Node<T> next;
        Node<T> result;
        index = hashFunction(key);
        cursor = this.table[index];
        next = null;
        if(cursor != null)
        {
            next = cursor.getNext();
        }
        result = null;
        while(cursor != null && cursor.getKey() != key)
        {
            cursor = next;
            if(cursor != null)
            {
                next = cursor.getNext();
            }
        }
        if(cursor != null && cursor.getKey() == key)
        {
            result = cursor;
        }
        return result;
    }

    /**
     * Checks if a Chained Hash Search was successful
     *
     * @param node
     * @param key
     * @return a String stating if a Chained Hash Search was successful
     */
    public String checkChainedHashSearch(Node<T> node, int key)
    {
        StringBuilder output = new StringBuilder();
        output.append("Search was ");
        if(node != null)
        {
            output.append("successful.");
        }
        else
        {
            output.append("unsuccesful.");
        }
        return output.append(Constants.newline).toString();
    }

    /**
     * Formats a Multiplication Hash Table
     *
     * @param multiply
     * @return A Formatted Multiplication Hash Table
     */
    public String formatMultiplicationHashTable(MultiplicationHashTable<T> multiply)
    {
        StringBuilder output = new StringBuilder();
        output.append(Constants.multiplicationHashTableTitle).append(Constants.newline).append(Constants.newline);
        for(int i = 0; i < multiply.getSize(); i++)
        {
            output.append(Constants.element).append(i).append(Node.formatList(multiply.get(i)));
        }
        return output.append(Constants.newline).toString();
    }
}
