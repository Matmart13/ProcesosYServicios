package Servidor;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;

public class HiloContador extends Thread{
	JLabel label;
	public HiloContador(JLabel _label) {
		// TODO Auto-generated constructor stub
		label = _label;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	try {
		int a = 0;
			while(true){
		
			 try {
					a = a +1;	
	                Thread.sleep(1000);
	            }catch(InterruptedException e)    {
	            }

			label.setText(String.valueOf(a));
			}
	}catch(Exception e) {
		label.setText("00:00:00");
	}
	}
}
