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
public class Node
{

    /**
     *
     */
    private int key;

    /**
     *
     */
    private Node next;

    /**
     *
     */
    private Node previous;

    /**
     * Constructor
     *
     * @param key
     */
    public Node(int key)
    {
        this.key = key;
        this.next = null;
        this.previous = null;
    }

    /**
     * Constructor
     *
     * @param key
     * @param previous
     * @param next
     */
    public Node(int key, Node previous, Node next)
    {
        this.key = key;
        this.next = next;
        this.previous = previous;
    }

    /**
     * @return The Next Node
     */
    public Node getNext()
    {
        return next;
    }

    /**
     * @return The Previous Node
     */
    public Node getPrevious()
    {
        return previous;
    }

    /**
     * @return The Value
     */
    public int getKey()
    {
        return key;
    }

    /**
     * @param next The Next Node to set
     */
    public void setNext(Node next)
    {
        this.next = next;
    }

    /**
     * @param previous The Previous Node to set
     */
    public void setPrevious(Node previous)
    {
        this.previous = previous;
    }

    /**
     * @param key The Value to set
     */
    public void setKey(int key)
    {
        this.key = key;
    }

    /**
     * Formats a List
     *
     * @param list
     * @return A Formatted List
     */
    public static String formatList(Node list)
    {
        StringBuilder output = new StringBuilder();
        output.append(Constants.colon);
        Node cursor = list;
        Node next = null;
        if(cursor != null)
        {
            next = cursor.getNext();
        }

        //Go through and generate the string leaving the Last Member off
        while(cursor != null && next != null)
        {
            output.append(cursor.getKey()).append(Constants.separator);
            cursor = next;
            next = cursor.getNext();
        }

        //Check if the List is Empty
        if(cursor != null)
        {

            //Append the Last Member
            output.append(cursor.getKey());
        }
        return output.append(Constants.newline).toString();
    }
}
