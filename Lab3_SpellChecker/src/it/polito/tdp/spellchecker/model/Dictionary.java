package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dictionary {

	final static boolean dicotomica = false;
	
	protected List<String> dizionario;

	public Dictionary() {
		dizionario = new LinkedList<String>();
	}

	public void loadDictionary(String language) {
		try {
			
			FileReader fr = new FileReader("rsc/" + language + ".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			
			while ((word = br.readLine()) != null) {
				// Aggiungo word alla struttura dati.
				dizionario.add(word.toLowerCase());
			}
			
			// Ordino il dizionario (per la ricerca dicotomica)
			Collections.sort(dizionario);
			
			br.close();
			
		} catch (IOException e) {
			
			System.out.println("Errore nella lettura del file");
		}
		
	};

	public List<RichWord> spellCheckText(List<String> inputTextList) {
		
		List<RichWord> parole = new LinkedList<RichWord>();
		
		RichWord r;
		for (String s : inputTextList) {
			
			if (dicotomica) {
				if (binarySearch(s.toLowerCase())) 
					r = new RichWord(s, true);
				else 
					r = new RichWord(s, false);
				parole.add(r);
				
			} else {
				if (dizionario.contains(s.toLowerCase())) 
					r = new RichWord(s, true);
				else 
					r = new RichWord(s, false);
				parole.add(r);
			}
		}
		return parole;
	}
	     
	
	
	/*
	 * Metodo che implementa la ricerca dicotomica
	 */
	private boolean binarySearch(String stemp) {
		
		int inizio = 0;
	     int fine = dizionario.size();

	     while (inizio!=fine){
	         int medio = inizio + (fine - inizio)/2;
	         if (stemp.compareToIgnoreCase(dizionario.get(medio))==0){
	             return true;
	         } else if (stemp.compareToIgnoreCase(dizionario.get(medio))>0){
	               inizio=medio +1;
	           } else {
	               fine=medio;
	           }
	     }
		
		return false;
	}
	
}
