//
//  MasterViewController.m
//  Photo Gallery
//
//  Created by Hideki Itakura on 8/10/12.
//  Copyright (c) 2012 Hideki Itakura. All rights reserved.
//

#import "MasterViewController.h"

#import "DetailViewController.h"

@interface MasterViewController () {

}
@end

@implementation MasterViewController

@synthesize list;

- (void)awakeFromNib
{
    [super awakeFromNib];
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    
    // custom codes
    self.title = @"Products";
    
    NSArray *listArray = [[NSArray alloc] initWithObjects:@"iPhone", @"iPad", @"iMac", @"MacBook Air", nil];
    self.list = listArray;
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}

#pragma mark - Table View

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView
{
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return [list count];
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *CellIdentifier = @"Cell";
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier];
    cell.textLabel.text = [list objectAtIndex:[indexPath row]];
    return cell;
}



- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
{
    [[segue destinationViewController] setProductName:[list objectAtIndex:[self.tableView.indexPathForSelectedRow row]]];
}

@end
