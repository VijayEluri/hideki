#!/usr/bin/env python

import sys
from urllib2 import urlopen, Request
import simplejson

TWITTER_DEF_TRENDS_API_URL = "http://api.twitter.com/1/trends.json"
TWITTER_TRENDS_API_URL     = "http://api.twitter.com/1/trends/%s.json"

''' sample twitter api
TRENDS_URL    = "http://api.twitter.com/1/trends.json"
CURRENT_URL   = "http://api.twitter.com/1/trends/current.json"
DAILY_URL     = "http://api.twitter.com/1/trends/daily.json"
WEEKLY_URL    = "http://api.twitter.com/1/trends/weekly.json"
AVAILABLE_URL = "http://api.twitter.com/1/trends/available.json"
'''

def main(argv):
	if len(argv) == 0:
		url = TWITTER_DEF_TRENDS_API_URL
	elif len(argv) == 1:
		if  (argv[0] == '-h' or argv[0] == "--help"):
			print >> sys.stderr, "USAGE: twitter_trend.py [current/daily/weekly/available/woeid]"
			print >> sys.stderr, "\tTokyo => 1118370"
			print >> sys.stderr, "\tSan Francisco => 2487956"
			print >> sys.stderr, "\tWorldwide => 1"
			return
		else:
			url = TWITTER_TRENDS_API_URL % (argv[0])
	print url
	req = Request(url)
	res = urlopen(req)
	json = simplejson.load(res)
	print simplejson.dumps(json, indent=3, ensure_ascii=False)


if __name__ == '__main__':
	main(sys.argv[1:])
