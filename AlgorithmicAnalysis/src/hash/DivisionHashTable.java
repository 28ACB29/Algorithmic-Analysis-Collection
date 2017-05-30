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
public class DivisionHashTable<T>
{

    /**
     * Table of Lists
     */
    private Node<T>[] table;

    /**
     * Constructor
     *
     * @param size
     */
    public DivisionHashTable(int size)
    {
        this.table = (Node<T>[]) new Object[size];
    }

    /**
     * Deletes a key from the table
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

        //Find the node with the key value
        while(cursor != null && next != null && cursor.getKey() != key)
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
     * Gets the the node at the index given
     *
     * @param index
     * @return the the node at the index given
     */
    public Node<T> get(int index)
    {
        return this.table[index];
    }

    /**
     * Gets the Size
     *
     * @return Size
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
        output.append(Constants.divisionHashTableTitle).append(Constants.newline).append(Constants.newline);
        for(int i = 0; i < this.table.length; i++)
        {
            output.append(Constants.element).append(i).append(Node.formatList(this.table[i]));
        }
        return output.append(Constants.newline).toString();
    }

    /**
     * Hash function for the table
     *
     * @param key
     * @return Hash
     */
    public int hashFunction(T key)
    {
        return key.hashCode() % this.table.length;
    }

    /**
     * Inserts a key into the table
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

        //Find the node with the key value
        while(cursor != null && next != null && cursor.getKey() != key)
        {
            cursor = next;
            next = cursor.getNext();
        }

        //If the correct node is found remove it from the list
        if(cursor == null)
        {
            this.table[index] = new Node<T>(key);
        }
        else if(next == null)
        {
            cursor.setNext(new Node<T>(key, cursor, null));
        }
    }

    /**
     * Searches the table for the key
     *
     * @param key
     * @return Node
     */
    public Node<T> search(T key)
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
    public String checkChainedHashSearch(Node<T> node, T key)
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
     * Formats a Division Hash Table
     *
     * @param divide
     * @return A Formatted Division Hash Table
     */
    public String formatDivisionHashTable(DivisionHashTable<T> divide)
    {
        StringBuilder output = new StringBuilder();
        output.append(Constants.divisionHashTableTitle).append(Constants.newline).append(Constants.newline);
        for(int i = 0; i < divide.getSize(); i++)
        {
            output.append(Constants.element).append(i).append(Node.formatList(divide.get(i)));
        }
        return output.append(Constants.newline).toString();
    }
}
