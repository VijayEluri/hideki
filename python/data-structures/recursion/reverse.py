#!/usr/bin/env python
# -*- coding: utf-8 -*-

'''reverse array O(N) solution
	actually O(N/2) solution, it is better than O(N) solution ''' 

import sys

def reverse(array, left, right):
	if left > right:
		return
	temp = array[right]
	array[right] = array[left]
	array[left] = temp
	reverse(array, left+1, right-1)
	

def main(argv):
	reverse(argv, 0, len(argv) - 1)
	print argv

if __name__ == '__main__':
	main(sys.argv[1:])
