#!/usr/bin/env python
# -*- codeing: utf-8 -*-

class Stack:
	def __init__(self):
		self.list = []

	def __str__(self):
		return "Stack( " + str(self.list) + " )"

	def pop(self):
		if self.empty():
			return None
		return self.list.pop()

	def push(self, val):
		self.list.append(val)

	def empty(self):
		if len(self.list) == 0:
			return True
		else:
			return False

if __name__ == '__main__':
	stack = Stack()
	print "stack.push(1)"
	stack.push(1)
	print "stack.push(2)"
	stack.push(2)
	print "stack.push(3)"
	stack.push(3)
	print "\tstack.pop() = %d" % stack.pop()
	print "\tstack.pop() = %d" % stack.pop()
	print "stack.push(4)"
	stack.push(4)
	print "stack.push(5)"
	stack.push(5)
	print "\tstack.pop() = %d" % stack.pop()
	print "\tstack.pop() = %d" % stack.pop()
	print "\tstack.pop() = %d" % stack.pop()
