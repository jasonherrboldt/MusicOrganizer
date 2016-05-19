package com.jason;

public class Song {

    private String songTitle;
    private String artist;
    private String albumName;
    private String genre;
    private String songLength;
    private int albumTrack = -1;

    /**
     * Public constructor.
     *
     * @param songTitle   The name of the song.
     * @param artist      The recording artist.
     * @param albumName   The name of the album the song belongs to.
     * @param genre       The genre of the song.
     * @param songLength  The length of the song.
     * @param albumTrack  The album track # of the song.
     */
    public Song(String songTitle, String artist, String albumName, String genre, String songLength, int albumTrack) {
        this.songTitle = songTitle;
        this.artist = artist;
        this.albumName = albumName;
        this.genre = genre;
        this.songLength = songLength;
        this.albumTrack = albumTrack;
    }

}
