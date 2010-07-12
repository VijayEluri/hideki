#!/usr/bin/env python
# -*- coding: utf-8 -*-

import urllib
import urllib2
import simplejson

class Twitter(object):
	def __init__(self,
			username=None,
			password=None):
		self._username = username
		self._password = password

	''' Public Methods '''

	''' Search API Methods '''

	def search(self, query, **kwargs):
		base_url = 'http://search.twitter.com/search.json'
		kwargs.update({ 'q': query })
		url = base_url + '?' + urllib.urlencode(kwargs)
		opener = self._getOpener(url)
		json = opener.open(url,None).read()
		opener.close()
		return simplejson.loads(json)



	''' Timeline Methods '''

	def publicTimeline(self, **kwargs):
		"""Fetch the 20 most recent statuses from non-protected users who have set a custom user icon.

  		Args:

  		Returns:
			An sequence of status dict objects

  		"""
		base_url = 'http://api.twitter.com/1/statuses/public_timeline.json'
		url = base_url + '?' + urllib.urlencode(kwargs)
		opener = self._getOpener(url)
		json = opener.open(url,None).read()
		opener.close()
		return simplejson.loads(json)

	def homeTimeline(self, **kwargs):
		base_url = 'http://api.twitter.com/1/statuses/home_timeline.json'
		url = base_url + '?' + urllib.urlencode(kwargs)
		opener = self._getOpener(url, username=self._username, password=self._password)
		json = opener.open(url,None).read()
		opener.close()
		return simplejson.loads(json)

	def friendsTimeline(self, **kwargs):
		base_url = 'http://api.twitter.com/1/statuses/friends_timeline.json'
		url = base_url + '?' + urllib.urlencode(kwargs)
		opener = self._getOpener(url, username=self._username, password=self._password)
		json = opener.open(url,None).read()
		opener.close()
		return simplejson.loads(json)

	def userTimeline(self, **kwargs):
		base_url = 'http://api.twitter.com/1/statuses/user_timeline.json'
		url = base_url + '?' + urllib.urlencode(kwargs)
		opener = self._getOpener(url, username=self._username, password=self._password)
		json = opener.open(url,None).read()
		opener.close()
		return simplejson.loads(json)

	''' Internal Methods '''
	def _getOpener(self, url, username=None, password=None):
		if username and password:
			auth_handler = urllib2.HTTPBasicAuthHandler()
			(scheme, netloc, path, params, query, fragment) = urlparse.urlparse(url)
			auth_handler.add_password('Twitter API', netloc, username, password)
			opener = urllib2.build_opener(auth_handler)
		else:
			opener = urllib2.build_opener()
		return opener
		


if __name__ == '__main__':
	twitter = Twitter('username', 'password')
	print twitter.search("sumo", lang='ja', locale='ja', rpp='2')
	#print twitter.publicTimeline()
	#print twitter.homeTimeline()
	#print twitter.friendsTimeline()
	#print twitter.userTimeline()
