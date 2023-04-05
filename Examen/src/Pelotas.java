import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JFrame;
/*----------------------------------

Archivo: Pelotas.java
Descripcion:Este programa ejecuta una ventana con un reloj y al pulsar el 1 sale una pelota y al pulsar el 2 salen dos pelotas.

   Fecha   / Autor / Version
   18-11-22/ Martin / 1.0 Versión Inicial

--------------------------------------*/
import javax.swing.JLabel;

public class Pelotas extends JFrame implements KeyListener {
	static int anchoCampo = 1000;
	static int altoCampo = 500;
	JLabel tiempo;
	public Pelotas() {
	
		addKeyListener(this);
		setTitle("BOLAS ");
		setSize(anchoCampo, altoCampo);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		tiempo = new JLabel("00:00:000");
		tiempo.setHorizontalAlignment(JLabel.CENTER);
		add(tiempo,BorderLayout.CENTER);
		setVisible(true);

	}

	/*
	 * Clase Pelota: Esta todo el codigo de la realizacion de la pelota con el run
	 */
	class Pelota extends Thread {
		int x = 0, y = 0;
		int diametro = 50;
		Color c;
		int incX = 1, incY = 1;
		int longCampoX, longCampoY;

		public Pelota(int sizeX, int sizeY) {
			longCampoX = sizeX;
			longCampoY = sizeY;
			Random randomGeneretator = new Random();
			x = randomGeneretator.nextInt(longCampoX);
			y = randomGeneretator.nextInt(longCampoY);
			diametro = randomGeneretator.nextInt(100);
			c = GeneraColorAletorio();

		}

		public Color GeneraColorAletorio() {
			Random randomGeneretator = new Random();
			int red = randomGeneretator.nextInt(256);
			int green = randomGeneretator.nextInt(256);
			int blue = randomGeneretator.nextInt(256);
			Color randomColor = new Color(red, green, blue);
			return randomColor;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			Graphics g = getGraphics();
			while (true) {
				g.setColor(Color.white);
				g.fillOval(x, y, diametro, diametro);
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String horaActual = sdf.format(cal.getTime());
				
				tiempo.setText(horaActual);
				x += incX;
				y += incY;
				g.setColor(c);
				g.fillOval(x, y, diametro, diametro);

				if (x == 0 || x == longCampoX - diametro) {
					incX = -incX;
				}
				if (y == 0 || y == longCampoY - diametro) {
					incY = -incY;
				}

				try {

					Thread.sleep(5);
				} catch (Exception e) {
					// TODO: handle exception
					tiempo.setText("00:00:00");
				}
				
				}
			}
	
		}

	

	/*
	 * Método Main
	 */
	public static void main(String[] args) {
		new Pelotas();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	

	}


	/*
	 * Metodo que sirve para que al tocar la tecla aparezca una pelota es decir se
	 * encuentra la instaciación de Pelota.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Pelota P = new Pelota(anchoCampo, altoCampo);
		Pelota C = new Pelota(anchoCampo, altoCampo);
		if( e.getKeyCode() == KeyEvent.VK_1) {
			P.start();
		}else if (e.getKeyCode() == KeyEvent.VK_2) {
			P.start();
			C.start();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
}
