package br.com.ctc.main;

import java.util.Scanner;
import br.com.ctc.constants.Strings;
import br.com.ctc.model.Word;

/* 
	created by Matheus Tavares
 */

public class Main {
 
	private static Scanner input[] = {
			new Scanner(System.in),
			new Scanner(System.in),
			new Scanner(System.in)};
	private static Word word;
	
	public static void main(String[] args) {				
	    allInputs();	    
	    finalOut();
	}

	private static void allInputs() {		
		System.out.println(Strings.QUESTION_1);
		word = new Word(input[0].nextLine());
		
	    System.out.println(Strings.QUESTION_2);	    
	    if(input[1].nextLine().toUpperCase().equals(Strings.ANSWER_NO)) {
	    	word.setLettersToLowerCase();
	    }	
	    
	    System.out.println(Strings.QUESTION_3);	    
	    if(!input[2].nextLine().toUpperCase().equals(Strings.ANSWER_NO)) {
	    	word.removeSpaces();
	    }	
	    
	    closeScanners();
	}

	private static void closeScanners() {
		input[0].close();
	    input[1].close();
	    input[2].close();
	}
	
	private static void finalOut() {
		if(checkWordPalindrome(word.getLetters())) {
	    	System.out.println(Strings.FINAL_ANSWER_TRUE);
	    } else {
	    	System.out.println(Strings.FINAL_ANSWER_FALSE);
	    }	    
	    System.out.println(word);
	}
	
	private static boolean checkWordPalindrome(String letters) {		
		if(letters.equals(word.getLettersInverseOrder())) {
			return true;
		}
		return false;
	}
	

}
