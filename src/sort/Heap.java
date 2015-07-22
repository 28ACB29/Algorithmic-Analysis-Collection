package sort;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;

/**
 *
 * @author Arthur C. Baroi
 */
public class Heap
{

    /**
     * Heap for Heap Sort
     */
    private ArrayList<Integer> heap;

    /**
     * Default Constructor
     */
    public Heap()
    {
        heap = new ArrayList<Integer>();
    }

    /**
     * Copy Constructor
     *
     * @param input
     */
    public Heap(Heap input)
    {
        final int size;
        size = input.heap.size();
        heap = new ArrayList<Integer>(size);
        for(int i = 0; i < size; i++)
        {
            heap.add(i, input.get(i));
        }
    }

    /**
     * Conversion Constructor
     *
     * @param input
     */
    public Heap(int[] input)
    {
        final int length;
        length = input.length;
        heap = new ArrayList<Integer>(length);
        for(int i = 0; i < length; i++)
        {
            heap.add(i, input[i]);
        }
    }

    /**
     * Exchanges the two Elements at the given indices
     *
     * @param index1
     * @param index2
     */
    public void exchange(int index1, int index2)
    {
        int temp;
        temp = get(index1);
        set(index1, get(index2));
        set(index2, temp);
    }

    /**
     * Gets the Element at the Index Given
     *
     * @param index
     * @return The Element at the Index Given
     */
    public int get(int index)
    {
        return heap.get(index);
    }

    /**
     *
     * @return If the Heap is Empty
     */
    public boolean isEmpty()
    {
        return heap.isEmpty();
    }

    /**
     * Gets the Left Child at the Index Given
     *
     * @param index
     * @return The Left Child at the Index Given
     */
    public int leftChild(int index)
    {
        return heap.get(leftChildIndex(index));
    }

    /**
     * Gets the Index of the Left Child at the Index Given
     *
     * @param index
     * @return The Index of the Left Child at the Index Given
     */
    public int leftChildIndex(int index)
    {
        return 2 * index + 1;
    }

    /**
     * Gets the Parent at the Index Given
     *
     * @param index
     * @return The Parent at the Index Given
     */
    public int parent(int index)
    {
        return heap.get(parentIndex(index));
    }

    /**
     * Gets the Index of the Parent at the Index Given
     *
     * @param index
     * @return The Index of the Parent at the Index Given
     */
    public int parentIndex(int index)
    {
        if(index % 2 == 0)
        {
            return (index - 2) / 2;
        }
        else
        {
            return (index - 1) / 2;
        }
    }

    /**
     * Removes the Last Element and returns it
     *
     * @return The Last Element
     */
    public int pop()
    {
        return heap.remove(heap.size() - 1);
    }

    /**
     * adds an Element to the Heap
     *
     * @param value
     */
    public void push(int value)
    {
        heap.add(value);
    }

    /**
     * Gets the Right Child at the Index Given
     *
     * @param index
     * @return The Right Child at the Index Given
     */
    public int rightChild(int index)
    {
        return heap.get(rightChildIndex(index));
    }

    /**
     * Gets the Index of the Right Child at the Index Given
     *
     * @param index
     * @return The Index of the Right Child at the Index Given
     */
    public int rightChildIndex(int index)
    {
        return 2 * index + 2;
    }

    /**
     * Sets the Element at the Index Given with the given value
     *
     * @param index
     * @param value
     */
    public void set(int index, int value)
    {
        heap.set(index, value);
    }

    /**
     * Gets the size of the Heap
     *
     * @return The size of the Heap
     */
    public int size()
    {
        return heap.size();
    }
}
