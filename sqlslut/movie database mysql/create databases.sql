DROP DATABASE movie;


CREATE database movie;
use movie;

CREATE TABLE movie(
movie_id int(5) not null AUTO_INCREMENT,
movie_title varchar(50) not null,
movie_desc varchar(150),
movie_director varchar(50),
movie_writer varchar(50),
movie_hero varchar(50),
movie_release_date date,
movie_rating int(1) check (movie_rating > 0 and movie_rating <= 5),
constraint movie_pk primary key (movie_id)
)engine innodb;

create table genre(
    genre_id int(5) not null,
    genre_type varchar(25) not null,
    genre_desc varchar(200),
    constraint genre_pk primary key (genre_id)
)engine innodb;

create table movie_genre(
    movie_genre_id int(5) not null,
    genre_movie_id int(5) not null,
    genre_genre_id int(5) not null,
    constraint movie_genre_pk primary key (movie_genre_id),
    constraint movie_genre_fk_movie foreign key (genre_movie_id) references movie (movie_id),
    constraint movie_genre_fk_genre foreign key (genre_genre_id) references genre (genre_id)
)engine innodb;


create table poster(
    poster_id int(5) not null,
    poster_title varchar(50),
    poster_movie_id int(5) not null,
    constraint poster_pk primary key (poster_id),
    constraint poster_fk_movie foreign key (poster_movie_id) references movie (movie_id)
)engine innodb;

create table trailer(
    trailer_id int(5) not null,
    trailer_length int(2),
    trailer_url varchar(150),
    trailer_movie_id int(5) not null,
    constraint trailer_pk primary key (trailer_id),
    constraint trailer_fk_movie foreign key (trailer_movie_id) references movie (movie_id)
)engine innodb;

create table studio(
    studio_id int(5) not null,
    studio_name varchar(50) not null,
    studio_location varchar(200),
    constraint studio_pk primary key (studio_id)
)engine innodb;

create table movie_studio(
    movie_studio_id int(5) not null,
    studio_movie_id int(5) not null,
    studio_studio_id int(5) not null,
    constraint movie_studio_pk primary key (movie_studio_id),
    constraint movie_studio_fk_movie foreign key (studio_movie_id) references movie (movie_id),
    constraint movie_studio_fk_studio foreign key (studio_studio_id) references studio (studio_id)
)engine innodb;


create table actor(
    actor_id int(5) not null,
    actor_first_name varchar(50) not null,
    actor_last_name varchar(50),
    actor_nationality varchar(50),
    actor_email varchar (50),
    actor_insta_url varchar(150),
    actor_fb_url varchar(150),
    constraint actor_pk primary key (actor_id)
)engine innodb;

create table role(
	role_id int(5) not null,
    role_desc varchar(25) not null,
    role_movie_id int(5) not null,
    role_person_id int(5) not null,
    constraint role_pk primary key (role_id),
    constraint role_fk_movie foreign key (role_movie_id) references movie (movie_id),
    constraint role_fk_person foreign key (role_person_id) references actor (actor_id)
)engine innodb;



create table band(
    band_id int(5) not null,
    band_name varchar(25) not null,
    band_total_members int(3) not null,
    constraint band_pk primary key (band_id)
) engine innodb;


create table song(
    song_id int(5) not null,
    song_name varchar(100) not null,
    song_length int(3),
    song_url varchar(150),
    constraint song_pk primary key (song_id)
) engine innodb;



create table song_band(
    song_band_id int(5) not null,
    song_song_id int(5) not null,
    band_band_id int(5) not null,
    constraint song_band_pk primary key (song_band_id),
    constraint song_band_fk_song foreign key (song_song_id) references song (song_id),
    constraint song_band_fk_band foreign key (band_band_id) references band (band_id)
)engine innodb;


create table artiste(
    artiste_id int(5) not null,
    artiste_name varchar(50) not null,
    artiste_country varchar(50),
    artiste_age int(3),
    constraint artiste_pk primary key (artiste_id)
)engine innodb;


create table artiste_band(
    artiste_band_id int(5) not null,
    band_role varchar(50),
    artiste_artiste_id int(5) not null,
    band_band_id int(5) not null,
    constraint artiste_band_pk primary key (artiste_band_id),
    constraint artiste_band_fk_artiste foreign key (artiste_artiste_id) references artiste (artiste_id),
    constraint artiste_band_fk_band foreign key (artiste_band_id) references band (band_id)
)engine innodb;



