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
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;

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
		contentPane.setLayout(new MigLayout("", "[102px][291px,grow][70px][281px]", "[20px][295px][][20px][20px][23px][23px][grow][]"));
		
		JLabel lblAngebotErstellen = new JLabel("Angebot erstellen");
		contentPane.add(lblAngebotErstellen, "cell 0 0,alignx center,aligny center");
		
		JLabel lbDatum = new JLabel("Datum");
		contentPane.add(lbDatum, "cell 2 0,alignx right,aligny center");
		
		tfDatum = new JTextField();
		tfDatum.setEditable(false);
		tfDatum.setText(" " + dateFormat.format(date));
		contentPane.add(tfDatum, "cell 3 0,growx,aligny center");
		tfDatum.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(tMaterial);
		scrollPane.setVisible(true);
		contentPane.add(scrollPane, "cell 1 1,alignx right,growy");
		
		tMaterial = new JTable(modelMaterial);
		scrollPane.setViewportView(tMaterial);
		modelMaterial.addColumn("Materialbezeichnung");
		modelMaterial.addColumn("Preis");
		
		JScrollPane scrollPane_1 = new JScrollPane(tArbeit);
		scrollPane_1.setVisible(true);
		contentPane.add(scrollPane_1, "cell 3 1,grow");
		
		tArbeit = new JTable(modelArbeit);
		scrollPane_1.setViewportView(tArbeit);
		modelArbeit.addColumn("Arbeit");
		modelArbeit.addColumn("Arbeitskosten");
		
		JLabel lbMaterialHinzufuegen = new JLabel("Materialbezeichnung:");
		contentPane.add(lbMaterialHinzufuegen, "cell 0 3,alignx right,aligny center");
		
		tfMaterialName = new JTextField();
		contentPane.add(tfMaterialName, "cell 1 3,growx,aligny center");
		tfMaterialName.setColumns(10);
		
		JLabel lbArbeit = new JLabel("Arbeit:");
		contentPane.add(lbArbeit, "cell 2 3,alignx right,aligny center");
		
		tfArbeit = new JTextField();
		contentPane.add(tfArbeit, "cell 3 3,growx,aligny center");
		tfArbeit.setColumns(10);
		
		JLabel lbMaterialpreis = new JLabel("Materialpreis:");
		contentPane.add(lbMaterialpreis, "cell 0 4,alignx right,aligny center");
		
		tfMaterialPreis = new JTextField();
		contentPane.add(tfMaterialPreis, "cell 1 4,growx,aligny center");
		tfMaterialPreis.setColumns(10);
		
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
		

		
		
		JLabel lbArbeitskosten = new JLabel("Arbeitskosten:");
		contentPane.add(lbArbeitskosten, "cell 2 4,alignx right,aligny center");
		
		tfArbeitsKosten = new JTextField();
		contentPane.add(tfArbeitsKosten, "cell 3 4,growx,aligny center");
		tfArbeitsKosten.setColumns(10);
		contentPane.add(btMaterialHinzufuegen, "cell 1 5,alignx center,aligny center");
		
		
		contentPane.add(btArbeitHinzufgen, "cell 3 5,alignx center,aligny center");
		
		// Action Listener Material entfernen
		JButton btMaterialEntfernen = new JButton("Material entfernen");
		btMaterialEntfernen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listMaterialName.remove(listMaterialName.size()-1);
				modelMaterial.removeRow(modelMaterial.getRowCount()-1);
			}
		});
		contentPane.add(btMaterialEntfernen, "cell 1 6,alignx center,aligny center");
		
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
		contentPane.add(btGesamt, "cell 2 6,growx");
		contentPane.add(btArbeitEntfernen, "cell 3 6,alignx center,aligny center");
		
		tfSum = new JTextField();
		contentPane.add(tfSum, "cell 2 7,growx");
		tfSum.setColumns(10);
		
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
		contentPane.add(btAngebotErstellen, "cell 2 8");
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
