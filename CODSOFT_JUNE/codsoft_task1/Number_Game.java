package com.codsoft.internship.task1;

import java.util.Scanner;

public class Number_Game {

	public static void main(String[] args) {

//		Information about the game:
		System.out.println("-----------------------------Welcome to the Number Game-----------------------------");
		System.out.println("Steps to play the game:");
		System.out.println("1. Input your guess (which will be a number between 1 to 100).");
		System.out.println("2. System will compare your guess and display the message accordingly, such as:");
		System.out.println(" a. Increase your guess..");
		System.out.println(" b. Decrease your guess..");
		System.out.println(" c. Congrats! You've guessed it right..");
		System.out.println("3. Also there will be limited number of guesses available to each user.");
		System.out.println("4. If you are unable to guess it right in those number of guesses, then the game will terminate.");
		System.out.println("5. Otherwise a score will be displayed based on the number of guesses taken by a user.");
		System.out.println("\n\t\t\t---------LET'S PLAY---------");
		
//		Random number which will be guessed by the user:
		int generated_number = (int) Math.round(Math.random()*100);
		
//		Maximum number of guesses available:
		int no_of_guesses = 9;
		
//		Condition to continue the game:
		boolean toContinue = true;
		
//		Instance of Scanner class for taking the input from the user:
		Scanner sc = new Scanner(System.in);
				
//		Actually game - loop:
		while(toContinue) {
//			Taking the input:
			System.out.print("\nEnter your guess: ");
			int input = 0;
			
//			Validating the input:
			while(sc.hasNext()) {
				if(sc.hasNextInt()) {
					input = sc.nextInt();
					if(input >= 1 && input <= 100) break;
					else {
						System.out.println("ERROR: Please enter number between 1 to 100!\nTry again..");
						System.out.print("\nEnter your guess: ");
					}
				}else {
					System.out.println("ERROR: Invalid Input. It should be an integer between 1 to 100.\nTry again..");
					System.out.print("\nEnter your guess: ");
					sc.next();
				}
			}
			
//			Reducing the number of guesses available after every iteration:
			no_of_guesses -= 1;
			
//			Following if-else if blocks are checking all the possible results:
//			1. If inputted number is lesser than the generated number:
			if(input < generated_number) {
				if(no_of_guesses >= 1) {
					System.out.println("Increase your guess..");
					System.out.println("Number of guesses remaining: " + no_of_guesses);
					input = 0;
					continue;
				}else if(no_of_guesses == 0) {
					System.out.println("\nGame Over..!!\nMaximum number of guesses reached!\nBetter luck next time...");
					break;
				}
			}
//			2. If inputted number is greater than the generated number:
			else if(input > generated_number) {
				if(no_of_guesses >= 1) {
					System.out.println("Decrease your guess..");
					System.out.println("Number of guesses remaining: " + no_of_guesses);
		            input = 0;
		            continue;
				}else if(no_of_guesses == 0) {
					System.out.println("\nGame Over..!!\nMaximum number of guesses reached!\nBetter luck next time...");
		            break;
				}
			}
//			3. If inputted number is equal to generated number:
			else if(input == generated_number) {
				no_of_guesses = 9 - no_of_guesses;
				System.out.println("\nCongrats! You've guessed it right.");
				System.out.println("You've guessed it right in "+no_of_guesses+" times");
				break;
			}

		}
//		End of while-loop
		
//		Cleaning the resources:
		sc.close();
				
	}

}