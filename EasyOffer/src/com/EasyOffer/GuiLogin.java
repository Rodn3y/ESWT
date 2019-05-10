package com.EasyOffer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//GUI für Username- und Passwortabfrage
public class GuiLogin extends JFrame {
	

	//Hinterlegtes Passwort/Username für Loginabfrage
	public String UserPassword = ("Test"); // momentan Platzhalter...soll auf Passwort Datenbank zugreifen?!
	public String UserUsername = ("Test"); // momentan Platzhalter...soll auf Username Datenbank zugreifen?!

	//Textfeld und Passwortfeld
	private JTextField username;
	private JPasswordField password;

	//Schrift "Username" und "Passwort"
	private JLabel usernameLabel;
	private JLabel passwordLabel;

	//Knöpfe für Login und Exit
	private JButton loginButton;
	private JButton exitButton;
	
	

	public GuiLogin() {
		
		//Settings des GUIs
		this.setTitle("titel");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLayout(null);
		this.setTitle("Login");

		//Inizialisierung aller Komponenten
		this.initComponents();
		
		//hinzufügen der Komponenten
		add(username);
		add(usernameLabel);

		add(password);
		add(passwordLabel);

		add(loginButton);
		add(exitButton);

		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
	
    //Methode um Komponenten zu inizialisieren 
	private void initComponents() {
		
		//Textfeld für die Username-eingabe
		username = new JTextField();
		username.setLocation(200, 100);
		username.setSize(200, 30);
        
		//Label um Schrift "Username: " anzuzeigen
		usernameLabel = new JLabel("Username:");
		usernameLabel.setLocation(100, 100);
		usernameLabel.setSize(100, 30);
		
		
        //Passwortfeld für die Passwort-eingabe
		password = new JPasswordField();
		password.setLocation(200, 200);
		password.setSize(200, 30);
		
        //Label um Schrift "Passwort: " anzuzeigen
		passwordLabel = new JLabel("Passwort:");
		passwordLabel.setLocation(100, 200);
		passwordLabel.setSize(100, 30);
		
        //Button um "einzuloggen"
		loginButton = new JButton("login");
		loginButton.setLocation(175, 330);
		loginButton.setSize(150, 50);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
                //Passwort und Username Abfrage
				if (password.getText().contains(UserPassword) && username.getText().contains(UserUsername)) {
					password.setText(null);
					username.setText(null);
			        JFrame Frame = new JFrame();
					JOptionPane.showMessageDialog(Frame, "Anmeldung erfolgreich.", "Login",
							JOptionPane.INFORMATION_MESSAGE);
					Angebot angebot = new Angebot();
					angebot.setVisible(true);
				} else {
					JFrame Frame = new JFrame();
					JOptionPane.showMessageDialog(Frame, "Benztzername und/oder Password sind fehlerhaft.",
							"Zugriff verweigert!", JOptionPane.ERROR_MESSAGE);
					password.setText(null);
					username.setText(null);
				}
			}
		});
		
        //Button um Fenster zu schließen
		exitButton = new JButton("Exit");
		exitButton.setLocation(350, 330);
		exitButton.setSize(70, 50);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(getDefaultCloseOperation());
			}
		});
	}
}
