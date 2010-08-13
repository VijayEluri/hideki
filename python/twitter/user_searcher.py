#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys
import time
import urllib
import twitterapi
import simplejson as json
from StringIO import StringIO


def normalize(text):
	if text == None or text == "":
		return ""
	#return text.encode('utf-8').replace("\t", " ").replace("\r\n", " ").replace("\n", " ").replace("\r", " ") 
	return text.replace("\t", " ").replace("\r\n", " ").replace("\n", " ").replace("\r", " ") 

def main(argv):
	if len(argv) == 0:
		print >> sys.stderr, "Usage: user_searcher.py query"
		return

	query = " ".join(argv)
	per_page = 20
	page  = 1
	include_entities=1

	api = twitterapi.Twitter('hitakura','290303')

	retry = 0
	while True:
		try:
			resp = api.usersSearch(
					q=query,
					per_page=str(per_page),
					page=str(page),
					include_entities=str(include_entities))
		except:
			time.sleep(10)
			if retry > 5:
				break
			retry += 1
			continue
		for user in resp:
			io = StringIO()
			json.dump(user, io, False, False)
			print "%s\t%s" % (user["screen_name"], normalize(io.getvalue()))


		#print >> sys.stderr, "query=%s page=%d count=%d" % (query, page, len(resp))
		if len(resp) < per_page:
			break;
		page += 1
		time.sleep(5)

if __name__ == '__main__':
	main(sys.argv[1:])
