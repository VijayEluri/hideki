#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys
import urllib
import twitterapi

def main(argv):
	api = twitterapi.Twitter()
	for line in sys.stdin:
		query = line.strip()
		resp = api.search(q=query, lang='ja', locale='ja', rpp=200)
		results = resp['results']
		for tweet in results:
			if tweet['to_user_id'] == None:
				tweet['to_user_id'] = -1
			if not 'to_user' in tweet:
				tweet['to_user'] = ""
			print "%d\t%s\t%d\t%s\t%d\t%s\t%s\t%s\t%s" % (
				tweet['id'],
				tweet['to_user'],
				tweet['to_user_id'],
				tweet['from_user'],
				tweet['from_user_id'],
				tweet['iso_language_code'],
				tweet['created_at'],
				query,
				tweet['text'].encode('utf-8').replace("\t", " ").replace("\r\n", " ").replace("\n", " ").replace("\r", " ")) 

if __name__ == '__main__':
	main(sys.argv[1:])
