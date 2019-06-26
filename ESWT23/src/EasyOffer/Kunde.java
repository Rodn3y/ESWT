package EasyOffer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class Kunde extends JFrame {

	static int kundenbestand;

	// Instanzariablen:

	private String Vorname;
	private String Nachname;

	private int geburtsdatum;

	// Variablen f¸r Adresse
	private String Straﬂe;
	private String Stadt;
	private int pzl;
	private int hausnummer;

	private int Telnummer;

	public Kunde(String Vorname, String Nachname, String Straﬂe, String Stadt, int geburtsdatum, int hausnummer,
			int Telnummer) {
		this.Vorname = Vorname;
		this.Nachname = Nachname;
		this.Straﬂe = Straﬂe;
		this.Stadt = Stadt;

		this.geburtsdatum = geburtsdatum;
		this.hausnummer = hausnummer;
		this.Telnummer = Telnummer;
	}

	private JTextField vornameTextfeld;
	private JTextField nachnameTextfeld;
	private JTextField straﬂeFeld;
	private JTextField stadtFeld;
	private JTextField jahrFeld;
	private JComboBox<String> monatFeld;
	private JTextField tagFeld;
	private JTextField hausnummerFeld;
	private JTextField telnummerFeld;
	private JTextField postleitzahlFeld;

	private JRadioButton anredeChoice;
	private JRadioButton anredeChoiceFrau;

	private JButton anlegenButton;
	private JButton close;

	// GUI
	public Kunde() {

		this.setTitle("Kundenkartei");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);

		this.intiComponents();

		add(nachnameTextfeld);
		add(vornameTextfeld);
		add(straﬂeFeld);
		add(stadtFeld);

		// Geburtsdatum
		add(jahrFeld);
		add(monatFeld);
		add(tagFeld);

		add(anredeChoice);
		add(anredeChoiceFrau);

		add(hausnummerFeld);
		add(telnummerFeld);
		add(postleitzahlFeld);

		add(anlegenButton);
		add(close);

		this.setVisible(true);

	}

	private void intiComponents() {

		vornameTextfeld = new JTextField("Vorname");
		vornameTextfeld.setSize(150, 30);
		vornameTextfeld.setLocation(100, 100);

		nachnameTextfeld = new JTextField("Nachname");
		nachnameTextfeld.setSize(150, 30);
		nachnameTextfeld.setLocation(100, 150);

		// Anrede Choice
		anredeChoice = new JRadioButton("Herr");
		anredeChoice.setSize(50, 30);
		anredeChoice.setLocation(100, 200);

		anredeChoiceFrau = new JRadioButton("Frau");
		anredeChoiceFrau.setSize(50, 30);
		anredeChoiceFrau.setLocation(150, 200);

		ButtonGroup bg = new ButtonGroup();
		bg.add(anredeChoice);
		bg.add(anredeChoiceFrau);

		straﬂeFeld = new JTextField("Straﬂe");
		straﬂeFeld.setSize(150, 30);
		straﬂeFeld.setLocation(100, 300);

		stadtFeld = new JTextField("Stadt");
		stadtFeld.setSize(150, 30);
		stadtFeld.setLocation(100, 350);

		jahrFeld = new JTextField("Jahr");
		jahrFeld.setSize(150, 30);
		jahrFeld.setLocation(350, 100);

		String[] Monat = { "Januar", "Februar", "M‰rz", "April", "Mai", "Juni", "Juli", "August", "September",
				"Oktober", "November", "Dezember" };
		monatFeld = new JComboBox<String>(Monat);
		monatFeld.setSize(150, 30);
		monatFeld.setLocation(350, 150);

		tagFeld = new JTextField("Tag");
		tagFeld.setSize(150, 30);
		tagFeld.setLocation(350, 200);

		hausnummerFeld = new JTextField("Hausnummer");
		hausnummerFeld.setSize(150, 30);
		hausnummerFeld.setLocation(100, 400);

		telnummerFeld = new JTextField("Telefonnummer");
		telnummerFeld.setSize(150, 30);
		telnummerFeld.setLocation(350, 300);

		postleitzahlFeld = new JTextField("Postleitzahl");
		postleitzahlFeld.setSize(150, 30);
		postleitzahlFeld.setLocation(350, 350);

		anlegenButton = new JButton("Kunde anlegen");
		anlegenButton.setSize(150, 30);
		anlegenButton.setLocation(225, 500);
		anlegenButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// Felder richtig ausgef¸llt
				if (vornameTextfeld.getText().equals("Vorname") || nachnameTextfeld.getText().equals("Nachname")
						|| straﬂeFeld.getText().equals("Straﬂe") || stadtFeld.getText().equals("Stadt")
						|| hausnummerFeld.getText().equals("Hausnummer")) {
					JFrame Frame = new JFrame();
					JOptionPane.showMessageDialog(Frame, "Nicht alle felder richtig ausgef¸llt!", "Fehler!",
							JOptionPane.WARNING_MESSAGE);
					vornameTextfeld.setText("Vornamme");
					nachnameTextfeld.setText("Nachname");
					straﬂeFeld.setText("Straﬂe");
					stadtFeld.setText("Stadt");
					hausnummerFeld.setText("Hausnummer");

				} else {

					File kunden = new File("src/folder/kunden.txt");

					if (kunden.exists()) {
						System.out.println("data found");
					} else {
						try {
							kunden.createNewFile();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}

					try {
						PrintWriter writer = new PrintWriter(new FileWriter("src/folder/kunden.txt", true), true);

						if (anredeChoice.isSelected()) {
							writer.write("Herr");
						} else {
							writer.write("Frau");
						}
						
						writer.write(" ");
						writer.write(vornameTextfeld.getText());
						writer.write(" ");
						writer.write(nachnameTextfeld.getText());
						writer.write(" ");
						writer.write(stadtFeld.getText());
						writer.write(" ");
						writer.write(postleitzahlFeld.getText());
						writer.write(" ");
						writer.write(straﬂeFeld.getText());
						writer.write(" ");
						writer.write(hausnummerFeld.getText());
						writer.write(" ");
						writer.write(telnummerFeld.getText());
						writer.write(" ");

						writer.write(jahrFeld.getText());
						writer.write(" ");

						String monatFeldString = (String) monatFeld.getSelectedItem();
						writer.write(monatFeldString);
						writer.write(" ");

						writer.write(tagFeld.getText());
						writer.write(" ");

						writer.flush();

						writer.close();

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		});

		close = new JButton("close");
		close.setSize(10, 50);
		close.setLocation(50, 50);
	}
}