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
public class Node<T>
{

    /**
     *
     */
    private T key;

    /**
     *
     */
    private Node<T> next;

    /**
     *
     */
    private Node<T> previous;

    /**
     * Constructor
     *
     * @param key
     */
    public Node(T key)
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
    public Node(T key, Node<T> previous, Node<T> next)
    {
        this.key = key;
        this.next = next;
        this.previous = previous;
    }

    /**
     * @return The Next Node
     */
    public Node<T> getNext()
    {
        return this.next;
    }

    /**
     * @return The Previous Node
     */
    public Node<T> getPrevious()
    {
        return this.previous;
    }

    /**
     * @return The Value
     */
    public T getKey()
    {
        return this.key;
    }

    /**
     * @param next The Next Node to set
     */
    public void setNext(Node<T> next)
    {
        this.next = next;
    }

    /**
     * @param previous The Previous Node to set
     */
    public void setPrevious(Node<T> previous)
    {
        this.previous = previous;
    }

    /**
     * @param key The Value to set
     */
    public void setKey(T key)
    {
        this.key = key;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();
        output.append(Constants.colon);
        Node<T> cursor = this;
        Node<T> next = null;
        if(cursor != null)
        {
            next = cursor.next;
        }

        //Go through and generate the string leaving the Last Member off
        while(cursor != null && next != null)
        {
            output.append(cursor.key).append(Constants.separator);
            cursor = next;
            next = cursor.next;
        }

        //Check if the List is Empty
        if(cursor != null)
        {

            //Append the Last Member
            output.append(cursor.key);
        }
        return output.append(Constants.newline).toString();
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
