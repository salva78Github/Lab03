package it.polito.tdp.spellchecker.controller.model;

public class DictionaryWithDicotomicaSearch extends Dictionary{



	@Override
	protected boolean checkWord(String inputWord) {
		// TODO Auto-generated method stub
		int sizeDictionary = dictionary.size();
		System.out.println("<checkWord> sizeDictionary: " + sizeDictionary); 
		System.out.println("<checkWord> inputWord: " + inputWord); 
		
		int step = 0;
		int startIndex = 0;
		int endIndex = sizeDictionary;
		int medio;
		while(endIndex!=startIndex){
//			System.out.println("<checkWord> startIndex: " + startIndex); 
//			System.out.println("<checkWord> endIndex: " + endIndex); 
			medio = startIndex + (endIndex - startIndex)/2;
//			System.out.println("<checkWord> index: " + index); 
//			System.out.println("<checkWord> this.dictionary.get(index): " + this.dictionary.get(index).toLowerCase()); 
			step++;
//			System.out.println("<checkWord> step: " + step); 
			int resultCompare = dictionary.get(medio).toLowerCase().compareTo(inputWord);
//			System.out.println("<checkWord> resultCompare: " + resultCompare); 
			if(resultCompare==0){
				return true;
			}
			else if(resultCompare<0){
				startIndex = medio+1;
			}
			else{
				endIndex=medio;
			}
		}
		return false;
	}


}
