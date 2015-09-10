/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import constants.Constants;
import graph.AdjacencyList;
import graph.VertexNode;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 *
 * @author Arthur C. Baroi
 */
public class Search
{

    /**
     * Performs a Breadth First search on a Graph and a Source Vertex
     *
     * @param graph
     * @param source
     * @return A Breadth First Tree
     */
    public static AdjacencyList breadthFirstSearch(AdjacencyList graph, int source)
    {
        AdjacencyList output;
        ArrayList<Integer> neighborNodes;
        VertexNode vertex;
        ArrayDeque<VertexNode> queue;
        VertexNode neighborNode;
        output = new AdjacencyList(graph);

        //Set every Node except the Source Node to the same Value
        for(int i = 0; i < source; i++)
        {
            output.get(i).setColor(Constants.white);
            output.get(i).setDistance(Constants.absoluteMaximum);
            output.get(i).setPredecessor(null);
        }
        for(int i = source + 1; i < graph.getLength(); i++)
        {
            output.get(i).setColor(Constants.white);
            output.get(i).setDistance(Constants.absoluteMaximum);
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
        while(!queue.isEmpty())
        {

            //Pop off a Vertex and get its Neighbors
            vertex = queue.removeFirst();
            neighborNodes = output.getNeighbors(vertex.getVertex());

            //Go through all the Neighbors
            for(Integer neighbor : neighborNodes)
            {
                neighborNode = output.get(neighbor);

                //If the Vertex Colcr is White
                if(neighborNode.getColor().equals(Constants.white))
                {
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
     *
     * @param adjacencyList
     * @return The formatted Breadth First Tree
     */
    public static String formatbreadthFirstTree(AdjacencyList adjacencyList)
    {
        StringBuilder output = new StringBuilder();
        final int length;
        VertexNode predecessor;
        length = adjacencyList.getLength();
        output.append(Constants.vertex).append(Constants.separator).append(Constants.predecessor).append(Constants.separator).append(Constants.distance).append(Constants.newline);

        //Go through all the Vertices
        for(int i = 0; i < length; i++)
        {
            predecessor = adjacencyList.get(i).getPredecessor();

            //If there is a Predecessor
            if(predecessor != null)
            {

                //Print out the Vertex, Predecessor, and Shortest Distance
                output.append(i).append(Constants.separator).append(predecessor.getVertex()).append(Constants.separator).append(adjacencyList.get(i).getDistance()).append(Constants.newline);
            }
            else
            {

                //Otherwise print out the Vertex and Shortest Distance
                output.append(i).append(Constants.separator).append(Constants.separator).append(adjacencyList.get(i).getDistance()).append(Constants.newline);
            }
        }
        return output.toString();
    }

}
