package com.coders.campus.assignment2attampt2;

import java.util.Random;
import java.util.Scanner;

public class HighLowGuessingGame {
	public static void main(String[] args) {
		Random random = new Random();
		int theRandomNumber = random.nextInt(100) + 1;
		System.out.println(theRandomNumber);
		int userPick = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Please pick a number between 1 and 100: ");

		int userAttempts = 0;
		boolean win = false;
		int maxAttempts = 5;

		while (!win && userAttempts < maxAttempts) {
			String input = scan.nextLine();

			if (isValidInput(input)) {
				int intInput = Integer.parseInt(input);

				if (intInput < 1 || intInput > 100) {
					System.out.println("Your guess is not between 1-100, please try again.");
					System.out.println("You have " + (maxAttempts - userAttempts) + " more attempts");
				} else {
					userPick = intInput;

					if (userPick < theRandomNumber) {
						System.out.println("Your number is too low");
					} else if (userPick > theRandomNumber) {
						System.out.println("Your number is too high");
					} else {
						win = true;
						System.out.println("You Won!!!");
					}

					if (!win) {
						userAttempts++;
						System.out.println("You have " + (maxAttempts - userAttempts) + " more attempts");
						if (userAttempts == maxAttempts) {
							System.out.println("You Lost!!!");
							System.out.println("You have no more remaining attempts");
						} else {
							System.out.println("Try again: ");
						}
					}
				}
			} else {
				System.out.println("Invalid input. Please enter a valid number between 1 and 100.");
			}
		}

		scan.close();
	}

	private static boolean isValidInput(String input) {
		try {
			int intInput = Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}