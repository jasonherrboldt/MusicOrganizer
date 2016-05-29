package com.jason;

import java.io.File;

/**
 * Main engine.
 *
 * Created by Jason Herrboldt (intothefuture@gmail.com) on 5/19/16.
 */
public class Main {

    /*

    Command line usage:

    input_filename      the name of the input file to use (no path = current path)
    output_filename     the desired name of the output file (no path = current path)
    -sortby             valid arguments are genre, artist, album, song, and time (can only be one)
    -sortorder          valid arguments are ascending and descending (can only be one)

    e.g.
    input_file.txt output_file.txt -sortby album -sortorder descending

     */
    public static void main(String[] args) {

        // Fail if the wrong number of command line arguments are received.
        if(args.length != 2 && args.length != 4 && args.length != 6) {
            throw new IllegalArgumentException("Invalid number of arguments received. Args length must be 2, 4, or 6.");
        }

        String inputFileName = args[0];
        String outputFileName = args[1];
        String sortBy = "genre";
        String sortOrder = "ascending";

        for (int i = 0; i < args.length; i++) {
            switch(args[i]) {
                case "-sortby": {
                    testArg(args, i);
                    sortBy = args[i + 1];
                    if(!sortBy.equalsIgnoreCase("artist") && !sortBy.equalsIgnoreCase("album") &&
                            !sortBy.equalsIgnoreCase("song") && !sortBy.equalsIgnoreCase("time") &&
                            !sortBy.equalsIgnoreCase("genre")) {
                        throw new IllegalArgumentException("Illegal argument: " + args[i + 1] + ". Must either be " +
                                "genre, artist, album, song, or time");
                    }
                    break;
                }
                case "-sortorder": {
                    testArg(args, i);
                    sortOrder = args[i + 1];
                    if(!sortOrder.equalsIgnoreCase("ascending") && !sortOrder.equalsIgnoreCase("descending")) {
                        throw new IllegalArgumentException("Illegal argument: " + args[i + 1] + ". Must either be " +
                                "ascending or descending");
                    }
                    break;
                }
            }
        }

        testInputFile(inputFileName);
        MusicOrganizer mo = new MusicOrganizer(inputFileName, outputFileName, sortBy, sortOrder);
        mo.readSongsIntoMemory();
        mo.sortSongs();
        mo.printSongsToOutputFile();
    }

    /**
     * Throw an exception if the input file can't be open and read.
     *
     * @param inputFileName The name of the input file to read.
     */
    private static void testInputFile(String inputFileName) {
        File customOrgFile = new File(inputFileName);
        if(!customOrgFile.canRead()) {
            throw new IllegalArgumentException("Unable to read file " + inputFileName + ".");
        }
    }

    /**
     * Make sure a command line flag is followed by an argument.
     *
     * @param args The args to analyze
     * @param i The exact arg to analyze.
     */
    private static void testArg(String[] args, int i) {
        try {
            String test = args[i + 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("The flag " + args[i] + " was not followed by an argument.");
        }
        if (args[i + 1].charAt(0) == '-') {
            throw new IllegalArgumentException("The flag " + args[i] + " was followed by the invalid argument " +
                    args[i + 1] + ".");
        }
    }
}
