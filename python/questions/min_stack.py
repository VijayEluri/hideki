'''
Created on Nov 9, 2010

@author: hideki
'''

class MinStack(object):
    '''
    classdocs
    '''

    def __init__(self):
        '''
        Constructor
        '''
        self.main_stack = []
        self.min_stack = []
        
    def pop(self):
        if len(self.main_stack) == 0:
            raise Exception("stack is empty")
        number = self.main_stack.pop();
        if self.min() == number:
            self.min_stack.pop()
        return number
    
    def push(self, number):
        self.main_stack.append(number)
        if(len(self.min_stack)>0):
            current_min = self.min()
            if number <= current_min:
                self.min_stack.append(number)
        else:
            self.min_stack.append(number)
        
    def min(self):
        if len(self.min_stack) == 0:
            raise Exception("stack is empty")
        number = self.min_stack.pop()
        self.min_stack.append(number)
        return number
    
if __name__ == '__main__':
    stack = MinStack()
    stack.push(5)
    stack.push(3)
    stack.push(6)
    stack.push(7)
    stack.push(2)
    stack.push(2)
    stack.push(1)
    stack.push(4)
    try:
        print "min = %d" % stack.min()
        print "pop() = %d" % stack.pop()
        print "min = %d" % stack.min()
        print "pop() = %d" % stack.pop()
        print "min = %d" % stack.min()
        print "pop() = %d" % stack.pop()
        print "min = %d" % stack.min()
        print "pop() = %d" % stack.pop()
        print "min = %d" % stack.min()
        print "pop() = %d" % stack.pop()
        print "min = %d" % stack.min()
        print "pop() = %d" % stack.pop()
        print "min = %d" % stack.min()
        print "pop() = %d" % stack.pop()
        print "min = %d" % stack.min()
        print "pop() = %d" % stack.pop()
        print "min = %d" % stack.min()
        print "pop() = %d" % stack.pop()
        print "min = %d" % stack.min()
        print "pop() = %d" % stack.pop()
    except Exception as e:
        print e