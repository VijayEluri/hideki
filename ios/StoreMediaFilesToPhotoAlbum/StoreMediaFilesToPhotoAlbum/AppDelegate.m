//
//  AppDelegate.m
//  StoreMediaFilesToPhotoAlbum
//
//  Created by Hideki Itakura on 10/17/11.
//  Copyright (c) 2011 __MyCompanyName__. All rights reserved.
//

#import "AppDelegate.h"

@implementation AppDelegate

@synthesize window = _window;

- (void)dealloc
{
    [_window release];
    [super dealloc];
}

- (void)video:(NSString*)videoPath didFinishSavingWithError:(NSError*)error contextInfo:(void*)contextInfo{
    if(error != nil){
        NSLog(@"Error: %@   %@", error, videoPath);
    }
}

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
    self.window = [[[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]] autorelease];
    // Override point for customization after application launch.
    
    //NSString *path0 = [NSHomeDirectory() stringByAppendingPathComponent:[NSString stringWithFormat:@"Documents/sample_mpeg4.mp4"]];
    NSString *path0 = [[NSBundle mainBundle]pathForResource:@"sample_mpeg4"   ofType:@"mp4"];
    UISaveVideoAtPathToSavedPhotosAlbum(path0, self, @selector(video:didFinishSavingWithError:contextInfo:), nil);
    
    
    //NSString *path1 = [NSHomeDirectory() stringByAppendingPathComponent:[NSString stringWithFormat:@"Documents/sample_iPod.m4v"]];
    NSString *path1 = [[NSBundle mainBundle]pathForResource:@"sample_iPod"    ofType:@"m4v"];
    UISaveVideoAtPathToSavedPhotosAlbum(path1, self, @selector(video:didFinishSavingWithError:contextInfo:), nil);
    
    // mov file does not work....
    //NSString *path2 = [[NSBundle mainBundle]pathForResource:@"sample_iTuens"  ofType:@"mov"];
    //NSString *path2 = [NSHomeDirectory() stringByAppendingPathComponent:[NSString stringWithFormat:@"Documents/sample_iTuens.mov"]];
    //UISaveVideoAtPathToSavedPhotosAlbum(path2, self, @selector(video:didFinishSavingWithError:contextInfo:), nil);

    self.window.backgroundColor = [UIColor whiteColor];
    [self.window makeKeyAndVisible];
    return YES;
}

@end
