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
		# id, user_id, screen_name, name, description, url, profile_image_url,
		# followers_count, friends_count, favourites_count, status_count, listed_count
		print "insert into movies_user values (NULL, %s, '%s', '%s', '%s', '%s', '%s', %s, %s, %s, %s, %s);" % ( obj['id'], obj['screen_name'], obj['name'], obj['description'], obj['url'], obj['profile_image_url'], obj['followers_count'], obj['friends_count'], obj['favourites_count'], obj['statuses_count'], obj['listed_count'])

if __name__ == "__main__":
	main(sys.argv[1:])
