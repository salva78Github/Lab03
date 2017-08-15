package it.polito.tdp.spellchecker.controller.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
	private List<String> dictionary = new ArrayList<String>();
	
	/**
	 * carica il dizionario da file 
	 * 
	 * @param language
	 */
	public void loadDictionary(String language) {

		try {
			FileReader fr = new FileReader(Language.resolveLanguage(language).getFilePath());
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				// Aggiungere parola alla struttura dati
				dictionary.add(word);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file");
		}
	}

	/*
	 *  Metodo che esegue il controllo ortografico su testo di input (rapopresentato da una lista di parole), e 
	 * restituisce una lista di RichWord. Per ogni parola di inputTextList, tale metodo controlla se essa è presente nel dizionario. 
	 * In caso affermativo, la RichWord corrispondente, che dovrà essere creata e aggiunta alla lista di ritorno, sarà corretta, altrimenti sarà errata.  

	 */
	public List<RichWord> spellCheckText(List<String> inputTextList) {
		List<RichWord> richWords = new ArrayList<RichWord>();
		for(String inputWord : inputTextList){
			boolean isCorrect = this.dictionary.contains(inputWord);
			RichWord rw = new RichWord(inputWord);
			rw.setCorrect(isCorrect);
			richWords.add(rw);
		}
		
		return richWords;
	}
	 
	
	enum Language {
		ITALIAN("it","rsc/Italian.txt"), 
		ENGLISH("en", "rsc/English.txt");

		private String code;
		private String filePath;

		Language(String code, String filePath) {
			this.code = code;
			this.filePath = filePath;
		}

		String getCode(){
			return this.code;
		}

		String getFilePath(){
			return this.filePath;
		}
		
		static Language resolveLanguage(String code){
			for(Language l : Language.values()){
				if(l.getCode().equals(code)){
					return l;
				}
			}
			throw new IllegalArgumentException("Language not valid!");
		}
		
	}
}
