package com.mtit.bar;

import java.util.Scanner;

import com.mtit.bar.service.BarPublish;

public class BarPublishImpl implements BarPublish {

	String[][] drinks = { { "1.)","Beer" ,  "250.00" }, { "2.)" ,"Arrack",  "400.00"},
			{ "3.)", "Rum" ,"450.00"}, {"4.)" , "Gin" , "420.00"}, { "5.)", "Cocktail",  "350.00" } };
	String bill[][] = new String[20][3];
	int billItems = 0;
	
	@Override
	public void displayItems() {
		System.out.println(" Please choose any of the menu there..");
		for (int i = 0; i < drinks.length; ++i) {
			for (int j = 0; j < drinks[i].length; ++j) {
				System.out.print(drinks[i][j]);
				System.out.print(" ");
			}
			System.out.println("");
		}
		
	}

	@Override
	public void printBill() {

		System.out.println("---------------------------- Payment Bill  ----------------------------");
		System.out.println("");
		System.out.println("Item\t\tQuantity\tFull Amount");
		double sum = 0;
		for (int i = 0; i < billItems; ++i) {
			for (int j = 0; j < bill[i].length; ++j) {
				System.out.print(bill[i][j]);
				System.out.print("\t\t");
			}
			System.out.println("");
		}
		
		for (int i = 0; i < billItems; ++i) {
			sum = sum + Double.parseDouble(bill[i][2]);
		}
		
		System.out.println("");
		System.out.println("Total Purchased items: " + billItems);
		System.out.println("Total Purchase: " + sum);
		int payment = 0;
		do {
			System.out.print("\nEnter Payment: ");
			Scanner scnPay = new Scanner(System.in);
			payment = scnPay.nextInt();
		} while (sum > payment);
		System.out.println("Here's your change: " + (payment - sum));
		System.out
				.println(" ------------------------------ Thank you for coming!!!!!!! ------------------------------ ");

		
	}

	@Override
	public void addBill(int item, int quantity) {
		double amount = 0;
		String name = null;
	
		item--;
		name = drinks[item][1];			

				amount = Double.parseDouble(drinks[item][2]);
				amount = amount*quantity;
		
		bill[billItems][0] = String.valueOf(name);
		bill[billItems][1] = String.valueOf(quantity);
		bill[billItems][2] = String.valueOf(amount);
		billItems++;
	}

}
