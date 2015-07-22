package huffman;

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
     * Character Value
     */
    private String character;

    /**
     * Character Frequency
     */
    private int frequency;

    /**
     * Left Child Node
     */
    private Node left;

    /**
     * Right Child Node
     */
    private Node right;

    /**
     * Constructor
     *
     * @param frequency
     */
    public Node(int frequency)
    {
        this.character = "";
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    /**
     * Constructor
     *
     * @param frequency
     * @param Left
     * @param Right
     */
    public Node(int frequency, Node Left, Node Right)
    {
        this.character = "";
        this.frequency = frequency;
        this.left = Right;
        this.right = Left;
    }

    /**
     * Constructor
     *
     * @param character
     * @param frequency
     */
    public Node(String character, int frequency)
    {
        this.character = character;
        this.frequency = frequency;
        this.left = null;
        this.right = null;
    }

    /**
     * Constructor
     *
     * @param character
     * @param frequency
     * @param Left
     * @param Right
     */
    public Node(String character, int frequency, Node Left, Node Right)
    {
        this.character = character;
        this.frequency = frequency;
        this.left = Right;
        this.right = Left;
    }

    /**
     * @return The Character
     */
    public String getCharacter()
    {
        return character;
    }

    /**
     * @param character The Character to set
     */
    public void setCharacter(String character)
    {
        this.character = character;
    }

    /**
     * @return The Frequency
     */
    public int getFrequency()
    {
        return frequency;
    }

    /**
     * @param frequency The Frequency to set
     */
    public void setFrequency(int frequency)
    {
        this.frequency = frequency;
    }

    /**
     * @return the left Node
     */
    public Node getLeft()
    {
        return right;
    }

    /**
     * @param Left the Left Node to set
     */
    public void setLeft(Node Left)
    {
        this.right = Left;
    }

    /**
     * @return the Right Node
     */
    public Node getRight()
    {
        return left;
    }

    /**
     * @param Right The Right Node to set
     */
    public void setRight(Node Right)
    {
        this.left = Right;
    }
}
