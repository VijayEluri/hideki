#!/usr/bin/env python

''' O(logN) solution '''

import sys

def power(base, exponent):
	if exponent == 0:
		return 1

	temp = power(base, exponent/2)
	if exponent % 2 == 0:
		return temp * temp
	else:
		return base * temp * temp

def main(argv):
	if len(argv) != 2:
		print >> sys.stderr, "power.py base exponent"
		return
	base = int(argv[0])
	exponent = int(argv[1])
	print "%d**%d = %d" % (base, exponent, power(base, exponent))

if __name__ == '__main__':
	main(sys.argv[1:])
