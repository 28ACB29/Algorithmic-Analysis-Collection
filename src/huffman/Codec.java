package huffman;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Arthur C. Baroi
 */
public class Codec {

    /**
     * Permissible Characters for input String
     */
    public static final char[] characters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '!', '\'', ',', '.'};

    /**
     * Encodings for Characters
     */
    private String[] encodings;

    /**
     * Fixed Length Encodings for Characters
     */
    public static final String[] fixedLengthEncodings = {"000000", "000001", "000010", "000011", "000100", "000101", "000110", "000111", "001000", "001001", "001010", "001011", "001100", "001101", "001110", "001111", "010000", "010001", "010010", "010011", "010100", "010101", "010110", "010111", "011000", "011001", "011010", "011011", "011100", "011101", "011110"};

    /**
     * Frequencies for Characters
     */
    private int[] frequencies;

    /**
     * Message for Characters
     */
    private String message;

    /**
     * One String
     */
    public static final String one = "1";

    /**
     * Priority Queue
     */
    private Queue queue;

    /**
     * Zero String
     */
    public static final String zero = "0";

    /**
     * Constructor
     * @param message
     */
    public Codec(String message) {
        this.message = message;
        generateFrequencies();
        this.queue = new Queue(characters, frequencies);
        createTree();
        encodings = new String[characters.length];
        final Node Root = queue.peek();
        Node Cursor;
        for (int i = 0; i < characters.length; i++) {

            //Reset cursor to the root of the tree
            Cursor = Root;
            encodings[i] = createEncodings(Cursor, "", characters[i]);
        }
    }

    private String createEncodings(Node cursor, String branch, char character) {
        StringBuilder output = new StringBuilder();

        //If the character is found
        if (cursor.getCharacter().equals(Character.toString(character))) {

            //Append what Branch was taken
            output.append(branch);
        }

        //If there is a Left Child
        if (cursor.getLeft() != null) {

            //Go search through that Left Child
            String leftResult = createEncodings(cursor.getLeft(), zero, character);

            //If search was succesful
            if (!leftResult.isEmpty()) {

                //Append what Branch was taken and the search result
                output.append(branch).append(leftResult);
            }
        }

        //If there is a Right Child
        if (cursor.getRight() != null) {

            //Go search through that Right Child
            String rightResult = createEncodings(cursor.getRight(), one, character);

            //If search was succesful
            if (!rightResult.isEmpty()) {

                //Append what Branch was taken and the search result
                output.append(branch).append(rightResult);
            }
        }
        return output.toString();
    }

    private void createTree() {
        final int length = characters.length - 1;
        Node left;
        Node right;
        int frequency;
        for (int i = 0; i < length; i++) {

            //Find the least 2 nodes
            left = queue.pop();
            right = queue.pop();
            frequency = left.getFrequency() + right.getFrequency();

            //Create a node using the previous nodes as children
            Node tree = new Node(frequency, left, right);

            //Insert the node
            queue.insert(tree);
        }
    }

    /**
     * Decodes a Coded String
     * @param code
     * @return a Decoded String
     */
    public String decode(String code) {
        StringBuilder output = new StringBuilder();
        final Node Root;
        Node Cursor;
        Root = queue.peek();
        Cursor = Root;

        //Go through the code
        for (int i = 0; i < code.length(); i++) {

            //If the character is a 1
            if (Character.toString(code.charAt(i)).equals(one)) {

                //Go to the Right Child
                Cursor = Cursor.getRight();

            //If the character is a 0
            } else {

                //Go to the Left Child
                Cursor = Cursor.getLeft();
            }

            //If the cursor is a character
            if (!Cursor.getCharacter().isEmpty()) {

                //Append Character
                output.append(Cursor.getCharacter());

                //Reset cursor to the root of the tree
                Cursor = Root;
            }
        }
        return output.toString();
    }

    /**
     * Encodes a String
     * @param message
     * @return a Encoded String
     */
    public String encode(String message) {
        StringBuilder output = new StringBuilder();

        //Go through the message
        for (int i = 0; i < message.length(); i++) {
            output.append(getCharacterEncoding(message.charAt(i)));
        }
        return output.toString();
    }

    private String getCharacterEncoding(char character) {
        String encoding;
        encoding = "";
        for (int i = 0; i < characters.length; i++) {
            if (character == characters[i]) {
                encoding = encodings[i];
            }
        }
        return encoding;
    }

    /**
     *
     * @param code
     * @return
     */
    public String fixedLengthDecoding(String code) {
        StringBuilder output = new StringBuilder();
        final int words;
        final int wordLength;
        int wordStart;
        String substring;
        String encoding;
        wordLength = 6;
        words = code.length() / wordLength;
        for (int i = 0; i < words; i++) {
            wordStart = wordLength * i;
            substring = code.substring(wordStart, wordStart + wordLength);
            for (int j = 0; j < fixedLengthEncodings.length; j++) {
                encoding = fixedLengthEncodings[j];
                if (substring.equals(encoding)) {
                    output.append(characters[j]);
                }
            }
        }
        return output.toString();
    }

    /**
     *
     * @return
     */
    public String fixedLengthEncoding() {
        StringBuilder output = new StringBuilder();
        char charAt;
        char character;
        for (int i = 0; i < message.length(); i++) {
            for (int j = 0; j < characters.length; j++) {
                charAt = message.charAt(i);
                character = characters[j];
                if (charAt == character) {
                    output.append(fixedLengthEncodings[j]);
                }
            }
        }
        return output.toString();
    }

    private void generateFrequencies() {
        frequencies = new int[characters.length];

        //Go through all the Characters in the String
        for (int i = 0; i < message.length(); i++) {

            //Go through all the Characters in the List
            for (int j = 0; j < frequencies.length; j++) {

                //If the current character in the message
                //matches the current character
                if (message.charAt(i) == characters[j]) {

                    //Increment frequency
                    frequencies[j]++;
                }
            }
        }
    }

    /**
     * @return The Encodings
     */
    public String[] getEncodings() {
        return encodings;
    }

    /**
     * @return The Frequencies
     */
    public int[] getFrequencies() {
        return frequencies;
    }

    /**
     * Format a Codec
     * @param message
     * @return a Formatted Codec
     */
    public static String formatCodec(String message) {
        StringBuilder output = new StringBuilder();
        Codec codec;
        final int[] codecFrequencies;
        final String[] codecEncodings;
        final String codecFixedLengthEncoding;
        final int lastIndex;
        String code;
        output.append("Message: ").append(message).append(newline).append(characters);
        codec = new Codec(message);
        codecFrequencies = codec.getFrequencies();
        codecEncodings = codec.getEncodings();
        codecFixedLengthEncoding = codec.fixedLengthEncoding();
        lastIndex = Codec.characters.length - 1;

        //Display characters
        for (int i = 0; i < lastIndex; i++) {
            output.append(Codec.characters[i]).append(separator);
        }

        //Finish the Row
        output.append(Codec.characters[lastIndex]).append(newline);

        //Display frequencies
        output.append(Assignment7.frequencies);
        for (int i = 0; i < lastIndex; i++) {
            output.append(codecFrequencies[i]).append(separator);
        }

        //Finish the Row
        output.append(codecFrequencies[lastIndex]).append(newline);

        //Display codes
        output.append(codes);
        for (int i = 0; i < lastIndex; i++) {
            output.append(codecEncodings[i]).append(separator);
        }

        //Finish the Row
        output.append(codecEncodings[lastIndex]).append(newline);

        //Display encoded and decoded message
        code = codec.encode(message);
        output.append(encodedMessage).append(code).append(newline);
        output.append(codeLength).append(code.length()).append(newline);
        output.append(decodedMessage).append(codec.decode(code)).append(newline);
        output.append(newline);

        //Do Fixed Length encoding and decoding
        output.append("Message: ").append(message).append(newline);
        output.append(characters);

        //Display characters
        for (int i = 0; i < lastIndex; i++) {
            output.append(Codec.characters[i]).append(separator);
        }

        //Finish the Row
        output.append(Codec.characters[lastIndex]).append(newline);

        //Display Fixed Length codes
        output.append(fixedLengthCodes);
        for (int i = 0; i < lastIndex; i++) {
            output.append(Codec.fixedLengthEncodings[i]).append(separator);
        }

        //Finish the Row
        output.append(Codec.fixedLengthEncodings[lastIndex]).append(newline);

        //Display encoded and decoded Fixed Length message
        output.append(fixedLengthEncodedMessage).append(codecFixedLengthEncoding).append(newline);
        output.append(fixedLengthCodeLength).append(codecFixedLengthEncoding.length()).append(newline);
        output.append(fixedLengthDecodedMessage).append(codec.fixedLengthDecoding(codecFixedLengthEncoding)).append(newline);
        output.append(newline);
        return output.toString();
    }
}
