//
//  ModelObject.m
//  AddOne
//
//  Created by David Phillip Oster 07/13/2011
//  Copyright 2011 Rescue Mission Software. All rights reserved.
//
//  This class is inspired by the discussion of Singleton Object found in Apple's
//  "Cocoa Fundamentals Guide: Cocoa Objects"

//  The only change is that instead of a class method named "sharedManager," this 
//  class uses a method named "sharedInstance."  Both inside of and outside of Apple,
//  "sharedInstance" is a more common name for methods used to return the class instance.  



#import "ModelObject.h"

static ModelObject *sharedModelObject = nil;

@implementation ModelObject


+ (ModelObject*)sharedInstance
{
 @synchronized(self) {
    if (sharedModelObject == nil) {
        ModelObject *temp = [[self alloc] init];
        sharedModelObject = temp;
    }
    return sharedModelObject;
  }
}

- (id)init
{
    self = [super init];
    if (self) {
        if (sharedModelObject) {
            [self release];
            self = [sharedModelObject retain];
        }
    }
    return self;
}

- (id)copyWithZone:(NSZone *)zone
{
    return [self retain];
}


@end
