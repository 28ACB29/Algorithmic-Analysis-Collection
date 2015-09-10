package sort;

import constants.Constants;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Arthur C. Baroi
 */
public class Sort
{

    /**
     * Cost Counter for Insertion Sort Algorithm
     */
    private int insertionTotalCount;

    /**
     * Cost Counter for Merge Sort Algorithm
     */
    private int mergeTotalCount;

    /**
     * Cost Counter for the Heap Sort Algorithm
     */
    private int heapTotalCount;

    /**
     * Cost Counter for the Quick Sort algorithm
     */
    private int quickTotalCount;

    /**
     * Default Constructor
     */
    public Sort()
    {

        //Reset cost counters
        resetInsertionCounter();
        resetMergeCounter();
        resetHeapCounter();
        resetQuickCounter();
    }

    /**
     * @return The insertionTotalCount
     */
    public int getInsertionTotalCount()
    {
        return insertionTotalCount;
    }

    /**
     * @return The mergeTotalCount
     */
    public int getMergeTotalCount()
    {
        return mergeTotalCount;
    }

    /**
     * @return The heapTotalCount
     */
    public int getHeapTotalCount()
    {
        return heapTotalCount;
    }

    /**
     * @return The quickTotalCount
     */
    public int getQuickTotalCount()
    {
        return quickTotalCount;
    }

    /**
     * Reset Insertion Sort Cost Counter
     */
    public void resetInsertionCounter()
    {

        //Set Counter to 0
        insertionTotalCount = 0;
    }

    /**
     * Reset Merge Sort Cost Counter
     */
    public void resetMergeCounter()
    {

        //Set Counter to 0
        mergeTotalCount = 0;
    }

    /**
     * Reset the Heap Sort Counter
     */
    public void resetHeapCounter()
    {

        //Set Counter to 0
        heapTotalCount = 0;
    }

    /**
     * reset quick Sort Counter
     */
    public void resetQuickCounter()
    {

        //Set Cost Counter to 0
        quickTotalCount = 0;
    }

    /**
     * Sorts an Array using the Insertion Sort Algorithm
     *
     * @param input The input Array
     * @return The Sorted Array
     */
    public int[] InsertionSort(int[] input)
    {
        int[] output;
        output = input.clone();
        int key;
        int j;

        //Iterate through the entire Array
        for(int i = 1; i < output.length; i++)
        {
            insertionTotalCount++;

            //Select a Key Value to compare to
            key = output[i];
            insertionTotalCount++;

            //Pick the element just before the current one
            j = i - 1;
            insertionTotalCount++;

            //While j is within bounds
            //and the jth element is greater than the Key Value
            while(j > -1 && output[j] > key)
            {
                insertionTotalCount++;

                //Shift the element forward 1 place
                output[j + 1] = output[j];
                insertionTotalCount++;

                //Choose the next lower position
                j -= 1;
                insertionTotalCount++;
            }
            insertionTotalCount++;

            //Put the Key Value in the correct place
            output[j + 1] = key;
            insertionTotalCount++;
        }
        return output;
    }

    /**
     * Gets the sub-array between the two endpoints inclusively
     *
     * @param input
     * @param start
     * @param end
     * @return The sub-array between two endpoints
     */
    private int[] subArray(int[] input, int start, int end)
    {
        int[] output;
        output = new int[end - start + 1];

        //Copy elements from start iindex to end Index
        //from the original Array to the new Array
        for(int i = 0; i < output.length; i++)
        {
            mergeTotalCount++;
            output[i] = input[i + start];
            mergeTotalCount++;
        }
        return output;
    }

    /**
     * Merge two Arrays by successively popping the smallest element
     * at the head of the Array and putting it into the list
     *
     * @param left
     * @param right
     * @return the merged Array
     */
    private int[] Merge(int[] left, int[] right)
    {
        int[] output;
        int i;
        output = new int[left.length + right.length];

        //Define new position indicators for both Arrays
        i = 0;
        mergeTotalCount++;
        int j = 0;
        mergeTotalCount++;
        for(int k = 0; k < output.length; k++)
        {
            mergeTotalCount++;

            //If there are no more elements on the Right Array
            if(j >= right.length)
            {
                mergeTotalCount++;

                //Pop off the element from the Left Array
                output[k] = left[i];
                mergeTotalCount++;
                i += 1;
                mergeTotalCount++;
            }

            //If there are no more elements on the Left Array
            else if(i >= left.length)
            {
                mergeTotalCount++;

                //Pop off the element from the Right Array
                output[k] = right[j];
                mergeTotalCount++;
                j += 1;
                mergeTotalCount++;
            }

            //If the Left head is less than the Right head
            else if(left[i] <= right[j])
            {
                mergeTotalCount++;

                //Pop off the element from the Left Array
                output[k] = left[i];
                mergeTotalCount++;
                i += 1;
                mergeTotalCount++;

                //If the Right head is less than the Left head
            }
            else
            {
                mergeTotalCount++;

                //Pop off the element from the Right Array
                output[k] = right[j];
                mergeTotalCount++;
                j += 1;
                mergeTotalCount++;
            }
        }
        return output;
    }

