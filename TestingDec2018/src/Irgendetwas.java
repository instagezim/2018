import java.awt.event.*; // Für den ActionListener


public class Irgendetwas implements ActionListener {

	// Deklaration
	private Fenster mf;

	private Knopf mk1, mk2, mk3, mk4, mk5, mk6, mk7, mk8, mk9;

	private String spieler;

	private int spielzuege;

	private boolean sieg;

	public TicTacToe() {

		// Konstruktion
		mf = new Fenster();
		mf.setzeTitel("SPIELER X IST DRAN ");
		mf.setzeGroesse(300, 300);
		mk1 = new Knopf("", 0, 0, 100, 100);
		mk2 = new Knopf("", 100, 0, 100, 100);
		mk3 = new Knopf("", 200, 0, 100, 100);
		mk4 = new Knopf("", 0, 100, 100, 100);
		mk5 = new Knopf("", 100, 100, 100, 100);
		mk6 = new Knopf("", 200, 100, 100, 100);
		mk7 = new Knopf("", 0, 200, 100, 100);
		mk8 = new Knopf("", 100, 200, 100, 100);
		mk9 = new Knopf("", 200, 200, 100, 100);
		spieler = "";
		spielzuege = 0;
		sieg = false;

		// ActionListener zu den Knöpfen hinzufügen
		mk1.addActionListener(this);
		mk2.addActionListener(this);
		mk3.addActionListener(this);
		mk4.addActionListener(this);
		mk5.addActionListener(this);
		mk6.addActionListener(this);
		mk7.addActionListener(this);
		mk8.addActionListener(this);
		mk9.addActionListener(this);
		}
	
	public void actionPerformed(ActionEvent a) {
		spielzuege++; // Nach jeder Aktion (hier ein Knopfdruck) wird die Variable spielzuege um 1 erhöht

		// Zuweisung dafür, wer am Zug ist
		if (spielzuege == 1 || spielzuege == 3 || spielzuege == 5
		|| spielzuege == 7 || spielzuege == 9) {
		spieler = "X";
		mf.setzeTitel("SPIELER O IST DRAN ");
		} else if (spielzuege == 2 || spielzuege == 4 || spielzuege == 6
		|| spielzuege == 8 || spielzuege == 10) {
		spieler = "O";
		mf.setzeTitel("SPIELER X IST DRAN ");
		}

		// Zeichenzuweisung der Knöpfe jenachdem welcher Spieler am Zug war
		if (a.getSource() == mk1) {
		mk1.setzeText(spieler);
		mk1.setzeBenutzbar(false);
		} else if (a.getSource() == mk2) {
		mk2.setzeText(spieler);
		mk2.setzeBenutzbar(false);
		} else if (a.getSource() == mk3) {
		mk3.setzeText(spieler);
		mk3.setzeBenutzbar(false);
		} else if (a.getSource() == mk4) {
		mk4.setzeText(spieler);
		mk4.setzeBenutzbar(false);
		} else if (a.getSource() == mk5) {
		mk5.setzeText(spieler);
		mk5.setzeBenutzbar(false);
		} else if (a.getSource() == mk6) {
		mk6.setzeText(spieler);
		mk6.setzeBenutzbar(false);
		} else if (a.getSource() == mk7) {
		mk7.setzeText(spieler);
		mk7.setzeBenutzbar(false);
		} else if (a.getSource() == mk8) {
		mk8.setzeText(spieler);
		mk8.setzeBenutzbar(false);
		} else if (a.getSource() == mk9) {
		mk9.setzeText(spieler);
		mk9.setzeBenutzbar(false);
		}

	
	
}
