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

    /**
     * Public constructor.
     */

    public Album(Song song, String name) {
        this.songs = new ArrayList<>();
        this.songs.add(song);
        this.name = name;
        this.length = 1;
    }

    /**
     * @return The first song of an album.
     */
    public Song getFirstSong() {
        return songs.get(0);
    }

    /**
     * Add a song to the album.
     *
     * @param song The song to add.
     */
    public void addSong(Song song) {
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

    public void replaceSongs(List<Song> songs) {
        this.songs = songs;
    }
}

















