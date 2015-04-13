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

import java.util.ArrayList;

public class CodeBreaker {
	
	public int pegs, numColors;
	public ArrayList<String> colors;
	public boolean correct;
	public ArrayList<Choice> choiceList;
	public Choice guess;
	public int correctPositionColor, correctColor;
	
	public CodeBreaker(int pegs, int numColors, ArrayList<String> colors) {
		this.pegs = pegs;
		this.numColors = numColors;
		this.colors = colors;
		correct = false;
		
		choiceList = new ArrayList<Choice>();
		
		for(int i=0; i<Math.pow(numColors, pegs); i++){
			choiceList.add(new Choice(pegs));
		}
		generateChoices(0);
	}
	
	public void generateChoices(int column) {
		if(column >= pegs)
			return;
		int exp = pegs - column - 1;
		int repeats = (int) Math.round(Math.pow((double) numColors , (double) exp));
		int counter = 0;
		while(counter < Math.pow(numColors, pegs)){
			for(int i = 0; i < numColors; i++){
				for(int k = 0; k < repeats; k++){
					
					choiceList.get(counter).code[column] = i;
					counter++;
				}
			}
		}
		generateChoices(column + 1);
	}
	
	public void makeNextGuess() {
		//Make Random Guess out of remaining
		//Print as Color String
		if(choiceList.size() == 0)
			return;
		this.guess = choiceList.get(choiceList.size()-1);
		guessToOutput(guess);
	}
	
	public void updateList(){
		
		for(int i=0; i<choiceList.size(); i++){
			//MATCH & REMOVE
			if(!((guess.match(choiceList.get(i).code)[0] == correctPositionColor) && 
					(guess.match(choiceList.get(i).code)[1] == correctColor))) {
				choiceList.remove(i);
				i--;
			}
		}
		System.out.println(choiceList.size());
	}

	public void input(int correctPositionColor, int correctColor) {
		if(correctPositionColor == pegs){
			correct = true;
		}
		else{
			this.correctPositionColor = correctPositionColor;
			this.correctColor = correctColor;
			updateList();
		}
	}
	
	public void guessToOutput(Choice choice) {
		
		System.out.println("------- CODE --------");
		System.out.print("{");
		for(int i=0; i < pegs; i++){
			//System.out.print(choice.code[i]);
			System.out.print(colors.get(guess.code[i]) + " ");
		}
		System.out.println("}");
	}
	
	public void printList() {
		System.out.println( choiceList.size());
	}
}
