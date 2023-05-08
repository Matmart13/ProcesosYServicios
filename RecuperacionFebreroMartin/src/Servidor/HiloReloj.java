package Servidor;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;

public class HiloReloj extends Thread{
	JLabel tiempo;
	public HiloReloj(JLabel _tiempo) {
		// TODO Auto-generated constructor stub
		tiempo = _tiempo;
	}
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String horaActual = sdf.format(cal.getTime());
				tiempo.setText(horaActual);
				Thread.sleep(200);
			}
		} catch (Exception e) {
			tiempo.setText("00:00:00");
		}
	}
}
