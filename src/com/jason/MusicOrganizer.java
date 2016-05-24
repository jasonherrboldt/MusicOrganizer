package com.jason;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * Reads songs into memory from text file, organizes them per the user's
 * specifications, and prints the sorted list to an output file.
 *
 * Created by Jason Herrboldt (intothefuture@gmail.com) on 5/19/16.
 */
public class MusicOrganizer {

    private String inputFileName;
    private String outputFileName;
    private String sortBy;
    private String sortOrder;
    private int randomPlaylistLength;
    private Map<String, List<Song>> albums; // Map of album names to album tracks (can be single songs).

    /**
     * Public constructor.
     *
     * @param inputFileName         The name of the input file
     * @param outputFileName        The name of the output file
     * @param sortBy                The field by which the songs should be sorted
     * @param sortOrder             Ascending or descending
     * @param randomPlaylistLength  Length of the random song playlist
     */
    public MusicOrganizer(String inputFileName, String outputFileName, String sortBy, String sortOrder,
                          int randomPlaylistLength) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        this.sortBy = sortBy;
        this.sortOrder = sortOrder;
        this.randomPlaylistLength = randomPlaylistLength;
        albums = new HashMap<>();
        printArguments();
    }

    /**
     * (For debug.)
     */
    private void printArguments() {
        System.out.println("\ninputFileName = " + this.inputFileName);
        System.out.println("outputFileName = " + this.outputFileName);
        System.out.println("sortBy = " + this.sortBy);
        System.out.println("sortOrder = " + this.sortOrder);
        System.out.println("randomPlaylistLength = " + this.randomPlaylistLength + "\n");
    }

    /**
     * Put all the songs from the input file into the albums map.
     */
    public void readSongsIntoMemory() {
        File customOrgFile = new File(inputFileName);
        if(customOrgFile.canRead()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(customOrgFile));
                String line;
                // System.out.println("");
                int unnamedAlbumCount = 0; // Necessary to differentiate different empty albums.
                while ((line = br.readLine()) != null) {
                    // System.out.println(line); // (debug)
                    Song song = parseSong(line);
                    if (song != null) {
                        // System.out.println(song.toString() + "\n");
                        addSongToAlbums(song, unnamedAlbumCount);
                        unnamedAlbumCount++;
                    } // OK to ignore null songs.
                }
                String x = ""; // to catch breakpoint
            } catch (Exception e) { // Can be FileNotFoundException or IOException
                throw new IllegalArgumentException("Unable to open file " + inputFileName);
            }
        } else {
            throw new IllegalArgumentException("Unable to read file " + inputFileName + ".");
        }
    }

    /**
     * Add a song to the list of albums. Song object can be null.
     *
     * @param song The song to add.
     */
    public void addSongToAlbums(Song song, int unnamedAlbumCount) {
        String albumName = song.getAlbumName();
        String unnamedAlbumName = "Unnamed Album # ";
        if(albumName.equals("")) {
            albumName = unnamedAlbumName + String.valueOf(unnamedAlbumCount);
        }
        if(albums.containsKey(albumName)) {
            // todo: Add to existing album
            albums.get(albumName).add(song);
        } else {
            List<Song> newAlbum = new ArrayList<>();
            newAlbum.add(song);
            albums.put(albumName, newAlbum);
        }
    }

    /**
     * Create a song from a text input line. (Can be null.)
     *
     * @param line The line to parse.
     */
    private Song parseSong(String line) {
        // System.out.println(line); // (debug)
        // Hall & Oates,Adult Education,The Best Of Hall & Oates,9,'80s,241
        // [artist], [song], [album], [album track], [genre], [time]
        String artist = "";
        String songTitle = "";
        String albumName = "";
        int albumTrackNumber = -1;
        String genre = "";
        String songLength = "";

        List<String> tokens = Arrays.asList(line.trim().split(","));
        if(tokens.size() < 1 || tokens.size() > 6) {
            System.out.println("Bad data line -- incorrect number of tokens. Line ignored: " + line);
            return null;
        } else {
            try {
                artist = tokens.get(0);
                songTitle = tokens.get(1);
                genre = tokens.get(4);
                songLength = tokens.get(5);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Bad data line -- unable to parse information. Line ignored: " + line);
                return null;
            }
            if(artist.equals("") || songTitle.equals("") || genre.equals("") || songLength.equals("")) {
                System.out.println("Bad data line -- missing required information. Line ignored: " + line);
                return null;
            }
            try {
                albumName = tokens.get(2);
                albumTrackNumber = Integer.parseInt(tokens.get(3));
            } catch (Exception e) { // Could be NumberFormatException or IndexOutOfBoundsException.
                // Reinstate default values.
                albumName = "";
                albumTrackNumber = -1;
            }
            return new Song(songTitle, artist, albumName, genre, songLength, albumTrackNumber);
        }
    }
}















