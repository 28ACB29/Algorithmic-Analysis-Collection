/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

/**
 *
 * @author Arthur C. Baroi
 */
public class Constants
{

    /**
     * End size for Arrays
     */
    public static final int end = 16;

    /**
     * Header for the input Array Column
     */
    public static final String input = "Input Array for size = ";

    /**
     * Header for the Insertion Sort Cost Actual Column
     */
    public static final String insertionSortActualCost = "Insertion Sort Actual Cost";

    /**
     * File Handle for the Insertion Sort Arrays
     */
    public static final String insertionSortArraysFile = "./insertionSortArrays.csv";

    /**
     * File Handle for the Insertion Sort Table
     */
    public static final String insertionSortTableFile = "./insertionSortTable.csv";

    /**
     * Header for the Insertion Sort theoretical cost Column
     */
    public static final String insertionSortTheoreticalCost = "O(n^2)";

    /**
     * Header for the Merge Sort Actual Cost Column
     */
    public static final String mergeSortActualCost = "Merge Sort Actual Cost";

    /**
     * File Handle for the Merge Sort Arrays
     */
    public static final String mergeSortArraysFile = "./mergeSortArrays.csv";

    /**
     * File Handle for the Merge Sort Table
     */
    public static final String mergeSortTableFile = "./mergeSortTable.csv";

    /**
     * Header for the Merge Sort theoretical cost Column
     */
    public static final String mergeSortTheoreticalCost = "O(n lg(n))";

    /**
     * New Line Character for Terminating the end of a Line
     */
    public static final String newline = System.getProperty("line.separator");

    /**
     * Out of Bounds Index
     */
    public static final int outOfBoundsIndex = -1;

    /**
     * Header for the output Array Column
     */
    public static final String output = "Output Array for size = ";

    /**
     * Separator used for Delimiting Entries
     */
    public static final String separator = ", ";

    /**
     * Header for the Array Size Column
     */
    public static final String size = "Array Size";

    /**
     * Start Size for Arrays
     */
    public static final int start = 1;

    /**
     * Step increment size for Arrays
     */
    public static final int step = 1;

    /**
     * Header for the Heap Sort Actual Cost Column
     */
    public static final String heapSortActualCost = "Heap Sort Actual Cost";

    /**
     * File Handle for the Heap Sort Arrays
     */
    public static final String heapSortArraysFile = "./heapSortArrays.csv";

    /**
     * File Handle for the Heap Sort Table
     */
    public static final String heapSortTableFile = "./heapSortTable.csv";

    /**
     * Header for the Heap Sort Theoretical Cost Column
     */
    public static final String heapSortTheoreticalCost = "O(n lg(n))";

    /**
     * Probability of Record arrival
     */
    public static final double arrivalProbability = 0.8;

    /**
     * File Handle for the Change Log
     */
    public static final String changeLogFile = "./changeLog.txt";

    /**
     * Probability of Record deletion
     */
    public static final double deletionProbability = 0.5;

    /**
     * File Handle for the Executed Queue
     */
    public static final String executedQueueFile = "./executedQueue.csv";

    /**
     * Used to indicate that a job is finished
     */
    public static final String jobFinished = "Job for Record finished";

    /**
     * Header for The Job name of the Queue
     */
    public static final String jobName = "Job Name";

    /**
     * Header for The Job number of the Queue
     */
    public static final String jobNumber = "Job Number";

    /**
     * Header for The Job priority of the Queue
     */
    public static final String jobPriority = "Job Priority";

    /**
     * Header for The Job time of the Queue
     */
    public static final String jobTime = "Job Total Time";

    /**
     * Title for Change Log
     */
    public static final String logTitle = "Change Log for Simulation";

    /**
     * Queue size for the all Queues
     */
    public static final int maxQueueSize = 20;

    /**
     * Range of Name Values
     */
    public static final double nameRange = 9e7;

    /**
     * Offset of Name Values
     */
    public static final double nameOffset = 1e7;

    /**
     * Range of Priority Values
     */
    public static final int priorityRange = 40;

    /**
     * Offset of Priority Values
     */
    public static final int priorityOffset = -20;

    /**
     * Used to indicate that Record is added
     */
    public static final String recordAdded = "Record added to ready";

    /**
     * Used to indicate that Record is deleted
     */
    public static final String recordDeleted = "Record deleted from ready";

    /**
     * Used to indicate that Record is not added
     */
    public static final String recordNotAdded = "Record not added to ready";

    /**
     * Used to indicate that Record is not deleted
     */
    public static final String recordNotDeleted = "Record not deleted from ready";

    /**
     * File Handle for the Ready Queue
     */
    public static final String readyQueueFile = "./readyQueue.csv";

    /**
     * Prefix used for Job Names
     */
    public static final String texasState = "TXST-A";

    /**
     * total number of Time Steps
     */
    public static final int totalSteps = 25;

    /**
     * File Handle for the Waiting Queue
     */
    public static final String waitingQueueFile = "./waitingQueue.csv";

