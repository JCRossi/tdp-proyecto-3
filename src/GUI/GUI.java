package GUI;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Entidades.Pared;
import Logica.Logica;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GUI extends JFrame {

	private JPanel contentPane;
	private static JPanel panel;
	private JLabel lblPuntajeNumero;
	private JLabel lblVidasNumero;

	

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
		
		JLabel lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setBounds(535, 29, 79, 14);
		contentPane.add(lblPuntaje);
		
		lblPuntajeNumero = new JLabel("0");
		lblPuntajeNumero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPuntajeNumero.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPuntajeNumero.setForeground(Color.WHITE);
		lblPuntajeNumero.setBounds(568, 54, 46, 14);
		contentPane.add(lblPuntajeNumero);
		
		JLabel lblVidas = new JLabel("Vidas:");
		lblVidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVidas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVidas.setForeground(Color.WHITE);
		lblVidas.setBounds(535, 106, 79, 14);
		contentPane.add(lblVidas);
		
		lblVidasNumero = new JLabel("0");
		lblVidasNumero.setHorizontalAlignment(SwingConstants.TRAILING);
		lblVidasNumero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVidasNumero.setForeground(Color.WHITE);
		lblVidasNumero.setBounds(568, 135, 46, 14);
		contentPane.add(lblVidasNumero);
		
		logica.iniciarLogica(this);
		
		
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
                    case 32:{
                    	logica.plantarBomba();
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
	
	public void quitarEntidad(JLabel entidad) {
		 SwingUtilities.invokeLater(new Runnable(){
		      @Override
		      public void run() {
		    	  panel.remove(entidad);
		  		panel.validate();
		  		panel.repaint();
		      }
		    });
	}
	
	public void actualizarPuntajeGrafico(int puntos) {
		lblPuntajeNumero.setText("" + puntos);
	}
	
	public void actualizarVidaGrafica(int cantVidas) {
		lblVidasNumero.setText("" + cantVidas);
	}
}

