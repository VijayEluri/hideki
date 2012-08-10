//
//  MTAppDelegate.m
//  UIKitDemo
//
//  Created by Hideki Itakura on 8/9/12.
//  Copyright (c) 2012 Hideki Itakura. All rights reserved.
//

#import "MTAppDelegate.h"

#import "MTViewController.h"

@implementation MTAppDelegate

- (void)setupUI {
    // Create resizable images
    UIImage *navBarImage = [UIImage imageNamed:@"navBar.png"];
    
    // Set the background image for *all* UINavigationBars
    [[UINavigationBar appearance] setBackgroundImage:navBarImage forBarMetrics:UIBarMetricsDefault];
    
    UIImage *segmentSelected=[[UIImage imageNamed:@"segcontrol_sel.png"]resizableImageWithCapInsets:UIEdgeInsetsMake(0, 15, 0, 15)];
    UIImage *segmentUnselected=[[UIImage imageNamed:@"segcontrol_uns.png"]resizableImageWithCapInsets:UIEdgeInsetsMake(0, 15, 0, 15)];
    UIImage *segmentSelectedUnselected=[UIImage imageNamed:@"segcontrol_sel-uns.png"];
    UIImage *segUnselectedSelected=[UIImage imageNamed:@"segcontrol_uns-sel.png"];
    UIImage *segmentUnselectedUnselected=[UIImage imageNamed:@"segcontrol_uns-uns.png"];

    [[UISegmentedControl appearance] setBackgroundImage:segmentUnselected
                                               forState:UIControlStateNormal
                                             barMetrics:UIBarMetricsDefault];
    
    [[UISegmentedControl appearance] setBackgroundImage:segmentSelected
                                               forState:UIControlStateSelected
                                             barMetrics:UIBarMetricsDefault];
    
    [[UISegmentedControl appearance] setDividerImage:segmentUnselectedUnselected
                                 forLeftSegmentState:UIControlStateNormal
                                   rightSegmentState:UIControlStateNormal
                                          barMetrics:UIBarMetricsDefault];
    
    [[UISegmentedControl appearance] setDividerImage:segmentSelectedUnselected
                                 forLeftSegmentState:UIControlStateSelected
                                   rightSegmentState:UIControlStateNormal
                                          barMetrics:UIBarMetricsDefault];
    
    [[UISegmentedControl appearance] setDividerImage:segUnselectedSelected
                                 forLeftSegmentState:UIControlStateNormal
                                   rightSegmentState:UIControlStateSelected
                                          barMetrics:UIBarMetricsDefault];
}


- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
    self.window = [[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]];
    // Override point for customization after application launch.
    self.viewController = [[MTViewController alloc] initWithNibName:@"MTViewController" bundle:nil];
    self.window.rootViewController = self.viewController;
    [self.window makeKeyAndVisible];
    [self setupUI];
    return YES;
}

- (void)applicationWillResignActive:(UIApplication *)application
{
    // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
    // Use this method to pause ongoing tasks, disable timers, and throttle down OpenGL ES frame rates. Games should use this method to pause the game.
}

- (void)applicationDidEnterBackground:(UIApplication *)application
{
    // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later. 
    // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
}

- (void)applicationWillEnterForeground:(UIApplication *)application
{
    // Called as part of the transition from the background to the inactive state; here you can undo many of the changes made on entering the background.
}

- (void)applicationDidBecomeActive:(UIApplication *)application
{
    // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
}

- (void)applicationWillTerminate:(UIApplication *)application
{
    // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
}

@end
