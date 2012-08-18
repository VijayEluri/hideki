#!/usr/bin/env python

def twoSum(array, target):
	print array
	print target
	i = 0
	j = len(array) - 1
	#for i, j in zip(range(len(array)), range(len(array)-1, -1, -1)):
	while i < j:
		s = array[i] + array[j]
		if s == target:
			return (array[i], array[j])
		elif s < target:
			i += 1
		elif s > target:
			j -= 1
	return (-1, -1)

def threeSum(array, target):
	list = sorted(array)
	for x in list:
		(y, z) = twoSum(list, target-x)
		if y != -1 and z != -1:
			return (x, y, z)
	return (-1, -1, -1)



list = [20, 11, 88, 77, 5, 9, 10, 21, 68, 23, 55, 96, 23, 33, 44, 66, 75, 87, 8, 18, 1000, 1]
target = 104

print threeSum(list, target)