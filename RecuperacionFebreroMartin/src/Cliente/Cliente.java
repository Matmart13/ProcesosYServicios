package Cliente;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Servidor.Utiles;

public class Cliente extends JFrame implements ActionListener, Runnable {

	private static final long serialVersionUID = 1L;
	Socket socket;
	// streams
	DataInputStream fentrada ;
	DataOutputStream fsalida;
	String nombre;
	String contraseña;
	 JTextField mensaje = new JTextField();

	private JScrollPane scrollpanel;
	static JTextArea textarea1;
	JButton botonEnviar = new JButton("Enviar");
	JButton botonSalir = new JButton("Salir");
	boolean repetir = true;

	// constructor
	public Cliente(Socket s, String nombre, String contraseña) throws NoSuchAlgorithmException {
		super("CONEXION DEL CLIENTE CHAT: " + nombre);
		setLayout(null);

		mensaje.setBounds(10, 10, 400, 30);
		add(mensaje);

		textarea1 = new JTextArea();
		scrollpanel = new JScrollPane(textarea1);
		scrollpanel.setBounds(10, 50, 400, 300);
		add(scrollpanel);

		botonEnviar.setBounds(420, 10, 100, 30);
		add(botonEnviar);
		botonSalir.setBounds(420, 50, 100, 30);
		add(botonSalir);

		textarea1.setEditable(false);
		botonSalir.addActionListener(this);
		botonEnviar.addActionListener(this);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		socket = s;
		this.nombre = nombre;
		this.contraseña = contraseña;
		try {
			fentrada = new DataInputStream(socket.getInputStream());
			fsalida = new DataOutputStream(socket.getOutputStream());
			fsalida.writeUTF(nombre);
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-256");
			// String clave = "1234";
			// Contraseña que se pone
			byte dataBytes[] = contraseña.getBytes();
			md.update(dataBytes);// Se introduce texto a resumir
			// byte resumen[] = md.digest(); //Se calcula el resumen
			byte resumen[] = md.digest(); // Poniendo este nivel se añade mas dificultad para sacar la contraseña
			String contraseñaHex = Hexadecimal(resumen);
			// fsalida2.writeUTF(texto);
			fsalida.writeUTF(contraseñaHex);
			System.out.println(contraseñaHex);
		} catch (IOException e) {
			System.out.println("ERROR DE E/S");
			e.printStackTrace();
			System.exit(0);
		}
	}

	@Override
	public void run() {
		String texto = "";
		while (repetir) {
			try {
				texto = fentrada.readUTF();
				textarea1.setText(texto);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "IMPOSIBLE CONECTAR CON EL SERVIDOR\n" + e.getMessage(),
						"<<MENSAJE DE ERROR:2>>", JOptionPane.ERROR_MESSAGE);
				repetir = false;
			}
			
		}
		try {
			socket.close();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonEnviar) {
			if (mensaje.getText().trim().length() == 0)
				return;
			String texto1 = mensaje.getText();
			try {
				Utiles u = new Utiles();
				byte[] encriptar = encriptarMensaje(texto1);
				String envio = u.ByteArrayTohexString(encriptar);
				mensaje.setText("");
				fsalida.writeUTF(envio);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidKeyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchPaddingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalBlockSizeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BadPaddingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == botonSalir) {
			String texto = " > Abandona el chat ... " + nombre;
			try {
				//fsalida.writeUTF(texto);
				String salir = "*";
				fsalida.writeUTF(salir);
				repetir = false;
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws HeadlessException {
		int puerto = 6000;
		Socket s = null;
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre o nick:");
		String contraseña = JOptionPane.showInputDialog("Pon tu Contraseña");
		if (nombre.trim().length() == 0) {
			System.out.println("El nombre esta vacio.....");
			return;
		}
		if (contraseña.trim().length() == 0) {
			System.out.println("La contraseña esta vacia.....");
			return;
		}

		try {
			s = new Socket("localhost", puerto);
			Cliente cliente = new Cliente(s, nombre, contraseña);
			cliente.setBounds(0, 0, 540, 400);
			cliente.setVisible(true);
			new Thread(cliente).start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR");
		}
	}

	static String Hexadecimal(byte[] resumen) {
		String hex = "";
		for (int i = 0; i < resumen.length; i++) {
			String h = Integer.toHexString(resumen[i] & 0xFF);
			if (h.length() == 1)
				hex += "0";
			hex += h;
		}
		return hex.toUpperCase();
	}
	public byte[] encriptarMensaje(String s) throws FileNotFoundException, IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String clave= "clave_secreta.key";
        ObjectInputStream oin= new ObjectInputStream(new FileInputStream(clave));
        Key clavesecreta= (Key) oin.readObject();
        oin.close();

        Cipher c= Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, clavesecreta);

        byte textoCifrar[]= s.getBytes();
        byte textoCifrado[]=c.doFinal(textoCifrar);
        return textoCifrado;
    }

}
