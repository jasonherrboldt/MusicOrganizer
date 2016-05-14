# MusicOrganizer
###Description
This is a coding exercise I made up to sharpen and demonstrate my Java skills. It's a command line driven program that reads a list of songs from a file, organizes them by genre, and prints the organized song list to another file. 

The user may elect to sort the songs within each genre by title, by artist, by song title, by album, or by song length, either all ascending or all descending. (Default sorting is by artist, then by album, then by album track, then by song title, then by song length, all ascending.) The user may also request a random playlist of any length (up to the input length) to be printed after the sorted list. 

###Details, Assumptions, and Requirements

Genre blocks are sorted ascending by genre name, with an extra line break between blocks. For example, all alternative songs will be listed first, followed by all electronic songs, followed by all jazz, etc. Genre sort order may not be specified by the user.

When songs are sorted by album, songs with no associated album should come after all other albums if ascending, or before if descending. 

Album tracks with no track number should be ordered by track name. If an album has both numbered and non-numbered tracks, non-numbered tracks should always come last, either when ascending or descending.

A user may only specify the initial sorting within a genre, as well as the ascending / descending order. Secondary, tertiary, etc. sorting will be decided by the program. If an ascending / descending choice is not made, the default choice will be ascending. See the examples below. (The first row is the default, the 1st column is the only one the user can change.)

[table coming soon]

Album track sorting should always be ascending, irrespective of the selected overall ordering. 

The random playlist must randomly select songs from the entire list. 

Each comma-separated line of the input file should be in this format: [artist], [song title], [album title (may be left out)], [album track number (must be proceeded by an album name) (a unique positive integer)], [genre], [song length (must be of the form MSS, eg 244)]. 

Command line usage: 

input_filename 		the name of the input file to use (no path = current path)
output_filename 	the desired name of the output file (no path = current path)
-sortby 			valid arguments are artist, album_title, album_track, song_title, and time (can only be one)
-sortorder		valid arguments are ascending and descending (can only be one)
-random		the length of the random playlist to print

Exceptions for these cases should be logged to the console. All are fatal unless otherwise specified: 

- an input file line without all of the following: an artist, a song title, a genre, and a time – album title and track are optional (ok to log, ignore, and continue);
- an album with two or more identical track numbers (ok to log, ignore, and continue – only first one counts);
- a random playlist of length strictly less than 1 or strictly greater than the number of songs on the input file;
- an album track number without an accompanying album title (ok to log, ignore, and continue);
- an invalid song length, e.g. 376 (ok to log, ignore and continue);
- an invalid input filename;
- an empty input file;