    /**
     * Used to indicate that a Record has been moved from waiting to executed
     */
    public static final String waitingToExecuted = "Record moved from waiting to executed";

    /**
     * Used to indicate that a Record has been moved from ready to waiting
     */
    public static final String readyToWaiting = "Record moved from ready to waiting";

    /**
     * Header for the Time Step
     */
    public static final String timeStep = "Timestep: ";

    /**
     * Header for the Record Name
     */
    public static final String recordName = "Name: ";

    /**
     * Used to indicate that a Record has not been moved
     */
    public static final String recordNotMoved = "Record not moved: ";

    /**
     * Header for the Record Number
     */
    public static final String recordNumber = "Number: ";

    /**
     * Header for the Record Priority
     */
    public static final String recordPriority = "Priority: ";

    /**
     * Header for the Record Time
     */
    public static final String recordTime = "Time: ";

    /**
     * Used to indicate that waiting is empty
     */
    public static final String waitingIsEmpty = "waiting queue is empty";

    /**
     * Used to indicate that executed is full
     */
    public static final String executedIsFull = "executed queue is full";

    /**
     * Used to indicate that ready is empty
     */
    public static final String readyIsEmpty = "ready queue is empty";

    /**
     * Used to indicate that waiting is full
     */
    public static final String waitingIsFull = "waiting queue is full";

    /**
     * Header for the actual Cost Column
     */
    public static final String actualCost = "Computational Cost";

    /**
     * Header for the Actual Cost of the Quick Sort Column
     */
    public static final String quickSortActualCost = "Quick Sort Cost";

    /**
     * File Handle for the Quick Sort Arrays
     */
    public static final String quickSortArraysFile = "./quickSortArrays.csv";

    /**
     * File Handle for the Quick Sort Table
     */
    public static final String quickSortTableFile = "./quickSortTable.csv";

    /**
     * Header for the Quick Sort Theoretical Cost Column
     */
    public static final String quickSortTheoreticalCost = "O(n^2)";

    /**
     * File Handle for the Quick Sort Table
     */
    public static final String sortCollectionTableFile = "./sortCollectionTable.csv";

    /**
     * Size for the Chained Hash Tables
     */
    public static final int chainedTableSize = 47;

    /**
     * Colon separator for delimiting title and Data
     */
    public static final String colon = ": ";

    /**
     * File Handle for the Division Hash Table
     */
    public static final String divisionHashTableFile = "./divisionHashTable.txt";

    /**
     * Title for the Division Hash Table
     */
    public static final String divisionHashTableTitle = "Output for Division Hash Table";

    /**
     *
     */
    public static final String element = "Element ";

    /**
     * Range of values that a key can take
     */
    public static final double keyRange = 9e7;

    /**
     * Offset from 0 of values that a key can take
     */
    public static final double keyOffset = 1e7;

    /**
     * File Handle for the Multiplication Hash Table
     */
    public static final String multiplicationHashTableFile = "./multiplicationHashTable.txt";

    /**
     * Title for the Multiplication Hash Table
     */
    public static final String multiplicationHashTableTitle = "Output for Multiplication Hash Table";

    /**
     * A known value that does not exist in the table
     */
    public static final int outOfBoundsKey = 0;

    /**
     * Size of the Quadratically Probed Hash Table
     */
    public static final int probedTableSize = 67;

    /**
     * File Handle for the Quadratic Probing Hash Table
     */
    public static final String quadraticProbingHashTableFile = "./quadraticProbingHashTable.txt";

    /**
     * Title for the Quadratic Probing Hash Table
     */
    public static final String quadraticProbingHashTableTitle = "Output for Quadratic Probing Hash Table";

    /**
     * File Handle for the Division Hash Table
     */
    public static final String searchLogFile = "./searchLog.txt";

    /**
     * Successful Search Example
     */
    public static final String successfulSearchExample = "Successful Search Example: Search for ";

    /**
     * Total number of students for the chained Hash Tables
     */
    public static final int totalStudentsChained = 150;

    /**
     * Total number of students for the quadratically probed Hash Tables
     */
    public static final int totalStudentsProbed = 60;

    /**
     * Unsuccessful Search Example
     */
    public static final String unsuccessfulSearchExample = "Unsuccessful Search Example: Search for ";

    /**
     * Title for the Search Log
     */
    public static final String logOfSearches = "Log of Searches";

    /**
     * Example Matrix Dimensions from the Book
     */
    public static final int[] dimensionBookExample =
    {
        30, 35, 15, 5, 10, 20, 25
    };

    /**
     * Length of Matrix Multiplication Chain
     */
    public static final int dimensionLength = 20;

    /**
     * Range of Values for Matrix Dimension
     */
    public static final int dimensionRange = 9;

    /**
     * Offset of Values for Matrix Dimension
     */
    public static final int dimensionOffset = 1;

    /**
     * Left Parenthesis
     */
    public static final char left = '(';

    /**
     * File Handle for the Matrices
     */
    public static final String matricesFile = "./matrices.txt";

