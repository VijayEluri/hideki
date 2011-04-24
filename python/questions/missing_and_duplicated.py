#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Puzzle

URL: http://maxschireson.com/2011/04/23/want-a-job-working-on-mongodb-your-first-online-interview-is-in-this-post/

Here’s the puzzle:

You’re given an array of N 64 bit integers. N may be very large. You know that every integer 1-N appears once in the array, except there is one integer missing and one integer duplicated.

I’d like a linear time algorithm to find the missing and duplicated numbers. Further, your algorithm should run in small constant space and leave the array untouched.

– Max
"""


import sys
from random import shuffle


def find(array):
	"""
	This solution is Log(2N) algorithm, uses constant space, and does not modifiy array.
	"""

	# 1) calcurate XOR(1..N) and XOR(array)
	xor_indexes = 0;
	xor_values  = 0;
	for i in range(len(array)):
		val = array[i]
		xor_indexes ^= (i + 1)
		xor_values  ^= val;
	
	# 2) calcurate XOR(mis, dup)
	xor_mis_dup = xor_indexes ^ xor_values;

	# 3) find mis and dup
	for i in range(len(array)):
		val = array[i]
		# if val is dup, xor_values_val is xor_index wo missing
		xor_values_val = xor_values ^ val
		# if val is dup, XOR(xor_values_val, xor_index) == mis
		mis = xor_values_val ^ xor_indexes
		# if val is dup, mis ^ xor_mis_dup == val
		if (mis ^ xor_mis_dup) == val:
			dup = val
			break

	return (mis, dup)


def main(argv):
	"""
	Test code
	"""
	if len(argv) == 1:
		print >>sys.stderr, "USAGE: %s N\n\tN: array size and N >= 2" % (argv[0])
		return
	# generate the test data with N int array
	N = int(argv[1])
	if N <= 1:
		print >>sys.stderr, "USAGE: %s N\n\tN: array size and N >= 2" % (argv[0])
		return
	nums = range(1, N+1) # array
	shuffle(nums)     # suffle array
	nums[0] = nums[1] # missing & duplicate
	print >> sys.stdout, "array: %s" % (nums)
	# find missing & duplicated values
	(missing, duplicated) = find(nums)
	# print
	print >> sys.stdout, "missing: %d, duplicated: %d" % (missing, duplicated)

if __name__ == '__main__':
	main(sys.argv)
