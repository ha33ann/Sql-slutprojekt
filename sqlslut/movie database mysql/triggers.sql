-- show triggers;

delimiter $$
create trigger before_movie_insert_movie_rating before insert on movie
for each row
begin
	if new.movie_rating <= 2 then
	signal sqlstate '42000'
	set message_text = 'Check movie_rating in table movie failed. Rating is too low';
	end if;
end$$
delimiter ;


delimiter $$
create trigger before_movie_insert_genre_type before insert on genre
for each row
begin
	if new.genre_type not in ('Drama','Crime','Action','Comic Book','Sci-Fi','Mystery','Adventure','Comedy') then
    signal sqlstate '41000'
    set message_text = 'Check constraint on genre_type in table genre failed. Only valid genre type';
    end if;
end$$
delimiter ;


delimiter $$
create trigger before_movie_insert_trailer_length before insert on trailer
for each row
begin
	if (new.trailer_length <= 1) OR (new.trailer_length >= 6) then
	signal sqlstate '42000'
	set message_text = 'Check constraint on trailer_length in table trailer failed. Length is too long';
	end if;
end$$
delimiter ;