    /**
     * Sorts an Array using the Merge Sort Algorithm
     *
     * @param input the input Array
     * @return the sorted Array
     */
    public int[] MergeSort(int[] input)
    {
        int[] output;
        int start;
        int end;
        output = input.clone();
        start = 0;
        end = input.length - 1;

        //If the Array is larger than 1, then perform Merge sort
        if(start < end)
        {
            mergeTotalCount++;

            //Find the middle Index of the Array
            int middle = (end + start) / 2;
            mergeTotalCount++;

            //Do a recursive sort of the first Subarray
            int[] left = MergeSort(subArray(input, start, middle));
            mergeTotalCount++;

            //Do a recursive sort of the second Subarray
            int[] right = MergeSort(subArray(input, middle + 1, end));
            mergeTotalCount++;

            //Merge the two Subarrays together
            output = Merge(left, right);
            mergeTotalCount++;
        }
        else
        {
            mergeTotalCount++;
        }
        return output;
    }

    /**
     * Helper function designed to build a Heap
     *
     * @param input
     * @param index
     * @return Heap that partially observes the Heap Property
     */
    public Heap heapify(Heap input, int index)
    {
        Heap output;
        int leftIndex;
        int rightIndex;
        int largest;
        final int size;
        final int value;
        output = new Heap(input);

        //Get Child indices
        leftIndex = output.leftChildIndex(index);
        heapTotalCount++;
        rightIndex = output.rightChildIndex(index);
        heapTotalCount++;
        size = output.size() - 1;
        value = output.get(index);

        //If the Left Child Index is within the Heap
        //and Greater Than the Node Value
        if(leftIndex <= size && output.get(leftIndex) > value)
        {
            heapTotalCount++;

            //The Left Child is The Largest
            largest = leftIndex;
            heapTotalCount++;
        }
        else
        {
            heapTotalCount++;

            //The Current Node is The Largest
            largest = index;
            heapTotalCount++;
        }

        //If the Right Child Index is within the Heap
        //and the Node Value is Greater Than The Largest value
        if(rightIndex <= size && output.get(rightIndex) > output.get(largest))
        {
            heapTotalCount++;

            //The Right Child is The Largest
            largest = rightIndex;
            heapTotalCount++;
        }

        //If The Largest index is not the Current Node Index
        if(largest != index)
        {
            heapTotalCount++;

            //Exchange the Current Node with The Largest
            output.exchange(index, largest);
            heapTotalCount++;

            //Restore Heap Property
            output = heapify(output, largest);
            heapTotalCount++;
        }
        return output;
    }

    /**
     * Builds a Heap that observes the Heap Property
     *
     * @param input
     * @return A Heap that observes the Heap Property
     */
    public Heap buildHeap(Heap input)
    {
        Heap output;
        final int parentIndex;
        output = new Heap(input);
        parentIndex = output.parentIndex(output.size() - 1);

        //Start from the parent of the last Node
        //and iterate through the earlier Nodes
        for(int i = parentIndex; i > -1; i--)
        {
            heapTotalCount++;
            output = heapify(output, i);
            heapTotalCount++;
        }
        return output;
    }

    /**
     * Sorts an Array using the Heap Sort Algorithm
     *
     * @param input
     * @return The Sorted Array
     */
    public int[] heapSort(int[] input)
    {
        Heap temp;
        int[] output;
        final int lastIndex;
        temp = new Heap(input);
        output = new int[input.length];

        //Create a new Heap
        temp = buildHeap(temp);
        heapTotalCount++;
        lastIndex = temp.size() - 1;

        //Go through all the Nodes except Root in reverse order
        for(int i = lastIndex; i > 0; i--)
        {
            heapTotalCount++;

            //Exchange Node with Root
            temp.exchange(i, 0);
            heapTotalCount++;

            //Remove Last Element from the Heap and add it to the Output Array
            output[i] = temp.pop();
            heapTotalCount++;

            //Restore Heap Property
            temp = heapify(temp, 0);
            heapTotalCount++;
        }

        //Check if the Heap is Empty
        if(!temp.isEmpty())
        {

            //Remove Last Element from the Heap and add it to the Output Array
            output[0] = temp.pop();
        }
        heapTotalCount++;
        return output;
    }

