package graph;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import constants.Constants;
import java.util.ArrayList;

/**
 *
 * @author Arthur C. Baroi
 */
public class AdjacencyList
{

    /**
     * Adjacency List
     */
    private VertexNode[] list;

    /**
     * Constructor
     *
     * @param size
     */
    public AdjacencyList(int size)
    {
        list = new VertexNode[size];
    }

    /**
     * Copy Constructor
     *
     * @param adjacencyList
     */
    public AdjacencyList(AdjacencyList adjacencyList)
    {
        final int length;
        ArrayList<Integer> neighbors;
        int neighbor;
        length = adjacencyList.getLength();
        list = new VertexNode[length];

        //Go through all the Vertices
        for(int i = 0; i < length; i++)
        {
            list[i] = new VertexNode(i, -1);
            neighbors = adjacencyList.getNeighbors(i);

            //Go through all the Neighbors of a Vertex
            for(int j = 0; j < neighbors.size(); j++)
            {
                neighbor = neighbors.get(j);

                //Add Neighbor
                addNeighborDirected(i, neighbor);
            }
        }
    }

    /**
     * Conversion Constructor
     *
     * @param graph
     */
    public AdjacencyList(int[][] graph)
    {
        final int length;
        int[] neighbors;
        int neighbor;
        length = graph.length;
        list = new VertexNode[length];

        //Go through all the Vertices
        for(int i = 0; i < length; i++)
        {
            list[i] = new VertexNode(i, -1);
            neighbors = graph[i];

            //Go through all the Neighbors of a Vertex
            for(int j = 0; j < neighbors.length; j++)
            {
                neighbor = neighbors[j];

                //If neighbor is within Bounds
                if(neighbor < length)
                {

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
    public VertexNode get(int index)
    {
        return list[index];
    }

    /**
     * Gets the Length
     *
     * @return The Length
     */
    public int getLength()
    {
        return list.length;
    }

    /**
     * Adds a Neighbor for a Directed Graph
     *
     * @param vertex
     * @param neighbor
     */
    public void addNeighborDirected(int vertex, int neighbor)
    {

        //If vertex and neighbor are within Bounds
        if((vertex < list.length) && (neighbor < list.length))
        {
            VertexNode cursor;
            VertexNode next;
            cursor = list[vertex];
            next = null;
            if(cursor != null)
            {
                next = cursor.getNext();
            }

            //Find the Node with the key value
            while(cursor != null && next != null && cursor.getNeighbor() < neighbor)
            {
                cursor = next;
                next = cursor.getNext();
            }

            //If the correct Node is found remove it from the list
            if(next == null)
            {
                cursor.setNext(new VertexNode(vertex, neighbor, cursor, null));
            }
            else if(cursor.getNeighbor() > neighbor)
            {
                cursor.setPrevious(new VertexNode(vertex, neighbor, cursor.getPrevious(), cursor));
            }
        }
    }

    /**
     * Adds a Neighbor for a Undirected Graph
     *
     * @param vertex
     * @param neighbor
     */
    public void addNeighborUndirected(int vertex, int neighbor)
    {
        addNeighborDirected(vertex, neighbor);
        addNeighborDirected(neighbor, vertex);
    }

    /**
     * Gets all the Neighbors for a Particular Vertex
     *
     * @param vertex
     * @return All the Neighbors for a Particular Vertex
     */
    public ArrayList<Integer> getNeighbors(int vertex)
    {
        ArrayList<Integer> neighbors;
        VertexNode cursor;

        //If vertex is within Bounds
        if(vertex < list.length)
        {
            neighbors = new ArrayList<Integer>();
            cursor = list[vertex].getNext();

            //Go through all the possible Neighbors
            //and if there is a Neighbor
            while(cursor != null)
            {

                //Add it to the List
                neighbors.add(cursor.getNeighbor());
                cursor = cursor.getNext();
            }
        }
        else
        {
            neighbors = null;
        }
        return neighbors;
    }

    /**
     * Checks if vertex and neighbor are Neighbors
     *
     * @param vertex
     * @param neighbor
     * @return If vertex and neighbor are Neighbors
     */
    public boolean isNeighbor(int vertex, int neighbor)
    {
        boolean result;
        result = false;

        //If vertex and neighbor are within Bounds
        if((vertex < list.length) && (neighbor < list.length))
        {
            VertexNode cursor = list[vertex].getNext();
            while(cursor != null && cursor.getNeighbor() != neighbor)
            {
                cursor = cursor.getNext();
            }
            if(cursor.getNeighbor() == neighbor)
            {
                result = true;
            }
        }
        return result;
    }

    /**
     * Removes a Neighbor for a Directed Graph
     *
     * @param vertex
     * @param neighbor
     */
    public void removeNeighborDirected(int vertex, int neighbor)
    {

        //If vertex and neighbor are within Bounds
        if((vertex < list.length) && (neighbor < list.length))
        {
            VertexNode cursor;
            VertexNode next;
            cursor = list[vertex];
            next = null;
            if(cursor != null)
            {
                next = cursor.getNext();
            }

            //Find the Node with the Neighbor value
            while(cursor != null && next != null && cursor.getNeighbor() != neighbor)
            {
                cursor = next;
                if(cursor != null)
                {
                    next = cursor.getNext();
                }
            }

            //If the correct Node is found remove it from the List
            if(cursor != null && cursor.getNeighbor() == neighbor)
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
    }

    /**
     * Removes a Neighbor for a Undirected Graph
     *
     * @param vertex
     * @param neighbor
     */
    public void removeNeighborUndirected(int vertex, int neighbor)
    {
        removeNeighborDirected(vertex, neighbor);
        removeNeighborDirected(neighbor, vertex);
    }

    /**
     * Formats the Adjacency List
     *
     * @param adjacencyList
     * @return The formatted Adjacency List
     */
    public static String formatAdjacencyList(AdjacencyList adjacencyList)
    {
        StringBuilder output = new StringBuilder();
        final int length;
        ArrayList<Integer> neigbors;
        int k;
        int size;
        length = adjacencyList.getLength();
        for(int i = 0; i < length; i++)
        {
            k = 0;
            neigbors = adjacencyList.getNeighbors(i);
            size = neigbors.size();
            output.append(Constants.vertex).append(i).append(Constants.separator);

            //Go through and generate the String
            for(int j = 0; j < length; j++)
            {
                if(k < size && neigbors.get(k) == j)
                {
                    output.append(neigbors.get(k)).append(Constants.separator);
                    k++;
                }
                else
                {
                    output.append(Constants.separator);
                }
            }
            output.append(Constants.newline);
        }
        return output.toString();
    }
}
