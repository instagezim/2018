package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javafx.collections.ObservableList;

public class XmlHandler {

	// Static = klassengebunden, und dann muss nicht NEW xmlhandler geschrieben
	// werden!
	public static void marshall(ObservableList<Student> studentData, File datei) {

		JAXBContext context;
		BufferedWriter writer;

		try {
			writer = new BufferedWriter(new FileWriter(datei));

			// Mitteilen des obersten XML-Elements
			context = JAXBContext.newInstance(Studenten.class);

			Marshaller m = context.createMarshaller();

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			m.marshal(new Studenten(studentData), writer);

			writer.close();

		} catch (Exception e) {
			System.err.println("Upsss, irgendetwas ist beim Schreiben des XML-Files schief gelaufen.");
		}
	}

	public static ObservableList<Student> unmarshall(File datei) {

		Studenten studentData = new Studenten();

		JAXBContext context;

		try {
			context = JAXBContext.newInstance(Studenten.class);
			Unmarshaller um = context.createUnmarshaller();
			studentData = (Studenten) um.unmarshal(datei); // Cast, da studenten
															// kein objekt ist.

		} catch (Exception e) {
			System.err.println("Upsss");
		}

		return studentData.getStudentenData();
	}

}
