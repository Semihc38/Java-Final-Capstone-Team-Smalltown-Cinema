CREATE SEQUENCE seq_movie_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  

CREATE TABLE movies (
       movie_id int DEFAULT nextval('seq_movie_id'::regclass) NOT NULL,
       title varchar(200) NOT NULL,
       release_date date NOT NULL,
       isFeatured boolean NOT NULL,
       overview varchar(512),
       CONSTRAINT PK_movie PRIMARY KEY (movie_id)
       );
       
INSERT INTO movies (title, release_date, isFeatured, overview) VALUES ('Team', '2020-12-05', true, 'We are going to make this project great again');
INSERT INTO movies (title, release_date, isFeatured, overview) VALUES ('.Net is Crapshoot', '2020-12-05', false, 'You must not see movie of the year');
