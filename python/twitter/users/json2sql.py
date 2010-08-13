#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys
import simplejson as json

from utils import *

def main(argv):
	for line in sys.stdin:
		line = line.strip()
		(screen_id, text)  = line.split('\t')
		obj = json.loads(text)
		obj = dict_sql_escape(obj)
		obj = dict_strip(obj)
		if obj['utc_offset'] == None:
			obj['utc_offset'] = 0
		#print jsonobj
		# id, user_id, name, screen_name, location, description, profile_image_url, url, time_zone, lang, created_at,
		# followers_count, friends_count, favourites_count, status_count, listed_count, utc_offset, json
		print "insert into users values (NULL, %s, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %s, %s, %s, %s, %s, %s);" % ( obj['id'], obj['name'], obj['screen_name'], obj['location'], obj['description'], obj['profile_image_url'], obj['url'], obj['time_zone'], obj['lang'], obj['created_at'], obj['followers_count'], obj['friends_count'], obj['favourites_count'], obj['statuses_count'], obj['listed_count'], obj['utc_offset'])

if __name__ == "__main__":
	main(sys.argv[1:])
