//
//  main.m
//  RandomPossesions
//
//  Created by Hideki Itakura on 7/21/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "BNRItem.h"

int main(int argc, const char * argv[])
{

    @autoreleasepool {
        
        // insert code here...
        //NSLog(@"Hello, World!");
        
        // Create a mutable array object, store its address in items variable
        //NSMutableArray *items = [[NSMutableArray alloc]init];
        
        /*
        [items addObject:@"One"];
        [items addObject:@"Two"];
        [items addObject:@"Three"];
        
        [items insertObject:@"Zero" atIndex:0];
        
        
        for (int i = 0; i < [items count]; i++){
            NSLog(@"%@", [items objectAtIndex:i]);
        }
        */
        
        
        
        
        //BNRItem *p = [[BNRItem alloc]initWithItemName:@"Red Sofa" valueInDollars:100 serialNumber:@"A1B2C"];
         
        
        //NSLog(@"%@ %@ %@ %d", [p itemName],[p dateCreated], [p serialNumber], [p valueInDollars]);
        //NSLog(@"%@", p);
        
        /*
        for (int i = 0; i < 10; i++){
            BNRItem *p = [BNRItem randomItem];
            //[p doSomethingWeird];
            [items addObject:p];
        }
        */
        
        /*
        for(int i = 0; i < [items count]; i++){
            NSLog(@"%@", [items objectAtIndex:i]);
        }
         */
        
        BNRItem *backpack = [[BNRItem alloc]init];
        [backpack setItemName:@"Backpack"];
        //[items addObject:backpack];
        
        BNRItem *calcurator = [[BNRItem alloc]init];
        [calcurator setItemName:@"Calcurator"];
        //[items addObject:calcurator];
        
        [backpack setContainedItem:calcurator]; 
        
        /*
        for(BNRItem *item in items){
            NSLog(@"%@", item);
        }
         */
        

        
        // Destroy the array pointed to by items
        //NSLog(@"Setting items to nil...");
        //items = nil;
        
        backpack = nil;
        
        NSLog(@"Container: %@", [calcurator container]);
        
        calcurator = nil;
    }
    return 0;
}

