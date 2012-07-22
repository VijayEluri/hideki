//
//  QuizViewController.m
//  Quiz
//
//  Created by Hideki Itakura on 7/21/12.
//  Copyright (c) 2012 __MyCompanyName__. All rights reserved.
//

#import "QuizViewController.h"

@interface QuizViewController ()

@end

@implementation QuizViewController


- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    // Call the init method implmented by the superclass
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if(self){
        // Create two arrays and make the pointers poin to them
        questions = [[NSMutableArray alloc]init];
        answers = [[NSMutableArray alloc]init];
        
        // Add questions and answers to the arrays
        [questions addObject:@"What is 7 + 7"];
        [answers addObject:@"14"];
        
        [questions addObject:@"What is the capital of Vermont"];
        [answers addObject:@"Montpelier"];
        
        [questions addObject:@"From what is cognac made?"];
        [answers addObject:@"Grapes"];

    }
    return self;
}
- (IBAction)showQuestion:(id)sender
{
    currentQuestionIndex++;
    
    // Am I past the last question?
    if(currentQuestionIndex == [questions count]){
        currentQuestionIndex = 0;
    }
    
    NSString *question = [questions objectAtIndex:currentQuestionIndex];
    
    NSLog(@"displaying question: %@", question);
    
    [questionField setText:question];
    
    [answerField setText:@"???"];
                    
                        
}
- (IBAction)showAnswer:(id)sender
{
    NSString *answer = [answers objectAtIndex:currentQuestionIndex];
    
    [answerField setText:answer];
}
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

@end
