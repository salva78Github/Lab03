package it.polito.tdp.spellchecker.controller.model;

import java.util.LinkedList;
import java.util.List;

public class DictionaryWithDicotomicaSearch extends Dictionary{
	private List<String> dictionary = new LinkedList<String>();

	@Override
	protected void addWord(String word) {
		// TODO Auto-generated method stub
		this.dictionary.add(word);
	}



	@Override
	protected boolean checkWord(String inputWord) {
		// TODO Auto-generated method stub
		int sizeDictionary = this.dictionary.size();
		System.out.println("<checkWord> sizeDictionary: " + sizeDictionary); 
		System.out.println("<checkWord> inputWord: " + inputWord); 
		
		int step = 0;
		int startIndex = 0;
		int endIndex = sizeDictionary;
		int index;
		while((endIndex-startIndex)!=1){
//			System.out.println("<checkWord> startIndex: " + startIndex); 
//			System.out.println("<checkWord> endIndex: " + endIndex); 
			index = (endIndex + startIndex)/2;
//			System.out.println("<checkWord> index: " + index); 
//			System.out.println("<checkWord> this.dictionary.get(index): " + this.dictionary.get(index).toLowerCase()); 
			step++;
//			System.out.println("<checkWord> step: " + step); 
			int resultCompare = this.dictionary.get(index).toLowerCase().compareTo(inputWord);
//			System.out.println("<checkWord> resultCompare: " + resultCompare); 
			if(resultCompare==0){
				return true;
			}
			else if(resultCompare<0){
				startIndex = index;
			}
			else{
				endIndex=index;
			}
		}
		return false;
	}


}
