//
//  ViewController.h
//  TwitterRocks
//
//  Created by Hideki Itakura on 8/4/12.
//  Copyright (c) 2012 Hideki Itakura. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <Twitter/Twitter.h>
#import <Accounts/Accounts.h>

@interface ViewController : UIViewController<UITableViewDataSource, UITableViewDelegate>
{
    __weak UITableView *_tableView;
    __weak UIActivityIndicatorView *_activityIndicatorView;
    NSArray *_dataSource;
}

@property (nonatomic,weak)IBOutlet UITableView *tableView;
@property (nonatomic,weak)IBOutlet UIActivityIndicatorView *activityIndicatorView;

@property (nonatomic,strong)NSArray *dataSource;

-(IBAction)requestTimeline:(id)sender;
-(IBAction)requestMentions:(id)sender;

@end
