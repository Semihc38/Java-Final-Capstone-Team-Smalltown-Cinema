
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

CREATE TABLE theaters(
theater_id int DEFAULT nextval('seq_theater_id'::regclass) NOT NULL,
CONSTRAINT PK_theater PRIMARY KEY (theater_id)

);

CREATE TABLE showtimes(
showtime_id int DEFAULT nextval('seq_showtime_id'::regclass) NOT NULL,
movie_id int NOT NULL,
theater_id int NOT NULL,
start_time time NOT NULL,
CONSTRAINT PK_showtime PRIMARY KEY (showtime_id)
);

ALTER TABLE showtimes ADD CONSTRAINT FK_movie FOREIGN KEY (movie_id) REFERENCES movies(movie_id);
ALTER TABLE showtimes ADD CONSTRAINT FK_theater FOREIGN KEY (theater_id) REFERENCES theaters(theater_id);

ALTER TABLE movies drop constraint FK_movie;