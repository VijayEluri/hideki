//
//  BNRMapPoint.m
//  Whereami
//
//  Created by Hideki Itakura on 7/23/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import "BNRMapPoint.h"

@implementation BNRMapPoint
@synthesize coordinate, title;

- (id)initWithCoordinate:(CLLocationCoordinate2D)c title:(NSString *)t
{
    self = [super init];
    if(self){
        coordinate = c;
        [self setTitle:t];
    }
    return self;
}
-(id)init
{
    return [self initWithCoordinate:CLLocationCoordinate2DMake(40.07, -89.32) title:@"Hometown"];
}
@end
