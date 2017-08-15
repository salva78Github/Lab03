package it.polito.tdp.spellchecker.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {

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

	}

	@FXML
	void doSpellCheck(ActionEvent event) {

	}

}
