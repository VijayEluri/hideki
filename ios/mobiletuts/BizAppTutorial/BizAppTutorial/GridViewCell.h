//
//  GridViewCell.h
//  BizAppTutorial
//
//  Created by Hideki Itakura on 8/7/12.
//  Copyright (c) 2012 Hideki Itakura. All rights reserved.
//
#import <UIKit/UIKit.h>
#import "AQGridView.h"

@interface GridViewCell : AQGridViewCell

@property (nonatomic, retain)UIImageView* imageView;
@property (nonatomic, retain)UILabel* captionLabel;

@end
