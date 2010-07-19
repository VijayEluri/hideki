#!/usr/bin/env python
# -*- coding: utf-8 -*-

''' quick sort 
	array items should be unique '''

import sys


def swap(array, i, j):
	tmp = array[i]
	array[i] = array[j]
	array[j] = tmp

def partition(array, left, right):
	pivot = array[(left + right) / 2]
	while True:
		while array[left] < pivot:
			left += 1
		while array[right] > pivot:
			right -= 1
		if left < right:
			swap(array, left, right)
		else:
			return left


def qsort(array, left, right):
	split = partition(array, left, right)
	if left < split:
		qsort(array, left, split)
	if right > split + 1:
		qsort(array, split + 1, right)


def main(argv):
	array = map(lambda x: int(x),argv)
	qsort(array, 0, len(array) - 1)
	print array

if __name__ == '__main__':
	main(sys.argv[1:])
