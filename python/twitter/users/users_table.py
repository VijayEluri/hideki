#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys
import sqlite3


def main(argv):
	db = sqlite3.connect('twitter.db')
	for name in db.execute("select name from users").fetchall():
		print name[0]
	db.close()

if __name__ == '__main__':
	main(sys.argv[1:])