    /**
     * File Handle for the Matrices from the Book
     */
    public static final String matricesBookExampleFile = "./matricesBookExample.txt";

    /**
     * Matrix Variable
     */
    public static final String matrix = "A";

    /**
     * Matrix Chain
     */
    public static final String matrixChain = "Matrix Chain";

    /**
     * String for Multiplication Sign
     */
    public static final String multiplicationSign = " x ";

    /**
     * File Handle for the Multiplication Table
     */
    public static final String multiplicationTableFile = "./multiplicationTable.csv";

    /**
     * File Handle for the Multiplication Table from the Book
     */
    public static final String multiplicationTableBookExampleFile = "./multiplicationTableBookExample.csv";

    /**
     * File Handle for the Order Table
     */
    public static final String orderTableFile = "./orderTable.csv";

    /**
     * File Handle for the Order Table from the Book
     */
    public static final String orderTableBookExampleFile = "./orderTableBookExample.csv";

    /**
     * Out of Bounds Value
     */
    public static final int outOfBoundsValue = Integer.MAX_VALUE;

    /**
     * Right Parenthesis
     */
    public static final char right = ')';

    /**
     *
     */
    public static final String space = " ";

    /**
     * Header for the Character Row
     */
    public static final String characters = "Characters: ";

    /**
     * Header for the Variable Length Code Length Row
     */
    public static final String codeLength = "Code Length: ";

    /**
     * Header for the Variable Length Codes Row
     */
    public static final String codes = "Variable Length Codes: ";

    /**
     * Header for the Decoded Message Row
     */
    public static final String decodedMessage = "Decoded message: ";

    /**
     * Header for the Encoded Message Row
     */
    public static final String encodedMessage = "Encoded message: ";

    /**
     * Header for the Variable Length Code Length Row
     */
    public static final String fixedLengthCodeLength = "Fixed Length Code Length: ";

    /**
     * Header for the Fixed Length Codes Row
     */
    public static final String fixedLengthCodes = "Fixed Length Codes: ";

    /**
     * Header for the Fixed Length Decoded Message Row
     */
    public static final String fixedLengthDecodedMessage = "Fixed Length Decoded message: ";

    /**
     * Header for the Fixed Length Encoded Message Row
     */
    public static final String fixedLengthEncodedMessage = "Fixed Length Encoded message: ";

    /**
     * Header for the Frequencies Row
     */
    public static final String frequencies = "Frequencies: ";

    /**
     *
     */
    public static final String message1 = "the quick brown fox jumped over the lazy dog.";

    /**
     *
     */
    public static final String message2 = "madam, i'm adam!";

    /**
     *
     */
    public static final String message3 = "a man, a plan, a canal, panama!";

    /**
     *
     */
    public static final String message4 = "lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    /**
     * File Handle for the Messages
     */
    public static final String messagesFile = "./messages.txt";

    /**
     * Title for messages
     */
    public static final String messages = "Messages";

    /**
     * File Handle for the Adjacency List
     */
    public static final String adjacencyListFile = "./adjacencyList.csv";

    /**
     * File Handle for the Adjacency List example Graph from the Book
     */
    public static final String adjacencyListBookExampleFile = "./adjacencyListBookExample.csv";

    /**
     * File Handle for the Adjacency Matrix
     */
    public static final String adjacencyMatrixFile = "./adjacencyMatrix.csv";

    /**
     * File Handle for the Adjacency Matrix example Graph from the Book
     */
    public static final String adjacencyMatrixBookExampleFile = "./adjacencyMatrixBookExample.csv";

    /**
     * Black Color for the Breadth First Search
     */
    public static final String black = "black";

    /**
     * File Handle for the Breadth First Tree
     */
    public static final String breadthFirstTreeFile = "./breadthFirstTree.csv";

    /**
     * File Handle for the Breadth First Tree example Graph from the Book
     */
    public static final String breadthFirstTreeBookExampleFile = "./breadthFirstTreeBookExample.csv";

    /**
     * Probability of there being a connection between 2 Nodes.
     */
    public static final double connectionProbability = .5;

    /**
     * Header for the Distance Column
     */
    public static final String distance = "Distance: ";

    /**
     * Example Graph from the Book
     */
    public static final int[][] graphBookExample =
    {
        {
            1, 4
        },
        {
            0, 5
        },
        {
            3, 5, 6
        },
        {
            2, 6, 7
        },
        {
            0
        },
        {
            1, 2, 6
        },
        {
            2, 3, 5, 7
        },
        {
            3, 6
        }
    };

    /**
     * Gray Color for the Breadth First Search
     */
    public static final String gray = "gray";

    /**
     * Out of Bounds Value
     */
    public static final int absoluteMaximum = Integer.MAX_VALUE;

    /**
     * Header for the Predecessor Column
     */
    public static final String predecessor = "Predecessor: ";

    /**
     * Header for the Vertex Column
     */
    public static final String vertex = "Vertex: ";

    /**
     * White Color for the Breadth First Search
     */
    public static final String white = "white";

}
