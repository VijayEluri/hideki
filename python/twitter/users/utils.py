#!/usr/bin/env python
# -*- coding: utf-8 -*-

from types import *

def dict_strip(dict):
	for k, v in dict.iteritems():
		t = type(v)
		if t == StringType or t == UnicodeType:
			dict[k] = strip(v)
	return dict

def strip(text):
	if text == None or text == "":
		return ""
	return text.replace("\t", " ").replace("\r\n", " ").replace("\n", " ").replace("\r", " ") 

def dict_sql_escape(dict):
	for k, v in dict.iteritems():
		t = type(v)
		if t == StringType or t == UnicodeType:
			dict[k] = sql_escape(v)
	return dict

def sql_escape(text):
	return text.replace("'", "''")
