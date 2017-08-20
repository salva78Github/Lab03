package it.polito.tdp.spellchecker.controller.model;

public class DictionaryWithSimpleSearch extends Dictionary{
	

	 






	@Override
	protected boolean checkWord(String inputWord) {
		// TODO Auto-generated method stub
		boolean isCorrect = dictionary.contains(inputWord);
		return isCorrect;
	}
}
