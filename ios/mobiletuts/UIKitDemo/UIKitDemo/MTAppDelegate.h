//
//  MTAppDelegate.h
//  UIKitDemo
//
//  Created by Hideki Itakura on 8/9/12.
//  Copyright (c) 2012 Hideki Itakura. All rights reserved.
//

#import <UIKit/UIKit.h>

@class MTViewController;

@interface MTAppDelegate : UIResponder <UIApplicationDelegate>

@property (strong, nonatomic) UIWindow *window;

@property (strong, nonatomic) MTViewController *viewController;

@end
