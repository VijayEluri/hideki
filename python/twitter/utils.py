#!/usr/bin/env python
# -*- coding: utf-8 -*-

def normalize(text):
	if text == None or text == "":
		return ""
	return text.encode('utf-8').replace("\t", " ").replace("\r\n", " ").replace("\n", " ").replace("\r", " ") 
