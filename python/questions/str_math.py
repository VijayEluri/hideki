#!/usr/bin/env python
# -*- coding: utf-8 -*-

def add(strNum1, strNum2):
	"""
	Summation of two number strings
	"""
	# check sign of both string values
	minus1 = False
	minus2 = False
	if strNum1[0] == '-':
		minus1 = True;
	if strNum2[0] == '-':
		minus2 = True;

	# addition or subtraction
	subtraction = False
	if minus1 != minus2:
		subtraction = True

	# get both reverse string of positive value
	if minus1 == False:
		rStrNum1   = strNum1[::-1]
	else:
		rStrNum1   = strNum1[:0:-1]
	if minus2 == False:
		rStrNum2   = strNum2[::-1]
	else:
		rStrNum2   = strNum2[:0:-1]

	# get length of strings
	strNum1Len = len(rStrNum1)
	strNum2Len = len(rStrNum2)

	# bigger absolute value should be set as string 1
	if strNum2Len > strNum1Len:
		tmp = rStrNum2
		rStrNum2 = rStrNum1
		rStrNum1 = tmp
		tmp = minus2
		minus2 = minus1
		minus1 = tmp
		strNum1Len = len(rStrNum1)
		strNum2Len = len(rStrNum2)
	elif strNum1Len == strNum2Len:
		if rStrNum1[::-1] < rStrNum2[::-1]:
			tmp = rStrNum2
			rStrNum2 = rStrNum1
			rStrNum1 = tmp
			strNum1Len = len(rStrNum1)
			strNum2Len = len(rStrNum2)
			tmp = minus2
			minus2 = minus1
			minus1 = tmp


	advance    = 0
	result     = ""
	index = 0
	while index < strNum1Len or index < strNum2Len:
		val1 = 0
		val2 = 0
		if index < strNum1Len:
			val1 = int(rStrNum1[index]) - int('0')
		if index < strNum2Len:
			val2 = int(rStrNum2[index]) - int('0')
		if subtraction == False:
			val = val1 + val2 + advance
			if val / 10 > 0:
				advance = 1
			else:
				advance = 0
		else:
			val = val1 - val2 + advance
			if val < 0:
				val += 10
				advance = -1
			else:
				advance = 0
		result += str((int('0') + val % 10))
		index += 1
	result = result[::-1]
	if minus1 and minus2:
		result = "-" + result
	elif subtraction and minus1:
		result = "-" + result
	return result


print "123 + 3210   = %s" % add("123", "3210")
print "-123 + -3210 = %s" % add("-123", "-3210")
print "-123 + 3210  = %s" % add("-123", "3210")
print "123 + -3210  = %s" % add("123", "-3210")
print "0 + 0        = %s" % add("0", "0")
print "4294967296 + 4294967296 = %s" % add("4294967296", "4294967296")    # 2**32 is bigger than max inter value
