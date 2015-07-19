package priority_queue;

import constants.Constants;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Arthur C. Baroi
 */
public class Record {

    /**
     * Record Name
     */
    private String name;

    /**
     * Record Number
     */
    private int number;

    /**
     * Record Priority
     */
    private int priority;

    /**
     * Record Time
     */
    private int time;

    /**
     * Constructor
     * @param number
     * @param name
     * @param priority
     */
    public Record(int number, String name, int priority) {
        this.name = name;
        this.number = number;
        this.priority = priority;
        this.time = 0;
    }

    /**
     * @return The Name
     */
    public String getName() {
        return name;
    }

    /**
     * @return The Number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @return The Priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @return The Time
     */
    public int getTime() {
        return time;
    }

    public void incrementTime() {
        time++;
    }

    /**
     * @param name The Name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param number The Number to set
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * @param priority The Priority to set
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * @param time The Time to set
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Formats a Record to be displayed
     * @param Record
     * @return String of a Record to be displayed
     */
    public static String displayRecord(Record Record) {
        StringBuilder output = new StringBuilder();
        return output.append(Constants.recordNumber).append(Record.getNumber()).append(Constants.separator).append(Constants.recordName).append(Record.getName()).append(Constants.separator).append(Constants.recordPriority).append(Record.getPriority()).append(Constants.separator).append(Constants.recordTime).append(Record.getTime()).append(Constants.newline).toString();
    }

    /**
     * Formats a Record
     * @param Record
     * @return a formatted Record
     */
    public static String formatRecord(Record Record) {
        StringBuilder output = new StringBuilder();
        return output.append(Record.getNumber()).append(Constants.separator).append(Record.getName()).append(Constants.separator).append(Record.getPriority()).append(Constants.separator).append(Record.getTime()).append(Constants.newline).toString();
    }
}
