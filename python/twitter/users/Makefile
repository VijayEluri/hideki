create_table: create_table_users.sql
	sqlite3 twitter.db < $<

insert_users.sql: twitter-movie-users.txt
	cat $< \
	| ./json2sql.py \
	> $@

insert_users: insert_users.sql
	sqlite3 twitter.db < $<

	

delete_database:
	rm -f twitter.db

clean:
	rm -f insert_users.sql
