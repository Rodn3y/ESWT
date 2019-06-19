import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UserRegistration extends JFrame {

	private JLabel Usernamereg;
	private JLabel Passwordreg;
	private JLabel Passwordreg2;

	private JTextField newUsername;
	private JTextField newPassword;
	private JTextField newPassword2;

	private JButton safeButton;

	public UserRegistration() {

		this.setTitle("Registrieren:");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 600);
		this.setLayout(null);

		this.initComponents();

		add(Usernamereg);
		add(Passwordreg);
		add(Passwordreg2);
		add(newUsername);
		add(newPassword);
		add(newPassword2);
		add(safeButton);

		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

	private void initComponents() {

		Usernamereg = new JLabel("neuer Benutzername angeben:");
		Usernamereg.setLocation(100, 100);
		Usernamereg.setSize(200, 30);

		Passwordreg = new JLabel("Password festelgen:");
		Passwordreg.setLocation(100, 200);
		Passwordreg.setSize(200, 30);

		Passwordreg2 = new JLabel("Password wiederholen: ");
		Passwordreg2.setLocation(100, 300);
		Passwordreg2.setSize(200, 30);

		newUsername = new JTextField();
		newUsername.setLocation(100, 130);
		newUsername.setSize(200, 30);

		newPassword = new JTextField();
		newPassword.setLocation(100, 230);
		newPassword.setSize(200, 30);

		newPassword2 = new JTextField();
		newPassword2.setLocation(100, 330);
		newPassword2.setSize(200, 30);

		safeButton = new JButton("registrieren");
		safeButton.setLocation(170, 400);
		safeButton.setSize(150, 50);
		safeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String password1 = newPassword.getText();
				String password2 = newPassword2.getText();
				String username = newUsername.getText();

				if (password1.contentEquals(password2)) {
					
					JFrame Frame = new JFrame();
					JOptionPane.showMessageDialog(Frame, "Registrierung erfolgreich!", "Juhu",
							JOptionPane.INFORMATION_MESSAGE);

					try {
						PrintWriter writer = new PrintWriter(new FileWriter("src/folder/data.txt", true),true);
						writer.write(username);
						writer.write("\n");
						writer.write(password1);
						writer.write("\n\n");
						writer.flush();
						
						writer.close();
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				} else {
					JFrame Frame = new JFrame();
					JOptionPane.showMessageDialog(Frame, "Passwörter ungleich",
							"Registrierung nicht erfolgreich!", JOptionPane.ERROR_MESSAGE);
					newPassword.setText(null);
					newPassword2.setText(null);
					newUsername.setText(null);
					
				}
			}

		});

	}

}
