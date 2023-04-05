
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextArea;

public class HiloServidorChat extends Thread {
	DataInputStream fentrada;
	Socket socket = null;
	JTextArea j;
	public HiloServidorChat(Socket s, JTextArea j) {
		this.socket = s;
		this.j = j;
		try {
			// CREO FLUJO DE ENTRADA PARA LEER LOS MENSAJES
			fentrada = new DataInputStream(socket.getInputStream());
			String cadena = "";
			cadena = fentrada.readUTF();
			j.setText(cadena);
			
		} catch (IOException e) {
			System.out.println("ERROR DE E/S");
			e.printStackTrace();
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		j.append("Estoy en el run");
		while (true) {
			String cadena = "";
			try {
				cadena = fentrada.readUTF();
				
				if (cadena.trim().equals("*")) {
					break;
				}else {
					j.setText(cadena + "\n");
				}

			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}

		// se cierra el socket del cliente
	
	}
}
