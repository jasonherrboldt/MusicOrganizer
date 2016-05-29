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

    /**
     * Print a song's attributes to a string.
     *
     * @param sortBy    Decides the order in which the attributes will be printed
     * @return          The printed string.
     */
    public String printSong(String sortBy) {
        String albumTrackNumberStr = "";
        if(albumTrackNumber != -1) {
            albumTrackNumberStr = Integer.toString(albumTrackNumber);
        }

        /*
            Genre | artist | song | album | album track | time
            Artist | song | album | album track | time | genre
            Album | artist | song | album track | time | genre
            Song | artist | album | genre | time | album track
            Time | artist | song | album | genre | album track
         */

        switch (sortBy) {
            case "genre": {
                    return "genre: " + genre + " | artist: " + artist + " | song: " + songTitle + " | album: "
                            + albumName + " | album track #: " + albumTrackNumberStr + " | time: " + songLength;
            }
            case "artist": {
                return "artist: " + artist + " | song: " + songTitle + " | album: " + albumName + " | album track #: " +
                        albumTrackNumberStr + " | time: " + songLength + " | genre: " + genre;
            }
            case "album": {
                return "album: " + albumName + " | artist: " + artist + " | song: " + songTitle + " | album track #: " +
                        albumTrackNumberStr + " | time: " + songLength + " | genre: " + genre;
            }
            case "song": {
                return "song: " + songTitle + " | artist: " + artist + " | album: " + albumName + " | genre: " + genre +
                        " | time: " + songLength + " | album track #: " + albumTrackNumberStr;
            }
            case "time": {
                return "time: " + songLength + " | artist: " + artist + " | song: " + songTitle + " | album: " + albumName +
                        " | genre: " + genre + " | album track #: " + albumTrackNumberStr;
            }
        }
        return "";
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
    public int getSongLength() {
        return Integer.parseInt(this.songLength);
    }

    /**
     * @return the album track number
     */
    public int getAlbumTrackNumber() {
        return albumTrackNumber;
    }

    /**
     * Set the song's genre. (Allows albums to force a single album genre as per the documentation.)
     *
     * @param genre The genre to set.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
