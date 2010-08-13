#!/usr/bin/env python
# -*- coding: utf-8 -*-

import urllib
import urllib2
import simplejson
import urlparse

class Twitter(object):
	""" Twitter API class

	Existing python Twitter libraries are not fully compatible with Twitter API.
	So I'd like to write simple Twitter API python library for my use-cases.

	Twitter API Documentation
	http://apiwiki.twitter.com/Twitter-API-Documentation
	http://dev.twitter.com
	"""

	def __init__(self,
			username=None,
			password=None):
		self._username = username
		self._password = password

	''' Public Methods '''

	''' Search API Methods '''

	def search(self, **kwargs):
		base_url = 'http://search.twitter.com/search.json'
		url = base_url + '?' + urllib.urlencode(kwargs)
		return self._fetchUrl(url)


	''' Timeline Methods '''

	def publicTimeline(self, **kwargs):
		""" Fetch the 20 most recent statuses from non-protected users who have set a
		custom user icon.

  		Args:

  		Returns:
			An sequence of status dict objects
  		"""
		base_url = 'http://api.twitter.com/1/statuses/public_timeline.json'
		url = base_url + '?' + urllib.urlencode(kwargs)
		return self._fetchUrl(url)

	def homeTimeline(self, **kwargs):
		base_url = 'http://api.twitter.com/1/statuses/home_timeline.json'
		url = base_url + '?' + urllib.urlencode(kwargs)
		return self._fetchUrl(url)

	def friendsTimeline(self, **kwargs):
		base_url = 'http://api.twitter.com/1/statuses/friends_timeline.json'
		url = base_url + '?' + urllib.urlencode(kwargs)
		return self._fetchUrl(url)

	def userTimeline(self, **kwargs):
		base_url = 'http://api.twitter.com/1/statuses/user_timeline.json'
		url = base_url + '?' + urllib.urlencode(kwargs)
		return self._fetchUrl(url)

	''' User Methods '''
	def usersShow(self, **kwargs):
		base_url = 'http://api.twitter.com/1/users/show.json'
		url = base_url + '?' + urllib.urlencode(kwargs)
		return self._fetchUrl(url)

	def usersLookup(self, **kwargs):
		base_url = 'http://api.twitter.com/1/users/lookup.json'
		url = base_url + '?' + urllib.urlencode(kwargs)
		return self._fetchUrl(url)

	def usersSearch(self, **kwargs):
		""" GET users/search

		Runs a search for users similar to Find People button on Twitter.com.
		The results returned by people search on Twitter.com are the same as those
		returned by this API request.

		Only the first 1000 matches are available.

		Requires Authentication: true

		Parameters:
			Required:
				q - The search query to run against people search
			Optional
				per_page
				page
				include_entitles
		"""
		base_url = 'http://api.twitter.com/1/users/search.json'
		url = base_url + '?' + urllib.urlencode(kwargs)
		return self._fetchUrl(url)

	''' Favorite Methods '''
	def favorites(self, **kwargs):
		base_url = 'http://api.twitter.com/1/favorites.json'
		url = base_url + '?' + urllib.urlencode(kwargs)
		return self._fetchUrl(url)

	''' Friendship Methods '''
	def friendsIds(self, **kwargs):
		base_url = 'http://api.twitter.com/1/friends/ids.json'
		url = base_url + '?' + urllib.urlencode(kwargs)
		return self._fetchUrl(url)

	def followersIds(self, **kwargs):
		base_url = 'http://api.twitter.com/1/followers/ids.json'
		url = base_url + '?' + urllib.urlencode(kwargs)
		return self._fetchUrl(url)

	''' Internal Methods '''

	def _fetchUrl(self, url):		
		opener = self._getOpener(url, username=self._username, password=self._password)
		json = opener.open(url,None).read()
		opener.close()
		return simplejson.loads(json)

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
	#twitter = Twitter()
	#twitter = Twitter('username', 'password')
	twitter = Twitter('hitakura', '290303')
	#print twitter.search(q="sumo", lang='ja', locale='ja', rpp='2')
	#print twitter.publicTimeline()
	#print twitter.homeTimeline()
	#print twitter.friendsTimeline()
	#print twitter.userTimeline()
	#print twitter.favorites()
	#print twitter.friendsIds(screen_name="hitakura")
	#print twitter.followersIds(screen_name="hitakura")
	#print twitter.usersShow(screen_name="lalha")
	#print twitter.usersLookup(screen_name="lalha,hitakura")
	print twitter.usersSearch(q="映画", per_page="1", include_entities="true")
