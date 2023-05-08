package Servidor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class HiloPelota extends Thread{ 
	JPanel panel;
	int x = 0, y = 0;
	int diametro = 50;
	Color c;
	int incX = 1, incY = 1;
	int longCampoX, longCampoY;
	public HiloPelota(JPanel _panel) {
		// TODO Auto-generated constructor stub
		panel = _panel;
		longCampoX = _panel.getWidth();
		longCampoY = _panel.getHeight();
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
		Graphics g = panel.getGraphics();
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
