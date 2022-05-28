use movie;

/* inserting in movie table */
insert into movie (movie_title,movie_desc,movie_director,movie_writer,movie_hero,movie_release_date,movie_rating) values ('The Shawshank Redemption', 'Two imprisoned men bond over a number of years', 'Frank Darabont', 'Stephen King', 'Tim Robbins', '1994-10-14', '4.5');
insert into movie (movie_title,movie_desc,movie_director,movie_writer,movie_hero,movie_release_date,movie_rating) values ('The Godfather', 'The aging patriarch of an organized crime dynasty transfers control to his son','Francis Ford Coppola','Mario Puzo', 'Marlon Brando', '1972-3-24', '4.2');
insert into movie (movie_title,movie_desc,movie_director,movie_writer,movie_hero,movie_release_date,movie_rating) values ('The Dark Knight','The menace known as the joker wreaks havoc on Gotham City', 'Christopher Nolan','Jonathan Nolan','Christian Bale','2008-7-18', '4.5');
insert into movie (movie_title,movie_desc,movie_director,movie_writer,movie_hero,movie_release_date,movie_rating) values ('12 Angry Men', 'The jury in a New York City murder trial is frustrated by a single member whose skeptical caution forces them to more carefully consider the evidence.', 'Sidney Lumet', 'Reginald Rose', 'Henry Fonda', '1957-4-10', '3.5');
insert into movie (movie_title,movie_desc,movie_director,movie_writer,movie_hero,movie_release_date,movie_rating) values ('Schindlers List', 'In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce.','Steven Spielberg', 'Thomas Keneally', 'Liam Neeson', '1994-10-14', 4);
insert into movie (movie_title,movie_desc,movie_director,movie_writer,movie_hero,movie_release_date,movie_rating) values ('The Lord of the Rings', 'Gandalf and Aragorn lead the World of Men against Sauron\'s army to draw his gaze from Frodo and Sam', 'Peter Jackson', 'J.R.R Tolkien','Elijah Wood',  '2003-12-17', 3.5);
insert into movie (movie_title,movie_desc,movie_director,movie_writer,movie_hero,movie_release_date,movie_rating) values ('Pulp Fiction', 'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.', 'Quentin Tarantino','Roger Avary','John Travolta','1994-10-14', 5);
insert into movie (movie_title,movie_desc,movie_director,movie_writer,movie_hero,movie_release_date,movie_rating) values (' The Good, the Bad and the Ugly', 'A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.','Sergio Leone', 'Luciano Vincezoni','Clint Eastwood', '1967-12-29', 5);
insert into movie (movie_title,movie_desc,movie_director,movie_writer,movie_hero,movie_release_date,movie_rating) values ('Forrest Gump', 'the Vietnam War and other historical events unfold from the perspective with an IQ of 75, whose desire is to be reunited with his sweetheart.', 'Robert Zemeckis', 'Winston Groom','Tom Hanks','1994-7-6', '3.5');
insert into movie (movie_title,movie_desc,movie_director,movie_writer,movie_hero,movie_release_date,movie_rating) values ('Fight Club', 'An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.', 'David Fincher', 'Chunk Palahniuk', 'Brad Pitt', '1999-10-15', 2.5);
insert into movie (movie_title,movie_desc,movie_director,movie_writer,movie_hero,movie_release_date,movie_rating) values ('Inception', 'A thief who steals corporate secrets through the use of dream-sharing technology is given the task of planting an idea', 'Christopher Nolan','Christopher Nolan','Leonardo DiCaprio','2010-8-16', 4);


/* inserting in genre table */
insert into genre values (0001, 'Drama', 'Drama film is a genre that relies on the emotional and relational development of realistic characters');
insert into genre values (0002, 'Crime', 'Films that focus on crime');
insert into genre values (0003, 'Action', 'Action film is a film genre in which the protagonist or protagonists end up in a series of challenges that typically include violence, extended fighting, physical feats, and frantic chases.');
insert into genre values (0004, 'Comic Book', 'Film adaptions from comic books and graphic novels');
insert into genre values (0005, 'Sci-Fi', 'Films of speculative fiction, typically dealing with imaginative concepts such as futuristic science and tech');
insert into genre values (0006, 'Mystery', 'Is a type of fiction in which a detective, or other professional, solves a crime or series of crimes');
insert into genre values (0007, 'Adventure', 'An adventure is an event or series of events that happens outside the course of the protagonist''s ordinary life, usually accompanied by danger, often by physical action.');
insert into genre values (0008, 'Comedy', 'Comedy is a genre of film in which the main emphasis is on humor. ');


