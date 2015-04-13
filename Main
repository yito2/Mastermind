/*
* CSC 172
*
* Version 1.0
*
* Copyright Yukako
*
* Course : CSC172 SPRING 2015
*
* Assignment : Project 1
*
* Author : Yukako Ito
*
* Lab Session : Mon/Wed 2pm
*
* Lab TA : TJ Stein
*
* Last Revised : February 19, 2015
*
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		
		System.out.println("Please enter the number of pegs you'd like to play with: ");
		int pegs = reader.nextInt();
		System.out.println("Please enter the number of colors you'd like to play with: ");
		int colors = reader.nextInt();
		
		ArrayList<String> colorList = new ArrayList<String>();
		
		for(int i=0; i<colors; i++){
			System.out.println("Enter Color: ");
			colorList.add(reader.next());
		}
		
		CodeBreaker mastermind = new CodeBreaker(pegs, colors, colorList);
		
		while(!mastermind.correct){
			mastermind.makeNextGuess();
			
			System.out.println("Enter Amount Correct Position and Color: ");
			int correctPositionColor = reader.nextInt();
			System.out.println("Enter Amount Correct Color: ");
			int correctColor = reader.nextInt();
			mastermind.input(correctPositionColor, correctColor);
		}
		
		if(mastermind.correct) {
			System.out.println("The computer has beat you!");
			System.out.println("Play again?");
			String answer=reader.next();
			if(answer.equalsIgnoreCase("yes")) {
				System.out.println();
				restart();
			}
			/*else
			{
				System.out.println();
			} */
		}
		reader.close();
	}
	
	public static void restart() {
		Scanner reader=new Scanner(System.in);
		System.out.println("Please enter the number of pegs you'd like to play with: ");
		int pegs = reader.nextInt();
		System.out.println("Please enter the number of colors you'd like to play with: ");
		int colors = reader.nextInt();
		
		ArrayList<String> colorList = new ArrayList<String>();
		
		for(int i=0; i<colors; i++) {
			System.out.println("Enter Color: ");
			colorList.add(reader.next());
		}
		
		CodeBreaker mastermind = new CodeBreaker(pegs, colors, colorList);
		
		while(!mastermind.correct) {
			mastermind.makeNextGuess();
			
			System.out.println("Enter Amount Correct Position and Color: ");
			int correctPositionColor = reader.nextInt();
			System.out.println("Enter Amount Correct Color: ");
			int correctColor = reader.nextInt();
			mastermind.input(correctPositionColor, correctColor);
		}
		
		if(mastermind.correct) {
			System.out.println("The computer has beat you!");
			System.out.println("Play again?");
			System.out.println();
		}
		reader.close();
	}

}
