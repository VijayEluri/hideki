//
//  QuizAppDelegate.h
//  Quiz
//
//  Created by Hideki Itakura on 5/21/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface QuizAppDelegate : NSObject <UIApplicationDelegate> {
	int currentQuestionIndex;
	
	// the model objects
	NSMutableArray *questions;
	NSMutableArray *answers;

	// the view objects
	IBOutlet UILabel *questionField;
	IBOutlet UILabel *answerField;
	
    UIWindow *window;
}

@property (nonatomic, retain) IBOutlet UIWindow *window;

- (IBAction)showQuestion:(id)sender;
- (IBAction)showAnswer:(id)sender;

@end

