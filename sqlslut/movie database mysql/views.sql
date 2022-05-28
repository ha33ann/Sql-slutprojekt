use movie;

create view movie_v_trailer as
  select movie_title, trailer_url
  from movie, trailer
  where movie_id = trailer_movie_id;

create view movie_v_genre as
  select movie_title, genre_type
  from movie, genre, movie_genre
  where movie_id = genre_movie_id and genre_genre_id = genre_id;

create view movie_v_trailer_v_poster as
  select movie_title, trailer_url, poster_title
  from movie, trailer, poster
  where movie_id = trailer_movie_id and movie_id = poster_movie_id;


create view movie_v_actors as
  select movie_title, actor_first_name, actor_last_name, role_desc
  from movie, actor, role
  where movie_id = role_movie_id and role_person_id = actor_id;

create view movie_v_studio as
  select movie_title, studio_name
  from movie, studio, movie_studio
  where movie_id = studio_movie_id and studio_studio_id = studio_id;


