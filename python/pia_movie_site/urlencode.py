#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys
import urllib

for line in sys.stdin:
	line = line.strip()
	print "%s\t%s" % (line, urllib.quote_plus(line))
