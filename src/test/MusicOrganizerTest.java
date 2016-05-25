package test;

import java.util.*;

import com.jason.MusicOrganizer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * A test class for the MusicOrganizer class.
 *
 * Created by Jason Herrboldt (intothefuture@gmail.com) on 5/24/2016.
 */
public class MusicOrganizerTest {

    @Test
    public void dummyTest() {
        String x = "1";
        assertEquals(x, "1");
    }

    /**
     * Test the sorting of a complete album.
     */
    @Test
    public void testSortingAlbumTracks1() {
        MusicOrganizer mo = new MusicOrganizer("input_file_test_1.txt", "output_file.txt", "song", "ascending", 0);
        mo.readSongsIntoMemory();
        mo.sortAlbumTracks();
        // todo: how to confirm sort order?
    }

    /**
     * Test the sorting order of an album with songs that are missing track numbers.
     */
    @Test
    public void testSortingAlbumTracks2() {
        MusicOrganizer mo = new MusicOrganizer("input_file_test_2.txt", "output_file.txt", "song", "ascending", 0);
        mo.readSongsIntoMemory();
        mo.sortAlbumTracks();
        // todo: how to confirm sort order?
    }

}
