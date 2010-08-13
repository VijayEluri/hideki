#! /usr/bin/env python
# -*- coding: utf-8 -*-

import sys
import re

p = re.compile(r'映画\s*(「|『)(.*?)(』|」).*')

def extract_title(text):
	m = p.match(text)
	if m != None:
		return m.group(2)
	else:
		return "NO MATCH"

def main(argv):
	for line in sys.stdin:
		line = line.strip()
		title = extract_title(line)
		print "[%s] => %s" % (title, line)
	
if __name__ == '__main__':
	main(sys.argv[1:])
