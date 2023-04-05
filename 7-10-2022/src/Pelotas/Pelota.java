package Pelotas;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


class Pelota{
	
		int x = 300;
		int inc_x= 1;
		int y  =800;
		int inc_y = 1;
		int diametro = 20;
		int longCampoX,longCampoY;
public Pelota(int _sizeX, int _sizeY, JFrame campo) {
	longCampoX= _sizeX;
	longCampoY = _sizeY;
	x = _sizeX/2;
	y = _sizeY/2;
	diametro = 20;
	Graphics g= campo.getGraphics();
	while(true) {
		
		g.setColor(Color.red);
		g.fillOval(x, y, diametro, diametro);
		}
	}
}