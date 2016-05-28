package test;

import java.util.*;

import com.jason.Album;
import com.jason.MusicOrganizer;
import com.jason.Song;
import org.junit.Ignore;
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
        MusicOrganizer mo = new MusicOrganizer("input_file_test_1.txt", "output_file.txt", "genre", "ascending");
        mo.readSongsIntoMemory();
        mo.sortAlbumTracks();
        List<Integer> albumTrackNumbersBeforeSorting = new ArrayList<>();
        List<Integer> albumTrackNumbersAfterSorting = new ArrayList<>();
        Map<String, Album> albums = mo.getAlbums();
        for(Map.Entry<String, Album> album : albums.entrySet()) {
            Album albumSongs = album.getValue();
            for(Song song : albumSongs.getSongs()) {
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
        MusicOrganizer mo = new MusicOrganizer("input_file_test_2.txt", "output_file.txt", "genre", "ascending");
        mo.readSongsIntoMemory();
        mo.sortAlbumTracks();
        Map<String, Album> albums = mo.getAlbums();
        for(Map.Entry<String, Album> album : albums.entrySet()) {
            List<String> songTitlesBeforeSorting = new ArrayList<>();
            List<String> songTitlesAfterSorting = new ArrayList<>();
            Album albumSongs = album.getValue();
            for(Song song : albumSongs.getSongs()) {
                if(song.getAlbumTrackNumber() == -1) {
                    songTitlesBeforeSorting.add(song.getSongTitle());
                    songTitlesAfterSorting.add(song.getSongTitle());
                }
            }
            Collections.sort(songTitlesAfterSorting);
            assertEquals(songTitlesBeforeSorting, songTitlesAfterSorting);
        }
    }

    /**
     * Assert that an album object will take on a value of "Various Artists" if songs by different artists are assigned
     * to the same album.
     */
    @Ignore
    public void testCompilationArtistName() {

    }

    /**
     * Album tracks should always display in ascending track order, irrespective of the ascending / descending choice
     * made by the user.
     */
    @Ignore
    public void testAlbumTrackSortingForDescending() {

    }

    @Ignore
    public void testSortByGenreAscending() {

    }

    @Ignore
    public void testSortByArtistAscending() {

    }

    @Ignore
    public void testSortByAlbumAscending() {

    }

    @Ignore
    public void testSortbySongAscending() {

    }

    @Ignore
    public void testSortByTimeAscending() {

    }

    @Ignore
    public void testSortByGenreDescending() {

    }

    @Ignore
    public void testSortByArtistDescending() {

    }

    @Ignore
    public void testSortByAlbumDescending() {

    }

    @Ignore
    public void testSortbySongDescending() {

    }

    @Ignore
    public void testSortByTimeDescending() {

    }
}

























