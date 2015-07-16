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
public class Queue {

    /**
     * Priority Queue
     */
    private ArrayList<Node> queue;

    /**
     * Conversion Constructor
     * @param Nodes
     */
    public Queue(Node[] Nodes) {
        queue = new ArrayList<Node>(Nodes.length);
        for (int i = 0; i < Nodes.length; i++) {
            insert(Nodes[i]);
        }
    }

    /**
     * Conversion Constructor
     * @param characters
     * @param frequencies
     */
    public Queue(char[] characters, int[] frequencies) {
        queue = new ArrayList<Node>(characters.length);
        Node node;
        for (int i = 0; i < characters.length; i++) {
            node = new Node(Character.toString(characters[i]), frequencies[i]);
            insert(node);
        }
    }

    /**
     * Inserts a Node into the Queue
     * @param node 
     */
    public void insert(Node node) {
        int index;
        index = 0;

        //Go through all the Indices and see if the Element fits anywhere
        while (index < queue.size() && (queue.get(index).getFrequency() > node.getFrequency())) {
            index++;
        }

        //If the Element is within the Queue
        if (index < queue.size()) {

            //Add the Element at the current Index
            //and shift the Elements after the current index forward
            queue.add(index, node);
        }

        //If the queue is Queue
        //or if the Element belongs at the end of the Queue
        if (queue.isEmpty() || index == queue.size()) {

            //Add the Element to the end of the list
            queue.add(node);
        }
    }

    /**
     * Returns but not removes the Least Element
     * @return The Least Element
     */
    public Node peek() {
        return queue.get(queue.size() - 1);
    }

    /**
     * Returns  and removes the Least Element
     * @return The Least Element
     */
    public Node pop() {
        return queue.remove(queue.size() - 1);
    }
}
