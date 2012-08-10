//
//  HypnosisterAppDelegate.h
//  Hypnosister
//
//  Created by Hideki Itakura on 7/30/12.
//  Copyright (c) 2012 Hideki Itakura. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "HypnosisView.h"
@interface HypnosisterAppDelegate : UIResponder <UIApplicationDelegate,UIScrollViewDelegate>
{
    HypnosisView *view;
}
@property (strong, nonatomic) UIWindow *window;

@end
