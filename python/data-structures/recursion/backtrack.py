#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys

class NQueens:

	_boardsize         = 0
	_solutions_found   = 0
	_solutions_target  = 0
	_board             = []
	_col_empty         = []
	_up_diagno_empty   = []
	_down_diagno_empty = []
	
	def __init__(self, size=4):
		print size
		self._boardsize = size
		for row in range(self._boardsize):
			self._board.append(['_' for x in range(self._boardsize)])
		self._col_empty         = [True for x in range(self._boardsize)]
		self._up_diagno_empty   = [True for x in range(self._boardsize * 2 - 1)]
		self._down_diagno_empty = [True for x in range(self._boardsize * 2 - 1)]

	def isSafe(self, row, col):
		return (self._col_empty[col] and self._up_diagno_empty[row+col] and self._down_diagno_empty[self._boardsize - 1 + row - col])
	
	def placeQueen(self, row, col):
		self._board[row][col] = 'Q'
		self._col_empty[col] = False
		self._up_diagno_empty[row+col] = False
		self._down_diagno_empty[self._boardsize - 1 + row - col] = False
	
	
	def removeQueen(self, row, col):
		self._board[row][col] = '_'
		self._col_empty[col] = True
		self._up_diagno_empty[row+col] = True
		self._down_diagno_empty[self._boardsize - 1 + row - col] = True
	
	def findSafeColumn(self,row):
		# base case: a solution
		if row == self._boardsize: 
			self._solutions_found += 1
			self.displayBoard()
			if self._solutions_found >= self._solutions_target:
				sys.exit(0)
			return
	
		for col in range(self._boardsize):
			if self.isSafe(row, col):
				self.placeQueen(row, col)
				# move onto the next row
				self.findSafeColumn(row + 1)
				# backtrack
				self.removeQueen(row, col)
	
	def displayBoard(self):
		for row in self._board:
			print " ".join(row)
	
	
def main(argv):
	size = 4
	if len(argv) == 1:
		size = int(argv[0])
	nqueens = NQueens(size)
	nqueens.findSafeColumn(0)

if __name__ == '__main__':
	main(sys.argv[1:])
