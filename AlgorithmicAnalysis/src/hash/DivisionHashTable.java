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
public class DivisionHashTable
{

    /**
     * Table of Lists
     */
    private Node[] table;

    /**
     * Constructor
     *
     * @param size
     */
    public DivisionHashTable(int size)
    {
        table = new Node[size];
    }

    /**
     * Deletes a key from the table
     *
     * @param key
     */
    public void delete(int key)
    {
        final int index;
        Node cursor;
        Node next;
        index = hashFunction(key);
        cursor = table[index];
        next = null;
        if(cursor != null)
        {
            next = cursor.getNext();
        }

        //Find the node with the key value
        while(cursor != null && next != null && cursor.getValue() != key)
        {
            cursor = next;
            if(cursor != null)
            {
                next = cursor.getNext();
            }
        }

        //If the correct node is found remove it from the list
        if(cursor != null && cursor.getValue() == key)
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
    public Node get(int index)
    {
        return table[index];
    }

    /**
     * Gets the Size
     *
     * @return Size
     */
    public int getSize()
    {
        return table.length;
    }

    /**
     * Hash function for the table
     *
     * @param key
     * @return Hash
     */
    public int hashFunction(int key)
    {
        return key % table.length;
    }

    /**
     * Inserts a key into the table
     *
     * @param key
     */
    public void insert(int key)
    {
        final int index;
        Node cursor;
        Node next;
        index = hashFunction(key);
        cursor = table[index];
        next = null;
        if(cursor != null)
        {
            next = cursor.getNext();
        }

        //Find the node with the key value
        while(cursor != null && next != null && cursor.getValue() != key)
        {
            cursor = next;
            next = cursor.getNext();
        }

        //If the correct node is found remove it from the list
        if(cursor == null)
        {
            table[index] = new Node(key);
        }
        else if(next == null)
        {
            cursor.setNext(new Node(key, cursor, null));
        }
    }

    /**
     * Searches the table for the key
     *
     * @param key
     * @return Node
     */
    public Node search(int key)
    {
        final int index;
        Node cursor;
        Node next;
        Node result;
        index = hashFunction(key);
        cursor = table[index];
        next = null;
        if(cursor != null)
        {
            next = cursor.getNext();
        }
        result = null;
        while(cursor != null && cursor.getValue() != key)
        {
            cursor = next;
            if(cursor != null)
            {
                next = cursor.getNext();
            }
        }
        if(cursor != null && cursor.getValue() == key)
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
    public static String checkChainedHashSearch(Node node, int key)
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
    public static String formatDivisionHashTable(DivisionHashTable divide)
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
