package io;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arthur C. Baroi
 */
public class BuilderWriter {

    /**
     * File Handle
     */
    private String file;

    /**
     * String Builder
     */
    private StringBuilder builder;

    /**
     * File Writer
     */
    private FileWriter writer;

    /**
     * Constructor
     * @param file
     */
    public BuilderWriter(String file) {
        this.builder = new StringBuilder();
        this.file = file;
        try {
            this.writer = new FileWriter(this.file, false);
        } catch (IOException ex) {
            Logger.getLogger(BuilderWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param str
     * @return
     */
    public BuilderWriter append(String str) {
        builder.append(str);
        return this;
    }

    /**
     *
     * @param b
     * @return
     */
    public BuilderWriter append(boolean b) {
        builder.append(b);
        return this;
    }

    /**
     *
     * @param c
     * @return
     */
    public BuilderWriter append(char c) {
        builder.append(c);
        return this;
    }

    /**
     *
     * @param d
     * @return
     */
    public BuilderWriter append(double d) {
        builder.append(d);
        return this;
    }

    /**
     *
     * @param f
     * @return
     */
    public BuilderWriter append(float f) {
        builder.append(f);
        return this;
    }

    /**
     *
     * @param i
     * @return
     */
    public BuilderWriter append(int i) {
        builder.append(i);
        return this;
    }

    /**
     *
     * @param lng
     * @return
     */
    public BuilderWriter append(long lng) {
        builder.append(lng);
        return this;
    }

    /**
     * Writes Data stored in the StringBuilder to the File
     */
    public void write() {
        try {
            writer.write(builder.toString());
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(BuilderWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
