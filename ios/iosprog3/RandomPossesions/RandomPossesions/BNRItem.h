//
//  BNRItem.h
//  RandomPossesions
//
//  Created by Hideki Itakura on 7/21/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface BNRItem : NSObject
{
    /*
    NSString *itemName;
    NSString *serialNumber;
    int valueInDollars;
    NSDate *dateCreated;
    
    BNRItem *containedItem;
    __weak BNRItem *container;
    //__unsafe_unretained BNRItem *container;
    */
}

//- (void) doSomethingWeird;

+ (id)randomItem;

/*
- (void)setItemName:(NSString*)str;
- (NSString*)itemName;

- (void)setSerialNumber:(NSString*)str;
- (NSString*)serialNumber;

- (void)setValueInDollars:(int)i;
- (int)valueInDollars;

- (NSDate*)dateCreated;

- (void)setContainedItem:(BNRItem*)i;
- (BNRItem*)containedItem;

- (void)setContainer:(BNRItem*)i;
- (BNRItem*)container;
*/

@property (nonatomic,strong) BNRItem *containedItem;
@property (nonatomic,weak) BNRItem *container;

@property (nonatomic,copy) NSString *itemName;
@property (nonatomic,copy) NSString *serialNumber;
@property (nonatomic) int valueInDollars;
@property (nonatomic, readonly,strong) NSDate *dateCreated;



- (id)initWithItemName:(NSString*)name 
        valueInDollars:(int)value 
          serialNumber:(NSString*)sNumber;

- (id)initWithItemName:(NSString*)name;
@end
