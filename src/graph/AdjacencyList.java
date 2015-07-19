package graph;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import constants.Constants;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 *
 * @author Arthur C. Baroi
 */
public class AdjacencyList {

    /**
     * Adjacency List
     */
    private VertexNode[] list;

    /**
     * Constructor
     * @param size
     */
    public AdjacencyList(int size) {
        list = new VertexNode[size];
    }

    /**
     * Copy Constructor
     * @param adjacencyList
     */
    public AdjacencyList(AdjacencyList adjacencyList) {
        final int length;
        ArrayList<Integer> neighbors;
        int neighbor;
        length = adjacencyList.getLength();
        list = new VertexNode[length];

        //Go through all the Vertices
        for (int i = 0; i < length; i++) {
            list[i] = new VertexNode(i,-1);
            neighbors = adjacencyList.getNeighbors(i);

            //Go through all the Neighbors of a Vertex
            for (int j = 0; j < neighbors.size(); j++) {
                neighbor = neighbors.get(j);

                //Add Neighbor
                addNeighborDirected(i, neighbor);
            }
        }
    }

    /**
     * Conversion Constructor
     * @param graph
     */
    public AdjacencyList(int[][] graph) {
        final int length;
        int[] neighbors;
        int neighbor;
        length = graph.length;
        list = new VertexNode[length];

        //Go through all the Vertices
        for (int i = 0; i < length; i++) {
            list[i] = new VertexNode(i,-1);
            neighbors = graph[i];

            //Go through all the Neighbors of a Vertex
            for (int j = 0; j < neighbors.length; j++) {
                neighbor = neighbors[j];

                //If neighbor is within Bounds
                if (neighbor < length) {

                    //Add Neighbor
                    addNeighborDirected(i, neighbor);
                }
            }
        }
    }

    /**
     *
     * @param index
     * @return
     */
    public VertexNode get(int index) {
        return list[index];
    }

    /**
     * Gets the Length
     * @return The Length
     */
    public int getLength() {
        return list.length;
    }

    /**
     * Adds a Neighbor for a Directed Graph
     * @param vertex
     * @param neighbor
     */
    public void addNeighborDirected(int vertex, int neighbor) {

        //If vertex and neighbor are within Bounds
        if ((vertex < list.length) && (neighbor < list.length)) {
            VertexNode cursor;
            VertexNode next;
            cursor = list[vertex];
            next = null;
            if (cursor != null) {
                next = cursor.getNext();
            }

            //Find the Node with the key value
            while (cursor != null && next != null && cursor.getNeighbor() < neighbor) {
                cursor = next;
                next = cursor.getNext();
            }

            //If the correct Node is found remove it from the list
            if (next == null) {
                cursor.setNext(new VertexNode(vertex, neighbor, cursor, null));
            } else if (cursor.getNeighbor() > neighbor) {
                cursor.setPrevious(new VertexNode(vertex, neighbor, cursor.getPrevious(), cursor));
            }
        }
    }

    /**
     * Adds a Neighbor for a Undirected Graph
     * @param vertex
     * @param neighbor
     */
    public void addNeighborUndirected(int vertex, int neighbor) {
        addNeighborDirected(vertex, neighbor);
        addNeighborDirected(neighbor, vertex);
    }

    /**
     * Gets all the Neighbors for a Particular Vertex
     * @param vertex
     * @return All the Neighbors for a Particular Vertex
     */
    public ArrayList<Integer> getNeighbors(int vertex) {
        ArrayList<Integer> neighbors;
        VertexNode cursor;

        //If vertex is within Bounds
        if (vertex < list.length) {
            neighbors = new ArrayList<Integer>();
            cursor = list[vertex].getNext();

            //Go through all the possible Neighbors
            //and if there is a Neighbor
            while (cursor != null) {

                //Add it to the List
                neighbors.add(cursor.getNeighbor());
                cursor = cursor.getNext();
            }
        } else {
            neighbors = null;
        }
        return neighbors;
    }

