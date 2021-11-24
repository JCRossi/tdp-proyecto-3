package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Logica.Logica;
import Musica.PlayMusic;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private static Fondo panel;
	private static FondoLat panelPuntaje;
	private JLabel lblPuntajeNumero;
	private JLabel lblVidasNumero, lblPausa;
	private JPanel panelBase, panelVictoria, panelDerrota;
	private JButton btnNewButton1, btnNewButton2, btnNewButton3, btnNewButton4, btnNewButton;
	private JLabel lblVidas, lblPuntaje, lblPuntuacionFinalDerrota, lblNumeroPuntajeFinalDerrota, lblnivel, lblDerrota, lblNumeroPuntajeFinal, lblPuntuacionFinal, lblVictoria;
	private JLayeredPane layeredPane;

	/**
	 * Create the frame.
	 */
	public GUI(Logica logica,String pathMusical) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 564);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 639, 525);
		contentPane.add(layeredPane);
		
		panelVictoria = new FondoJuego("/images/GUI/fondojuegoVictoria.png");
		panelVictoria.setBounds(0, 0, 639, 525);
		panelVictoria.setLayout(null);
		
		lblVictoria = new JLabel("Ganaste!");
		lblVictoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblVictoria.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lblVictoria.setBounds(121, 11, 397, 73);
		panelVictoria.add(lblVictoria);
		
		lblPuntuacionFinal = new JLabel("Tu puntuacion:");
		lblPuntuacionFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntuacionFinal.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblPuntuacionFinal.setBounds(147, 129, 345, 57);
		panelVictoria.add(lblPuntuacionFinal);
		
		lblNumeroPuntajeFinal = new JLabel("");
		lblNumeroPuntajeFinal.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNumeroPuntajeFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroPuntajeFinal.setBounds(215, 186, 209, 57);
		panelVictoria.add(lblNumeroPuntajeFinal);
		
		panelDerrota = new FondoJuego("/images/GUI/fondojuegoDerrota.png");
		panelDerrota.setBounds(0, 0, 639, 525);
		panelDerrota.setLayout(null);
		
		lblDerrota = new JLabel("Fin del juego!");
		lblDerrota.setHorizontalAlignment(SwingConstants.CENTER);
		lblDerrota.setFont(new Font("Tahoma", Font.PLAIN, 55));
		lblDerrota.setBounds(121, 11, 397, 73);
		panelDerrota.add(lblDerrota);
		
		lblPuntuacionFinalDerrota = new JLabel("Tu puntuacion:");
		lblPuntuacionFinalDerrota.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntuacionFinalDerrota.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblPuntuacionFinalDerrota.setBounds(147, 129, 345, 57);
		panelDerrota.add(lblPuntuacionFinalDerrota);
		
		lblNumeroPuntajeFinalDerrota = new JLabel("");
		lblNumeroPuntajeFinalDerrota.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNumeroPuntajeFinalDerrota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroPuntajeFinalDerrota.setBounds(215, 186, 209, 57);
		panelDerrota.add(lblNumeroPuntajeFinalDerrota);
		
		lblnivel = new JLabel("");
		lblnivel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblnivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblnivel.setBounds(10, 245, 619, 78);
		panelDerrota.add(lblnivel);
		
		
		panelBase = new JPanel();
		panelBase.setBounds(0, 0, 639, 525);
		layeredPane.add(panelBase);
		panelBase.setLayout(null);
		
		panel = new Fondo("/images/maxresdefault.png");
		panel.setBounds(0, 0, 525, 525);
		panelBase.add(panel);
		panel.setLayout(null);
		panel.setFocusable(true);
		
		panelPuntaje = new FondoLat("/images/GUI/jojopanellateral.png");
		panelPuntaje.setBounds(525, 0, 114, 525);
		panelBase.add(panelPuntaje);
		panelPuntaje.setLayout(null);
		panelPuntaje.setFocusable(true);
		
		lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntaje.setForeground(Color.BLACK);
		lblPuntaje.setBounds(20, 29, 79, 14);
		panelPuntaje.add(lblPuntaje);
		
		lblPuntajeNumero = new JLabel("0");
		lblPuntajeNumero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPuntajeNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntajeNumero.setForeground(Color.BLACK);
		lblPuntajeNumero.setBounds(20, 54, 79, 25);
		panelPuntaje.add(lblPuntajeNumero);
		
		lblVidas = new JLabel("Vidas:");
		lblVidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVidas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVidas.setForeground(Color.BLACK);
		lblVidas.setBounds(20, 109, 79, 14);
		panelPuntaje.add(lblVidas);
		
		lblVidasNumero = new JLabel("0");
		lblVidasNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblVidasNumero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVidasNumero.setForeground(Color.BLACK);
		lblVidasNumero.setBounds(20, 134, 79, 25);
		panelPuntaje.add(lblVidasNumero);
		
		lblPausa = new JLabel("");
		lblPausa.setHorizontalAlignment(SwingConstants.CENTER);
		lblPausa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPausa.setForeground(Color.BLACK);
		lblPausa.setBounds(20, 226, 80, 100);
		panelPuntaje.add(lblPausa);
		
		File archivo = new File(pathMusical);
		PlayMusic p = new PlayMusic(archivo);
		
		btnNewButton = new JButton("|| / >");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.activarYDesactivar();
			}
		});
		btnNewButton.setBounds(20, 446, 80, 39);
		panelPuntaje.add(btnNewButton);
		
		btnNewButton1 = new JButton("Invencible");
		btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton1.setFocusable(false);
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logica.invencible();
				btnNewButton1.setEnabled(false);
			}
		});
		btnNewButton1.setBounds(20, 400, 80, 39);
		panelPuntaje.add(btnNewButton1);
		
		btnNewButton2 = new JButton("Menu");
		btnNewButton2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton2.setFocusable(false);
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.Desactivar();
				Logica juego = new Logica();
				SeleccionTematica a = new SeleccionTematica(juego);
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton2.setBounds(20, 354, 80, 39);
		panelPuntaje.add(btnNewButton2);
		
		btnNewButton3 = new JButton("Menu");
		btnNewButton3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton3.setFocusable(false);
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.Desactivar();
				Logica juego = new Logica();
				SeleccionTematica a = new SeleccionTematica(juego);
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton3.setBounds(279, 445, 80, 39);
		panelVictoria.add(btnNewButton3);
		
		btnNewButton4 = new JButton("Menu");
		btnNewButton4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton4.setFocusable(false);
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.Desactivar();
				Logica juego = new Logica();
				SeleccionTematica a = new SeleccionTematica(juego);
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton4.setBounds(279, 445, 80, 39);
		panelDerrota.add(btnNewButton4);
		layeredPane.add(panelDerrota);
		layeredPane.add(panelVictoria);
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
                    case 80:{
					}
                    case 27:{
                    	logica.pausarJuego();
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
	
	public void actualizarFondo(String direccion) {
		panel.setFondo(direccion); 
	
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


	public void seguir() {
		lblPausa.setText("");
	}
	
	public void pausar() {
		lblPausa.setText("<html>Juego <br/> Pausado <br/> pulse 'p'  <br/> o 'Esc' para continuar  <br/>");
	}


	public void perdiste(int puntaje, int nivel) {
		lblNumeroPuntajeFinalDerrota.setText(""+puntaje);
		layeredPane.removeAll();
		layeredPane.add(panelDerrota);
		layeredPane.repaint();
		layeredPane.revalidate();
		lblnivel.setText("El nivel alcanzado fue el " + nivel);
	}


	public void ganaste(int puntaje) {
		lblNumeroPuntajeFinal.setText(""+puntaje);
		layeredPane.removeAll();
		layeredPane.add(panelVictoria);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}

