# Music Organizer
###Description
This is a coding exercise I made up to sharpen and demonstrate my Java skills. It was written in Java 8, and I am the only one who made commits. It's a command line driven program that reads a list of songs from a file, sorts them according to user preference, and prints the organized song list to another file.

The user may elect to have the songs sorted by genre, by artist, by album, by song title, or by song length, either all ascending or all descending. (Default is ascending by genre -- see the table below.) 

###Details, Assumptions, and Requirements

Albums are assumed to contain songs of the same genre. An album's genre is determined by the genre of the first song that is added to it (not necessarily the song with the lowest album track number.) This is an unfortunate compromise to save hours of coding for rare edge cases.

Must be able to successfully handle compilations, i.e. songs with various artist names and song titles that belong to the same album. (Does not need an album artist name -- albums with multiple artist names will default to an album artist of "Various Artists".)

Tracks within the same album with no track numbers should be ordered by track name. If an album has both numbered and non-numbered tracks, non-numbered tracks should always come last, either when ascending or descending.

Songs with no album information should come last when sorting albums ascending, first when descending. 

A user may specify the initial sorting, as well as the ascending / descending order. Secondary, tertiary, etc. sorting will be decided by the program. If an ascending / descending choice is not made, the default choice will be ascending. See the examples below. The first row is the default. The user may choose to sort by any row, then all other columns programatically follow as indicated by the columns. Dashes indicate that no programatic choice will be made. (These are extreme edge cases.) For example, the second row shows what will happen when the user elects to sort by artist. If a group of songs have the same artist, they will next be sorted by album, then album track, etc. But if the user sorts by song, it's unlikely that any two songs will have the same title. 

