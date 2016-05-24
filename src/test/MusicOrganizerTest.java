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

    @Test
    public void testAddingSongsToAlbum() {
        // MusicOrganizer mo = new MusicOrganizer(inputFileName, outputFileName, sortBy, sortOrder, randomPlaylistLength);
        MusicOrganizer mo = new MusicOrganizer("input_file.txt", "output_file.txt", "song", "ascending", 0);
    }

}
