#!/usr/bin/env python

"""
From:
	http://stackoverflow.com/questions/731832/interview-question-ffn-n

Question:
Design a function f, such that:

f(f(n)) == -n
Where n is a 32 bit signed integer; you can't use complex numbers arithmetic.

If you can't design such a function for the whole range of numbers, design it for the largest range possible.
"""

def f(n):
	if n == 0:
		return 0

	if n > 0:
		# odd number
		if n % 2 == 1:
			return n + 1
		# even number
		else:
			return -1 * (n - 1)
	else:
		# odd number
		if n % 2 == 1:
			return n - 1
		# even number
		else:
			return -1 * (n + 1)

print "f(f(0)) = %d" % (f(f(0)))

print "f(f(1)) = %d" % (f(f(1)))
print "f(f(2)) = %d" % (f(f(2)))
print "f(f(3)) = %d" % (f(f(3)))
print "f(f(4)) = %d" % (f(f(4)))
print "f(f(5)) = %d" % (f(f(5)))

print "f(f(-1)) = %d" % (f(f(-1)))
print "f(f(-2)) = %d" % (f(f(-2)))
print "f(f(-3)) = %d" % (f(f(-3)))
print "f(f(-4)) = %d" % (f(f(-4)))
print "f(f(-5)) = %d" % (f(f(-5)))
