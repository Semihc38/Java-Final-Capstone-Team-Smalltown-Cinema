INSERT INTO movies (title, release_date, isFeatured, overview, poster) VALUES ('Jurassic Park', '2020-12-05', true, 'There are dinosaurs everywhere');

ALTER TABLE movies ADD poster varchar(500);

UPDATE movies SET poster = 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/9i3plLl89DHMz7mahksDaAo7HIS.jpg' WHERE movie_id = 3;

UPDATE movies SET title = 'TENET', release_date = '2020-09-03', overview = 'Armed with only one word - Tenet - and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.',
poster = 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/k68nPLbIST6NP96JmTxmZijEvCA.jpg' WHERE movie_id = 1;

UPDATE movies SET title = 'Home Alone', release_date = '1990-11-16', overview = 'Eight-year-old Kevin McCallister makes the most of the situation after his family unwittingly leaves him behind when they go on Christmas vacation. But when a pair of bungling burglars set their sights on Kevins house, the plucky kid stands ready to defend his territory. By planting booby traps galore, adorably mischievous Kevin stands his ground as his frantic mother attempts to race home before Christmas Day.',
poster = 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/9wSbe4CwObACCQvaUVhWQyLR5Vz.jpg' WHERE movie_id = 2;

UPDATE movies SET overview = 'A wealthy entrepreneur secretly creates a theme park featuring living dinosaurs drawn from prehistoric DNA. Before opening day, he invites a team of experts and his two eager grandchildren to experience the park and help calm anxious investors. However, the park is anything but amusing as the security systems go off-line and the dinosaurs escape.',
release_date = '1993-06-11' WHERE movie_id = 3;

UPDATE movies SET isFeatured = true WHERE movie_id = 2;

DELETE FROM movies WHERE movie_id = 4;

INSERT INTO movies (title, release_date, isFeatured, overview, poster) VALUES ('National Lampoon"s Christmas Vacation', '1989-12-01', true, 'It"s Christmas time and the Griswolds are preparing for a family seasonal celebration, but things never run smoothly for Clark, his wife Ellen and their two kids. Clark"s continual bad luck is worsened by his obnoxious family guests, but he manages to keep going knowing that his Christmas bonus is due soon.',
'https://image.tmdb.org/t/p/w600_and_h900_bestv2/dm2KpvwzfyPduUK1yBATxPveSgd.jpg');

UPDATE movies SET title = 'National Lampoon''s Christmas Vacation' WHERE movie_id = 4;


