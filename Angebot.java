package com.angebot;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.table.TableModel;

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
		setBounds(100, 100, 786, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setVisible(true);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
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
		gbc_tfDatum.insets = new Insets(0, 0, 5, 0);
		gbc_tfDatum.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDatum.gridx = 3;
		gbc_tfDatum.gridy = 0;
		contentPane.add(tfDatum, gbc_tfDatum);
		tfDatum.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(tMaterial);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		scrollPane.setVisible(true);
		gbc_scrollPane.gridheight = 9;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		tMaterial = new JTable(modelMaterial);
		scrollPane.setViewportView(tMaterial);
		modelMaterial.addColumn("Materialbezeichnung");
		modelMaterial.addColumn("Preis");
		
		JScrollPane scrollPane_1 = new JScrollPane(tArbeit);
		scrollPane_1.setVisible(true);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 9;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 3;
		gbc_scrollPane_1.gridy = 1;
		contentPane.add(scrollPane_1, gbc_scrollPane_1);
		
		tArbeit = new JTable(modelArbeit);
		scrollPane_1.setViewportView(tArbeit);
		modelArbeit.addColumn("Arbeit");
		modelArbeit.addColumn("Arbeitskosten");
		
		JLabel lbMaterialHinzufuegen = new JLabel("Materialbezeichnung:");
		GridBagConstraints gbc_lbMaterialHinzufuegen = new GridBagConstraints();
		gbc_lbMaterialHinzufuegen.insets = new Insets(0, 0, 5, 5);
		gbc_lbMaterialHinzufuegen.anchor = GridBagConstraints.EAST;
		gbc_lbMaterialHinzufuegen.gridx = 0;
		gbc_lbMaterialHinzufuegen.gridy = 11;
		contentPane.add(lbMaterialHinzufuegen, gbc_lbMaterialHinzufuegen);
		
		tfMaterialName = new JTextField();
		GridBagConstraints gbc_tfMaterialName = new GridBagConstraints();
		gbc_tfMaterialName.insets = new Insets(0, 0, 5, 5);
		gbc_tfMaterialName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMaterialName.gridx = 1;
		gbc_tfMaterialName.gridy = 11;
		contentPane.add(tfMaterialName, gbc_tfMaterialName);
		tfMaterialName.setColumns(10);
		
		JLabel lbArbeit = new JLabel("Arbeit:");
		GridBagConstraints gbc_lbArbeit = new GridBagConstraints();
		gbc_lbArbeit.anchor = GridBagConstraints.EAST;
		gbc_lbArbeit.insets = new Insets(0, 0, 5, 5);
		gbc_lbArbeit.gridx = 2;
		gbc_lbArbeit.gridy = 11;
		contentPane.add(lbArbeit, gbc_lbArbeit);
		
		tfArbeit = new JTextField();
		GridBagConstraints gbc_tfArbeit = new GridBagConstraints();
		gbc_tfArbeit.insets = new Insets(0, 0, 5, 0);
		gbc_tfArbeit.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfArbeit.gridx = 3;
		gbc_tfArbeit.gridy = 11;
		contentPane.add(tfArbeit, gbc_tfArbeit);
		tfArbeit.setColumns(10);
		
		JLabel lbMaterialpreis = new JLabel("Materialpreis:");
		GridBagConstraints gbc_lbMaterialpreis = new GridBagConstraints();
		gbc_lbMaterialpreis.insets = new Insets(0, 0, 5, 5);
		gbc_lbMaterialpreis.anchor = GridBagConstraints.EAST;
		gbc_lbMaterialpreis.gridx = 0;
		gbc_lbMaterialpreis.gridy = 12;
		contentPane.add(lbMaterialpreis, gbc_lbMaterialpreis);
		
		tfMaterialPreis = new JTextField();
		GridBagConstraints gbc_tfMaterialPreis = new GridBagConstraints();
		gbc_tfMaterialPreis.insets = new Insets(0, 0, 5, 5);
		gbc_tfMaterialPreis.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMaterialPreis.gridx = 1;
		gbc_tfMaterialPreis.gridy = 12;
		contentPane.add(tfMaterialPreis, gbc_tfMaterialPreis);
		tfMaterialPreis.setColumns(10);
		
		//Action - Listener
		JButton btMaterialHinzufuegen = new JButton("Material hinzuf\u00FCgen");
		btMaterialHinzufuegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int position = 1;
				String materialBenennung = tfMaterialName.getText();
				String materialKosten = tfMaterialPreis.getText();
				 listMaterialName.add(materialBenennung);
				 listMaterialKosten.add(Double.parseDouble(materialKosten));
				 modelMaterial.insertRow(modelMaterial.getRowCount(), new Object[]{position, materialBenennung,materialKosten} );
				 tfMaterialName.setText("");
				 tfMaterialPreis.setText("");
			}
		});
		
		JLabel lbArbeitskosten = new JLabel("Arbeitskosten:");
		GridBagConstraints gbc_lbArbeitskosten = new GridBagConstraints();
		gbc_lbArbeitskosten.anchor = GridBagConstraints.EAST;
		gbc_lbArbeitskosten.insets = new Insets(0, 0, 5, 5);
		gbc_lbArbeitskosten.gridx = 2;
		gbc_lbArbeitskosten.gridy = 12;
		contentPane.add(lbArbeitskosten, gbc_lbArbeitskosten);
		
		tfArbeitsKosten = new JTextField();
		GridBagConstraints gbc_tfArbeitsKosten = new GridBagConstraints();
		gbc_tfArbeitsKosten.insets = new Insets(0, 0, 5, 0);
		gbc_tfArbeitsKosten.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfArbeitsKosten.gridx = 3;
		gbc_tfArbeitsKosten.gridy = 12;
		contentPane.add(tfArbeitsKosten, gbc_tfArbeitsKosten);
		tfArbeitsKosten.setColumns(10);
		GridBagConstraints gbc_btMaterialHinzufuegen = new GridBagConstraints();
		gbc_btMaterialHinzufuegen.insets = new Insets(0, 0, 5, 5);
		gbc_btMaterialHinzufuegen.gridx = 1;
		gbc_btMaterialHinzufuegen.gridy = 13;
		contentPane.add(btMaterialHinzufuegen, gbc_btMaterialHinzufuegen);
		
		JButton btArbeitHinzufgen = new JButton("Arbeit hinzuf\u00FCgen");
		GridBagConstraints gbc_btArbeitHinzufgen = new GridBagConstraints();
		gbc_btArbeitHinzufgen.insets = new Insets(0, 0, 5, 0);
		gbc_btArbeitHinzufgen.gridx = 3;
		gbc_btArbeitHinzufgen.gridy = 13;
		contentPane.add(btArbeitHinzufgen, gbc_btArbeitHinzufgen);
		
		JButton btMaterialEntfernen = new JButton("Material entfernen");
		GridBagConstraints gbc_btMaterialEntfernen = new GridBagConstraints();
		gbc_btMaterialEntfernen.insets = new Insets(0, 0, 0, 5);
		gbc_btMaterialEntfernen.gridx = 1;
		gbc_btMaterialEntfernen.gridy = 14;
		contentPane.add(btMaterialEntfernen, gbc_btMaterialEntfernen);
		
		JButton btArbeitEntfernen = new JButton("Arbeit entfernen");
		GridBagConstraints gbc_btArbeitEntfernen = new GridBagConstraints();
		gbc_btArbeitEntfernen.gridx = 3;
		gbc_btArbeitEntfernen.gridy = 14;
		contentPane.add(btArbeitEntfernen, gbc_btArbeitEntfernen);
	}

	public TableModel getTMaterialModel() {
		return tMaterial.getModel();
	}
	public void setTMaterialModel(TableModel model) {
		tMaterial.setModel(model);
	}
}
