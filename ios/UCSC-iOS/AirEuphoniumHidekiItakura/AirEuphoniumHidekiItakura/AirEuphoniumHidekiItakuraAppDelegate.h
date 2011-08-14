//
//  AirEuphoniumHidekiItakuraAppDelegate.h
//  AirEuphoniumHidekiItakura
//
//  Created by Hideki Itakura on 7/8/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>

@class AirEuphoniumHidekiItakuraViewController;

@interface AirEuphoniumHidekiItakuraAppDelegate : NSObject <UIApplicationDelegate> {

}

@property (nonatomic, retain) IBOutlet UIWindow *window;

@property (nonatomic, retain) IBOutlet AirEuphoniumHidekiItakuraViewController *viewController;

@end
