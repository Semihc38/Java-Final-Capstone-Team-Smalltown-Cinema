
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

INSERT INTO theaters (theater_id) VALUES (1);
INSERT INTO theaters (theater_id) VALUES (2);
INSERT INTO theaters (theater_id) VALUES (3);
INSERT INTO theaters (theater_id) VALUES (4);


--_______________
--Showtimes Data
--_______________

INSERT INTO showtimes (movie_id, theater_id, start_time) VALUES (1, 1, '11:00:00');
INSERT INTO showtimes (movie_id, theater_id, start_time) VALUES (1, 1, '07:00:00');
INSERT INTO showtimes (movie_id, theater_id, start_time) VALUES (2, 2, '11:00:00');
INSERT INTO showtimes (movie_id, theater_id, start_time) VALUES (2, 2, '07:00:00');
INSERT INTO showtimes (movie_id, theater_id, start_time) VALUES (3, 3, '11:00:00');
INSERT INTO showtimes (movie_id, theater_id, start_time) VALUES (3, 3, '07:00:00');
INSERT INTO showtimes (movie_id, theater_id, start_time) VALUES (6, 4, '11:00:00');
INSERT INTO showtimes (movie_id, theater_id, start_time) VALUES (6, 4, '07:00:00');

SELECT * FROM showtimes WHERE movie_id = 1;












