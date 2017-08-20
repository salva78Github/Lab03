package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.controller.model.DictionaryWithSimpleSearch;
import it.polito.tdp.spellchecker.controller.model.RichWord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController implements Initializable{

	@FXML
	private ComboBox<String> idCBLanguage;

	@FXML
	private TextArea idTAWords;

	@FXML
	private Button idBSpellCheck;

	@FXML
	private TextArea idTAWrongWords;

	@FXML
	private Label idLWrongWordsNumber;

	@FXML
	private Button idBClearText;

	@FXML
	private Label idLTimeExecution;


	   
	
	@FXML
	void doClearText(ActionEvent event) {
		idTAWords.setText("");
		idTAWrongWords.setText("");
	}

	@FXML
	void doSpellCheck(ActionEvent event) {
		String language = idCBLanguage.getSelectionModel().getSelectedItem();
		System.out.println("<doSpellCheck> selected Language: " + language);
		DictionaryWithSimpleSearch dictionaryInstance = new DictionaryWithSimpleSearch();
		//DictionaryWithDicotomicaSearch dictionaryInstance = new DictionaryWithDicotomicaSearch();
		dictionaryInstance.loadDictionary(language);
		
		Long startTime = System.nanoTime(); 
		String input = idTAWords.getText();
		System.out.println("<doSpellCheck> input: " + input);
		String filteredInput = input.toLowerCase().replaceAll("[\\p{Punct}]", "");
		System.out.println("<doSpellCheck> filteredInput: " + filteredInput);
		
		String[] words = filteredInput.split(" ");
		List<String> wordsList = Arrays.asList(words);
		List<RichWord> rwList = dictionaryInstance.spellCheckText(wordsList);
		
		StringBuffer sbWrongWords = new StringBuffer();
		int errorCounter = 0;
		for(RichWord rw : rwList){
			System.out.println("<doSpellCheck> word: " + rw);
			if(!rw.isCorrect()){
				sbWrongWords.append(rw.getWord()).append("\n");
				errorCounter++;
			}
		}	
		Long endTime = System.nanoTime(); 
		
		idTAWrongWords.setText(sbWrongWords.toString());
		idLWrongWordsNumber.setText("The Text contains " + errorCounter + " errors");
		idLTimeExecution.setText("Spell check completed in " + (endTime-startTime)/1e9 + " seconds.");
		
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<String> list = new ArrayList<String>();
        list.add("English");
        list.add("Italian");
        ObservableList<String> obList = FXCollections.observableList(list);
        idCBLanguage.getItems().clear();
        idCBLanguage.setItems(obList);
	}

}