    /**
     * Checks if vertex and neighbor are Neighbors
     * @param vertex
     * @param neighbor
     * @return If vertex and neighbor are Neighbors
     */
    public boolean isNeighbor(int vertex, int neighbor) {
        boolean result;
        result = false;

        //If vertex and neighbor are within Bounds
        if ((vertex < list.length) && (neighbor < list.length)) {
            VertexNode cursor = list[vertex].getNext();
            while (cursor != null && cursor.getNeighbor() != neighbor) {
                cursor = cursor.getNext();
            }
            if (cursor.getNeighbor() == neighbor) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Removes a Neighbor for a Directed Graph
     * @param vertex
     * @param neighbor
     */
    public void removeNeighborDirected(int vertex, int neighbor) {

        //If vertex and neighbor are within Bounds
        if ((vertex < list.length) && (neighbor < list.length)) {
            VertexNode cursor;
            VertexNode next;
            cursor = list[vertex];
            next = null;
            if (cursor != null) {
                next = cursor.getNext();
            }

            //Find the Node with the Neighbor value
            while (cursor != null && next != null && cursor.getNeighbor() != neighbor) {
                cursor = next;
                if (cursor != null) {
                    next = cursor.getNext();
                }
            }

            //If the correct Node is found remove it from the List
            if (cursor != null && cursor.getNeighbor() == neighbor) {
                if (cursor.getPrevious() != null) {
                    cursor.getPrevious().setNext(cursor.getNext());
                }
                if (cursor.getNext() != null) {
                    cursor.getNext().setPrevious(cursor.getPrevious());
                }
                cursor = null;
            }
        }
    }

    /**
     * Removes a Neighbor for a Undirected Graph
     * @param vertex
     * @param neighbor
     */
    public void removeNeighborUndirected(int vertex, int neighbor) {
        removeNeighborDirected(vertex, neighbor);
        removeNeighborDirected(neighbor, vertex);
    }

    /**
     * Performs a Breadth First search on a Graph and a Source Vertex
     * @param graph
     * @param source
     * @return A Breadth First Tree
     */
    public static AdjacencyList breadthFirstSearch(AdjacencyList graph, int source) {
        AdjacencyList output;
        ArrayList<Integer> neighborNodes;
        VertexNode vertex;
        ArrayDeque<VertexNode> queue;
        VertexNode neighborNode;
        output = new AdjacencyList(graph);

        //Set every Node except the Source Node to the same Value
        for (int i = 0; i < source; i++) {
            output.get(i).setColor(Constants.white);
            output.get(i).setDistance(Constants.outOfBoundsValue);
            output.get(i).setPredecessor(null);
        }
        for (int i = source + 1; i < graph.getLength(); i++) {
            output.get(i).setColor(Constants.white);
            output.get(i).setDistance(Constants.outOfBoundsValue);
            output.get(i).setPredecessor(null);
        }

        //Set Source Node to different Values
        output.get(source).setColor(Constants.gray);
        output.get(source).setDistance(0);
        output.get(source).setPredecessor(null);

        //Create Queue
        queue = new ArrayDeque<VertexNode>(output.getLength());
        queue.addLast(output.get(source));

        //While Queue is not Empty
        while (!queue.isEmpty()) {

            //Pop off a Vertex and get its Neighbors
            vertex = queue.removeFirst();
            neighborNodes = output.getNeighbors(vertex.getVertex());

            //Go through all the Neighbors
            for (Integer neighbor : neighborNodes) {
                neighborNode = output.get(neighbor);

                //If the Vertex Colcr is White
                if (neighborNode.getColor().equals(Constants.white)) {
                    neighborNode.setColor(Constants.gray);
                    neighborNode.setDistance(vertex.getDistance() + 1);
                    neighborNode.setPredecessor(vertex);
                    queue.addLast(neighborNode);
                }
            }
            vertex.setColor(Constants.black);
        }
        return output;
    }

    /**
     * Formats the Breadth First Tree
     * @param adjacencyList
     * @return The formatted Breadth First Tree
     */
    public static String formatbreadthFirstTree(AdjacencyList adjacencyList) {
        StringBuilder output = new StringBuilder();
        final int length;
        VertexNode predecessor;
        length = adjacencyList.getLength();
        output.append(Constants.vertex).append(Constants.separator).append(Assignment8.predecessor).append(Constants.separator).append(Constants.distance).append(Constants.newline);

        //Go through all the Vertices
        for (int i = 0; i < length; i++) {
            predecessor = adjacencyList.get(i).getPredecessor();

            //If there is a Predecessor
            if (predecessor != null) {

                //Print out the Vertex, Predecessor, and Shortest Distance
                output.append(i).append(Constants.separator).append(predecessor.getVertex()).append(Constants.separator).append(adjacencyList.get(i).getDistance()).append(Constants.newline);
            } else {

                //Otherwise print out the Vertex and Shortest Distance
                output.append(i).append(Constants.separator).append(Constants.separator).append(adjacencyList.get(i).getDistance()).append(Constants.newline);
            }
        }
        return output.toString();
    }

    /**
     * Formats the Adjacency List
     * @param adjacencyList
     * @return The formatted Adjacency List
     */
    public static String formatAdjacencyList(AdjacencyList adjacencyList) {
        StringBuilder output = new StringBuilder();
        final int length;
        ArrayList<Integer> neigbors;
        int k;
        int size;
        length = adjacencyList.getLength();
        for (int i = 0; i < length; i++) {
            k = 0;
            neigbors = adjacencyList.getNeighbors(i);
            size = neigbors.size();
            output.append(Constants.vertex).append(i).append(Constants.separator);

            //Go through and generate the String
            for (int j = 0; j < length; j++) {
                if (k < size  && neigbors.get(k) == j) {
                    output.append(neigbors.get(k)).append(Constants.separator);
                    k++;
                } else {
                    output.append(Constants.separator);
                }
            }
            output.append(Constants.newline);
        }
        return output.toString();
    }
}
