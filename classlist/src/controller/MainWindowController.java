package controller;

import java.util.Observable;
import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Student;

public class MainWindowController {
	@FXML
	TableView<Student> tableView;
	@FXML
	TableColumn<String, Student> matrikelnummerColumn;
	@FXML
	TableColumn<String, Student> vornameColumn;
	@FXML
	TableColumn<String, Student> nachnameColumn;
	@FXML
	Label matrikelnummerLabel, nachnameLabel, vornameLabel, adresseLabel, plzLabel, ortLabel, telefonLabel, mailLabel;

	private Main main;
	private Stage stage;

	public void showDetails(Student student) {
		if (student != null) {
			matrikelnummerLabel.setText(student.getMatrikelnummer());
			nachnameLabel.setText(student.getNachname());
			vornameLabel.setText(student.getVorname());
			adresseLabel.setText(student.getAdresse());
			plzLabel.setText(student.getPlz());
			ortLabel.setText(student.getOrt());
			telefonLabel.setText(student.getTelefon());
			mailLabel.setText(student.getMail());
		}
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public void initialize() {
		// diese methode braucht man um das mapping model->view zu erstellen.
		// diese methode muss initialize heissen!

		matrikelnummerColumn.setCellValueFactory(new PropertyValueFactory<>("matrikelnummer"));
		nachnameColumn.setCellValueFactory(new PropertyValueFactory<>("nachname")); // pro
																					// oben
																					// verknüpfte
																					// zeile
																					// wird
																					// hier
																					// dies
																					// gesetzt!!
																					// jede
																					// einzeln!
		vornameColumn.setCellValueFactory(new PropertyValueFactory<>("vorname"));
		tableView.getSelectionModel().selectedItemProperty()
				.addListener((observables, oldValue, newValue) -> showDetails(newValue)); // das
																							// zubeobachtende
																							// objekt
																							// wird
																							// bewacht
																							// und
																							// dann
																							// wird
																							// der
																							// alte
																							// wert
																							// vom
																							// vorherigen
																							// zum
																							// neuen
																							// wert
																							// überschrieben!
	}

	public void handleNew() {
		main.newStudentWindow();
	}

	public void handleEdit() {
		if (tableView.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("");
			alert.setContentText("Sie haben kein Studenten angewählt. Bitte wählen Sie den gewünschten Student aus.");
			alert.show();
		} else {

			Student student = tableView.getSelectionModel().getSelectedItem();
			boolean okClicked = main.newStudentWindow(student);
			if (okClicked) {
				refreshTableView();
				showDetails(student);
			}
			main.saveStudenten();
		}
	}

	public void refreshTableView() {
		tableView.setItems(null); // alles löschen
		tableView.layout(); // neu zeichnen ohne elemente/inhalt
		tableView.setItems(main.getStudentData());
	}

	public void handleDelete() {
		if (tableView.getSelectionModel().getSelectedItem() == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("");
			alert.setContentText("Sie haben kein Studenten angewählt. Bitte wählen Sie den gewünschten Student aus.");
			alert.show();
		} else {

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Student löschen");
			alert.setHeaderText("Bestätigung");
			alert.setContentText("Wollen den Student wirklich löschen?");

			Optional<ButtonType> result = alert.showAndWait();
			// grafisch: result ist die variable vom OK oder Cancel Button!

			if (result.get() == ButtonType.OK) {
				int index = tableView.getSelectionModel().getSelectedIndex(); // welches
																				// ist
																				// angewählt?
				main.getStudentData().remove(index);
				main.saveStudenten();
			} else {

			}
		}
	}

	public void handleLogout() {
		stage.close();
		main.welcomeWindow();
	}

	public void handleSave() {
		main.saveStudenten();
	}

	public void setStudentData(ObservableList<Student> studentData) { // die
																		// ganzen
																		// personen
																		// sollen
																		// in
																		// der
																		// tabelle
																		// angezeigt
																		// werden!
		tableView.setItems(studentData);
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

}