/* inserting in movie-genre table */
insert into movie_genre values (0001, 1, 0001);
insert into movie_genre values (0002, 2, 0002);
insert into movie_genre values (0003, 2, 0001);
insert into movie_genre values (0004, 3, 0002);
insert into movie_genre values (0005, 3, 0003);
insert into movie_genre values (0006, 3, 0004);
insert into movie_genre values (0007, 4, 0002);
insert into movie_genre values (0008, 4, 0001);
insert into movie_genre values (0009, 5, 0001);
insert into movie_genre values (0010, 5, 0002);
insert into movie_genre values (0011, 6, 0003);
insert into movie_genre values (0012, 6, 0005);
insert into movie_genre values (0013, 7, 0004);
insert into movie_genre values (0014, 7, 0003);
insert into movie_genre values (0015, 7, 0005);
insert into movie_genre values (0016, 8, 0001);
insert into movie_genre values (0017, 8, 0006);
insert into movie_genre values (0018, 9, 0007);
insert into movie_genre values (0019, 9, 0001);
insert into movie_genre values (0020, 9, 0005);
insert into movie_genre values (0021, 10, 0008);
insert into movie_genre values (0022, 10, 0002);


/*inserting in poster table */
insert into poster values (0001, 'The Shawshank Redemption', 1);
insert into poster values (0002, 'The Godfather', 2);
insert into poster values (0003, 'The Dark Knight',3);
insert into poster values (0004, '12 Angry Men',4);
insert into poster values (0005, 'Schindlers List',5);
insert into poster values (0006, 'The Lord of the Rings' ,6);
insert into poster values (0007, 'Pulp Fiction',7);
insert into poster values (0008, null, 8);
insert into poster values (0009, null, 9);
insert into poster values (0010, null, 10);

/*Inserting in trailer table */
insert into trailer values (0001, '2' , 'https://www.imdb.com/video/vi3877612057/?playlistId=tt0111161?ref_=ext_shr_lnk', 1);
insert into trailer values (0002, '1' , 'https://www.imdb.com/video/vi1348706585/?playlistId=tt0068646?ref_=ext_shr_lnk', 2);
insert into trailer values (0003, '0', 'https://www.imdb.com/video/vi324468761/?playlistId=tt0468569?ref_=ext_shr_lnk', 3);
insert into trailer values (0004, '2', 'https://www.imdb.com/video/vi2924462873/?playlistId=tt0050083?ref_=ext_shr_lnk', 4);
insert into trailer values (0005, '2', 'https://www.imdb.com/video/vi1158527769/?playlistId=tt0108052?ref_=ext_shr_lnk', 5);
insert into trailer values (0006, '1', 'https://www.imdb.com/video/vi718127897/?playlistId=tt0167260?ref_=ext_shr_lnk', 6);
insert into trailer values (0007, '1', 'https://www.imdb.com/video/vi2620371481/?playlistId=tt0110912?ref_=ext_shr_lnk', 7);
insert into trailer values (0008, '3', 'https://www.imdb.com/video/vi3416964889/?playlistId=tt0060196?ref_=ext_shr_lnk', 8);
insert into trailer values (0009, '3',null, 9);
insert into trailer values (0010, '2', 'https://www.imdb.com/video/vi781228825/?playlistId=tt0137523?ref_=ext_shr_lnk', 10);
insert into trailer values (0011, '1', 'https://www.imdb.com/video/vi2959588889/?playlistId=tt1375666?ref_=ext_shr_lnk', 11);



/*Inserting in studio table */
insert into studio values (0001, 'Castle Rock Entertainment', '127A Smithfield Road, Frederiksted, Virgin Islands, United States');
insert into studio values (0002, 'Paramount Pictures', 'Forze d\'Agro, Messina, Sicily, Italy, United States');
insert into studio values (0003, 'Warner Bros', 'Chicago, Illinois, United States of America');
insert into studio values (0004, 'Orion-Nova Productions', 'New York Country Courthouse, New York City, America');
insert into studio values (0005, 'Universal Pictures', 'United States');
insert into studio values (0006, 'New Line Cinema', 'Hinuera Valley, New Zealand, United States');
insert into studio values (0007, 'Miramax', '1435 Flower Street, Glendale, California, USA');
insert into studio values (0008, 'Produzioni Europee Associate (PEA)', 'Carazo, Burgos, Castilla y Leon, Spain');
insert into studio values (0009, 'The Steve Tisch Company', 'Chippewa Square, USA');
insert into studio values (0010, 'Fox 2000 Picture', 'USA, Germany');
insert into studio values (0011, 'Legendary Entertainment', 'USA,  Japanese, French');


