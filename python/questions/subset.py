#!/usr/bin/env python
# -*- coding: utf-8 -*-

list = [3, 4, 9, 14, 15, 19, 28, 37, 47, 50, 54, 56, 59, 61, 70, 73, 78, 81, 92, 95, 97, 99]

counter = 0

def find(start, end, n):    
    if end < 0:
        return
    
    X = list[end]
    
    if n == X:
        global counter
        counter += 1
    elif X < n:
        find(start, end -1, n - X)

    find(start, end -1, n)
    
def subsets(n):
    idx = list.index(n)
    find(0, idx - 1, n)
                
def main():
    global counter
    counter = 0
    for n in list:
        subsets(n)
    print counter

if __name__ == '__main__':
    main()