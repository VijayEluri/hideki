#!/usr/bin/env python
# -*- coding: utf-8 -*-

from stack import Stack

class Queue:
	def __init__(self):
		self.inStack  = Stack()
		self.outStack = Stack()

	def offer(self, val):
		self.inStack.push(val)

	def poll(self):
		if self.outStack.empty() :
			while True:
				val = self.inStack.pop()
				if val == None:
					break
				self.outStack.push(val)
		return self.outStack.pop()

		


if __name__ == '__main__':
	queue = Queue()
	print "queue.offer(1)"
	queue.offer(1)
	print "queue.offer(2)"
	queue.offer(2)
	print "queue.offer(3)"
	queue.offer(3)
	print "\tqueue.poll() = %d" % queue.poll()
	print "\tqueue.poll() = %d" % queue.poll()
	print "queue.offer(4)"
	queue.offer(4)
	print "\tqueue.poll() = %d" % queue.poll()
	print "queue.offer(5)"
	queue.offer(5)
	print "\tqueue.poll() = %d" % queue.poll()
	print "\tqueue.poll() = %d" % queue.poll()
	#print "\tqueue.poll() = %d" % queue.poll()
