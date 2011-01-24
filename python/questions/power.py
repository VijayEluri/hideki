#!/usr/bin/env python
# -*- coding: utf-8 -*-

def power(x, n):
	print str(x)+ " " + str(n)
	if n == 0:
		return 1

	temp = power(x, n / 2)
	print "\t" + str(temp)
	if n % 2 == 0:
		return temp * temp
	else:
		return x * temp * temp



print "%d" % power(2, 5)
