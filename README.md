# MusicOrganizer
###Description
(Under construction.) This is a coding exercise I made up to sharpen and demonstrate my Java skills (written in Java 8). It's a command line driven program that reads a list of songs from a file, sorts them according to user preference, and prints the organized song list to another file.

The user may elect to have the songs sorted by genre, by artist, by album, by song title, or by song length, either all ascending or all descending. (Default is ascending by genre -- see the table below.) 

###Details, Assumptions, and Requirements

Albums are assumed to contain songs of the same genre. An album's genre is determined by the genre of the first song that is added to it (not necessarily the song with the lowest album track number.)

Must be able to successfully handle compilations, i.e. songs with various artist names and song titles that belong to the same album. (Does not need an album artist name -- albums with multiple artist names will default to an album artist of "Various Artists".)

Songs by the same artist with no associated album should come after all other albums by the same artist, for both descending and ascending.

Tracks within the same album with no track numbers should be ordered by track name. If an album has both numbered and non-numbered tracks, non-numbered tracks should always come last, either when ascending or descending.

A user may specify the initial sorting, as well as the ascending / descending order. Secondary, tertiary, etc. sorting will be decided by the program. If an ascending / descending choice is not made, the default choice will be ascending. See the examples below. The first row is the default. The user may choose to sort by any row, then all other columns programatically follow as indicated by the columns. Dashes indicate that no programatic choice will be made. (These are extreme edge cases.)

![alt tag](http://traffic.libsyn.com/hardcoremathuser/sorting.png)

Album track sorting should always be ascending, irrespective of the selected overall ordering. 

Each comma-separated line of the input file should be in this format: [artist], [song title], [album title (may be left out)], [album track number (a unique positive integer) (may be left out)], [genre], [song length (must be of the form MMSS, eg 244)]. 

Command line usage: 

* input_filename [the name of the input file to use (no path = current path)]
* output_filename [the desired name of the output file (no path = current path)]
* -sortby [valid arguments are genre, artist, album, song, and time (can only be one)]
* -sortorder [valid arguments are ascending and descending (can only be one)]

Exceptions for these cases should be logged to the console. All are fatal unless otherwise specified: 

- an input file line without all of the following: an artist, a song title, a genre, and a time -– album title and track are optional (ok to log, ignore, and continue);
- an invalid song length, e.g. 376 (ok to log, ignore and continue);
- unable to open input file;
- unable to read input file.

An example input file example is located in the root directory (input_file.txt). It has full albums, singles, and one or two incomplete lines that should be ignored by the program. 
