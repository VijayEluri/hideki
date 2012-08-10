//
//  WhereamiViewController.m
//  Whereami
//
//  Created by Hideki Itakura on 7/23/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import "WhereamiViewController.h"
#import "BNRMapPoint.h"

@interface WhereamiViewController ()

@end

@implementation WhereamiViewController

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if(self){
        locationManager = [[CLLocationManager alloc]init];
        [locationManager setDelegate:self];
        [locationManager setDesiredAccuracy:kCLLocationAccuracyBest];
        
        //[locationManager startUpdatingLocation];
    }
    return self;
}
-(void)dealloc
{
    [locationManager setDelegate:nil];
}
- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    
    [worldView setShowsUserLocation:YES];
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

-(void)locationManager:(CLLocationManager *)manager 
   didUpdateToLocation:(CLLocation *)newLocation 
          fromLocation:(CLLocation *)oldLocation
{
    NSLog(@"%@", newLocation);
    
    NSTimeInterval t = [[newLocation timestamp] timeIntervalSinceNow];
    if(t < -180){
        return;
    }
    [self foundLocation:newLocation];
}

-(void)locationManager:(CLLocationManager *)manager 
      didFailWithError:(NSError *)error
{
    NSLog(@"Could not find location: %@", error);
}
/*
-(void)doSomethingWeird
{
    NSLog(@"Line 1");
    NSLog(@"Line 2");
    NSLog(@"Line 3");
}
 */
- (void)mapView:(MKMapView *)mapView didUpdateUserLocation:(MKUserLocation *)userLocation
{
    NSLog(@"didUpdateUserLocation: %@", userLocation);
    CLLocationCoordinate2D loc = [userLocation coordinate];
    MKCoordinateRegion region = MKCoordinateRegionMakeWithDistance(loc, 250, 250);
    [worldView setRegion:region animated:YES];
}
- (BOOL)textFieldShouldReturn:(UITextField *)textField
{
    [self findLocation];
    [textField resignFirstResponder];
    return YES;
}
-(void)findLocation{
    [locationManager startUpdatingLocation];
    [activityIndicator startAnimating];
    [locationTitleField setHidden:YES];
}
-(void)foundLocation:(CLLocation *)loc
{
    CLLocationCoordinate2D  coord = [loc coordinate];
    BNRMapPoint *mp = [[BNRMapPoint alloc]initWithCoordinate:coord title:[locationTitleField text]];
    [worldView addAnnotation:mp];
    MKCoordinateRegion region = MKCoordinateRegionMakeWithDistance(coord, 250, 250);
    [worldView setRegion:region];
    
    [locationTitleField setText:@""];
    [activityIndicator stopAnimating];
    [locationTitleField setHidden:NO];
    [locationManager stopUpdatingLocation];
}
@end
