package GUI;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Pared;
import Logica.Logica;

import javax.swing.JLabel;
import java.awt.Color;

public class GUI extends JFrame {

	private JPanel contentPane;
	private static JPanel panel;

	

	/**
	 * Create the frame.
	 */
	public GUI(Logica logica) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 564);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Poner new Fondo() despues
		panel = new JPanel();
		panel.setBounds(0, 0, 525, 525);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setFocusable(true);
		
		logica.iniciarLogica(this);
		logica.avisarActualizacionLaberintoGrafico();
		
		
		KeyListener eventoTeclado = new KeyListener() {

			
			
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case 37:{
                    	logica.cambiarDireccionJugador('l');
                        break;
                    }

                    case 39:{
                    	logica.cambiarDireccionJugador('r');
                        break;
                    }

                    case 40:{
                    	logica.cambiarDireccionJugador('d');
                        break;
                    }

                    case 38:{
                    	logica.cambiarDireccionJugador('u');
                        break;
                    }

                }
            }
            
            

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };

        panel.addKeyListener(eventoTeclado);
		
        

	}
	
	
	public void agregarEntidad(JLabel entidad) {
			panel.add(entidad);
		
	}
}

