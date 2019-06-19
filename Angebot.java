package com.angebot;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.TableModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Angebot extends JFrame {
	private JTable tMaterial;
	private JTable tArbeit;
	private JTextField tfMaterialName;
	private JTextField tfMaterialPreis;
	private JTextField tfArbeit;
	private JTextField tfArbeitsKosten;
	
	DefaultTableModel modelMaterial ;
	DefaultTableModel modelArbeit;
	
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/YY");
	Date date = new Date();
	Calendar cal = Calendar.getInstance();
	
	private JTextField tfDatum;
	private JPanel contentPane;
	private JTextField tfSum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Angebot frame = new Angebot();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Angebot() {
		
		modelMaterial = new DefaultTableModel();
		modelArbeit = new DefaultTableModel();
		
		List<String> listMaterialName = new ArrayList<>();
		List<Double> listMaterialKosten = new ArrayList<>();

		List<String> listArbeitsBezeichnung = new ArrayList<>();
		List<Double> listArbeitsKosten = new ArrayList<>();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setVisible(true);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{102, 352, 117, 281, 0};
		gbl_contentPane.rowHeights = new int[]{20, 295, 33, 20, 20, 23, 23, 20, 23, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		// Action Listener Material entfernen
		JButton btMaterialEntfernen = new JButton("Material entfernen");
		btMaterialEntfernen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listMaterialName.remove(listMaterialName.size()-1);
				modelMaterial.removeRow(modelMaterial.getRowCount()-1);
			}
		});
		
		JLabel lblAngebotErstellen = new JLabel("Angebot erstellen");
		GridBagConstraints gbc_lblAngebotErstellen = new GridBagConstraints();
		gbc_lblAngebotErstellen.insets = new Insets(0, 0, 5, 5);
		gbc_lblAngebotErstellen.gridx = 0;
		gbc_lblAngebotErstellen.gridy = 0;
		contentPane.add(lblAngebotErstellen, gbc_lblAngebotErstellen);
		
		JLabel lbDatum = new JLabel("Datum");
		GridBagConstraints gbc_lbDatum = new GridBagConstraints();
		gbc_lbDatum.anchor = GridBagConstraints.EAST;
		gbc_lbDatum.insets = new Insets(0, 0, 5, 5);
		gbc_lbDatum.gridx = 2;
		gbc_lbDatum.gridy = 0;
		contentPane.add(lbDatum, gbc_lbDatum);
		
		tfDatum = new JTextField();
		tfDatum.setEditable(false);
		tfDatum.setText(" " + dateFormat.format(date));
		GridBagConstraints gbc_tfDatum = new GridBagConstraints();
		gbc_tfDatum.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDatum.insets = new Insets(0, 0, 5, 5);
		gbc_tfDatum.gridx = 3;
		gbc_tfDatum.gridy = 0;
		contentPane.add(tfDatum, gbc_tfDatum);
		tfDatum.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(tMaterial);
		scrollPane.setVisible(true);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		tMaterial = new JTable(modelMaterial);
		scrollPane.setViewportView(tMaterial);
		
		JScrollPane scrollPane_1 = new JScrollPane(tArbeit);
		scrollPane_1.setVisible(true);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 3;
		gbc_scrollPane_1.gridy = 1;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
		tArbeit = new JTable(modelArbeit);
		scrollPane_1.setViewportView(tArbeit);
		
		JLabel lbMaterialHinzufuegen = new JLabel("Materialbezeichnung:");
		GridBagConstraints gbc_lbMaterialHinzufuegen = new GridBagConstraints();
		gbc_lbMaterialHinzufuegen.anchor = GridBagConstraints.EAST;
		gbc_lbMaterialHinzufuegen.insets = new Insets(0, 0, 5, 5);
		gbc_lbMaterialHinzufuegen.gridx = 0;
		gbc_lbMaterialHinzufuegen.gridy = 3;
		contentPane.add(lbMaterialHinzufuegen, gbc_lbMaterialHinzufuegen);
		
		tfMaterialName = new JTextField();
		GridBagConstraints gbc_tfMaterialName = new GridBagConstraints();
		gbc_tfMaterialName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMaterialName.insets = new Insets(0, 0, 5, 5);
		gbc_tfMaterialName.gridx = 1;
		gbc_tfMaterialName.gridy = 3;
		contentPane.add(tfMaterialName, gbc_tfMaterialName);
		tfMaterialName.setColumns(10);
		
		JLabel lbArbeit = new JLabel("Arbeit:");
		GridBagConstraints gbc_lbArbeit = new GridBagConstraints();
		gbc_lbArbeit.anchor = GridBagConstraints.EAST;
		gbc_lbArbeit.insets = new Insets(0, 0, 5, 5);
		gbc_lbArbeit.gridx = 2;
		gbc_lbArbeit.gridy = 3;
		contentPane.add(lbArbeit, gbc_lbArbeit);
		
		tfArbeit = new JTextField();
		GridBagConstraints gbc_tfArbeit = new GridBagConstraints();
		gbc_tfArbeit.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfArbeit.insets = new Insets(0, 0, 5, 0);
		gbc_tfArbeit.gridx = 3;
		gbc_tfArbeit.gridy = 3;
		contentPane.add(tfArbeit, gbc_tfArbeit);
		tfArbeit.setColumns(10);
		
		JLabel lbMaterialpreis = new JLabel("Materialpreis:");
		GridBagConstraints gbc_lbMaterialpreis = new GridBagConstraints();
		gbc_lbMaterialpreis.anchor = GridBagConstraints.EAST;
		gbc_lbMaterialpreis.insets = new Insets(0, 0, 5, 5);
		gbc_lbMaterialpreis.gridx = 0;
		gbc_lbMaterialpreis.gridy = 4;
		contentPane.add(lbMaterialpreis, gbc_lbMaterialpreis);
		
		tfMaterialPreis = new JTextField();
		GridBagConstraints gbc_tfMaterialPreis = new GridBagConstraints();
		gbc_tfMaterialPreis.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMaterialPreis.insets = new Insets(0, 0, 5, 5);
		gbc_tfMaterialPreis.gridx = 1;
		gbc_tfMaterialPreis.gridy = 4;
		contentPane.add(tfMaterialPreis, gbc_tfMaterialPreis);
		tfMaterialPreis.setColumns(10);
		

		
		
		JLabel lbArbeitskosten = new JLabel("Arbeitskosten:");
		GridBagConstraints gbc_lbArbeitskosten = new GridBagConstraints();
		gbc_lbArbeitskosten.anchor = GridBagConstraints.EAST;
		gbc_lbArbeitskosten.insets = new Insets(0, 0, 5, 5);
		gbc_lbArbeitskosten.gridx = 2;
		gbc_lbArbeitskosten.gridy = 4;
		contentPane.add(lbArbeitskosten, gbc_lbArbeitskosten);
		
		tfArbeitsKosten = new JTextField();
		GridBagConstraints gbc_tfArbeitsKosten = new GridBagConstraints();
		gbc_tfArbeitsKosten.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfArbeitsKosten.insets = new Insets(0, 0, 5, 0);
		gbc_tfArbeitsKosten.gridx = 3;
		gbc_tfArbeitsKosten.gridy = 4;
		contentPane.add(tfArbeitsKosten, gbc_tfArbeitsKosten);
		tfArbeitsKosten.setColumns(10);
		// Action - Listener Arbeit hinzufügen
		JButton btArbeitHinzufgen = new JButton("Arbeit hinzuf\u00FCgen");
		btArbeitHinzufgen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String arbeit = tfArbeit.getText();
				String arbeitsKosten = tfArbeitsKosten.getText();
				 listArbeitsBezeichnung.add(arbeit);
				 listArbeitsKosten.add(Double.parseDouble(arbeitsKosten));
				 modelArbeit.insertRow(modelArbeit.getRowCount(), new Object[]{ arbeit,arbeitsKosten} );
				 tfArbeit.setText("");
				 tfArbeitsKosten.setText("");
			}
		});
		
		//Action - Listener Material hinzufügen
		JButton btMaterialHinzufuegen = new JButton("Material hinzuf\u00FCgen");
		btMaterialHinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String materialBenennung = tfMaterialName.getText();
				String materialKosten = tfMaterialPreis.getText();
				 listMaterialName.add(materialBenennung);
				 listMaterialKosten.add(Double.parseDouble(materialKosten));
				 modelMaterial.insertRow(modelMaterial.getRowCount(), new Object[]{ materialBenennung,materialKosten} );
				 tfMaterialName.setText("");
				 tfMaterialPreis.setText("");
			}
		});
		GridBagConstraints gbc_btMaterialHinzufuegen = new GridBagConstraints();
		gbc_btMaterialHinzufuegen.insets = new Insets(0, 0, 5, 5);
		gbc_btMaterialHinzufuegen.gridx = 1;
		gbc_btMaterialHinzufuegen.gridy = 5;
		contentPane.add(btMaterialHinzufuegen, gbc_btMaterialHinzufuegen);
		
		
		GridBagConstraints gbc_btArbeitHinzufgen = new GridBagConstraints();
		gbc_btArbeitHinzufgen.insets = new Insets(0, 0, 5, 0);
		gbc_btArbeitHinzufgen.gridx = 3;
		gbc_btArbeitHinzufgen.gridy = 5;
		contentPane.add(btArbeitHinzufgen, gbc_btArbeitHinzufgen);
		GridBagConstraints gbc_btMaterialEntfernen = new GridBagConstraints();
		gbc_btMaterialEntfernen.insets = new Insets(0, 0, 5, 5);
		gbc_btMaterialEntfernen.gridx = 1;
		gbc_btMaterialEntfernen.gridy = 6;
		contentPane.add(btMaterialEntfernen, gbc_btMaterialEntfernen);
		
		// Action Listener Arbeit entfernen
		JButton btArbeitEntfernen = new JButton("Arbeit entfernen");
		btArbeitEntfernen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listArbeitsBezeichnung.remove(listArbeitsBezeichnung.size()-1);
				modelArbeit.removeRow(modelArbeit.getRowCount()-1);
			}
		});
		
		JButton btGesamt = new JButton("Gesamt");
		btGesamt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfSum.setText(Double.toString((getSumMaterial()+getSumArbeit())));
				
			}
		});
		GridBagConstraints gbc_btGesamt = new GridBagConstraints();
		gbc_btGesamt.anchor = GridBagConstraints.NORTH;
		gbc_btGesamt.fill = GridBagConstraints.HORIZONTAL;
		gbc_btGesamt.insets = new Insets(0, 0, 5, 5);
		gbc_btGesamt.gridx = 2;
		gbc_btGesamt.gridy = 6;
		contentPane.add(btGesamt, gbc_btGesamt);
		GridBagConstraints gbc_btArbeitEntfernen = new GridBagConstraints();
		gbc_btArbeitEntfernen.insets = new Insets(0, 0, 5, 0);
		gbc_btArbeitEntfernen.gridx = 3;
		gbc_btArbeitEntfernen.gridy = 6;
		contentPane.add(btArbeitEntfernen, gbc_btArbeitEntfernen);
		
		JButton btAngebotErstellen = new JButton("Angebot erstellen");
		btAngebotErstellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("C:\\Users\\Leo\\Documents\\Angebot.txt");
					if(!file.exists()) {
						file.createNewFile();
					}
					
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					
					bw.write("MaterialKosten" + "\n\n");
					bw.write("Materialbezeichnung:\t\tPreis:\n");
					
					for(int i = 0; i < tMaterial.getRowCount(); i++) {
						for(int j = 0; j < tMaterial.getColumnCount();j++) {
							bw.write((String)tMaterial.getModel().getValueAt(i, j)+ "\t\t\t\t");
						}	
						bw.write("\n");
					}
					bw.write("\n\n\n");
					bw.write("Arbeitskosten" + "\n\n");
					bw.write("Arbeit:\t\t\t\tPreis:\n");
					
					for(int i = 0; i < tArbeit.getRowCount(); i++) {
						for(int j = 0; j < tArbeit.getColumnCount(); j++) {
							bw.write((String)tArbeit.getModel().getValueAt(i, j)+ "\t\t\t\t");
						}
						bw.write("\n");
					}
					
					bw.write("\n\nGesamtkosten: \t\t\t" + tfSum.getText() + " EUR");
					bw.close();
					fw.close();
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		tfSum = new JTextField();
		GridBagConstraints gbc_tfSum = new GridBagConstraints();
		gbc_tfSum.anchor = GridBagConstraints.NORTH;
		gbc_tfSum.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSum.insets = new Insets(0, 0, 5, 5);
		gbc_tfSum.gridx = 2;
		gbc_tfSum.gridy = 7;
		contentPane.add(tfSum, gbc_tfSum);
		tfSum.setColumns(10);
		GridBagConstraints gbc_btAngebotErstellen = new GridBagConstraints();
		gbc_btAngebotErstellen.anchor = GridBagConstraints.NORTHWEST;
		gbc_btAngebotErstellen.insets = new Insets(0, 0, 0, 5);
		gbc_btAngebotErstellen.gridx = 2;
		gbc_btAngebotErstellen.gridy = 8;
		contentPane.add(btAngebotErstellen, gbc_btAngebotErstellen);
		modelMaterial.addColumn("Materialbezeichnung");
		modelMaterial.addColumn("Preis");
		modelArbeit.addColumn("Arbeit");
		modelArbeit.addColumn("Arbeitskosten");
	}
	
	public double getSumMaterial() {
		int rowsCount = tMaterial.getRowCount();
		double sumMaterial = 0;
		for(int i = 0; i < rowsCount; i++) {
			sumMaterial += Double.parseDouble(tMaterial.getValueAt(i, 1).toString());
		}
		return sumMaterial;
	}
	
	public double getSumArbeit() {
		int rowsCount = tArbeit.getRowCount();
		double sumArbeit = 0;
		for(int i = 0; i < rowsCount; i++) {
			sumArbeit += Double.parseDouble(tArbeit.getValueAt(i, 1).toString());
		}
		return sumArbeit;
	}
	
	public TableModel getTMaterialModel() {
		return tMaterial.getModel();
	}
	public void setTMaterialModel(TableModel model) {
		tMaterial.setModel(model);
	}
}
