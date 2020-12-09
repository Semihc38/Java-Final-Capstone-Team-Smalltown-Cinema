DROP TABLE IF EXISTS movies CASCADE;
DROP TABLE IF EXISTS showtimes CASCADE;
DROP TABLE IF EXISTS theaters CASCADE;

DROP SEQUENCE IF EXISTS seq_movie_id;
DROP SEQUENCE IF EXISTS seq_showtime_id;
DROP SEQUENCE IF EXISTS seq_theater_id;

--Beginning of Movie Table--

CREATE SEQUENCE seq_movie_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
  --Create Table--
  
  CREATE TABLE movies (
       movie_id int DEFAULT nextval('seq_movie_id'::regclass) NOT NULL,
       title varchar(200) NOT NULL,
       release_date date NOT NULL,
       isFeatured boolean NOT NULL,
       overview varchar(512),
       poster varchar(500),
       CONSTRAINT PK_movie PRIMARY KEY (movie_id)
       );
  --Inserting Movies--     
INSERT INTO movies (title, release_date, isFeatured, overview, poster) VALUES (
'Jurassic Park', 
'1993-06-11', 
true, 
'A wealthy entrepreneur secretly creates a theme park featuring living dinosaurs drawn from prehistoric DNA. 
Before opening day, he invites a team of experts and his two eager grandchildren to experience the park and help calm anxious investors. 
However, the park is anything but amusing as the security systems go off-line and the dinosaurs escape.', 
'https://image.tmdb.org/t/p/w600_and_h900_bestv2/9i3plLl89DHMz7mahksDaAo7HIS.jpg'
);
  
INSERT INTO movies (title, release_date, isFeatured, overview, poster) VALUES (
'TENET', 
'2020-09-03', 
true, 
'Armed with only one word - Tenet - and fighting for the survival of the entire world,
 the Protagonist journeys through a twilight world of international espionage on a mission 
 that will unfold in something beyond real time.',
 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/k68nPLbIST6NP96JmTxmZijEvCA.jpg'
 );

INSERT INTO movies (title, release_date, isFeatured, overview, poster) VALUES (
'Home Alone',
'1990-11-16',
true,
'Eight-year-old Kevin McCallister makes the most of the situation after his family 
unwittingly leaves him behind when they go on Christmas vacation. But when a pair of bungling burglars 
set their sights on Kevins house, the plucky kid stands ready to defend his territory. 
By planting booby traps galore, adorably mischievous Kevin stands his ground as his frantic mother attempts 
to race home before Christmas Day.',
'https://image.tmdb.org/t/p/w600_and_h900_bestv2/9wSbe4CwObACCQvaUVhWQyLR5Vz.jpg'
);

INSERT INTO movies (title, release_date, isFeatured, overview, poster) VALUES (
'National Lampoon''s Christmas Vacation', 
'1989-12-01', 
true, 
'It"s Christmas time and the Griswolds are preparing for a family seasonal celebration, 
but things never run smoothly for Clark, his wife Ellen and their two kids. 
Clark"s continual bad luck is worsened by his obnoxious family guests, but he manages to keep going knowing 
that his Christmas bonus is due soon.',
'https://image.tmdb.org/t/p/w600_and_h900_bestv2/dm2KpvwzfyPduUK1yBATxPveSgd.jpg'
);
--End Movie Table--

--Start Showtime Table--

CREATE SEQUENCE seq_showtime_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE SEQUENCE seq_theater_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

--Table Creation--

CREATE TABLE theaters(
theater_id int DEFAULT nextval('seq_theater_id'::regclass) NOT NULL,
CONSTRAINT PK_theater PRIMARY KEY (theater_id)

);

CREATE TABLE showtimes(
showtime_id int DEFAULT nextval('seq_showtime_id'::regclass) NOT NULL,
movie_id int NOT NULL,
theater_id int NOT NULL,
start_time varchar(50) NOT NULL,
CONSTRAINT PK_showtime PRIMARY KEY (showtime_id)
);

ALTER TABLE showtimes ADD CONSTRAINT FK_movie FOREIGN KEY (movie_id) REFERENCES movies(movie_id);
ALTER TABLE showtimes ADD CONSTRAINT FK_theater FOREIGN KEY (theater_id) REFERENCES theaters(theater_id);

INSERT INTO theaters (theater_id) VALUES (1);
INSERT INTO theaters (theater_id) VALUES (2);
INSERT INTO theaters (theater_id) VALUES (3);
INSERT INTO theaters (theater_id) VALUES (4);


--_______________
--Showtimes Data
--_______________

INSERT INTO showtimes (movie_id, theater_id, start_time) VALUES (1, 1, '11:00 AM');
INSERT INTO showtimes (movie_id, theater_id, start_time) VALUES (1, 1, '7:00 PM');
INSERT INTO showtimes (movie_id, theater_id, start_time) VALUES (2, 2, '11:00 AM');
INSERT INTO showtimes (movie_id, theater_id, start_time) VALUES (2, 2, '7:00 PM');
INSERT INTO showtimes (movie_id, theater_id, start_time) VALUES (3, 3, '11:00 AM');
INSERT INTO showtimes (movie_id, theater_id, start_time) VALUES (3, 3, '7:00 PM');
INSERT INTO showtimes (movie_id, theater_id, start_time) VALUES (4, 4, '11:00 AM');
INSERT INTO showtimes (movie_id, theater_id, start_time) VALUES (4, 4, '7:00 PM');