    /**
     * Generates a random Pivot Index
     *
     * @param size
     * @return A random Pivot Index
     */
    public int generatePivotIndex(int size)
    {
        return (int) (Math.random() * size);
    }

    /**
     * Creates a partitioned Array with Values that are greater than
     * the value at the Pivot Index
     *
     * @param input
     * @param pivotIndex
     * @return A partitioned Array with Values that are greater than
     * the value at the Pivot Index
     */
    public int[] partitionAbove(int[] input, int pivotIndex)
    {
        final int length;
        final int lastIndex;
        int pivotValue;
        ArrayList<Integer> Temp;
        final int size;
        int[] output;
        length = input.length;
        lastIndex = length - 1;
        pivotValue = input[pivotIndex];
        Temp = new ArrayList<Integer>(lastIndex);

        //Partition the Array by choosing Values greater than to the Pivot value
        for(int i = 0; i < pivotIndex; i++)
        {
            quickTotalCount++;
            if(input[i] > pivotValue)
            {
                quickTotalCount++;
                Temp.add(input[i]);
                quickTotalCount++;
            }
        }
        for(int i = pivotIndex + 1; i < length; i++)
        {
            quickTotalCount++;
            if(input[i] > pivotValue)
            {
                quickTotalCount++;
                Temp.add(input[i]);
                quickTotalCount++;
            }
        }
        quickTotalCount++;

        //Write out the List to an Array
        //(not part of the algorithm)
        size = Temp.size();
        output = new int[size];
        for(int i = 0; i < size; i++)
        {
            output[i] = Temp.get(i);
        }
        return output;
    }

    /**
     * Creates a partitioned Array with Values that are Lesser than
     * or equal to the Value at the Pivot Index
     *
     * @param input
     * @param pivotIndex
     * @return A partitioned Array with Values that are Lesser than
     * or equal to the Value at the Pivot Index
     */
    public int[] partitionBelow(int[] input, int pivotIndex)
    {
        final int length;
        final int lastIndex;
        final int pivotValue;
        length = input.length;
        ArrayList<Integer> Temp;
        final int size;
        int[] output;
        lastIndex = length - 1;
        pivotValue = input[pivotIndex];
        Temp = new ArrayList<Integer>(lastIndex);

        //Partition the Array by choosing Values Lesser than or equal to the Pivot Value
        for(int i = 0; i < pivotIndex; i++)
        {
            quickTotalCount++;
            if(input[i] <= pivotValue)
            {
                quickTotalCount++;
                Temp.add(input[i]);
                quickTotalCount++;
            }
        }
        quickTotalCount++;
        for(int i = pivotIndex + 1; i < length; i++)
        {
            quickTotalCount++;
            if(input[i] <= pivotValue)
            {
                quickTotalCount++;
                Temp.add(input[i]);
                quickTotalCount++;
            }
        }
        quickTotalCount++;

        //Write out the List to an Array
        //(not part of the algorithm)
        size = Temp.size();
        output = new int[size];
        for(int i = 0; i < size; i++)
        {
            output[i] = Temp.get(i);
        }
        return output;
    }

    /**
     * Sorts an Array using the quick Sort algorithm
     *
     * @param input the input Array
     * @return The sorted Array
     */
    public int[] QuickSort(int[] input)
    {
        int[] output;
        final int pivotIndex;
        final int pivotValue;
        final int[] below;
        final int[] above;
        output = input.clone();

        //Choose a Pivot Index randomly
        pivotIndex = generatePivotIndex(input.length);
        quickTotalCount++;

        //If Array is greater than 1
        if(0 < output.length - 1)
        {
            quickTotalCount++;
            pivotValue = input[pivotIndex];

            //partiton the Array
            below = QuickSort(partitionBelow(output, pivotIndex));
            quickTotalCount++;
            above = QuickSort(partitionAbove(output, pivotIndex));
            quickTotalCount++;
            System.arraycopy(below, 0, output, 0, below.length);
            output[below.length] = pivotValue;
            System.arraycopy(above, 0, output, below.length + 1, above.length);
        }
        quickTotalCount++;
        return output;
    }

    /**
     * Formats an Array
     *
     * @param input
     * @return A formatted Array
     */
    private static String formatArray(int[] input)
    {
        StringBuilder output = new StringBuilder();
        final int lastIndex;
        lastIndex = input.length - 1;

        //Go through and generate the String leaving the Last Member off
        for(int i = 0; i < lastIndex; i++)
        {
            output.append(input[i]).append(Constants.separator);
        }

        //Check if the Queue is Empty
        if(lastIndex > Constants.outOfBoundsIndex)
        {

            //Append the Last Element
            output.append(input[lastIndex]);
        }
        return output.toString();
    }
}
