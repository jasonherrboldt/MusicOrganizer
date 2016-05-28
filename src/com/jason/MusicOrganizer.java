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
    private int songCount;
    private Map<String, Album> albumsMap; // Map of album names to albumsMap (albumsMap may have 1...* songs).
    private List<Album> sortedAlbums;

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
        this.songCount = 0;
        albumsMap = new HashMap<>();
        sortedAlbums = new ArrayList<>();
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
     * Put all the songs from the input file into the albumsMap map.
     */
    public void readSongsIntoMemory() {
        File customOrgFile = new File(inputFileName);
        if(customOrgFile.canRead()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(customOrgFile));
                String line;
                int unnamedAlbumCount = 0; // Necessary to differentiate empty albumsMap.
                while ((line = br.readLine()) != null) {
                    Song song = parseSong(line);
                    if (song != null) {
                        addSongToAlbums(song, unnamedAlbumCount);
                        unnamedAlbumCount++;
                        String genre = song.getGenre();
                        if(genre != null) { // Should never happen. But of course that means that it might.

                        } else {
                            System.out.println("Song " + song.toString() + " is missing genre. Line ignored.");
                        }
                        songCount++;
                    } // OK to ignore null songs (invalid text lines have already been logged to the console).
                }
            } catch (Exception e) { // Could be FileNotFoundException or IOException.
                throw new IllegalArgumentException("Unable to open file " + inputFileName + ".");
            }
            if(randomPlaylistLength > songCount) {
                System.out.println("Requested random playlist length of " + randomPlaylistLength +
                        " exceeds length of input song list. Random playlist will not be generated.");
                randomPlaylistLength = 0;
            }
        } else {
            throw new IllegalArgumentException("Unable to read file " + inputFileName + ".");
        }
    }

    /**
     * Print every song in every album (for debug).
     */
    public void printAllSongsToConsole() {
        System.out.println("\n" + songCount + " songs processed:\n");
        int printCount = 0;
        for(Album album : sortedAlbums) {
            List<Song> songs = album.getSongs();
            for (Song song : songs) {
                System.out.println(printCount + " | " + song.toString());
                printCount++;
            }
        }
    }

    /**
     * Add a song to the list of albumsMap. Song object can be null.
     *
     * @param song The song to add.
     */
    public void addSongToAlbums(Song song, int unnamedAlbumCount) {
        if(song != null) {
            String albumName = song.getAlbumName();
            if(albumName.equals("")) {
                albumName = "Unnamed Album # " + String.valueOf(unnamedAlbumCount);
            }
            if(albumsMap.containsKey(albumName)) {
                albumsMap.get(albumName).addSong(song);
            } else {
                Album newAlbum = new Album(song, albumName);
                albumsMap.put(albumName, newAlbum);
            }
        } // OK to ignore null songs.
    }

    /**
     * Put the album tracks in ascending order (user may not override).
     */
    public void sortAlbumTracks() {
        for(Map.Entry<String, Album> album : albumsMap.entrySet()) {
            if(album.getValue().getLength() > 1) {
                List<Song> albumSongs = album.getValue().getSongs();
                List<Song> sortedAlbumSongs = new ArrayList<>();
                List<Song> sortedTracklessAlbumSongs = new ArrayList<>();
                for(Song song : albumSongs) {
                    if(song.getAlbumTrackNumber() > 0) {
                        sortedAlbumSongs.add(song);
                    } else {
                        sortedTracklessAlbumSongs.add(song);
                    }
                }
                // Sort songs ascending by track number.
                Collections.sort(sortedAlbumSongs, (Song s1, Song s2) -> s1.getAlbumTrackNumber() - s2.getAlbumTrackNumber());

                // Sort songs without track numbers ascending by song title.
                Collections.sort(sortedTracklessAlbumSongs, (Song s1, Song s2) ->
                        s1.getSongTitle().compareTo(s2.getSongTitle()));

                // Join the two sorted lists and use the resulting list to replace the current album.
                sortedAlbumSongs.addAll(sortedTracklessAlbumSongs);
                album.getValue().replaceSongs(sortedAlbumSongs);
            }
        }
    }

    /**
     * Sort the songs by the user's specifications.
     */
    public void sortSongs() {
        sortAlbumTracks();

        switch (sortBy) {
            case "genre": {
                // (Everything below is for debug.)
                /*
                List<Song> allSongs = new ArrayList<>();
                for(Map.Entry<String, Album> album : albumsMap.entrySet()) {
                    if(album.getValue().getLength() == 1) { // Just doing singles for now (debug).
                        allSongs.add(album.getValue().getFirstSong());
                    }
                }
                Collections.sort(allSongs, (Song s1, Song s2) -> s1.getGenre().compareTo(s2.getGenre()));
                for(Song song : allSongs) {
                    System.out.println(song.toString());
                }
                 */

                // List<Album> allAlbums = new ArrayList<>();
                for(Album album : albumsMap.values()) {
                    sortedAlbums.add(album);
                }
                Collections.sort(sortedAlbums, (Album a1, Album a2) -> a1.getGenre().compareTo(a2.getGenre()));

                break;
            }
            case "artist": {
                // todo
                break;
            }
            case "album_title": {
                // todo
                break;
            }
            case "album_track": {
                // todo
                break;
            }
            case "song_title": {
                // todo
                break;
            }
            case "time": {
                // todo
                break;
            }
        }

        if(randomPlaylistLength > 0) {
            // createAndAppendRandomSongPlaylist();
        }
        printAllSongsToConsole(); // debug.
    }

    /**
     * Print the sorted songs to output file by genre block (plus random playlist if requested).
     */
    public void printSongsToOutputFile() {
        // todo: Remember to split song list into genre blocks, including the random playlist (if it exists).
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
                // Do nothing; allow original values to persist.
            }
            return new Song(songTitle, artist, albumName, genre, songLength, albumTrackNumber);
        }
    }

    /**
     * @return all albumsMap.
     */
    public Map<String, Album> getAlbumsMap() {
        return albumsMap;
    }
}















