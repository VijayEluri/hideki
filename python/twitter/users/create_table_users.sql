create table users (
	id INTEGER PRIMARY KEY,
	user_id INTEGER,
	name TEXT,
	screen_name TEXT,
	location TEXT,
	description TEXT,
	profile_image_url TEXT,
	url TEXT,
	time_zone TEXT,
	lang VARCHAR(2),
	created_at DATE,
	followers_count INTEGER,
	friends_count INTEGER,
	favourites_count INTEGER,
	status_count INTEGER,
	listed_count INTEGER,
	utc_offset INTEGER
);
