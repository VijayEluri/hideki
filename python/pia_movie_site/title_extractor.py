#!/usr/bin/env python
# -*- coding: utf-8 -*-

import codecs
import sys
from BeautifulSoup import BeautifulSoup
#streamWriter = codecs.lookup('utf-8')[-1]
#sys.stdout = streamWriter(sys.stdout)
sys.stdout = codecs.getwriter('utf-8')(sys.stdout)
soup = BeautifulSoup(sys.stdin.read())
rankTitleTDs = soup.findAll('td', attrs={'class':'rankTitle'})
for td in rankTitleTDs:
	anchors = td.findAll('a')
	if len(anchors) == 2:
		print anchors[1].string
