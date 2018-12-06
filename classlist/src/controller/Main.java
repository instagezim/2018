package controller;

import java.io.File;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Student;
import model.XmlHandler;

public class Main extends Application {

	private Stage primaryStage;

	private ObservableList<Student> studentData = FXCollections.observableArrayList();

	public Main() { // das weiss VIEW noch nicht, also nicht ersichtlich, jetzt
					// muss im mainwindowcontroller noch .... gemacht werden
		studentData.add(new Student("MNR1", "Brun", "Marcel", "Stirnrütistrasse 1", "6048", "Horw", "0791110101",
				"brun.marcel@teko.ch"));
		studentData.add(new Student("MNR2", "Gjoklaj", "Gezim", "Büntentrasse 2", "6232", "Geuensee", "0792220202",
				"gjoklaj.gezim@teko.ch"));
		studentData.add(new Student("MNR3", "Grüter", "Julien", "Zückestrasse 3", "6017", "Ruswil", "0793330303",
				"grueter.julien@teko.ch"));
		studentData.add(new Student("MNR4", "Grütter", "Nicola", "Einschlagstrasse 4", "4622", "Egerkingen",
				"0794440404", "gruetter.nicola@teko.ch"));
		studentData.add(new Student("MNR5", "Heer", "Daniel", "Stirnrütistrasse 5", "5036", "Oberentfelden",
				"0795550505", "heer.daniel@teko.ch"));
		studentData.add(new Student("MNR6", "Krause", "Alexander", "Bergstrasse 46", "79539", "Lörrach", "0796660606",
				"krause.alexander@teko.ch"));
		studentData.add(new Student("MNR7", "Lehmann", "Thomas", "Hardstrasse 15", "4656", "Starrkirch-Wil",
				"0797770707", "lehmann.thomas@teko.ch"));
		studentData.add(new Student("MNR8", "Leienbach", "Nikole", "Speisestrasse 4", "4600", "Olten", "0798880808",
				"leienbach.nikole@teko.ch"));
		studentData.add(new Student("MNR9", "Misteli", "Jens", "Mittelgäustrasse 1", "4613", "Rickenbach", "0799990909",
				"misteli.jens@teko.ch"));
		studentData.add(new Student("MNR10", "Moser", "Patrick", "Wynenfeldweg 14", "5033", "Buchs", "0791011010",
				"moser.patick@teko.ch"));
		studentData.add(new Student("MNR11", "Probst", "Sandra", "Haupstrasse 11", "4600", "Olten", "0791111111",
				"probst.sandra@teko.ch"));
		studentData.add(new Student("MNR12", "Schürch", "Remo", "Eichstrasse 17", "6330", "Cham", "0791211212",
				"schuerch.remo@teko.ch"));
		studentData.add(new Student("MNR13", "Ün", "Petrus", "Bannstrasse 10", "4632", "Trimbach", "0791311313",
				"uen.petrus@teko.ch"));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		welcomeWindow(); // beim start wird das welcomewindow aufgebaut
	}

	public void welcomeWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/WelcomeView.fxml"));
			AnchorPane pane = loader.load(); // das erste ist AnchorPane, das
												// wird jetzt geladen!
			Scene scene = new Scene(pane); // eine szene wird gebaut!
			Stage stage = new Stage();

			scene.getStylesheets().add("view/style.css"); // CSS einbindung!

			WelcomeController controller = loader.getController();
			controller.setMain(this); // eigenes objekt geben!
			controller.setStage(stage);

			primaryStage.setTitle("Willkommen");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mainWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/MainWindowView.fxml"));
			AnchorPane pane = loader.load(); // das erste ist AnchorPane, das
												// wird jetzt geladen!
			Scene scene = new Scene(pane); // eine szene wird gebaut!
			Stage stage = new Stage();

			MainWindowController controller = loader.getController();
			controller.setMain(this); // eigenes objekt geben!
			controller.setStage(stage);
			controller.setStudentData(studentData);

			primaryStage.setTitle("Klassenliste");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void newStudentWindow() {
		newStudentWindow(null); // führt die methode aus, ohne Person/Objekt im
								// übergabeparameter
	}

	public boolean newStudentWindow(Student student) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/NewStudentView.fxml"));
			AnchorPane pane = loader.load(); // das erste ist AnchorPane, das
												// wird jetzt geladen!
			Scene scene = new Scene(pane); // eine szene wird gebaut!
			Stage stage = new Stage();

			NewStudentController controller = loader.getController();
			controller.setMain(this); // eigenes objekt geben!
			controller.setStage(stage);
			controller.setStudent(student);

			// zweites fenster
			stage.setTitle("Neuer Student");
			stage.setScene(scene);
			stage.setResizable(false); // dass das Resizing blockiert wird!
			stage.showAndWait(); // erst jetzt kann es geöffnet werden (jetzt
									// wird es angezeigt!)

			return controller.isOkClicked();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		launch(args);
	}

	public ObservableList<Student> getStudentData() {
		return studentData;
	}

	public void saveStudenten() {
		XmlHandler.marshall(studentData, new File("studenten.xml"));
	}

	public void readStudenten() {
		studentData = XmlHandler.unmarshall(new File("studenten.xml"));
	}

}