/*inserting in movie-studio table */
insert into movie_studio values (0001, 1, 1);
insert into movie_studio values (0002, 2, 2);
insert into movie_studio values (0003, 3, 3);
insert into movie_studio values (0004, 4, 4);
insert into movie_studio values (0005, 5, 5);
insert into movie_studio values (0006, 6, 3);
insert into movie_studio values (0007, 7, 3);
insert into movie_studio values (0008, 8, 7);
insert into movie_studio values (0009, 9, 3);
insert into movie_studio values (0010, 10, 3);
insert into movie_studio values (0011, 11, 2);

/*inserting in actor table */
insert into actor values (0001, 'Leonardo', 'DiCaprio', 'USA', 'https://twitter.com/LeoDiCaprio?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor', 'https://www.instagram.com/leonardodicaprio/', 'https://www.facebook.com/LeonardoDiCaprio');
insert into actor values (0002, 'Tim', 'Robbins', 'American', 'https://twitter.com/timrobbins1', 'https://www.instagram.com/timrobbinshere/?hl=en', 'https://www.facebook.com/public/Tim-Robbins');
insert into actor values (0003, 'Henry', 'Fonda', 'American', 'https://twitter.com/iamfonda?lang=en', 'https://www.instagram.com/henryfonda_/?hl=en', 'https://www.facebook.com/HenryFonda/');
insert into actor values (0004, 'Christian' , 'Bale' , 'UK', 'https://twitter.com/theofficialbale?lang=en', 'https://www.instagram.com/christianbale_/?hl=en', 'https://www.facebook.com/ChristianBaleBook/' );
insert into actor values (0005, 'Liam', 'Neeson', 'UK', 'https://twitter.com/the_liamneeson?lang=en', 'https://www.instagram.com/neeson_liam/?hl=en','https://www.facebook.com/LiamNeesonUSA/');
insert into actor values (0006, 'Elijah', 'Wood', 'American', 'https://twitter.com/elijahwood', 'https://www.instagram.com/elijahwoodswe/?hl=en', 'https://www.facebook.com/officialelijahwood');
insert into actor values (0007, 'John', 'Travolta', 'America', 'https://twitter.com/johntravoltahot?lang=en', 'https://www.instagram.com/johntravolta/?hl=en', 'https://www.facebook.com/johntravolta');
insert into actor values (0008, 'Clint', 'Eastwood' , 'American', 'https://twitter.com/clintforever?lang=en', 'https://www.instagram.com/clinteastwoodfans01/?hl=en', 'https://www.facebook.com/ClintEastwoodMovieDirector');
insert into actor values (0009, 'Tom', 'Hanks', null, 'https://twitter.com/tomhanks?lang=en', 'https://www.instagram.com/tomhanks/', 'https://www.facebook.com/TomHanks');
insert into actor values (0010, 'Brad', 'Pitt', 'American', 'https://twitter.com/pittofficial?lang=en', 'https://www.instagram.com/bradpittofflcial/?hl=en', null);
insert into actor values (0011, 'Marlon', 'Brando', 'American', 'https://twitter.com/marlonbrando?lang=en','https://www.instagram.com/marlonbrando/?hl=en','https://www.facebook.com/marlonbrandoestate');
insert into actor values (0012, 'Frank', 'Darabont', 'France', 'https://twitter.com/frankdarabont?lang=en','https://www.instagram.com/rabontfrank5c70/?hl=en','https://www.facebook.com/public/Frank-Darabont');
insert into actor values (0013, 'Stephen', 'King', 'American', 'https://twitter.com/StephenKing','https://www.instagram.com/stephenkingofficialpage/?hl=en','https://www.facebook.com/stephenkingwriter/');
insert into actor values (0014, 'Francio', 'Ford Coppola', 'American', 'https://twitter.com/coppolaford?lang=en','https://www.instagram.com/francisfordcoppola_/?hl=en','https://www.facebook.com/pages/category/Artist/Francis-Ford-Coppola-9661134092/');
insert into actor values (0015, 'Jonathan', 'Nolan', 'UK', 'https://twitter.com/jonathannolan','https://www.instagram.com/jonathannolan/?hl=en','https://www.facebook.com/public/Jonathan-Nolan');
insert into actor values (0016, 'Christopher', 'Nolan', 'UK', 'https://twitter.com/chris_nolann?lang=en','https://www.instagram.com/christophernolann/?hl=en','https://www.facebook.com/ChristopherNolan.info/');
insert into actor values (0017, 'Sidney', 'Lumet', null, 'https://twitter.com/bysidneylumet','https://www.instagram.com/sidneylumet/?hl=en','https://www.facebook.com/FilmmakerSidneyLumet/');


