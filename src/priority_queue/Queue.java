package priority_queue;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;

/**
 *
 * @author Arthur C. Baroi
 */
public class Queue
{

    /**
     * Heap Structure
     */
    private ArrayList<Record> heap;

    /**
     * Default Constructor
     */
    public Queue()
    {
        heap = new ArrayList<Record>();
    }

    /**
     * Constructor
     *
     * @param size
     */
    public Queue(int size)
    {
        heap = new ArrayList<Record>(size);
    }

    /**
     * Copy Constructor
     *
     * @param Input
     */
    public Queue(Queue Input)
    {
        final int size;
        size = Input.heap.size();
        heap = new ArrayList<Record>(size);
        for(int i = 0; i < size; i++)
        {
            heap.set(i, Input.get(i));
        }
    }

    /**
     * Conversion Constructor
     *
     * @param input
     */
    public Queue(Record[] input)
    {
        final int length;
        length = input.length;
        heap = new ArrayList<Record>(length);
        for(int i = 0; i < length; i++)
        {
            heap.add(i, input[i]);
        }
    }

    /**
     * Builds a Heap that observes the Heap Property
     *
     * @param Input
     * @return A Heap that observes the Heap Property
     */
    private ArrayList<Record> buildHeap(ArrayList<Record> Input)
    {
        ArrayList<Record> Output;
        final int parentIndex;
        Output = new ArrayList<Record>(Input);
        parentIndex = parentIndex(Output.size() - 1);

        //Start from the parent of the Last node and iterate through the earlier Nodes
        for(int i = parentIndex; i > -1; i--)
        {
            Output = heapify(Output, i);
        }
        return Output;
    }

    /**
     * sorts an array using The Heap Sort Algorithm
     *
     * @param input
     */
    private void heapSort()
    {

        //Create a temporary copy of The Heap
        ArrayList<Record> Temp;
        ArrayList<Record> output;
        final int lastIndex;
        Temp = new ArrayList<Record>(heap);
        output = new ArrayList<Record>(heap);

        //Create a new heap
        Temp = buildHeap(Temp);
        Record temp;
        lastIndex = Temp.size() - 1;

        //Go through all the Nodes except root in reverse order
        for(int i = lastIndex; i > 0; i--)
        {

            //Exchange node with root
            temp = Temp.get(i);
            Temp.set(i, Temp.get(0));
            Temp.set(0, temp);

            //Remove Last Element from The Heap and add it to the Output Array
            output.set(i, Temp.remove(Temp.size() - 1));

            //Restore Heap Property
            Temp = heapify(Temp, 0);
        }

        //Check if the Queue is empty
        if(!Temp.isEmpty())
        {

            //Remove Last Element from The Heap and add it to the Output Array
            output.set(0, Temp.remove(Temp.size() - 1));
        }
        heap = output;
    }

    /**
     * Helper function designed to build a Heap
     *
     * @param input
     * @param index
     * @return A heap
     */
    private ArrayList<Record> heapify(ArrayList<Record> input, int index)
    {
        ArrayList<Record> Output;
        int leftIndex;
        int rightIndex;
        final int size;
        final Record value;
        Output = new ArrayList<Record>(input);

        //Get Child Indices
        leftIndex = leftChildIndex(index);
        rightIndex = rightChildIndex(index);
        int largest;
        size = Output.size() - 1;
        value = Output.get(index);
        Record temp;

        //If the Left Child index is within The Heap
        //and greater than the Node Value
        if(leftIndex <= size && Output.get(leftIndex).getPriority() > value.getPriority())
        {

            //The Left Child is the Largest
            largest = leftIndex;
        }
        else
        {

            //The Current Node is the Largest
            largest = index;
        }

        //If the Right Child index is within The Heap
        //and the Node Value is greater than the Largest value
        if(rightIndex <= size && Output.get(rightIndex).getPriority() > Output.get(largest).getPriority())
        {

            //The Right Child is the Largest
            largest = rightIndex;
        }

        //If the Largest Index is not the Current Node Index
        if(largest != index)
        {

            //Exchange the Current Node with the Largest Node
            temp = Output.get(index);
            Output.set(index, Output.get(largest));
            Output.set(largest, temp);

            //Restore Heap Property
            heapify(Output, largest);
        }
        return Output;
    }

    /**
     * Exchanges the two Elements at the given Indices
     *
     * @param index1
     * @param index2
     */
    public void exchange(int index1, int index2)
    {
        Record temp;
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
    public Record get(int index)
    {
        return heap.get(index);
    }

    /**
     * Gets the Left Child at the Index Given
     *
     * @param index
     * @return The Left Child at the Index Given
     */
    public Record leftChild(int index)
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
     * Returns whether or not the Heap is Empty
     *
     * @return whether or not the Heap is Empty
     */
    public boolean isEmpty()
    {
        return heap.isEmpty();
    }

    /**
     * Increments the time for all the records
     */
    public void incrementTime()
    {
        for(Record record : heap)
        {
            record.incrementTime();
        }
    }

    /**
     * Gets the Parent at the Index Given
     *
     * @param index
     * @return The Parent at the Index Given
     */
    public Record parent(int index)
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
     * returns the Maximum Element
     *
     * @return The Maximum Element
     */
    public Record peek()
    {
        return heap.get(heap.size() - 1);
    }

    /**
     * removes the Maximum Element and returns it
     *
     * @return The Maximum Element
     */
    public Record pop()
    {
        Record element;
        element = heap.remove(heap.size() - 1);
        heapSort();
        return element;
    }

    /**
     * Pushes a Record onto the Queue
     *
     * @param Value
     */
    public void push(Record Value)
    {
        heap.add(Value);
        heapSort();
    }

    /**
     * Removes a Record from the Queue at the Index Given
     *
     * @param index
     * @return a Record from the Queue at the Index Given
     */
    public Record remove(int index)
    {
        Record element;
        element = heap.remove(index);
        heapSort();
        return element;
    }

    /**
     * Removes a Record from the Queue
     *
     * @param Element
     * @return a Record from the Queue
     */
    public boolean remove(Record Element)
    {
        boolean removed;
        removed = heap.remove(Element);
        heapSort();
        return removed;
    }

    /**
     * Gets the Right Child at the Index Given
     *
     * @param index
     * @return The Right Child at the Index Given
     */
    public Record rightChild(int index)
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
     * Sets the Element at the Index Given with the Given Value
     *
     * @param index
     * @param value
     */
    public void set(int index, Record value)
    {
        heap.set(index, value);
    }

    /**
     * Gets the Size of The Heap
     *
     * @return The Size of The Heap
     */
    public int size()
    {
        return heap.size();
    }

    /**
     * Formats a Record
     *
     * @param queue
     * @return A formatted Record
     */
    private static String formatQueue(Queue queue)
    {
        StringBuilder output;
        final int length;
        final int lastIndex;
        length = queue.size();
        lastIndex = queue.size() - 1;
        output = new StringBuilder(length);

        //Go through and generate the String leaving the Last Member off
        for(int i = 0; i < lastIndex; i++)
        {
            output.append(Record.formatRecord(queue.get(i)));
        }

        //Check if the Queue is Empty
        if(!queue.isEmpty())
        {

            //Append the Last Member
            output.append(Record.formatRecord(queue.get(lastIndex)));
        }
        return output.toString();
    }

    /**
     * Move a Record
     *
     * @param sender
     * @param reciever
     */
    private static void moveRecord(Queue sender, Queue reciever)
    {
        reciever.push(sender.pop());
    }
}
