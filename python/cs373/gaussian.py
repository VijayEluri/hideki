#!/usr/bin/env python
# -*- coding: utf-8 -*-

from math import *

def f(mu, sigma2, x):
	return 1.0 / sqrt(2. * pi * sigma2) * exp(-0.5 * pow(x - mu, 2) / sigma2)

print f(10., 4., 8.)
print f(10., 4., 10.)
