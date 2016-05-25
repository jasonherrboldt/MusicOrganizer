package com.jason;

/**
 * A song.
 *
 * Created by Jason Herrboldt (intothefuture@gmail.com) on 5/19/16.
 */
public class Song {

    private String songTitle;
    private String artist;
    private String albumName;
    private String genre;
    private String songLength;
    private int albumTrackNumber = -1; // nonexistent until proven otherwise

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
        this.albumTrackNumber = albumTrack;
    }

    @Override
    public String toString() {
        if(albumTrackNumber != -1) {
            return "Genre: " + genre + " | artist: " + artist + " | album name: " + albumName + " | song title: "
                    + songTitle + " | song length: " + songLength + " | album track #: " + albumTrackNumber;
        } else {
            return "Genre: " + genre + " | artist: " + artist + " | album name: " + albumName + " | song title: "
                    + songTitle + " | song length: " + songLength + " | album track #:";
        }
    }

    /**
     * @return the song title
     */
    public String getSongTitle() {
        return songTitle;
    }

    /**
     * @return the song artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @return the album name
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @return the song length
     */
    public String getSongLength() {
        return songLength;
    }

    /**
     * @return the album track number
     */
    public int getAlbumTrackNumber() {
        return albumTrackNumber;
    }
}
