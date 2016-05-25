package test;

import java.util.*;

import com.jason.MusicOrganizer;
import com.jason.Song;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * A test class for the MusicOrganizer class.
 *
 * Created by Jason Herrboldt (intothefuture@gmail.com) on 5/24/2016.
 */
public class MusicOrganizerTest {

    /**
     * Test the sorting of a complete album.
     */
    @Test
    public void testSortingAlbumTracks1() {
        MusicOrganizer mo = new MusicOrganizer("input_file_test_1.txt", "output_file.txt", "song", "ascending", 0);
        mo.readSongsIntoMemory();
        mo.sortAlbumTracks();
        List<Integer> albumTrackNumbersBeforeSorting = new ArrayList<>();
        List<Integer> albumTrackNumbersAfterSorting = new ArrayList<>();
        Map<String, List<Song>> albums = mo.getAlbums();
        assertEquals(albums.size(), 1);
        for(Map.Entry<String, List<Song>> album : albums.entrySet()) {
            List<Song> albumSongs = album.getValue();
            for(Song song : albumSongs) {
                albumTrackNumbersBeforeSorting.add(song.getAlbumTrackNumber());
                albumTrackNumbersAfterSorting.add(song.getAlbumTrackNumber());
            }

            Collections.sort(albumTrackNumbersAfterSorting);
            assertEquals(albumTrackNumbersAfterSorting, albumTrackNumbersBeforeSorting);
        }
    }

    /**
     * Test the sorting order of an album with songs that are missing track numbers.
     */
    @Test
    public void testSortingAlbumTracks2() {
        MusicOrganizer mo = new MusicOrganizer("input_file_test_2.txt", "output_file.txt", "song", "ascending", 0);
        mo.readSongsIntoMemory();
        mo.sortAlbumTracks();
        Map<String, List<Song>> albums = mo.getAlbums();
        assertEquals(albums.size(), 1);
        for(Map.Entry<String, List<Song>> album : albums.entrySet()) {
            List<Song> albumSongs = album.getValue();
            for(Song song : albumSongs) {
                // todo: figure out how to test this.
            }
        }

    }

}














