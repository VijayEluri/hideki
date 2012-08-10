//
//  GridViewController.h
//  BizAppTutorial
//
//  Created by Hideki Itakura on 8/7/12.
//  Copyright (c) 2012 Hideki Itakura. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "AQGridView.h"

@interface GridViewController : UIViewController<AQGridViewDelegate,AQGridViewDataSource>
@property (nonatomic, retain)IBOutlet AQGridView* gridView;
@property (nonatomic, retain)NSArray* services;
@end
