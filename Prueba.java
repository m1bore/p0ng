package Pong;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;
import java.awt.Color;

public class Prueba extends JFrame {

	private JPanel contentPane;

	
	
	int score=0;
	public int getScore() {
		return score;
	}	
	int score2=0;
	public int getScore2() {
		return score2;
	}	
	
	
	
	//Creamos la pelota/palos y pintamos
		Ball peloto = new Ball(this);
		Stick palo = new Stick(this);
		Stick2 palo2 = new Stick2(this);
	
		
		public void paint(Graphics g) {
		//añadimos super.paint(); para limpiar la pantalla cada vez que repintamos con el bucle
		super.paint(g);
			
		peloto.paint(g);
		palo.paint(g);
		palo2.paint(g);
		//Pintamos el marcador
		g.setColor(Color.GRAY);
		g.setFont(new Font("Verdana", Font.BOLD, 30));
		g.drawString(String.valueOf(getScore()), 400, 50);
		g.drawString(String.valueOf(getScore2()), 40, 50);	
		}
	
	/**
	 * Create the frame.
	 */
	
	public Prueba() {
		
		setTitle("PONG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		Canvas canvas = new Canvas();
		contentPane.add(canvas);
		
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				palo.keyReleased(e);
				palo2.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				palo.keyPressed(e);
				palo2.keyPressed(e);
			}
		});
		setFocusable(true);

	}
	
	
	

	private void move() {
		
		peloto.move();
		palo.move();
		palo2.move();
		
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Prueba prueba = new Prueba();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prueba.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		while (true) {
			
			prueba.move();
			prueba.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
