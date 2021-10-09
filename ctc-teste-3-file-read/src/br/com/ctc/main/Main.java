package br.com.ctc.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import br.com.ctc.constants.Strings;

/* 
code created by Matheus Tavares
*/

public class Main {
	public static void main(String[] args) throws IOException {
		long initialTime = System.currentTimeMillis();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Strings.FILE_NAME));        
		generateTextFile(bufferedWriter);        
		
        BufferedReader bufferedReader = openBufferedReader();
		
		ArrayList<Integer> phraseUses = getPhraseUses(bufferedReader);		
		bufferedReader.close();        
		
		 
		for (int i = 0; i < phraseUses.size(); i++) {
			System.out.println(phraseUses.get(i) + Strings.FINAL_INFORMATION + Strings.PHRASE[i]);
		}
		
		//System.out.println(Strings.FINAL_INFORMATION + "\nCom a seguinte quantidade de usos: ");
		
        long fim = System.currentTimeMillis();
        System.out.println(timePassed(initialTime, fim) + Strings.TIME_INFORMATION);
	}

	private static BufferedReader openBufferedReader() throws FileNotFoundException {
		InputStream fileInputStream = new FileInputStream(Strings.FILE_NAME);
		Reader inputStreamReader = new InputStreamReader(fileInputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		return bufferedReader;
	}
	
	private static void generateTextFile(BufferedWriter bw) throws IOException {
		// here the text file will be generated
        // I used 100000 to not create a very heavy file
        for(Long i = 0L; i < 100000; i++) {
        	bw.write(Strings.PHRASE[0] + "|");	        bw.newLine();
        	bw.write(Strings.PHRASE[1] + "|");	        bw.newLine();
        	bw.write(Strings.PHRASE[2] + "|");	        bw.newLine();
        	bw.write(Strings.PHRASE[3] + "|");	        bw.newLine();
        	bw.write(Strings.PHRASE[0] + "|");	        bw.newLine();
        	bw.write(Strings.PHRASE[4] + "|");	        bw.newLine();
        	bw.write(Strings.PHRASE[5] + "|");	        bw.newLine();
        }
        bw.close();
	}
	
	private static long timePassed(long initialTime, long fim) {
		return ((fim - initialTime) / 1000) % 60;
	}
 
	private static ArrayList<Integer> getPhraseUses(BufferedReader bufferedReader) throws IOException {
		ArrayList<Integer> phraseUses = new ArrayList<>();
		for(int i = 0; i <6; i++) {
			phraseUses.add(0);
		}
		
		String linha = "";		
		while(linha != null) {
			linha = bufferedReader.readLine();
			if(linha != null) {
				Integer pipeIndex = linha.lastIndexOf("|");			
				String frase = linha.substring(0,pipeIndex);
				if(frase.equals(Strings.PHRASE[0])){
					phraseUses.set(0, phraseUses.get(0) + 1);
				}else if(frase.equals(Strings.PHRASE[1])){
					phraseUses.set(1, phraseUses.get(1) + 1);
				}else if(frase.equals(Strings.PHRASE[2])){
					phraseUses.set(2, phraseUses.get(2) + 1);
				}else if(frase.equals(Strings.PHRASE[3])){
					phraseUses.set(3, phraseUses.get(3) + 1);
				}else if(frase.equals(Strings.PHRASE[4])){
					phraseUses.set(4, phraseUses.get(4) + 1);
				}else if(frase.equals(Strings.PHRASE[5])){
					phraseUses.set(5 , phraseUses.get(5) + 1);									
				}
			}
		}
		return phraseUses;
	}
}
