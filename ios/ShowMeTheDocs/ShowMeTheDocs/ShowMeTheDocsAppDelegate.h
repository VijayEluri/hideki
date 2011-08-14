//
//  ShowMeTheDocsAppDelegate.h
//  ShowMeTheDocs
//
//  Created by Hideki Itakura on 7/13/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>

@class ShowMeTheDocsViewController;

@interface ShowMeTheDocsAppDelegate : NSObject <UIApplicationDelegate> {

}

@property (nonatomic, retain) IBOutlet UIWindow *window;

@property (nonatomic, retain) IBOutlet ShowMeTheDocsViewController *viewController;

@end
