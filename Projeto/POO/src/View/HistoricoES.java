package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

import Controllers.HistoricoES_Controller;
import Models.Apartamento;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HistoricoES {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoricoES window = new HistoricoES();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HistoricoES() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		HistoricoES_Controller controller = new HistoricoES_Controller();
		
		JLabel lblNewLabel = new JLabel("Tipo");
		lblNewLabel.setBounds(201, 18, 27, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E/S");
		lblNewLabel_1.setBounds(10, 29, 37, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox cbES = new JComboBox();
		cbES.setModel(new DefaultComboBoxModel(new String[] {"Entrada", "Saida"}));
		cbES.setBounds(40, 25, 141, 21);
		frame.getContentPane().add(cbES);
		
		JComboBox cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Visita", "Entrega", "Residente"}));
		cbTipo.setBounds(238, 25, 167, 21);
		frame.getContentPane().add(cbTipo);
		
		JLabel lblNewLabel_2 = new JLabel("APTO");
		lblNewLabel_2.setBounds(10, 69, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox cbAPTO = new JComboBox();
		cbAPTO.setBounds(40, 65, 365, 21);
		frame.getContentPane().add(cbAPTO);
		
		ArrayList<Apartamento> apartamentos = new ArrayList<Apartamento>();
		apartamentos = controller.getApartamentos();
		for(Apartamento apto : apartamentos) {
			cbAPTO.addItem(apto);
		}
		
		JLabel lblNewLabel_3 = new JLabel("RG");
		lblNewLabel_3.setBounds(10, 92, 45, 42);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnBuscar.setBounds(318, 103, 85, 21);
		frame.getContentPane().add(btnBuscar);
		
		JLabel lblNewLabel_4 = new JLabel("Nome");
		lblNewLabel_4.setBounds(10, 147, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(40, 144, 268, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(40, 104, 268, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnRegistrarES = new JButton("Registrar E/S");
		btnRegistrarES.setBounds(301, 241, 102, 21);
		frame.getContentPane().add(btnRegistrarES);
		
		JLabel lblNewLabel_5 = new JLabel("Observa\u00E7\u00E3o");
		lblNewLabel_5.setBounds(40, 170, 65, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(21, 191, 398, 40);
		frame.getContentPane().add(textArea);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(320, 143, 85, 21);
		frame.getContentPane().add(btnNovo);
	}
	
}
