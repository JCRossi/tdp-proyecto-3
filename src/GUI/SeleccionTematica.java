package GUI;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Logica;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;

public class SeleccionTematica extends JFrame {
	private JPanel contentPane;
	private boolean finalizado;
	public Tematica tematica;
	private ImageIcon fondo;
	private Tematica tem;

	public SeleccionTematica(Logica juego) {
		finalizado = false;
		setResizable(false);
		setBounds(100, 100, 500, 575);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 484, 536);
		contentPane.add(layeredPane);
		
		JPanel panelControles = new FondoGUI("/images/GUI/jojofondoAyuda.png");
		panelControles.setBounds(0, 0, 484, 536);
		panelControles.setLayout(null);
		//layeredPane.add(panelControles);
		
		
		
		JPanel panelTematica = new FondoGUI("/images/GUI/jojofondoTematica.png");
		panelTematica.setBounds(0, 0, 484, 536);
		panelTematica.setLayout(null);
		//layeredPane.add(panelTematica);
		
		JLabel lblNewLabel = new JLabel("Seleccione la tem\u00E1tica:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(45, 24, 334, 64);
		panelTematica.add(lblNewLabel);
		
		JPanel panelPrincipal = new FondoGUI("/images/GUI/jojofondo.png");
		panelPrincipal.setBounds(0, 0, 484, 536);
		layeredPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JButton btnPlay = new JButton("Jugar");
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tem == null) {
					tem = new TematicaParte2();
					juego.setTematica(tem); 
				}
					
				GUI frame = new GUI(juego,tem.pathDeMusica());
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnPlay.setBounds(127, 205, 230, 80);
		panelPrincipal.add(btnPlay);
		
		JButton btnTematica = new JButton("Tematica");
		btnTematica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelTematica);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnTematica.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnTematica.setBounds(127, 300, 230, 80);
		panelPrincipal.add(btnTematica);
		
		JButton btnControles = new JButton("Ayuda");
		btnControles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelControles);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnControles.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnControles.setBounds(127, 395, 230, 80);
		panelPrincipal.add(btnControles);
		
		
		
		JButton btnNewButton = new JButton("Parte 2");
		btnNewButton.setBounds(45, 130, 90, 45);
		panelTematica.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tem = new TematicaParte2();
				juego.setTematica(tem); 
				layeredPane.removeAll();
				layeredPane.add(panelPrincipal);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Parte 5");
		btnNewButton_2.setBounds(45, 411, 90, 45);
		panelTematica.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tem = new TematicaParte5();
				juego.setTematica(tem); 
				layeredPane.removeAll();
				layeredPane.add(panelPrincipal);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Parte 3");
		btnNewButton_1.setBounds(45, 270, 90, 45);
		panelTematica.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tem = new TematicaParte3();
				juego.setTematica(tem); 
				layeredPane.removeAll();
				layeredPane.add(panelPrincipal);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		
		JButton btnNewButton_3 = new JButton("Volver");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.setBounds(192, 482, 100, 25);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panelPrincipal);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		panelControles.add(btnNewButton_3);
		
		JLabel lblNivel5 = new JLabel("hola");
		lblNivel5.setBounds(333, 368, 130, 130);
		fondo = new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(SeleccionTematica.class.getResource("/images/nivel_1/nivel1Parte5.png"))).getImage().getScaledInstance(130,130,Image.SCALE_DEFAULT) );
		lblNivel5.setIcon(fondo);
		panelTematica.add(lblNivel5);
		
		JLabel lblNivel2 = new JLabel("hola2");
		lblNivel2.setBounds(333, 86, 130, 130);
		fondo = new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(SeleccionTematica.class.getResource("/images/nivel_1/nivel1Parte2.png"))).getImage().getScaledInstance(130,130,Image.SCALE_DEFAULT) );
		lblNivel2.setIcon(fondo);
		panelTematica.add(lblNivel2);
		
		JLabel lblNivel3 = new JLabel("hola2");
		fondo = new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(SeleccionTematica.class.getResource("/images/nivel_1/nivel1Parte3.png"))).getImage().getScaledInstance(130,130,Image.SCALE_DEFAULT) );
		lblNivel3.setIcon(fondo);
		lblNivel3.setBounds(333, 227, 130, 130);
		panelTematica.add(lblNivel3);
		
		JLabel personajesParte2 = new JLabel("New label");
		fondo = new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(SeleccionTematica.class.getResource("/images/GUI/personajesParte2.png"))).getImage().getScaledInstance(130,130,Image.SCALE_DEFAULT) );
		personajesParte2.setIcon(fondo);
		personajesParte2.setBounds(176, 86, 130, 130);
		panelTematica.add(personajesParte2);
		
		JLabel personajesParte3 = new JLabel("New label");
		fondo = new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(SeleccionTematica.class.getResource("/images/GUI/personajesParte3.png"))).getImage().getScaledInstance(130,130,Image.SCALE_DEFAULT) );
		personajesParte3.setIcon(fondo);
		personajesParte3.setBounds(176, 227, 130, 130);
		panelTematica.add(personajesParte3);
		
		JLabel personajesParte5 = new JLabel("New label");
		fondo = new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(SeleccionTematica.class.getResource("/images/GUI/personajesParte5.png"))).getImage().getScaledInstance(130,130,Image.SCALE_DEFAULT) );
		personajesParte5.setIcon(fondo);
		personajesParte5.setBounds(176, 368, 130, 130);
		panelTematica.add(personajesParte5);
		
		
		
		
		
		finalizado = true;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	public Tematica getTematicaSeleccionada() {
		return this.tem;
	}
	
	public void CiclarHastaSeleccionDeTematica() {
		while(finalizado == false) {
			
		}
		while(tem == null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
