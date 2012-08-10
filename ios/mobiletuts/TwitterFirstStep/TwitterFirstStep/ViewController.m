//
//  ViewController.m
//  TwitterFirstStep
//
//  Created by Hideki Itakura on 8/3/12.
//  Copyright (c) 2012 Hideki Itakura. All rights reserved.
//

#import <Twitter/Twitter.h>

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

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
-(IBAction)tweet:(id)sender{
    if ([TWTweetComposeViewController canSendTweet]) {
         NSLog(@"I can send tweets.");
        // Initialize Tweet Compose View Controller
        TWTweetComposeViewController *vc = [[TWTweetComposeViewController alloc] init];
        
        // Settin The Initial Text
        [vc setInitialText:@"This tweet was sent using the new Twitter framework available in iOS 5."];
        
        // Adding an Image
        UIImage *image = [UIImage imageNamed:@"Boston City Flow.jpg"];
        [vc addImage:image];
        
        // Adding a URL
        NSURL *url = [NSURL URLWithString:@"http://mobile.tutsplus.com"];
        [vc addURL:url];
        
        // Setting a Completing Handler
        [vc setCompletionHandler:^(TWTweetComposeViewControllerResult result) {
            [self dismissModalViewControllerAnimated:YES];
        }];
        
        
        // Display Tweet Compose View Controller Modally
        [self presentViewController:vc animated:YES completion:nil];

    }
    else{
        // Show Alert View When The Application Cannot Send Tweets
        NSString *message = @"The application cannot send a tweet at the moment. This is because it cannot reach Twitter or you don't have a Twitter account associated with this device.";
        UIAlertView *alertView = [[UIAlertView alloc] initWithTitle:@"Oops" message:message delegate:nil cancelButtonTitle:@"Dismiss" otherButtonTitles:nil];
        [alertView show];
    }
}
@end
