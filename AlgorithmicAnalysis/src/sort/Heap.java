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
public class Heap<T extends Comparable<T>>
{

    /**
     * Heap for Heap Sort
     */
    private ArrayList<T> heap;

    /**
     * Default Constructor
     */
    public Heap()
    {
        this.heap = new ArrayList<T>();
    }

    /**
     * Copy Constructor
     *
     * @param input
     */
    public Heap(Heap<T> input)
    {
        final int size;
        size = input.heap.size();
        this.heap = new ArrayList<T>(size);
        for(int i = 0; i < size; i++)
        {
            this.heap.add(i, input.get(i));
        }
    }

    /**
     * Conversion Constructor
     *
     * @param input
     */
    public Heap(ArrayList<T> input)
    {
        this.heap = new ArrayList<T>(input);
    }

    /**
     * Exchanges the two Elements at the given indices
     *
     * @param index1
     * @param index2
     */
    public void exchange(int index1, int index2)
    {
        T temp;
        temp = this.get(index1);
        this.set(index1, this.get(index2));
        this.set(index2, temp);
    }

    /**
     * Gets the Element at the Index Given
     *
     * @param index
     * @return The Element at the Index Given
     */
    public T get(int index)
    {
        return this.heap.get(index);
    }

    /**
     *
     * @return If the Heap is Empty
     */
    public boolean isEmpty()
    {
        return this.heap.isEmpty();
    }

    /**
     * Gets the Left Child at the Index Given
     *
     * @param index
     * @return The Left Child at the Index Given
     */
    public T leftChild(int index)
    {
        return this.heap.get(leftChildIndex(index));
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
    public T parent(int index)
    {
        return this.heap.get(parentIndex(index));
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
    public T pop()
    {
        return this.heap.remove(heap.size() - 1);
    }

    /**
     * adds an Element to the Heap
     *
     * @param value
     */
    public void push(T value)
    {
        this.heap.add(value);
    }

    /**
     * Gets the Right Child at the Index Given
     *
     * @param index
     * @return The Right Child at the Index Given
     */
    public T rightChild(int index)
    {
        return this.heap.get(rightChildIndex(index));
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
    public void set(int index, T value)
    {
        this.heap.set(index, value);
    }

    /**
     * Gets the size of the Heap
     *
     * @return The size of the Heap
     */
    public int size()
    {
        return this.heap.size();
    }
}
