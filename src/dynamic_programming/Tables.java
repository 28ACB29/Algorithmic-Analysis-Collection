package dynamic_programming;

import constants.Constants;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Arthur C. Baroi
 */
public class Tables {

    /**
     * Multiplication Table
     */
    private int[][] multiplications;

    /**
     * Order Table
     */
    private int[][] order;

    /**
     * Table Size
     */
    private int size;

    /**
     * Default Constructor
     * @param size
     */
    public Tables(int size) {
        this.multiplications = new  int[size][size];
        this.order = new  int[size][size];
        this.size = size;
    }

    /**
     * @return The multiplications
     */
    public int[][] getMultiplications() {
        return multiplications;
    }

    /**
     * @param i
     * @param j
     * @return The multiplications
     */
    public int getMultiplicationsElement(int i, int j) {
        return multiplications[i][j];
    }

    /**
     * @return The order
     */
    public int[][] getOrder() {
        return order;
    }

    /**
     * @param i
     * @param j
     * @return The order
     */
    public int getOrderElement(int i, int j) {
        return order[i][j];
    }

    /**
     * @return The Size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param multiplications The multiplications to set
     */
    public void setMultiplications(int[][] multiplications) {
        this.multiplications = multiplications;
    }

    /**
     * @param value
     * @param i
     * @param j
     */
    public void setMultiplicationsElement(int value, int i, int j) {
        this.multiplications[i][j] = value;
    }

    /**
     * @param order The order to set
     */
    public void setOrder(int[][] order) {
        this.order = order;
    }

    /**
     * @param value
     * @param i
     * @param j
     */
    public void setOrderElement(int value, int i, int j) {
        this.order[i][j] = value;
    }

    /**
     * @param size The Size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Format Dimensions
     * @param dimensions
     * @return Format Dimensions
     */
    public static String formatDimensions(int[] dimensions) {
        StringBuilder output = new StringBuilder();
        final int lastIndex;
        output.append(Constants.matrixChain).append(Constants.newline).append(Constants.newline);
        lastIndex = dimensions.length - 1;
        for (int i = 0; i < lastIndex; i++) {
            output.append(Constants.matrix).append(i + 1).append(Constants.colon).append(dimensions[i]).append(Constants.multiplicationSign).append(dimensions[i + 1]).append(Constants.newline);
        }
        return output.toString();
    }

    /**
     * Format a Table
     * @param table
     * @return A formatted Table
     */
    public static String formatTable(int[][] table) {
        StringBuilder output = new StringBuilder();
        final int rowLength;
        final int columnLength;
        output.append(Constants.space).append(Constants.separator);
        rowLength = table.length;
        columnLength = table[0].length;

        //Go Through and generate the Columns leaving the last Column off
        for (int i = 0; i < columnLength; i++) {
            output.append(i + 1).append(Constants.separator);
        }

        //Finish the Row
        output.append(Constants.newline);

        //Go through and generate the String leaving the last Member off
        for (int i = 0; i < rowLength; i++) {
            output.append(i + 1).append(Constants.separator);
            for (int j = 0; j < columnLength; j++) {
                output.append(table[i][j]).append(Constants.separator);
            }

            //Finish the Row
            output.append(Constants.newline);
        }
        return output.toString();
    }

    /**
     * A function that creates tables of multiplications and orders
     * @param dimensions
     * @return tables of multiplication and order tables
     */
    public static Tables matrixChainOrder(int[] dimensions) {
        int n;
        Tables tables;
        int j;
        int q;
        n = dimensions.length - 1;

        //Create new tables
        tables = new Tables(n);

        //Go through the entire chain
        for (int l = 1; l < n; l++) {

            //Go through each Sub-Chain
            for (int i = 0; i < n - l; i++) {
                j = i + l;

                //Calculate the number of scalar multiplications per chain
                for (int k = i; k < j; k++) {
                   q = tables.getMultiplicationsElement(i, k) + tables.getMultiplicationsElement(k + 1, j) + dimensions[i] * dimensions[k + 1] * dimensions[j + 1];
                    if (q < tables.getMultiplicationsElement(i, j) || (tables.getMultiplicationsElement(i, j) == 0 && i != j)) {
                        tables.setMultiplicationsElement(q, i, j);
                        tables.setOrderElement(k, i, j);
                    }
                }
            }
        }
        return tables;
    }

    /**
     * Print Optimal Parenthesization
     * @param order
     * @param i
     * @param j
     * @return Print Optimal Parenthesization
     */
    public static String printOptimalParens(int[][] order, int i, int j) {
        StringBuilder Output = new StringBuilder();
        if (i == j) {
            Output.append(Constants.matrix).append(i + 1);
        } else {
            Output.append(Constants.left);
            Output.append(printOptimalParens(order, i, order[i][j]));
            Output.append(printOptimalParens(order, order[i][j] + 1, j));
            Output.append(Constants.right);
        }
        return Output.toString();
    }
}
