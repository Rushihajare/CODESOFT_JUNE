package com.codsoft.internship.task4;

import java.io.*;
import java.text.*;
import java.util.*;

public class OptionMenu extends Account {
	
	/*To take an input from the user: */
	Scanner menuInput = new Scanner(System.in);
	/*Format of money*/
	DecimalFormat moneyFormat  = new DecimalFormat("'₹'###,##0.00");
	
	/*Created HashMap to store data in: customer_no : pin_no pair*/
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
	
	public void getLogin() throws IOException {
		int x = 1;
		do {
			try {
				data.put(952341, 191904);
				data.put(989947, 71976);
				
				System.out.println("Welcome to the ATM Project!");
				System.out.println("Enter your Customer Number: ");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.println("Enter your PIN Number: ");
				setPinNumber(menuInput.nextInt());
			} catch (Exception e) {
				System.out.println("\nInvalid Character(s). Only Numbers.\n");
				x = 2;
			}
			
			/*Checking if the entered customer number and pin number is valid or not!*/
			int cn = getCustomerNumber();
			int pn = getPinNumber();
			if(data.containsKey(cn) && data.get(cn) == pn) {
				getAccountType();
			} else { 
				System.out.println("\nWrong Customer Number or Pin Number!\n");
			}
		}while(x == 1);
	}
	
	
	/*Accessing the account type which is wanted by the customer*/
	public void getAccountType() {
		System.out.println("Select the Account you to want to access: ");
		System.out.println("Type 1 - Checking Account");
		System.out.println("Type 2 - Saving Account");
		System.out.println("Type 3 - Exit");
		
		int selection = menuInput.nextInt();
		
		switch(selection) {
		case 1:
			getChecking();
			break;
		case 2:
			getSaving();
			break;
		case 3:
			System.out.println("Thank you for using this ATM.\nHave a nice day!\n");
			break;
		default:
			System.out.println("\nInvalid Choice!\n");
		}
	}

	/*If the customer has selected Checking Account, then following features are available for the customer now:*/
	public void getChecking() {
		System.out.println("Checking Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice: ");
		
		int selection = menuInput.nextInt();
		
		switch(selection) {
		case 1:
			System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for using this ATM.\nHave a nice day!\n");
			break;		
		default:
			System.out.println("\nInvalid Choice!\n");
			getChecking();
		}
	}
	
	/*If the customer has selected Checking Account, then following features are available for the customer now:*/
	public void getSaving() {
		System.out.println("Saving Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice: ");
		
		int selection = menuInput.nextInt();
		
		switch(selection) {
		case 1:
			System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;
		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getSavingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for using this ATM.\nHave a nice day!\n");
			break;		
		default:
			System.out.println("\nInvalid Choice!\n");
			getSaving();
		}
	}
}
