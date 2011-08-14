//
//  TestViewAppDelegate.h
//  TestView
//
//  Created by Hideki Itakura on 7/13/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>

@class TestViewViewController;

@interface TestViewAppDelegate : NSObject <UIApplicationDelegate> {

}

@property (nonatomic, retain) IBOutlet UIWindow *window;

@property (nonatomic, retain) IBOutlet TestViewViewController *viewController;

@end
