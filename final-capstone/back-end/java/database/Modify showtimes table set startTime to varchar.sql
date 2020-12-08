START TRANSACTION;

DELETE FROM showtimes WHERE showtime_id = 1;

SELECT * FROM showtimes;

Commit transaction;

UPDATE showtimes SET start_time = '7:00 PM' WHERE start_time = '07:00:00';
rollback;
commit transaction;

ALTER TABLE showtimes 
ALTER COLUMN start_time TYPE VARCHAR(50);



