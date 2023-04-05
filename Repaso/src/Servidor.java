
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Servidor  extends JFrame implements KeyListener{
	static final int MAXIMO = 15;// MAXIMO DE CONEXIONES PERMITIDAS
	private static JScrollPane scrollpanel;
	static JTextArea textArea;
	static DataInputStream fentrada;
	
	public Servidor() {
		// TODO Auto-generated constructor stub
		addKeyListener(this);
		setLayout(null);
		JPanel panel = new JPanel();
		getContentPane();
		setFocusable(true);
		panel.setLayout(null);
		
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Servidor");
		textArea = new JTextArea();
		scrollpanel	 = new JScrollPane(textArea);
		scrollpanel.setBounds(30,70,400,200);
		add(scrollpanel);
		setSize(500,600);
		setVisible(true);
	}
	public static void main(String[] args) throws IOException {
		int numeroConexiones = 0;
		int PUERTO = 6000;
		ServerSocket servidor = new ServerSocket(PUERTO);
		System.out.println("Servidor iniciado...");
		new Servidor();
		Socket tabla[] = new Socket[MAXIMO];// para controlar las conexiones

		
		while (numeroConexiones <10) {
			Socket socket = new Socket();
			socket = servidor.accept();
			HiloServidorChat hilo = new HiloServidorChat(socket,textArea);
			hilo.start();
			
			textArea.setText(fentrada.readUTF());
			
		}
		servidor.close();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
