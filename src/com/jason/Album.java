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
    private boolean mixedGenres;
    private Set<String> genres;

    /**
     * Public constructor.
     */

    public Album(Song song, String name) {
        this.songs = new ArrayList<>();
        this.songs.add(song);
        this.artist = song.getArtist();
        this.name = name;
        this.length = 1;
        this.genres = new HashSet<>();
        this.genres.add(song.getGenre());
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
        this.songs.add(song);
        length++;
        genres.add(song.getGenre());
        if(!this.artist.equalsIgnoreCase("Various Artists")) {
            if(!song.getArtist().equalsIgnoreCase(this.artist)) {
                this.artist = "Various Artists";
            }
        }
        if(!mixedGenres) {
            if(!genres.contains(song.getGenre())) {
                mixedGenres = true;
            }
        }
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
     * @return true if album contains songs with mixed genres, false otherwise.
     */
    public boolean isMixedGenres() {
        return mixedGenres;
    }
}

















