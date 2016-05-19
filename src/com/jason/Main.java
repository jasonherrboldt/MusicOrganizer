package com.jason;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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
            throw new IllegalArgumentException("Invalid number of arguments received. Args length must be 2, 4, 6, or 8.");
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
                        throw new IllegalArgumentException("Illegal argument: " + args[i + 1] + ". Must either be artist, " +
                                "album_title, album_track, song_title, or time");
                    }
                    break;
                }
                case "-sortorder": {
                    testArg(args, i);
                    sortOrder = args[i + 1];
                    if(!sortOrder.equalsIgnoreCase("ascending") && !sortOrder.equalsIgnoreCase("descending")) {
                        throw new IllegalArgumentException("Illegal argument: " + args[i + 1] + ". Must either be ascending " +
                                "or descending");
                    }
                    break;
                }
                case "-random": {
                    testArg(args, i);
                    try {
                        randomPlaylistLength = Integer.parseInt(args[i + 1]);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Argument " + args[i] + " must be followed by a positive integer.");
                    }
                    break;
                }
            }
        }
        System.out.println("\ninputFileName = " + inputFileName);
        System.out.println("outputFileName = " + outputFileName);
        System.out.println("sortBy = " + sortBy);
        System.out.println("sortOrder = " + sortOrder);
        System.out.println("randomPlaylistLength = " + randomPlaylistLength);

        // printInputFile(inputFileName);
        List<Song> sortedSongs = sortSongs(inputFileName, sortBy, sortOrder, randomPlaylistLength);
        printSortedSongs(sortedSongs);

    }

    /**
     * Sort the songs in the input list.
     *
     * @param inputFileName         The name of the input file.
     * @param sortBy                The field by which the songs should be ordered.
     * @param sortOrder             Ascending or descending.
     * @param randomPlaylistLength  The length of the random playlist to print.
     * @return                      The sorted list of songs.
     */
    private static List<Song> sortSongs(String inputFileName, String sortBy, String sortOrder, int randomPlaylistLength) {
        List<Song> songs = new ArrayList<>();
        // todo
        return songs;
    }

    /**
     * Print the sorted list of songs. 
     * @param songs The list of songs to print.
     */
    private static void printSortedSongs(List songs) {
        // todo
    }

    /**
     * Print the input file to the console. (For debug mostly.)
     *
     * @param inputFileName The name of the input file to read.
     */
    private static void printInputFile(String inputFileName) {
        File customOrgFile = new File(inputFileName);
        if(!customOrgFile.canRead()) {
            throw new IllegalArgumentException("Unable to read file " + inputFileName + ".");
        } else {
            try {
                BufferedReader br = new BufferedReader(new FileReader(customOrgFile));
                String line;
                System.out.println("");
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("Unable to open file " + inputFileName);
            }
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
