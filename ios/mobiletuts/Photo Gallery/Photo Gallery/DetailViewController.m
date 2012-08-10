//
//  DetailViewController.m
//  Photo Gallery
//
//  Created by Hideki Itakura on 8/10/12.
//  Copyright (c) 2012 Hideki Itakura. All rights reserved.
//

#import "DetailViewController.h"

@interface DetailViewController ()
{
    CGFloat previousScale;
    CGFloat previousRotation;
    CGFloat beginX;
    CGFloat beginY;
}
@end

@implementation DetailViewController

@synthesize productImageView, productName;


#pragma mark - Managing the detail item



- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.

    self.title = productName;
    
    NSString *imageName = [NSString stringWithFormat:@"%@.jpg", productName];
    self.productImageView.image = [UIImage imageNamed:imageName];
    
    UIRotationGestureRecognizer *rotationGesture = [[UIRotationGestureRecognizer alloc] initWithTarget:self action:@selector(rotateImage:)];
    [self.view addGestureRecognizer:rotationGesture];
    
    UIPinchGestureRecognizer *pinchGesture = [[UIPinchGestureRecognizer alloc] initWithTarget:self action:@selector(scaleImage:)];
    [self.view addGestureRecognizer:pinchGesture];
    
    UITapGestureRecognizer *tapGesture = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(resetImage:)];
    [self.view addGestureRecognizer:tapGesture];
    
    UIPanGestureRecognizer *panGesture = [[UIPanGestureRecognizer alloc] initWithTarget:self action:@selector(moveImage:)];
    [panGesture setMinimumNumberOfTouches:1];
    [panGesture setMaximumNumberOfTouches:1];
    [self.view addGestureRecognizer:panGesture];
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    [self setProductImageView:nil];
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
}
- (void)rotateImage:(UIRotationGestureRecognizer *)recognizer
{
    
    if([recognizer state] == UIGestureRecognizerStateEnded) {
        
        previousRotation = 0.0;
        return;
    }
    
    CGFloat newRotation = 0.0 - (previousRotation - [recognizer rotation]);
    
    CGAffineTransform currentTransformation = self.productImageView.transform;
    CGAffineTransform newTransform = CGAffineTransformRotate(currentTransformation, newRotation);
    
    self.productImageView.transform = newTransform;
    
    previousRotation = [recognizer rotation];
}
- (void)scaleImage:(UIPinchGestureRecognizer *)recognizer
{
    
    if([recognizer state] == UIGestureRecognizerStateEnded) {
        
        previousScale = 1.0;
        return;
    }
    
    CGFloat newScale = 1.0 - (previousScale - [recognizer scale]);
    
    CGAffineTransform currentTransformation = self.productImageView.transform;
    CGAffineTransform newTransform = CGAffineTransformScale(currentTransformation, newScale, newScale);
    
    self.productImageView.transform = newTransform;
    
    previousScale = [recognizer scale];
}
- (void)resetImage:(UITapGestureRecognizer *)recognizer
{
    [UIView beginAnimations:nil context:nil];
    [UIView setAnimationDuration:0.3];
    
    self.productImageView.transform = CGAffineTransformIdentity;
    
    [self.productImageView setCenter:CGPointMake(self.view.frame.size.width/2, self.view.frame.size.height/2)];
    
    [UIView commitAnimations];
}
- (void)moveImage:(UIPanGestureRecognizer *)recognizer
{
    CGPoint newCenter = [recognizer translationInView:self.view];
    
    if([recognizer state] == UIGestureRecognizerStateBegan) {
        
        beginX = self.productImageView.center.x;
        beginY = self.productImageView.center.y;
    }
    
    newCenter = CGPointMake(beginX + newCenter.x, beginY + newCenter.y);
    
    [self.productImageView setCenter:newCenter];
    
}
@end
