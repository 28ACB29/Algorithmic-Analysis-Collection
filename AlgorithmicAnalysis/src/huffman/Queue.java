/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.ArrayList;

/**
 *
 * @author Arthur C. Baroi
 */
public class Queue
{

    /**
     * Priority Queue
     */
    private ArrayList<Node> queue;

    /**
     * Conversion Constructor
     *
     * @param Nodes
     */
    public Queue(Node[] Nodes)
    {
        this.queue = new ArrayList<Node>(Nodes.length);
        for(int i = 0; i < Nodes.length; i++)
        {
            insert(Nodes[i]);
        }
    }

    /**
     * Conversion Constructor
     *
     * @param characters
     * @param frequencies
     */
    public Queue(char[] characters, int[] frequencies)
    {
        this.queue = new ArrayList<Node>(characters.length);
        Node node;
        for(int i = 0; i < characters.length; i++)
        {
            node = new Node(Character.toString(characters[i]), frequencies[i]);
            insert(node);
        }
    }

    /**
     * Inserts a Node into the Queue
     *
     * @param node
     */
    public void insert(Node node)
    {
        int index;
        index = 0;

        //Go through all the Indices and see if the Element fits anywhere
        while(index < this.queue.size() && (this.queue.get(index).getFrequency() > node.getFrequency()))
        {
            index++;
        }

        //If the Element is within the Queue
        if(index < this.queue.size())
        {

            //Add the Element at the current Index
            //and shift the Elements after the current index forward
            this.queue.add(index, node);
        }

        //If the queue is Queue
        //or if the Element belongs at the end of the Queue
        if(this.queue.isEmpty() || index == this.queue.size())
        {

            //Add the Element to the end of the list
            this.queue.add(node);
        }
    }

    /**
     * Returns but not removes the Least Element
     *
     * @return The Least Element
     */
    public Node peek()
    {
        return this.queue.get(this.queue.size() - 1);
    }

    /**
     * Returns and removes the Least Element
     *
     * @return The Least Element
     */
    public Node pop()
    {
        return this.queue.remove(this.queue.size() - 1);
    }
}
