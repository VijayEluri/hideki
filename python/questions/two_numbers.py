#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys

def bsearch(val, list, left, right):
	if right < left:
		return None
	elif right == left and val != list[left]:
		return None
	half = (left + right) / 2
	if val == list[half]:
		return val
	elif val < list[half]:
		return bsearch2(val, list, left, half)
	elif val > list[half]:
		return bsearch2(val, list, half+1, right)

def find(target, list):
	for i in range(len(list)):
		val = bsearch(target - list[i], list, i+1, len(list) - 1) 
		if val != None:
			return (list[i], val)
	return (None, None)

def main(argv):
	if len(argv) < 3:
		print "Usage: %s numbers target_value" % argv[0]
		return
	l = map(lambda x: int(x), argv[1:-1])
	l = sorted(l)
	val  = int(argv[-1])
	print "%d & %d" % find(val, l)

if __name__ == '__main__':
	main(sys.argv)
