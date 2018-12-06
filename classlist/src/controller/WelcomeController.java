package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class WelcomeController {

	@FXML
	private TextField usernameField;
	@FXML
	private TextField passwordField;

	private Main main;
	private Stage stage;

	public void setMain(Main main) {
		this.main = main;
		passwordField.setOnKeyPressed(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				KeyEvent keyEvent = (KeyEvent) event;
				if (keyEvent.getCode().equals(KeyCode.ENTER)) {
					doLogin();
				}
			}
		});
	}

	public void loginButton(ActionEvent event) {
		doLogin();
	}

	private void doLogin() {
		if (usernameField.getText().equals("graziano") && passwordField.getText().equals("anti-zöpfe")) {
			main.mainWindow();// methode zum stage wechseln bzw. mainwindows
								// öffnen
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Login fehlgeschlagen!");
			alert.setContentText("Ungültiger Benutzername oder Passwort! Bitte versuchen Sie es erneut.");
			alert.showAndWait();
		}
		usernameField.clear();
		passwordField.clear();
	}

	@FXML
	public void handleKeyPressed(KeyEvent ke) {
		if (ke.getCode().equals(KeyCode.ENTER)) {
			doLogin();
		}
	}

	public void exitButton() {
		System.exit(0);
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

}