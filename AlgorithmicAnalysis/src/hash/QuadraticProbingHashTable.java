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
public class QuadraticProbingHashTable<T>
{

    /**
     *
     */
    private Node<T>[] table;

    /**
     * Default Constructor
     *
     * @param size
     */
    public QuadraticProbingHashTable(int size)
    {
        this.table = (Node<T>[]) new Object[size];
    }

    /**
     * Deletes a key from the Table
     *
     * @param key
     * @return The Location
     */
    public int delete(T key)
    {
        int index;
        Node<T> element;
        for(int i = 0; i < this.table.length; i++)
        {
            index = hashFunction(key, i);
            element = this.table[index];
            if(element != null && element.getKey() == key)
            {
                this.table[index] = null;
                return index;
            }
        }
        return -1;
    }

    /**
     * Gets the Node at the Index given
     *
     * @param index
     * @return The Node at the Index given
     */
    public Node<T> get(int index)
    {
        return this.table[index];
    }

    /**
     * Gets the size
     *
     * @return The size
     */
    public int getSize()
    {
        return this.table.length;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();
        output.append(Constants.quadraticProbingHashTableTitle).append(Constants.newline).append(Constants.newline);
        for(int i = 0; i < this.table.length; i++)
        {
            output.append(Constants.element).append(i).append(Constants.colon);
            if(this.get(i) != null)
            {
                output.append(this.table[i].getKey());
            }
            output.append(Constants.newline);
        }
        return output.toString();
    }


    /**
     * Hash function for the Table
     *
     * @param key
     * @param attempts
     * @return Hash
     */
    public int hashFunction(T key, int attempts)
    {
        return (key.hashCode() % this.table.length + attempts * attempts) % this.table.length;
    }

    /**
     * Inserts a key into the Table
     *
     * @param key
     * @return The Location
     */
    public int insert(T key)
    {
        int index;
        Node<T> element;
        for(int i = 0; i < this.table.length; i++)
        {
            index = hashFunction(key, i);
            element = this.table[index];
            if(element == null)
            {
                this.table[index] = new Node(key);
                return index;
            }
        }
        return -1;
    }

    /**
     * Searches the Table for the key
     *
     * @param key
     * @return The Location
     */
    public int search(T key)
    {
        int result;
        int index;
        Node<T> element;
        result = -1;
        for(int i = 0; i < this.table.length; i++)
        {
            index = hashFunction(key, i);
            element = this.table[index];
            if(element != null && element.getKey() == key)
            {
                result = index;
            }
        }
        return result;
    }

    /**
     * Checks if a Probed Hash Search was successful
     *
     * @param index
     * @param key
     * @return a String stating if a Probed Hash Search was successful
     */
    public String checkProbedHashSearch(int index, T key)
    {
        StringBuilder output = new StringBuilder();
        output.append("Search was ");
        if(index > -1)
        {
            output.append("succesful. Index is ").append(index).append(".");
        }
        else
        {
            output.append("unsuccesful.");
        }
        return output.append(Constants.newline).toString();
    }

    /**
     * Formats a Quadratic Probing Hash Table
     *
     * @param quadraticProbing
     * @return A Formatted Quadratic Probing Hash Table
     */
    public String formatQuadraticProbingHashTable(QuadraticProbingHashTable<T> quadraticProbing)
    {
        StringBuilder output = new StringBuilder();
        output.append(Constants.quadraticProbingHashTableTitle).append(Constants.newline).append(Constants.newline);
        for(int i = 0; i < quadraticProbing.getSize(); i++)
        {
            output.append(Constants.element).append(i).append(Constants.colon);
            if(quadraticProbing.get(i) != null)
            {
                output.append(quadraticProbing.get(i).getKey());
            }
            output.append(Constants.newline);
        }
        return output.toString();
    }
}
