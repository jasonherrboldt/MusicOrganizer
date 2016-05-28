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
     * Album tracks should always display in ascending track order, irrespective of the ascending / descending choice
     * made by the user.
     */
    @Test
    public void testSortingAlbumTracks3() {
        MusicOrganizer mo = new MusicOrganizer("input_file_test_1.txt", "output_file.txt", "genre", "descending");
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
     * Assert that an album object will take on a value of "Various Artists" if songs by different artists are assigned
     * to the same album.
     */
    @Test
    public void testCompilationArtistName() {
        MusicOrganizer mo = new MusicOrganizer("input_file_test_3.txt", "output_file.txt", "genre", "ascending");
        mo.readSongsIntoMemory();
        mo.sortAlbumTracks();
        Map<String, Album> albums = mo.getAlbums();
        for(Map.Entry<String, Album> album : albums.entrySet()) {
            assertEquals(album.getValue().getArtist(), "Various Artists");
        }
    }

    /**
     * Assert that genres are appearing in ascending order when user specifies ascending by genre.
     */
    @Test
    public void testSortByGenreAscending() {
        MusicOrganizer mo = new MusicOrganizer("input_file.txt", "output_file.txt", "genre", "ascending");
        mo.readSongsIntoMemory();
        mo.sortAlbumTracks();
        mo.sortSongs();
        List<Album> sortedAlbums = mo.getSortedAlbums();
        List<String> unsortedGenres = new ArrayList<>();
        List<String> sortedGenres = new ArrayList<>();
        for(Album album : sortedAlbums) {
            if(!unsortedGenres.contains(album.getGenre())) {
                unsortedGenres.add(album.getGenre());
                sortedGenres.add(album.getGenre());
            }
        }
        Collections.sort(sortedGenres, (String s1, String s2) -> s1.toLowerCase().compareTo(s2.toLowerCase()));
        assertEquals(sortedGenres, unsortedGenres);
    }

    /**
     * Assert artists appear in ascending order when user specifies ascending by artist.
     */
    @Test
    public void testSortByArtistAscending() {
        MusicOrganizer mo = new MusicOrganizer("input_file.txt", "output_file.txt", "artist", "ascending");
        mo.readSongsIntoMemory();
        mo.sortAlbumTracks();
        mo.sortSongs();
        List<Album> sortedAlbums = mo.getSortedAlbums();
        List<String> unsortedArtists = new ArrayList<>();
        List<String> sortedArtists = new ArrayList<>();
        for(Album album : sortedAlbums) {
            if(!unsortedArtists.contains(album.getArtist())) {
                unsortedArtists.add(album.getArtist());
                sortedArtists.add(album.getArtist());
            }
        }
        Collections.sort(sortedArtists, (String s1, String s2) -> s1.toLowerCase().compareTo(s2.toLowerCase()));
        assertEquals(sortedArtists, unsortedArtists);
    }

    /**
     * Assert albums appear in ascending order when user specifies ascending by album.
     */
    @Test
    public void testSortByAlbumAscending() {
        MusicOrganizer mo = new MusicOrganizer("input_file.txt", "output_file.txt", "album", "ascending");
        mo.readSongsIntoMemory();
        mo.sortAlbumTracks();
        mo.sortSongs();
        List<Album> sortedAlbums = mo.getSortedAlbums();
        List<String> unsortedAlbumNames = new ArrayList<>();
        List<String> sortedAlbumNames = new ArrayList<>();
        for(Album album : sortedAlbums) {
            if(!unsortedAlbumNames.contains(album.getName())) {
                unsortedAlbumNames.add(album.getName());
                sortedAlbumNames.add(album.getName());
            }
        }
        Collections.sort(sortedAlbumNames, (String s1, String s2) -> s1.toLowerCase().compareTo(s2.toLowerCase()));
        assertEquals(sortedAlbumNames, unsortedAlbumNames);
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

    /**
     * Assert that sorting by genre also results in sorting by artist, album, and track number.
     */
    @Ignore
    public void testInnerSortingByGenreAscending() {

    }

    /**
     * Assert that sorting by artist also results in sorting by album and track number.
     */
    @Ignore
    public void testInnerSortingByArtistAscending() {

    }

    /**
     * Assert that sorting by album also results in sorting by track number.
     */
    @Ignore
    public void testInnerSortingByAlbumAscending() {

    }

    /**
     * Assert that sorting by genre also results in sorting by artist, album, and track number.
     */
    @Ignore
    public void testInnerSortingByGenreDescending() {

    }

    /**
     * Assert that sorting by artist also results in sorting by album and track number.
     */
    @Ignore
    public void testInnerSortingByArtistDescending() {

    }

    /**
     * Assert that sorting by album also results in sorting by track number.
     */
    @Ignore
    public void testInnerSortingByAlbumDescending() {

    }
}

























