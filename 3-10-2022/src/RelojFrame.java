import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class RelojFrame extends JFrame implements Runnable {
	JLabel tiempo;
	Thread hilo;
public RelojFrame()
{
	setTitle("Reloj");
	setSize(200,100);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new BorderLayout());
	
	tiempo = new JLabel("00:00:000");
	tiempo.setHorizontalAlignment(JLabel.CENTER);
	add(tiempo,BorderLayout.CENTER);
	setVisible(true);
	hilo = new Thread(this);
	hilo.start();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RelojFrame();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
	try {
		while(true) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			String horaActual = sdf.format(cal.getTime());
			
			tiempo.setText(horaActual);
		}
	}catch(Exception e) {
		tiempo.setText("00:00:00");
	}
	}

}
