//
//  MTViewController.m
//  UIKitDemo
//
//  Created by Hideki Itakura on 8/9/12.
//  Copyright (c) 2012 Hideki Itakura. All rights reserved.
//
#import <QuartzCore/QuartzCore.h>
#import "MTViewController.h"

@interface MTViewController (){
    NSArray *imagesArray;
    NSArray *titlesArray;
}
@end

@implementation MTViewController

@synthesize aNavigationBar;
@synthesize anImageView;
@synthesize aLabel;
@synthesize aSegmentControl;

- (void)setupUI {
    [self.view setBackgroundColor:[UIColor colorWithPatternImage:[UIImage imageNamed:@"BG-pattern.png"]]];
    


    [anImageView.layer setBorderWidth:5.0f];
    [anImageView.layer setBorderColor:[[UIColor whiteColor] CGColor]];
    
    [anImageView.layer setShadowRadius:5.0f];
    [anImageView.layer setShadowOpacity:.85f];
    [anImageView.layer setShadowOffset:CGSizeMake(1.0f, 2.0f)];
    [anImageView.layer setShadowColor:[[UIColor blackColor] CGColor]];
    [anImageView.layer setShouldRasterize:YES];
    [anImageView.layer setMasksToBounds:NO];
    
    CGAffineTransform transform = CGAffineTransformMakeRotation(.03f);
    anImageView.transform = transform;
    
    [aLabel.layer setCornerRadius:15.0f];
}

- (void)setupData {
    imagesArray = [NSArray arrayWithObjects:@"red_rocks.jpg", @"tree.jpg", @"truck.jpg", nil];
    titlesArray = [NSArray arrayWithObjects:@"Red Rocks", @"A Tree", @"A Truck", nil];
}

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    
    // build arrays for images and titles
    [self setupData];
    
    // start app with first segment selected
    [self didChangeSegmentControl:aSegmentControl];
    
    // set up the custom UI elements
    [self setupUI];
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    
    [self setANavigationBar:nil];
    [self setAnImageView:nil];
    [self setALabel:nil];
    [self setASegmentControl:nil];
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
}

- (IBAction)didChangeSegmentControl:(UISegmentedControl*)sender {
    [anImageView setImage:[UIImage imageNamed:[imagesArray objectAtIndex:[sender selectedSegmentIndex]]]];
    
    [aLabel setText:[titlesArray objectAtIndex:[sender selectedSegmentIndex]]];
}
@end
