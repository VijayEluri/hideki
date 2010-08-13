#! /usr/bin/env python
# -*- coding: utf-8 -*-

import sys

class heap:
	def __init__(self, array):
		self.contents = array
		self.numItems = len(array) - 1
		self.makeHeap()

	def makeHeap(self):
		last = len(self.contents) - 1
		parentOfLast = (last - 1) / 2
		for i in range(parentOfLast, 0, -1):
			self.shiftDown(i)


	def shiftDown(self, i):
		toShift = self.contents[i]
		parent = i

		


def main(argv):
	array = map(lambda x: int(x), argv)
	h = heap(array)

if __name__ == '__main__':
	main(sys.argv[1:])
