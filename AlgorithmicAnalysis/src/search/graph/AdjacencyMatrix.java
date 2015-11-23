package search.graph;

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
public class AdjacencyMatrix
{

    /**
     * Used to indicate that a Node is a Neighbor
     */
    private static final int isNeighbor = 1;

    /**
     * Used to indicate that a Node is not a Neighbor
     */
    private static final int isNotNeighbor = 0;

    /**
     * Matrix for storing Adjacency Relationships
     */
    private int[][] matrix;

    /**
     * Default Constructor
     *
     * @param size
     */
    public AdjacencyMatrix(int size)
    {
        matrix = new int[size][size];
    }

    /**
     * Constructor
     *
     * @param graph
     */
    public AdjacencyMatrix(int[][] graph)
    {
        matrix = new int[graph.length][graph.length];
        int[] neighbors;
        int neighbor;

        //Go through all the Vertices
        for(int i = 0; i < graph.length; i++)
        {
            neighbors = graph[i];

            //Go through all the Neighbors of a Vertex
            for(int j = 0; j < neighbors.length; j++)
            {
                neighbor = neighbors[j];

                //If neighbor is within Bounds
                if(neighbor < graph.length)
                {
                    addNeighborDirected(i, neighbor);
                }
            }
        }
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
        if((vertex < matrix.length) && (neighbor < matrix.length))
        {
            matrix[vertex][neighbor] = isNeighbor;
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
     * Gets the Length
     *
     * @return The Length
     */
    public int getLength()
    {
        return matrix.length;
    }

    /**
     * Gets all the Neighbors for a Particular Vertex
     *
     * @param vertex
     * @return All the Neighbors for a Particular Vertex
     */
    public ArrayList<Integer> getNeighbors(int vertex)
    {
        ArrayList<Integer> neighbors = null;

        //If vertex is within Bounds
        if(vertex < matrix.length)
        {
            neighbors = new ArrayList<Integer>();
            int possibleNeighbor;

            //Go through all the possible Neighbors
            for(int i = 0; i < matrix.length; i++)
            {
                possibleNeighbor = matrix[vertex][i];

                //If there is a Neighbor
                if(possibleNeighbor == isNeighbor)
                {

                    //Add it to the List
                    neighbors.add(i);
                }
            }
        }
        return neighbors;
    }

    /**
     * Checks if vertex and neighbor are neighbors
     *
     * @param vertex
     * @param neighbor
     * @return If vertex and neighbor are neighbors
     */
    public boolean isNeighbor(int vertex, int neighbor)
    {
        boolean result;
        result = false;

        //If vertex and neighbor are within Bounds
        if((vertex < matrix.length) && (neighbor < matrix.length))
        {
            result = (matrix[vertex][neighbor] == isNeighbor);
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
        if((vertex < matrix.length) && (neighbor < matrix.length))
        {
            matrix[vertex][neighbor] = isNotNeighbor;
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
     * Formats the Adjacency Matrix
     *
     * @param adjacencyMatrix
     * @return The formatted Adjacency Matrix
     */
    public static String formatAdjacencyMatrix(AdjacencyMatrix adjacencyMatrix)
    {
        StringBuilder output = new StringBuilder();
        final int length;
        ArrayList<Integer> neigbors;
        int size;
        int k;
        length = adjacencyMatrix.getLength();
        for(int i = 0; i < length; i++)
        {
            k = 0;
            neigbors = adjacencyMatrix.getNeighbors(i);
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
