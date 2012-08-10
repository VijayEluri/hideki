//
//  FirstViewController.h
//  BizAppTutorial
//
//  Created by Hideki Itakura on 8/6/12.
//  Copyright (c) 2012 Hideki Itakura. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "FXLabel.h"

@interface FirstViewController : UIViewController

@property (nonatomic, strong) IBOutlet FXLabel*  logoLabel;
@property (nonatomic, strong) IBOutlet UILabel*  descriptionLabel;
@property (nonatomic, strong) IBOutlet UIButton* callUsButton;
@property (nonatomic, strong) IBOutlet UIButton* directionsButton;
@property (nonatomic, strong) IBOutlet UILabel*  copyrightLabel;

@end
