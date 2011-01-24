#!/usr/bin/env python

# -*- coding: utf-8 -*-

import sys


def same(a, b):
	if a == b:
		return True
	else:
		return False

def substring(x, y):
	len_x = len(x)
	len_y = len(y)
	for i in range(len_y):
		if y[i] == x[0]:
			if same(y[i:i+len_x], x):
				return True
	return False

def main(args):
	if len(args) != 3:
		print >> sys.stderr, "Usage %s x y" % (args[0])
		return

	x = args[1]
	y = args[2]
	print >> sys.stdout, "x (%s) is a substring of y (%s): %d" % (x, y, substring(x, y))

if __name__ == '__main__':
	main(sys.argv)
