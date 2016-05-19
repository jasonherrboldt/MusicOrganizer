package com.jason;


import java.util.ArrayList;
import java.util.List;

public class Album {

    private List<Song> albumSongs = new ArrayList<>();

    /**
     * Public constructor.
     */
    public Album() {
    }

    public void setAlbumTrack(Song song) {
        albumSongs.add(song);
        if(albumSongs.size() > 1) {
            sortAlbum();
        }
    }

    /**
     * Sort album ascending by track number.
     */
    public void sortAlbum() {
        // todo
    }
}