/*inserting in role table */
insert into role values (0001, 'lead actor', 0001, 0002);
insert into role values (0003, 'director' , 0001, 0012);
insert into role values (0004, 'writer', 0001, 0013);
insert into role values (0005, 'lead actor', 0002, 0011);
insert into role values (0006, 'co-actor', 0002, 0011);
insert into role values (0007, 'director', 0002, 0014);
insert into role values (0008, 'actor', 0003, 0004);
insert into role values (0009, 'writer', 0003, 0015);
insert into role values (0010, 'director', 0003, 0016);
insert into role values (0013, 'lead actor', 0004, 0003);
insert into role values (0014, 'director', 0004, 0017);

/*inserting in band table */
insert into band values (0001, 'Dope', 11);
insert into band values (0002, 'Sing Street', 6);
insert into band values (0003, 'Steel Dragon', 7);
insert into band values (0004, 'The Weird Sisters', 2);
insert into band values (0005, 'Kool and the Gang',25);
insert into band values (0006, 'The Prodigy', 7);
insert into band values (0007, 'Rammstein', 6);


/*inserting in song table */
insert into song values (0001, 'My funeral' , 3 , 'https://www.youtube.com/watch?v=TUEWnM6nGPo');
insert into song values (0002, 'Take Your best shot', 2, 'https://www.youtube.com/watch?v=Us39YXM5IEM');
insert into song values (0003, 'Du Hast', 3, 'https://www.youtube.com/watch?v=W3q8Od5qJio');
insert into song values (0004, 'Zick Zack', 4, 'https://www.youtube.com/watch?v=hBTNyJ33LWI');
insert into song values (0005, 'Get Down on it', 4, 'https://www.youtube.com/watch?v=qchPLaiKocI');
insert into song values (0006, 'Take my heart', 4, 'https://www.youtube.com/watch?v=aJPYQLp_jsk');
insert into song values (0007, 'We all die young', 4, 'https://www.youtube.com/watch?v=R-WqWaZxXSo');
insert into song values (0008, 'Stay Clean', 2, 'https://www.youtube.com/watch?v=eilzQSthLCY');
insert into song values (0009, 'Breathe', 4, 'https://www.youtube.com/watch?v=rmHDhAohJlQ');



/*inserting in song-band table */
insert into song_band values (0001, 0001, 0001);
insert into song_band values (0002, 0002, 0001);
insert into song_band values (0003, 0003, 0007);
insert into song_band values (0004, 0004, 0007);
insert into song_band values (0005, 0005, 0005);
insert into song_band values (0006, 0006, 0005);
insert into song_band values (0007, 0007, 0003);
insert into song_band values (0008, 0008, 0002);
insert into song_band values (0009, 0009, 0004);


/*inserting in artiste table */
insert into artiste values (0001, 'Edsel Dope', 'Florida USA', 48);
insert into artiste values (0002, 'Solar Lodger', 'Canada', null);
insert into artiste values (0003, 'Pat Benatar', 'New York City USA', 69);
insert into artiste values (0004, 'Till Lindemann', 'East Germany', 59);
insert into artiste values (0005, 'James "J.T." Taylor', 'South Carolina, US', 68);
insert into artiste values (0006, 'Lemmy', 'Staffordshire England', 70);


/*inserting in artiste-band table */
insert into artiste_band values (0001, 'lead vocals', 0001, 0001);
insert into artiste_band values (0002, 'lead guitar and singer', 0002, 0004);
insert into artiste_band values (0003, 'bass', 0003, 0001);
insert into artiste_band values (0004, 'drums', 0004, 0007);
insert into artiste_band values (0005, 'lead vocals', 0005, 0005);
insert into artiste_band values (0006, 'lead guitar', 0006, 0005);
