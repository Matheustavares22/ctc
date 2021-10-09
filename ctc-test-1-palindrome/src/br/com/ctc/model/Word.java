package br.com.ctc.model;

import br.com.ctc.constants.Strings;

public class Word {

	private String letters;

	public Word(String letters) {
		this.letters = letters;
	}
	
	public String getLetters() {
		return letters;
	}

	public void setLetters(String letters) {
		this.letters = letters;
	}
		
	public String getLettersInverseOrder (){
		// turns the word into a byte array
        byte[] lettersAsByteArray = this.letters.getBytes();
        byte[] result = new byte[lettersAsByteArray.length];
 
        // reverse letters
        for (int i = 0; i < lettersAsByteArray.length; i++) {
            result[i] = lettersAsByteArray[lettersAsByteArray.length - i - 1];
        }
        return new String(result);
	}
	
	public void setLettersToLowerCase() {
		letters = letters.toLowerCase();
	}
	
	public void removeSpaces() {
		letters = letters.replace(" ", "");
	}
	
	@Override
	public String toString() {		
		return String.format("%s: %s \n%s: %s",
	    		Strings.NORMAL_WORD,
	    		getLetters(),
	    		Strings.INVERSE_WORD,
	    		getLettersInverseOrder());
		
	}
	
}
