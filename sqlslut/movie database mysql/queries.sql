use movie;

describe movie;

select movie_title as Title, movie_desc as Description, movie_director as 'Movie Director', movie_writer as 'Movie Writer',movie_release_date as 'Release Date' from movie;

select movie_title, movie_rating from movie order by movie_rating desc; #descending order

select movie_title, movie_director, movie_rating from movie where movie_rating > 4;

select movie_title from movie where movie_release_date < sysdate();

select movie_title, actor_first_name, actor_last_name, role_desc from movie, actor, role
where movie_id = role_movie_id and role_person_id = actor_id;

ALTER TABLE actor DROP COLUMN actor_email;
  
ALTER TABLE actor ADD actor_twitter_url varchar(150) NOT NULL AFTER actor_nationality;


select song_name from song,  artiste, artiste_band, song_band
where song_id = song_song_id and artiste_id = artiste_artiste_id  and  artiste_name = 'Edsel Dope';


select * from movie, actor #View;
;


select movie_title, song_name, artiste_name
from movie, song, artiste, song_band, artiste_band
where song_song_id = song_id and artiste_artiste_id = artiste_id;


select * from movie, genre
where genre_type in ('Action', 'Adventure');


select * from movie, trailer;

select * from trailer where trailer_length > 2;

select * from movie,trailer,poster;

UPDATE trailer SET trailer_url = 'https://www.imdb.com/video/vi3567517977/?playlistId=tt0109830?ref_=ext_shr_lnk'
WHERE trailer_url = null;


update actor set actor_nationality = ifnull(actor_nationality, 'American');

insert into movie values ('12','Harry Potter', 'The series follows the life of a boy named Harry Potter. In the first book, He lives under the stairs in the house of the Dursleys', 'Alfonso Cuarón','J. K. Rowling','Daniel Radcliffe','2001-11-14', 5);

delete from movie where movie_title = 'The Godfather';

alter table movie change movie_desc movie_plot varchar(150);







