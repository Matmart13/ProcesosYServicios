package Servidor;

import java.awt.Color;

import java.awt.Font;
import java.io.*;
import java.net.*;
import java.security.NoSuchAlgorithmException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Servidor extends JFrame {
	static final int MAXIMO = 5;//MAXIMO DE CONEXIONES PERMITIDAS	
	//PANEL
	//--------------------------------
	JPanel panel;
    JLabel tiempo;
    static JLabel tiempoConectado;
    Thread hilo;
    
	static JTextField mensaje = new JTextField();
	private JScrollPane scrollpane1;
	static JTextArea textarea1;		
	private JScrollPane scrollpane2;
	static JTextArea textarea2;
	static JPanel areaPelotas;
	
	public Servidor() throws SocketException, NoSuchAlgorithmException, ClassNotFoundException, IOException {
		setLayout(null);
		panel = new JPanel();
		getContentPane();
		//addKeyListener(this);
		setFocusable(true);
		panel.setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Servidor Recuperación");
		
        tiempo = new JLabel( "00:00:000" );
        add( tiempo);		
        tiempo.setFont(new Font("Serif", Font.BOLD, 30));
        tiempo.setBounds(20, 0, tiempo.getPreferredSize().width,  tiempo.getPreferredSize().height);
		
        tiempoConectado = new JLabel( "000" );
        add( tiempoConectado);		
        tiempoConectado.setFont(new Font("Serif", Font.BOLD, 15));
        tiempoConectado.setBounds(300, 0,  tiempoConectado.getPreferredSize().width,  tiempoConectado.getPreferredSize().height);
		
		textarea1 = new JTextArea();
		scrollpane1 = new JScrollPane(textarea1);
		scrollpane1.setBounds(30, 70, 400, 400);
		add(scrollpane1);
		
		textarea2 = new JTextArea();
		scrollpane2 = new JScrollPane(textarea2);
		scrollpane2.setBounds(30, 500, 400, 50);
		add(scrollpane2);
		
		areaPelotas = new JPanel();
		areaPelotas.setBackground(Color.lightGray);
		areaPelotas.setBounds(500, 20, 400, 500);
		add(areaPelotas);
		
        add(panel);
        setSize(950, 600);
		setVisible(true);
		HiloReloj r = new HiloReloj(tiempo);
		r.start();
		HiloFTP ftp = new HiloFTP(textarea2);
		ftp.start();
	}
	
	public static void main(String args[]) throws IOException, NoSuchAlgorithmException, ClassNotFoundException {
		new Servidor();
		int numeroConexiones = 0;
		int PUERTO = 6000;
		ServerSocket servidor = new ServerSocket(PUERTO);

		System.out.println("Servidor iniciado...");
		while (numeroConexiones < 10) {
			Socket socket = new Socket();
			socket = servidor.accept();
			HiloServidor hs = new HiloServidor(socket,textarea1,areaPelotas,tiempoConectado);
			hs.start();
		}
		servidor.close();
	}//main
}//Servidor..  
