//
//  DetailViewController.h
//  BizAppTutorial
//
//  Created by Hideki Itakura on 8/8/12.
//  Copyright (c) 2012 Hideki Itakura. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "BusinessService.h"
@interface DetailViewController : UIViewController

@property (nonatomic,strong)UILabel* titleLabel;
@property (nonatomic,strong)UIImageView* articleImageView;
@property (nonatomic,strong)UILabel* metaLabel;
@property (nonatomic,strong)UILabel* nameLabel;
@property (nonatomic,strong)UIWebView* articleWebView;
@property (nonatomic,strong)UIScrollView* scrollView;

@property (nonatomic,retain)BusinessService* service;

@end
