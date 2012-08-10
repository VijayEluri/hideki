//
//  ViewController.m
//  TwitterRocks
//
//  Created by Hideki Itakura on 8/4/12.
//  Copyright (c) 2012 Hideki Itakura. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

@synthesize tableView = _tableView;
@synthesize activityIndicatorView = _activityIndicatorView;
@synthesize dataSource = _dataSource;


- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
}




-(IBAction)requestTimeline:(id)sender{
    [self.tableView setHidden:YES];
    [self.activityIndicatorView startAnimating];
    
    NSURL *url = [NSURL URLWithString:@"http://api.twitter.com/1/statuses/user_timeline.json"];

    NSMutableDictionary *parameters = [[NSMutableDictionary alloc]init];
    [parameters setObject:@"envatomobile" forKey:@"screen_name"];
    [parameters setObject:@"50" forKey:@"count"];
    [parameters setObject:@"1" forKey:@"include_entities"];
    
    TWRequest *request = [[TWRequest alloc]initWithURL:url parameters:parameters requestMethod:TWRequestMethodGET];
    
    [request performRequestWithHandler:^(NSData *responseData, NSHTTPURLResponse *urlResponse, NSError *error) {
        if (responseData != nil) {
            NSError *error = nil;
            self.dataSource = [NSJSONSerialization JSONObjectWithData:responseData options:NSJSONReadingMutableLeaves error:&error];
            if(self.dataSource != nil){
                NSLog(@"self.dataSource != nil");
                [self.tableView reloadData];
                [self.tableView setHidden:NO];
                [self.activityIndicatorView stopAnimating];
            }
            else{
                NSLog(@"Error serializing response data %@ with user info %@.", error, error.userInfo);
            }
        }
        else{
            NSLog(@"Error requesting timeline %@ with user info %@.", error, error.userInfo);
        }
    }];
}

-(IBAction)requestMentions:(id)sender{
    [self.tableView setHidden:YES];
    [self.activityIndicatorView startAnimating];
    
    ACAccountStore *accountStore = [[ACAccountStore alloc]init];
    ACAccountType *accountType = [accountStore accountTypeWithAccountTypeIdentifier:ACAccountTypeIdentifierTwitter];
    
    [accountStore requestAccessToAccountsWithType:accountType withCompletionHandler:^(BOOL granted, NSError *error) {
        if(granted){
            NSArray *accounts = [accountStore accountsWithAccountType:accountType];
            if(accounts.count){
                ACAccount *twitterAccount = [accounts objectAtIndex:0];
                
                [self.tableView setHidden:YES];
                [self.activityIndicatorView startAnimating];
                
                NSURL *url = [NSURL URLWithString:@"http://api.twitter.com/1/statuses/mentions.json"];
                NSMutableDictionary *parameters = [[NSMutableDictionary alloc]init];
                [parameters setObject:@"20" forKey:@"count"];
                [parameters setObject:@"1" forKey:@"include_entities"];
                
                TWRequest *request = [[TWRequest alloc]initWithURL:url parameters:parameters requestMethod:TWRequestMethodGET];
                [request setAccount:twitterAccount];
                
                [request performRequestWithHandler:^(NSData *responseData, NSHTTPURLResponse *urlResponse, NSError *error) {
                    if (responseData != nil) {
                        NSError *error = nil;
                        self.dataSource = [NSJSONSerialization JSONObjectWithData:responseData options:NSJSONReadingMutableLeaves error:&error];
                        if(self.dataSource != nil){
                            NSLog(@"self.dataSource != nil");
                            [self.tableView reloadData];
                            [self.tableView setHidden:NO];
                            [self.activityIndicatorView stopAnimating];
                        }
                        else{
                            NSLog(@"Error serializing response data %@ with user info %@.", error, error.userInfo);
                        }
                    }
                }];

            }
        }
        else{
            NSLog(@"The user does not grant us permission to access its Twitter account(s).");
        }
    }];
}

-(NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    NSLog(@"numberOfSectionsInTableView()");
    if(self.dataSource){
        NSLog(@"numberOfSectionsInTableView() 1");
        return 1;
    }
    else{
        NSLog(@"numberOfSectionsInTableView() 0");
        return 0;
    }
}
- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    NSLog(@"numberOfRowsInSection()");
    if(self.dataSource){
        NSLog(@"self.dataSource.count=%d",self.dataSource.count);
        return self.dataSource.count;
    }
    else{
        return 0;
    }
}
- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *CellIdentifier = @"Cell Identifier";
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    if(cell == nil){
        cell = [[UITableViewCell alloc]initWithStyle:UITableViewCellStyleSubtitle reuseIdentifier:CellIdentifier];
    }
    
    NSDictionary *tweet = [self.dataSource objectAtIndex:indexPath.row];
    NSLog(@"tweet: %@",[tweet objectForKey:@"text"]);
    
    cell.textLabel.text = [tweet objectForKey:@"text"];
    cell.imageView.image = [UIImage imageNamed:@"placeholder"];
    
    dispatch_queue_t queue = dispatch_queue_create("com.mobiletuts.task", NULL);
    dispatch_queue_t main = dispatch_get_main_queue();
    
    dispatch_async(queue, ^{
        NSURL  *imageURL = [NSURL URLWithString:[[tweet objectForKey:@"user"] objectForKey:@"profile_image_url"]];
        NSLog(@"imageURL: %@",imageURL);
        NSData *imageData = [NSData dataWithContentsOfURL:imageURL];
        dispatch_async(main, ^{
            cell.imageView.image = [UIImage imageWithData:imageData];
        });
        
    });
    dispatch_release(queue);
    
    return cell;
}
@end
