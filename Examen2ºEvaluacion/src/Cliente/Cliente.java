package Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cliente  extends JFrame implements ActionListener, Runnable{
	private static final long serialVersionUID=1L;
	Socket socket;
	//streams
	DataInputStream fentrada;
	DataOutputStream fsalida;
	String nombre;

	private JScrollPane scrollpanel;
	static JTextArea textarea1;
	JButton botonSalir = new JButton("Salir");
	JButton botonMayor = new JButton("Mayor");
	JButton botonMenor = new JButton("Menor");
	JButton botonAcertaste = new JButton("Acertaste");
	
	boolean repetir = true;
	int numero =0;
	//constructor
	public Cliente(Socket s, String nombre) {
		super("CONEXION DEL CLIENTE CHAT: "+nombre);
		setLayout(null);
		
		
		textarea1 = new JTextArea();
		scrollpanel=new JScrollPane(textarea1);
		scrollpanel.setBounds(10,50,400,300);
		add(scrollpanel);

 
        botonSalir.setBounds(420,180,100,30);
        add(botonSalir);
        botonMayor.setBounds(420,40,100,30);
        add(botonMayor);
        botonMenor.setBounds(420,80,100,30);
        add(botonMenor);
        botonAcertaste.setBounds(420,110,100,30);
        add(botonAcertaste);
        textarea1.setEditable(false);
        botonSalir.addActionListener(this);
        botonAcertaste.addActionListener(this);
        botonMayor.addActionListener(this);
        botonMenor.addActionListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        socket = s;
        this.nombre=nombre;
        try {
			fentrada=new DataInputStream(socket.getInputStream());
			fsalida=new DataOutputStream(socket.getOutputStream());

		} catch (IOException e) {
			System.out.println("ERROR DE E/S");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	@Override
	public void run() {
		String texto = "";
        while (repetir){
            try{
                texto = fentrada.readUTF();
                textarea1.setText(texto);
            }catch (IOException e){
                JOptionPane.showMessageDialog(null,"IMPOSIBLE CONECTAR CON EL SERVIDOR\n" + e.getMessage(),
                        "<<MENSAJE DE ERROR:2>>",JOptionPane.ERROR_MESSAGE);
                repetir = false;

        }
    }
        try {
            socket.close();
            System.exit(0);
        }catch (IOException e){
            e.printStackTrace();
        }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int inicial = 50;
		int min = 1;
		int max = 100;
		if (e.getSource()==botonSalir) {
			try {
				
				fsalida.writeUTF("*");
				repetir=false;
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		if(e.getSource()== botonAcertaste) {
			try {
				fsalida.writeUTF("Toma he acertado");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == botonMayor) {
			try {
				fsalida.writeUTF("\nEl numero es mayor");
				 numero = inicial * (int)(Math.random() * max);
				fsalida.writeUTF(String.valueOf(numero));
				inicial = numero;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == botonMenor) {
			try {
				fsalida.writeUTF("\nEl numero es menor");
				 numero = min * (int)(Math.random() * inicial);
				fsalida.writeUTF(String.valueOf(numero));
				 inicial = numero;
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		int puerto = 6000;
		Socket s=null;
		
		String nombre=JOptionPane.showInputDialog("Introduce tu nombre o nick:");
		
		if (nombre.trim().length()==0) {
			System.out.println("El nombre esta vacio.....");
			return;
		}
		
		try {
			s=new Socket("localhost", puerto);
			Cliente cliente = new Cliente(s, nombre);
			cliente.setBounds(0,0,540,400);
			cliente.setVisible(true);
			new Thread(cliente).start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
		}
	}
}


