package graph;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Arthur C. Baroi
 */
public class VertexNode
{

    /**
     * Color Value for Breadth First Search Algorithm
     */
    private String color;

    /**
     * Distance Value for Breadth First Search Algorithm
     */
    private int distance;

    /**
     * Neighbor Value for Adjacency List
     */
    private int neighbor;

    /**
     * Next Node for Adjacency List
     */
    private VertexNode next;

    /**
     * Predecessor Node for Breadth First Search Algorithm
     */
    private VertexNode predecessor;

    /**
     * Previous Node for Adjacency List
     */
    private VertexNode previous;

    /**
     * Vertex Value for Adjacency List
     */
    private int vertex;

    /**
     * Constructor
     *
     * @param vertex
     * @param neighbor
     */
    public VertexNode(int vertex, int neighbor)
    {
        this.color = "";
        this.distance = 0;
        this.neighbor = neighbor;
        this.next = null;
        this.predecessor = null;
        this.previous = null;
        this.vertex = vertex;
    }

    /**
     * Constructor
     *
     * @param vertex
     * @param neighbor
     * @param previous
     * @param next
     */
    public VertexNode(int vertex, int neighbor, VertexNode previous, VertexNode next)
    {
        this.color = "";
        this.distance = 0;
        this.neighbor = neighbor;
        this.next = next;
        this.predecessor = null;
        this.previous = previous;
        this.vertex = vertex;
    }

    /**
     * @return The Color
     */
    public String getColor()
    {
        return color;
    }

    /**
     * @return The Distance
     */
    public int getDistance()
    {
        return distance;
    }

    /**
     * @return The Neighbor
     */
    public int getNeighbor()
    {
        return neighbor;
    }

    /**
     * @return The Next Node
     */
    public VertexNode getNext()
    {
        return next;
    }

    /**
     * @return The Predecessor Node
     */
    public VertexNode getPredecessor()
    {
        return predecessor;
    }

    /**
     * @return The Previous Node
     */
    public VertexNode getPrevious()
    {
        return previous;
    }

    /**
     * @return The Vertex
     */
    public int getVertex()
    {
        return vertex;
    }

    /**
     * @param color The Color to set
     */
    public void setColor(String color)
    {
        this.color = color;
    }

    /**
     * @param distance The Distance to set
     */
    public void setDistance(int distance)
    {
        this.distance = distance;
    }

    /**
     * @param neighbor The Neighbor to set
     */
    public void setNeighbor(int neighbor)
    {
        this.neighbor = neighbor;
    }

    /**
     * @param next The Next Node to set
     */
    public void setNext(VertexNode next)
    {
        this.next = next;
    }

    /**
     * @param predecessor The Predecessor Node to set
     */
    public void setPredecessor(VertexNode predecessor)
    {
        this.predecessor = predecessor;
    }

    /**
     * @param previous The Previous Node to set
     */
    public void setPrevious(VertexNode previous)
    {
        this.previous = previous;
    }

    /**
     * @param vertex The Vertex to set
     */
    public void setVertex(int vertex)
    {
        this.vertex = vertex;
    }
}
