package br.com.ctc.main;
/* 
 created by Matheus Tavares
*/

import java.util.ArrayList;
import java.util.Scanner;

import br.com.ctc.constants.Strings;

public class Main {
	
	private static Integer targetNumber = 0;
	private static Long maxListDigit = 1L;
	private static ArrayList<Long> numbers = new ArrayList<Long>();
	private static Scanner input[] = {
			new Scanner(System.in),
			new Scanner(System.in)};
	
	public static void main(String[] args) {						
		allInputs();
		initializeNumberArray();
		finalOut();
	}

	private static void finalOut() {
		if(targetNumber > maxListDigit) {
			return;
		}
		
		ArrayList<String> finalOutput = new ArrayList<String>(complementaryPairs(numbers, targetNumber));
		finalOutput.forEach((i) -> System.out.println(i));
		System.out.println(Strings.INFORMATION_3 + targetNumber);
	}
	
	private static void initializeNumberArray() {		
		for(Long i = 1L; i <= maxListDigit; i++) {
			numbers.add((long) i);			
		}		
	}
	
	private static void allInputs() {	
		System.out.println(Strings.INFORMATION_1);
		maxListDigit = (long) input[0].nextLong();
		
		System.out.println(Strings.INFORMATION_2);
		targetNumber = input[1].nextInt();			
		
		closeScanners();
	}

	private static void closeScanners() {
		input[0].close();
		input[1].close();
	}	
	
	private static ArrayList<String> complementaryPairs (ArrayList<Long> numbers, Integer targerNumber) {
		ArrayList<String> numbersReturned = new ArrayList<String>();
		
		for(int i = 0; i < numbers.size(); i++) {
			for(int k = i; k < numbers.size(); k++) {
				Integer value = (int) (numbers.get(i) + numbers.get(k));
				if(value.equals(targerNumber)) {
					numbersReturned.add(numbers.get(i) + ", " + numbers.get(k));
				}
			}
		}							
		return numbersReturned;
	}

}
