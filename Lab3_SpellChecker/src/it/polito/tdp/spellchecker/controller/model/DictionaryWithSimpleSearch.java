package it.polito.tdp.spellchecker.controller.model;

import java.util.ArrayList;
import java.util.List;

public class DictionaryWithSimpleSearch extends Dictionary{
	private List<String> dictionary = new ArrayList<String>();
	

	 
	


	@Override
	protected void addWord(String word) {
		// TODO Auto-generated method stub
		dictionary.add(word);
		
	}






	@Override
	protected boolean checkWord(String inputWord) {
		// TODO Auto-generated method stub
		boolean isCorrect = this.dictionary.contains(inputWord);
		return isCorrect;
	}
}
