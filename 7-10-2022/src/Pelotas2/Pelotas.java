package Pelotas2;

import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;

/*----------------------------------

Archivo:Pelotas.java	
Descripcion: En este programa se ejecutara una pantalla que al pulsar cualquier tecla aparecen pelotas de color y tamaño aleatorio en base
			 a programación multihilo.

   Fecha   / Autor / Version
   7-10-22/ Martin / 1.0 Versión Inicial
   14-10-22/Martin/  1.1 Revisión
--------------------------------------*/
/*
 * Clase Pelotas Donde se encuentra el código de la ventana.
 */
public class Pelotas extends JFrame implements KeyListener {
	static int anchoCampo = 1000;
	static int altoCampo = 500;

	public Pelotas() {
		addKeyListener(this);

		setTitle("BOLAS ");
		setSize(anchoCampo, altoCampo);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		P.start();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}