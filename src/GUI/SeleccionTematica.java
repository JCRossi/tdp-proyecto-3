package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Logica;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeleccionTematica extends JFrame {
	private JPanel contentPane;
	private boolean finalizado;
	public Tematica tematica;

	public SeleccionTematica(Logica juego) {
		finalizado = false;
		setResizable(false);
		setBounds(100, 100, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Parte 2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tematica tem = new TematicaParte2();
				juego.setTematica(tem); 
				GUI frame = new GUI(juego,tem.pathDeMusica());
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(44, 119, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Parte 3");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tematica tem = new TematicaParte3();
				juego.setTematica(tem); 
				GUI frame = new GUI(juego,tem.pathDeMusica());
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(356, 119, 89, 23);
		contentPane.add(btnNewButton_1);
		
		finalizado = true;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	public Tematica getTematicaSeleccionada() {
		return this.tematica;
	}
	
	public void CiclarHastaSeleccionDeTematica() {
		while(finalizado == false) {
			
		}
		while(tematica == null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
