#!/usr/bin/env python
# -*- coding: utf-8 -*-

import math

def is_prime(n):
    if n < 2:
        return False
    
    if n == 2:
        return True

    if n % 2 == 0:
        return False
    
    sq = int(math.sqrt(n))
    for i in range(3, sq+1, 2):
        if n % i == 0:
            return False
        
    return True
    
def fib(n):
    if n == 0:
        return 0
    
    if n == 1:
        return 1
    
    return fib(n-1) + fib(n-2)

def prime_divisors(n):
    list = []
    sq = int(n**0.5) + 1
    for i in range(2, sq):
        if is_prime(i) and n % i == 0:
            list.append(i)
    return list
    

def main():
    X = 0
    num = 227000
    i = 0
    while True:
        f = fib(i)
        #print f
        if f > num:
            if is_prime(f):
                X = f
                break
        i += 1
        
    print "step 1: %d" % X 
    print "step 2: %d" % sum(prime_divisors(X+1))
        
        
if __name__ == '__main__':
    main()