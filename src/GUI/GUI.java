package GUI;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Pared;

import javax.swing.JLabel;
import java.awt.Color;

public class GUI extends JFrame {

	private JPanel contentPane, panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
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
		
		KeyListener eventoTeclado = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case 37:{
                    	//Juego.cambiarDireccionJugador(l)
                        break;
                    }

                    case 39:{
                    	//Juego.cambiarDireccionJugador(r)
                        break;
                    }

                    case 40:{
                    	//Juego.cambiarDireccionJugador(d)
                        break;
                    }

                    case 38:{
                    	//Juego.cambiarDireccionJugador(u)
                        break;
                    }

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };

        panel.addKeyListener(eventoTeclado);
		
		
	Pared pared = new Pared(52,50);
	agregarEntidad(pared.getEntidadGrafica());
		
		

	}
	
	
	public void agregarEntidad(JLabel entidad) {
		panel.add(entidad);
	}
}

