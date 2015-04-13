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

public class Choice {
	
	public int code[];
	
	public Choice(int pegs) {
		this.code = new int[pegs];
	}
	
	public int[] match(int[] code2) {
		int[] temp = new int[2];
		temp[0] = 0;
		temp[1] = 0;
		
		boolean[] match1 = new boolean[code.length];
		boolean[] match2 = new boolean[code2.length];

		for(int i=0; i<code.length; i++) {
			for(int j=0; j<code2.length; j++) {
				if(code[i] == code2[j] && i==j) {
					if(match1[i] == false && match2[j] == false) {
						match1[i] = true;
						match2[j] = true;
						temp[0]++;
					}
				}
			}
		}
		
		for(int i=0; i<code.length; i++) {
			for(int j=0; j<code2.length; j++) {
				if(code[i] == code2[j] && i!=j) {
					if(match1[i] == false && match2[j] == false) {
						match1[i] = true;
						match2[j] = true;
						temp[1]++;
					}
				}
			}
		}
		return temp;
	}
}
	
