package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Studenten")

public class Studenten {

	@XmlElement(name = "Student", type = Student.class)
	private ObservableList<Student> studentData = FXCollections.observableArrayList();

	public Studenten() {

	}

	public Studenten(ObservableList<Student> studentData) {
		this.studentData = studentData;
	}

	public ObservableList<Student> getStudentenData() {
		return studentData;
	}

	public void setStudentData(ObservableList<Student> studentData) {
		this.studentData = studentData;
	}

}
