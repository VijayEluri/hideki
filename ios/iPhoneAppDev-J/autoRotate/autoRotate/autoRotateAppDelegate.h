//
//  autoRotateAppDelegate.h
//  autoRotate
//
//  Created by Hideki Itakura on 7/27/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>

@class autoRotateViewController;

@interface autoRotateAppDelegate : NSObject <UIApplicationDelegate> {

}

@property (nonatomic, retain) IBOutlet UIWindow *window;

@property (nonatomic, retain) IBOutlet autoRotateViewController *viewController;

@end
