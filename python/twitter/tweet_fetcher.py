#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys
import time
import urllib
import twitterapi

def main(argv):
	api = twitterapi.Twitter()
	for line in sys.stdin:
		page  = 1
		retry = 0
		while True:
			query = line.strip()
			try:
				resp = api.search(q=query, lang='ja', rpp=100,page=str(page))
			except:
				time.sleep(10)
				if retry > 5:
					break
				retry += 1
				continue
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
			print >> sys.stderr, "title=%s page=%d count=%d" % (query, page, len(results))
			if len(results) < 100:
				break;
			page += 1
			time.sleep(5)

if __name__ == '__main__':
	main(sys.argv[1:])
