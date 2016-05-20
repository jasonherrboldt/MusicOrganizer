package com.jason;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by Jason Herrboldt (intothefuture@gmail.com) on 5/19/16.
 */
public class Main {

    /*

    Command line usage:

    input_filename      the name of the input file to use (no path = current path)
    output_filename     the desired name of the output file (no path = current path)
    -sortby             valid arguments are artist, album_title, album_track, song_title,
                        and time (can only be one)
    -sortorder          valid arguments are ascending and descending (can only be one)
    -random             the length of the random playlist to print

    e.g.
    input_file.txt output_file.txt -sortby album_title -sortorder descending -random 21

     */
    public static void main(String[] args) {

        // Fail if the wrong number of command line arguments are received.
        if(args.length != 2 && args.length != 4 && args.length != 6 && args.length != 8) {
            throw new IllegalArgumentException("Invalid number of arguments received. Args length must be 2, 4, 6, " +
                    "or 8.");
        }

        String inputFileName = args[0];
        String outputFileName = args[1];
        String sortBy = "genre";
        String sortOrder = "ascending";
        int randomPlaylistLength = 0;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-sortby": {
                    testArg(args, i);
                    sortBy = args[i + 1];
                    if(!sortBy.equalsIgnoreCase("artist") && !sortBy.equalsIgnoreCase("album_track") &&
                            !sortBy.equalsIgnoreCase("album_title") && !sortBy.equalsIgnoreCase("song_title") &&
                            !sortBy.equalsIgnoreCase("time")) {
                        throw new IllegalArgumentException("Illegal argument: " + args[i + 1] + ". Must either be " +
                                "artist, album_title, album_track, song_title, or time");
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
                case "-random": {
                    testArg(args, i);
                    try {
                        randomPlaylistLength = Integer.parseInt(args[i + 1]);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Argument " + args[i] + " must be followed by a positive " +
                                "integer.");
                    }
                    break;
                }
            }
        }

        testInputFile(inputFileName);
        MusicOrganizer mo = new MusicOrganizer(inputFileName, outputFileName, sortBy, sortOrder, randomPlaylistLength);
        mo.readSongsIntoMemory();
        // mo.printSongsToOutputFile();
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