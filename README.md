# MusicOrganizer
###Description
This is a coding exercise I made up to sharpen and demonstrate my Java skills. It's a command line driven program that reads a list of songs from a file, organizes them by genre, and prints the organized song list to another file. 

The user may elect to sort the songs within each genre by title, by artist, by song title, by album, or by song length, either all ascending or all descending. (Default sorting is by artist, then by album, then by album track, then by song title, then by song length, all ascending.) The user may also request a random playlist of any length (up to the input length) to be printed after the sorted list. 

###Details, Assumptions, and Requirements

Genre blocks are sorted ascending by genre name, with an extra line break between blocks. For example, all alternative songs will be listed first, followed by all electronic songs, followed by all jazz, etc. (Genre blocks may be sorted in descending order.) 

When songs are sorted by album, songs with no associated album should come after all other albums if ascending, or before if descending. 

Album tracks with no track number should be ordered by track name. If an album has both numbered and non-numbered tracks, non-numbered tracks should always come last, either when ascending or descending.

A user may only specify the initial sorting within a genre, as well as the ascending / descending order. Secondary, tertiary, etc. sorting will be decided by the program. If an ascending / descending choice is not made, the default choice will be ascending. See the examples below. (The first row is the default, the 1st column is the only one the user can change.)

![alt tag](http://hwcdn.libsyn.com/p/1/0/1/10157ed826459618/table.png?c_id=11706657&expiration=1463238061&hwt=514ec66d202c03d9844671a1a01cc19b)

Album track sorting should always be ascending, irrespective of the selected overall ordering. 

The random playlist must randomly select songs from the entire list. 

Each comma-separated line of the input file should be in this format: [artist], [song title], [album title (may be left out)], [album track number (must be proceeded by an album name) (a unique positive integer)], [genre], [song length (must be of the form MSS, eg 244)]. 

Command line usage: 

* input_filename [the name of the input file to use (no path = current path)]
* output_filename [the desired name of the output file (no path = current path)]
* -sortby [valid arguments are artist, album_title, album_track, song_title, and time (can only be one)]
* -sortorder [valid arguments are ascending and descending (can only be one)]
* -random [the length of the random playlist to print]

Exceptions for these cases should be logged to the console. All are fatal unless otherwise specified: 

- an input file line without all of the following: an artist, a song title, a genre, and a time – album title and track are optional (ok to log, ignore, and continue);
- an album with two or more identical track numbers (ok to log, ignore, and continue – only first one counts);
- a random playlist of length strictly less than 1 or strictly greater than the number of songs on the input file;
- an album track number without an accompanying album title (ok to log, ignore, and continue);
- an invalid song length, e.g. 376 (ok to log, ignore and continue);
- an invalid input filename;
- an empty input file;

Contents of an example input file example is below. It has full valid albums as well as data that should throw all of the input file exceptions above (except for empty and invalid files). 

Hall & Oates,Adult Education,The Best Of Hall & Oates,9,'80s,241

Pomo,Aerobix,The Other Day,15,Electronic,273

Steely Dan,Aja,Aja,2,Classic Rock,476

,All I Need,Mars Needs Total Science,12,Electronic,244

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

THE SOFT MOON,Circles,The Soft Moon,2,Punk & Alternative,242

Sade,Clean Heart,Stronger Than Pride,7,R&B,240

Squarepusher,The Coathanger,Just A Souvenir,2,Electronic,243

Steely Dan,Deacon Blues,Aja,3,Classic Rock,453

THE SOFT MOON,Dead Love,The Soft Moon,5,Punk & Alternative,244

Prince,Delirious,1999,3,R&B,240

Prince & The Revolution,Delirious,,3,'80s,240

Hour Of Penance,Deprave to Redeem,Sedition,8,Death Metal,242

Stan Getz & João Gilberto,Desafinado,Getz/Gilberto,4,Latin,244

Inanimate Existence,Dharmakaya,Liberation Through Hearing,1,Death Metal,240

The Police,Don't Stand So Close To Me,,,'80s,241

Fleetwood Mac,Don't stop,Rumours,4,Rock,193

This Mortal Coil,Drugs,Filigree & Shadow,23,Punk & Alternative,190

808 State,E Talk,Newbuild,6,Electronic,241

Survivor,Eye of the Tiger,,,'80s,243

Rockwell,Faces (feat. Lauren Laimant),Obsolete Medium,2,Electronic,244

Fwdslxsh,Fall,The Fall EP,1,Hip Hop / R&B,192

Hall & Oates,Family Man,The Best Of Hall & Oates,7,'80s,207

Patrice Rushen,Forget Me Nots,,,R&B,242

Miles Davis,Four,Blue Haze,2,Jazz,243

Putrid Pile,God Of Degradation,House Of Dementia,4,Death Metal,241

Inner City,Good Life,,,R&B,244

Katalepsy,Gore Conspiracy,Autopsychosis,7,Death Metal,241

"Earth, Wind & Fire",Got To Get You Into My Life,The Best Of Vol. 1,1,R&B,243

Fwdslxsh,High Tide (Reprise),The Fall EP,6,Hip Hop / R&B,193

Tensnake,Holla,Glow,10,Electronic,189

Steely Dan,Home At Last,Aja,5,Classic Rock,332

Pomo,How I Feel,The Other Day,6,Electronic,189

Hall & Oates,I Can't Go for That (No Can Co) (Extended Edit),The Best Of Hall & Oates,4,'80s,321

Steely Dan,I Got The News,Aja,6,Classic Rock,304

Sonic Youth,I'm Insane,Bad Moon Rising,6,Punk & Alternative,243

Necrophagist,Ignominious & Pale,Epitaph,3,Death Metal,241

Sonic Youth,Inhuman,Confusion Is Sex / Kill Yr Idols,5,Punk & Alternative,242

THE SOFT MOON,Insides,Zeros,4,Punk & Alternative,241

Sonic Youth,Jc,Dirty,13,Punk & Alternative,243

Steely Dan,Josie,Aja,7,Classic Rock,271

Van Halen,Jump,,,'80s,241

Kaytranada,Killa Cats,Kaytra Todo,1,Hip Hop / R&B,191

808 State,Kinky National,808 Utd. State 90,4,Electronic,240

Hall & Oates,Kiss On My List,The Best Of Hall & Oates,1,'80s,234

808 State,Leo Leo,Ex:El,3,Electronic,241

Madonna,Like A Virgin,,,'80s,191

ohbliv,Like I Light It,UP,15,Hip Hop / R&B,191

TEK.LUN,Live Out Your Life,The Crusade EP,8,Hip Hop / R&B,193

Stwo,Liz (Arnold x Lil Texas Remix),Liz,3,Hip Hop / R&B,241

Ladyhawke,Love Don't Live Here,Ladyhawke,6,Rock,242

Ta-ku,Love Lost,Songs To Break Up To,4,Hip Hop / R&B,242

Unai,Loving That Lost Feeling,Lost On Arrival,11,Electronic,242

Peter Schilling,Major Tom,,,'80s,240

Hall & Oates,Maneater,The Best Of Hall & Oates,6,'80s,264

Michael Sembello,Maniac,,6,'80s,244

Cal Tjader ,Maramoor Mambo,Soul Sauce,5,Latin,243

Sonic Youth,Marilyn Moore,EVOL ,8,Punk & Alternative,244

Sonic Youth,Mary-Christ,Goo,3,Punk & Alternative,191

Lone,Meeker Warm Energy,Reality Testing,3,Hip Hop / R&B,240

Toni Basil,Mickey,,,'80s,242

Ladyhawke,Morning Dreams,Ladyhawke,12,Rock,240

Suffocation,My Demise,Pinnacle Of Bedlam,7,Death Metal,244

Teebs,My Whole Life,Ardour,14,Electronic,191

INXS,Need You Tonight,,4,'80s,190

Heart,Never,,4,'80s,243

This Mortal Coil,(Nothing But) Blood,Blood,21,Punk & Alternative,243

Katalepsy,Number Of Death (13),Triumph Of Evilution,4,Death Metal,244

Motels,Only The Lonely,,,'80s,194

Hall & Oates,Out Of Touch,The Best Of Hall & Oates,10,'80s,248

Sade,Paradise,Stronger Than Pride,2,R&B,242

THE SOFT MOON,Parallels,The Soft Moon,6,Punk & Alternative,190

Inanimate Existence,Paths to Enlightenment,Liberation Through Hearing,4,Death Metal,241

Steely Dan,Peg,Aja,4,Classic Rock,235

Squarepusher,Planet Gear,Just A Souvenir,8,Electronic,242

Ta-ku,Poath,Latenyc,,Hip Hop / R&B,244

Hall & Oates,Private Eyes,The Best Of Hall & Oates,3,'80s,217

Mike Gao,"Ramen Hotline (feat. eLan, Go Yama & Elaquent)",Migamo,11,Hip Hop / R&B,192

Squarepusher,Red In Blue,Ufabulum,5,Electronic,191

Antonio Carlos Jobim,Sabia,Stone Flower,9,Latin,240

Hall & Oates,Say It Isn't So,The Best Of Hall & Oates,8,'80s,257

This Mortal Coil,Several Times,Blood,21,Punk & Alternative,192

Sonic Youth,She Is Not Alone,Sonic Youth EP,3,Punk & Alternative,242

The Tubes,She's A Beauty,,15,'80s,241

Hall & Oates,Some Things Are Better Left Unsaid,The Best Of Hall & Oates,11,'80s,325

Rockwell,Somebody’s Watching Me,,5,'80s,241

Prince,Something In The Water (Does Not Compute),1999,7,R&B,242

Cal Tjader ,Spring Is Here,Soul Sauce,8,Latin,243

Prince,Strange Relationship,Sign O' The Times [Disc 2],3,R&B,241

Sheena Easton,Strut,,,'80s,240

Pet Shop Boys,Suburbia,,4,'80s,244

Suff Daddy & Ta-Ku,Suff Daddy - Smile,Bricks & Mortar,2,Hip Hop / R&B,191

Inanimate Existence,Sulphuric Euphoria,Liberation Through Hearing,8,Death Metal,243

The Host,Summer Solstice At Cape Canaveral,The Host,10,Hip Hop / R&B,193

This Mortal Coil,Thais (2),Filigree & Shadow,25,Punk & Alternative,193

Tones On Tail,There's Only One,Tones On Tail,5,Punk & Alternative,241

Frozen Ghost,Time is the Answer,Frozen Ghost,16,Rock,242

Machinedrum,TMPL,Room(s) Extended,3,Hip Hop / R&B,240

Paula Morelenbaum,Tomara,Berimbaum,1,Latin,243

Atlantic Starr,Touch A Four Leaf Clover,,,R&B,241

Roy Davis Jr. & Jay Juniel,Transitions,Roy Davis Jr DJ Mix,1,Electronic,243

Machinedrum,Understand (Feat. DJ Rashad & Nick Hook),Movin' Forward: A Tribute To DJ Rashad,1,Hip Hop / R&B,241

Q-Chastic,untitled #3,Q-Chastic EP,3,Electronic,243

Elis Regina E Tom Jobim,Useless Landscape [Inutil Paisagem],Bossa Nova - Original Motion Picture Soundtrack,11,Latin,189

Sabrina Malheiros,Vou Voar,New Morning,11,Latin,242

Missing Persons,Walking in L.A.,Spring Session M,5,Rock,240

Universal Indicator,Wayne's Tantrum,Yellow,2,Electronic,192

Teebs,Wind Loop,Ardour,7,Electronic,194

Missy Elliott,WTF (Where They From) [feat. Pharrell Williams],WTF (Where They From) [feat. Pharrell Williams] - Single,1,Hip Hop / R&B,192

This Mortal Coil,You And Your Sister,Blood,6,Punk & Alternative,194

Hall & Oates,You Make My Dreams,The Best Of Hall & Oates,2,'80s,187

Hall & Oates,Your Imagination (Extended Edit),The Best Of Hall & Oates,5,'80s,308