![alt tag](http://traffic.libsyn.com/hardcoremathuser/sorting.png)

Album track sorting should always be ascending, irrespective of the selected overall ordering. 

Each comma-separated line of the input file should be in this format: [artist], [song title], [album title (may be left out)], [album track number (a unique positive integer) (may be left out)], [genre], [song length (must be of the form SSS, eg 244)]. 

Command line usage: 

* input_filename [the name of the input file to use (no path = current path)]
* output_filename [the desired name of the output file (no path = current path)]
* -sortby [valid arguments are genre, artist, album, song, and time (can only be one)]
* -sortorder [valid arguments are ascending and descending (can only be one)]

Exceptions for these cases should be logged to the console. All are fatal unless otherwise specified: 

- an input file line without all of the following: an artist, a song title, a genre, and a time -– album title and track are optional (ok to log, ignore, and continue);
- unable to open input file;
- unable to read input file.

An example input file example is located in the root directory (input_file.txt). It has full albums, singles, and one or two incomplete lines that should be ignored by the program. An example output file is also available (output_file.txt), showing the same songs after being sorted ascending by genre.

Sample input (extract):

    Hall & Oates,Adult Education,The Best Of Hall & Oates,9,80s,241
    Pomo,Aerobix,The Other Day,15,Electronic,243
    Steely Dan,Aja,Aja,2,Classic Rock,476
    Total Science,All I Need,Mars Needs Total Science,12,Electronic,244
    Doves,Ambition,Some Cities,11,Rock,240
    Prince & The Revolution,Anotherloverholenyohead,Parade,11,R&B,240
    Antônio Carlos Jobim,Antigua,Wave,9,Latin,190
    The Motels,Art Fails,All Four One ,4,Rock,191
    Ohbliv,bahdiyap,HW&W Vol 1,10,Hip Hop / R&B,189
    Elis Regina,Bala Com Bala,,5,Latin,192
    Prince,The Ballad Of Dorothy Parker,Sign O' The Times [Disc 1],4,R&B,241
    Toco,Barracao,Outro Lugar,7,Latin,189
    Steely Dan,Black Cow,Aja,1,Classic Rock,308
    Teebs,Burner,Ardour,6,Electronic,192
    Sade,Clean Heart,Stronger Than Pride,7,R&B,240
    Squarepusher,The Coathanger,Just A Souvenir,2,Electronic,243
    Steely Dan,Deacon Blues,Aja,3,Classic Rock,453
    THE SOFT MOON,Dead Love,The Soft Moon,5,Punk & Alternative,244
    Prince,Delirious,1999,3,R&B,240
    Prince & The Revolution,Delirious,,3,80s,240
    Hour Of Penance,Deprave to Redeem,Sedition,8,Death Metal,242
    Stan Getz & João Gilberto,Desafinado,Getz/Gilberto,4,Latin,244
    Inanimate Existence,Dharmakaya,Liberation Through Hearing,1,Death Metal,240
    The Police,Don't Stand So Close To Me,,,80s,241
    Fleetwood Mac,Don't stop,Rumours,4,Rock,193
    This Mortal Coil,,Filigree & Shadow,23,Punk & Alternative,190
    808 State,E Talk,Newbuild,6,Electronic,241
    Survivor,Eye of the Tiger,,,80s,243
    Rockwell,Faces (feat. Lauren L?aimant),Obsolete Medium,2,Electronic,244
    Fwdslxsh,Fall,The Fall EP,1,Hip Hop / R&B,192
    Hall & Oates,Family Man,The Best Of Hall & Oates,7,80s,207
    Patrice Rushen,Forget Me Nots,,,R&B,242
    Miles Davis,Four,Blue Haze,2,Jazz,243
    Putrid Pile,God Of Degradation,House Of Dementia,4,Death Metal,241
    Inner City,Good Life,,,R&B,244
    Katalepsy,Gore Conspiracy,Autopsychosis,7,Death Metal,241
    Earth Wind & Fire,Got To Get You Into My Life,The Best Of Vol. 1,1,R&B,243
    Fwdslxsh,High Tide (Reprise),The Fall EP,6,Hip Hop / R&B,193
    Tensnake,Holla,Glow,10,Electronic,189
    Steely Dan,Home At Last,Aja,5,Classic Rock,332
    Pomo,How I Feel,The Other Day,6,Electronic,189
    Hall & Oates,I Can't Go for That (No Can Co) (Extended Edit),The Best Of Hall & Oates,4,80s,321
    Steely Dan,I Got The News,Aja,6,Classic Rock,304
    Sonic Youth,I'm Insane,Bad Moon Rising,6,Punk & Alternative,243
    Necrophagist,Ignominious & Pale,Epitaph,3,Death Metal,241
    Sonic Youth,Inhuman,Confusion Is Sex / Kill Yr Idols,5,Punk & Alternative,242
    THE SOFT MOON,Insides,Zeros,4,Punk & Alternative,241
    Sonic Youth,Jc,Dirty,13,Punk & Alternative,243
    Steely Dan,Josie,Aja,7,Classic Rock,271
    Van Halen,Jump,,,80s,241
    Kaytranada,Killa Cats,Kaytra Todo,1,Hip Hop / R&B,191
    808 State,Kinky National,808 Utd. State 90,4,Electronic,240
    Hall & Oates,Kiss On My List,The Best Of Hall & Oates,1,80s,234
    808 State,Leo Leo,Ex:El,3,Electronic,241
    Madonna,Like A Virgin,,,80s,191
    ohbliv,Like I Light It,UP,15,Hip Hop / R&B,191
    TEK.LUN,Live Out Your Life,The Crusade EP,8,Hip Hop / R&B,193
    Stwo,Liz (Arnold x Lil Texas Remix),Liz,3,Hip Hop / R&B,241
    Ladyhawke,Love Don't Live Here,Ladyhawke,6,Rock,242
    Ta-ku,Love Lost,Songs To Break Up To,4,Hip Hop / R&B,242

Sample output (extract, sorted ascending by genre):

    genre: 80s | artist: Hall & Oates | album: The Best Of Hall & Oates | song: Kiss On My List | album track #: 1 | time: 234
    genre: 80s | artist: Hall & Oates | album: The Best Of Hall & Oates | song: You Make My Dreams | album track #: 2 | time: 187
    genre: 80s | artist: Hall & Oates | album: The Best Of Hall & Oates | song: Private Eyes | album track #: 3 | time: 217
    genre: 80s | artist: Hall & Oates | album: The Best Of Hall & Oates | song: I Can't Go for That (No Can Co) (Extended Edit) | album track #: 4 | time: 321
    genre: 80s | artist: Hall & Oates | album: The Best Of Hall & Oates | song: Your Imagination (Extended Edit) | album track #: 5 | time: 308
    genre: 80s | artist: Hall & Oates | album: The Best Of Hall & Oates | song: Maneater | album track #: 6 | time: 264
    genre: 80s | artist: Hall & Oates | album: The Best Of Hall & Oates | song: Family Man | album track #: 7 | time: 207
    genre: 80s | artist: Hall & Oates | album: The Best Of Hall & Oates | song: Say It Isn't So | album track #: 8 | time: 257
    genre: 80s | artist: Hall & Oates | album: The Best Of Hall & Oates | song: Adult Education | album track #: 9 | time: 241
    genre: 80s | artist: Hall & Oates | album: The Best Of Hall & Oates | song: Out Of Touch | album track #: 10 | time: 248
    genre: 80s | artist: Hall & Oates | album: The Best Of Hall & Oates | song: Some Things Are Better Left Unsaid | album track #: 11 | time: 325
    genre: 80s | artist: Heart | album:  | song: Never | album track #: 4 | time: 243
    genre: 80s | artist: INXS | album:  | song: Need You Tonight | album track #: 4 | time: 190
    genre: 80s | artist: Madonna | album:  | song: Like A Virgin | album track #:  | time: 191
    genre: 80s | artist: Michael Sembello | album:  | song: Maniac | album track #: 6 | time: 244
    genre: 80s | artist: Motels | album:  | song: Only The Lonely | album track #:  | time: 194
    genre: 80s | artist: Pet Shop Boys | album:  | song: Suburbia | album track #: 4 | time: 244
    genre: 80s | artist: Peter Schilling | album:  | song: Major Tom | album track #:  | time: 240
    genre: 80s | artist: Prince & The Revolution | album:  | song: Delirious | album track #: 3 | time: 240
    genre: 80s | artist: Rockwell | album:  | song: SomebodyÂ’s Watching Me | album track #: 5 | time: 241
    genre: 80s | artist: Sheena Easton | album:  | song: Strut | album track #:  | time: 240
    genre: 80s | artist: Survivor | album:  | song: Eye of the Tiger | album track #:  | time: 243
    genre: 80s | artist: The Police | album:  | song: Don't Stand So Close To Me | album track #:  | time: 241
    genre: 80s | artist: The Tubes | album:  | song: She's A Beauty | album track #: 15 | time: 241
    genre: 80s | artist: Toni Basil | album:  | song: Mickey | album track #:  | time: 242
    genre: 80s | artist: Van Halen | album:  | song: Jump | album track #:  | time: 241
    genre: Classic Rock | artist: Steely Dan | album: Aja | song: Black Cow | album track #: 1 | time: 308
    genre: Classic Rock | artist: Steely Dan | album: Aja | song: Aja | album track #: 2 | time: 476
    genre: Classic Rock | artist: Steely Dan | album: Aja | song: Deacon Blues | album track #: 3 | time: 453
    genre: Classic Rock | artist: Steely Dan | album: Aja | song: Peg | album track #: 4 | time: 235
    genre: Classic Rock | artist: Steely Dan | album: Aja | song: Home At Last | album track #: 5 | time: 332
    genre: Classic Rock | artist: Steely Dan | album: Aja | song: I Got The News | album track #: 6 | time: 304
    genre: Classic Rock | artist: Steely Dan | album: Aja | song: Josie | album track #: 7 | time: 271
    genre: Death Metal | artist: Hour Of Penance | album: Sedition | song: Deprave to Redeem | album track #: 8 | time: 242
    genre: Death Metal | artist: Inanimate Existence | album: Liberation Through Hearing | song: Dharmakaya | album track #: 1 | time: 240
    genre: Death Metal | artist: Inanimate Existence | album: Liberation Through Hearing | song: Paths to Enlightenment | album track #: 4 | time: 241
    genre: Death Metal | artist: Inanimate Existence | album: Liberation Through Hearing | song: Sulphuric Euphoria | album track #: 8 | time: 243
    genre: Death Metal | artist: Katalepsy | album: Autopsychosis | song: Gore Conspiracy | album track #: 7 | time: 241
    genre: Death Metal | artist: Katalepsy | album: Triumph Of Evilution | song: Number Of Death (13) | album track #: 4 | time: 244
    genre: Death Metal | artist: Necrophagist | album: Epitaph | song: Ignominious & Pale | album track #: 3 | time: 241
    genre: Death Metal | artist: Putrid Pile | album: House Of Dementia | song: God Of Degradation | album track #: 4 | time: 241
    genre: Death Metal | artist: Suffocation | album: Pinnacle Of Bedlam | song: My Demise | album track #: 7 | time: 244
    genre: Electronic | artist: 808 State | album: 808 Utd. State 90 | song: Kinky National | album track #: 4 | time: 240
    genre: Electronic | artist: 808 State | album: Ex:El | song: Leo Leo | album track #: 3 | time: 241
    genre: Electronic | artist: 808 State | album: Newbuild | song: E Talk | album track #: 6 | time: 241
    genre: Electronic | artist: Pomo | album: The Other Day | song: How I Feel | album track #: 6 | time: 189
    genre: Electronic | artist: Pomo | album: The Other Day | song: Aerobix | album track #: 15 | time: 243
    genre: Electronic | artist: Q-Chastic | album: Q-Chastic EP | song: untitled #3 | album track #: 3 | time: 243
    genre: Electronic | artist: Rockwell | album: Obsolete Medium | song: Faces (feat. Lauren LÂ’aimant) | album track #: 2 | time: 244
    genre: Electronic | artist: Roy Davis Jr. & Jay Juniel | album: Roy Davis Jr DJ Mix | song: Transitions | album track #: 1 | time: 243
    genre: Electronic | artist: Squarepusher | album: Just A Souvenir | song: The Coathanger | album track #: 2 | time: 243
    genre: Electronic | artist: Squarepusher | album: Just A Souvenir | song: Planet Gear | album track #: 8 | time: 242
    genre: Electronic | artist: Squarepusher | album: Ufabulum | song: Red In Blue | album track #: 5 | time: 191
    genre: Electronic | artist: Teebs | album: Ardour | song: Burner | album track #: 6 | time: 192
    genre: Electronic | artist: Teebs | album: Ardour | song: Wind Loop | album track #: 7 | time: 194
    genre: Electronic | artist: Teebs | album: Ardour | song: My Whole Life | album track #: 14 | time: 191
    genre: Electronic | artist: Tensnake | album: Glow | song: Holla | album track #: 10 | time: 189
    genre: Electronic | artist: Total Science | album: Mars Needs Total Science | song: All I Need | album track #: 12 | time: 244
    genre: Electronic | artist: Unai | album: Lost On Arrival | song: Loving That Lost Feeling | album track #: 11 | time: 242
    genre: Electronic | artist: Universal Indicator | album: Yellow | song: Wayne's Tantrum | album track #: 2 | time: 192
