package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Student;

public class NewStudentController {

	@FXML
	TextField matrikelnummerField, nachnameField, vornameField, adresseField, plzField, ortField, telefonField,
			mailField;

	private Stage stage;
	private Main main;
	private Student student;
	private boolean okClicked = false;

	public void setStudent(Student student) {
		this.student = student;
		if (student != null) { // wenn wirklich eine person dahinter ist, dann
								// übernimmt er alle textfelder von der
								// ausgewählten person.
			fillStudentDetails();
		}
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void handleCancel() {
		stage.close();
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	public void handleOkey() {

		List<String> zahlenfelder = new ArrayList<>();
		zahlenfelder.add(plzField.getText());
		zahlenfelder.add(telefonField.getText());

		List<String> fehlerhafteFelder = new ArrayList<>();
		for (String feld : zahlenfelder) {
			if (!validiereZahl(feld)) {
				fehlerhafteFelder.add(feld);
			}
		}

		List<String> mussFelder = new ArrayList<>();
		mussFelder.add(matrikelnummerField.getText());
		mussFelder.add(nachnameField.getText());
		mussFelder.add(vornameField.getText());
		mussFelder.add(adresseField.getText());
		mussFelder.add(plzField.getText());
		mussFelder.add(ortField.getText());
		mussFelder.add(telefonField.getText());
		mussFelder.add(mailField.getText());

		List<String> fehlerhafteMussFelder = new ArrayList<>();
		for (String feld : mussFelder) {
			if (feld.isEmpty()) {
				fehlerhafteMussFelder.add(feld);
			}
		}

		if (!fehlerhafteMussFelder.isEmpty()) {
			String fehlerTextMuss = "Foldende Felder müssen noch gesetzt werden: \n\n";

			if (matrikelnummerField.getText().isEmpty()) {
				fehlerTextMuss = fehlerTextMuss + "Matrikelnummer\n";
			}
			if (nachnameField.getText().isEmpty()) {
				fehlerTextMuss = fehlerTextMuss + "Nachname\n";
			}
			if (vornameField.getText().isEmpty()) {
				fehlerTextMuss = fehlerTextMuss + "Vorname\n";
			}
			if (adresseField.getText().isEmpty()) {
				fehlerTextMuss = fehlerTextMuss + "Adresse\n";
			}
			if (plzField.getText().isEmpty()) {
				fehlerTextMuss = fehlerTextMuss + "PLZ\n";
			}
			if (ortField.getText().isEmpty()) {
				fehlerTextMuss = fehlerTextMuss + "Ort\n";
			}
			if (telefonField.getText().isEmpty()) {
				fehlerTextMuss = fehlerTextMuss + "Telefon\n";
			}
			if (mailField.getText().isEmpty()) {
				fehlerTextMuss = fehlerTextMuss + "Mail";
			}
			fehlerhafteFelder(fehlerTextMuss);
		} else if (!fehlerhafteFelder.isEmpty()) {
			String fehlerTextZahl = "Folgende Felder müssen eine Ganzzahl sein: \n";

			if (!plzField.getText().matches("\\d+")) { // Ganzzahlen
				fehlerTextZahl = fehlerTextZahl + "PLZ " + "\n";
			}
			if (!telefonField.getText().matches("\\d+")) { // Ganzzahlen
				fehlerTextZahl = fehlerTextZahl + "Telefon " + "\n";
			}

			fehlerhafteFelder(fehlerTextZahl);

		} else {

			if (student != null) { // wenns die person gibt, passt er die werte
									// an
									// (überschreibt nur)
				student.setMatrikelnummer(matrikelnummerField.getText());
				student.setNachname(nachnameField.getText());
				student.setVorname(vornameField.getText());
				student.setAdresse(adresseField.getText());
				student.setPlz(plzField.getText());
				student.setOrt(ortField.getText());
				student.setTelefon(telefonField.getText());
				student.setMail(mailField.getText());
			} else {
				Student student = new Student(matrikelnummerField.getText(), // wenns
																				// die
																				// person
																				// nicht
																				// gibt,
																				// dann
																				// wird
																				// hier
																				// eine
																				// erstellt.
						nachnameField.getText(), vornameField.getText(), adresseField.getText(), plzField.getText(),
						ortField.getText(), telefonField.getText(), mailField.getText());
				main.getStudentData().add(student);
			}
			okClicked = true;
			main.saveStudenten();
			stage.close();
		}
	}

	public void fillStudentDetails() {
		matrikelnummerField.setText(student.getMatrikelnummer());
		nachnameField.setText(student.getNachname());
		vornameField.setText(student.getVorname());
		adresseField.setText(student.getAdresse());
		plzField.setText(student.getPlz());
		ortField.setText(student.getOrt());
		telefonField.setText(student.getTelefon());
		mailField.setText(student.getMail());
	}

	private boolean validiereZahl(String feld) {
		try {
			Integer.valueOf(feld);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private void fehlerhafteFelder(String fehlerText) {
		Alert alert = new Alert(AlertType.ERROR);
		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());
		dialogPane.getStyleClass().add("context-menu");
		alert.setTitle("Fehler");
		alert.setHeaderText("");
		alert.setContentText(fehlerText);
		alert.showAndWait();
	}

}
