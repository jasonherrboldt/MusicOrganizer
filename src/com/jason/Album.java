package com.jason;

import java.util.*;

/**
 * An album.
 *
 * Created by Jason Herrboldt (intothefuture@gmail.com) on 5/25/16.
 */
public class Album {

    private List<Song> songs;
    private String name;
    private int length;
    private String artist;
    private String genre;

    /**
     * Public constructor.
     */
    public Album(Song song, String name) {
        this.songs = new ArrayList<>();
        this.songs.add(song);
        this.artist = song.getArtist();
        this.name = name;
        this.length = 1;
        this.genre = song.getGenre();
    }

    /**
     * @return The first song of an album.
     */
    public Song getFirstSong() {
        return songs.get(0);
    }

    /**
     * Add a song to the album. Change the album artist to "Various Artists" as necessary.
     *
     * @param song The song to add.
     */
    public void addSong(Song song) {
        // Program documentation explicitly states that album artists are not supported.
        // Albums of mixed artists automatically results in an album artist of "Various Artists".
        if(!this.artist.equalsIgnoreCase("Various Artists")) {
            if(!song.getArtist().equalsIgnoreCase(this.artist)) {
                this.artist = "Various Artists";
            }
        }
        // Program documentation explicitly states that albums of mixed genres are not supported.
        // Behavior is enforced to avoid the appearance of a bug. WILL alter input data, but the users
        // can't say they weren't warned.
        if(!song.getGenre().equalsIgnoreCase(this.genre)) {
            song.setGenre(this.genre);
        }
        this.songs.add(song);
        length++;
    }

    /**
     * @return The name of the album.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The list of album songs.
     */
    public List<Song> getSongs() {
        return songs;
    }

    /**
     * @return The album length.
     */
    public int getLength() {
        return length;
    }

    /**
     * Replace the album songs with a new list of songs (necessary when sorting).
     *
     * @param songs The new list of songs.
     */
    public void replaceSongs(List<Song> songs) {
        this.songs = songs;
    }

    /**
     * @return The album artist.
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Set the album artist.
     *
     * @param artist the album artist.
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * @return The genre of the first track of the album.
     */
    public String getGenre() {
        return genre;
    }

}

















