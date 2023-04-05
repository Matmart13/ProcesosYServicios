package HiloServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Comun.ComunHilos;

public class HiloServidorChat extends Thread{
	DataInputStream fentrada;
	Socket socket = null;
	ComunHilos comun;
	
	public HiloServidorChat(Socket s, ComunHilos comun) {
		this.socket = s;
		this.comun = comun;
		try {
			//CREO FLUJO DE ENTRADA PARA LEER LOS MENSAJES
			fentrada = new DataInputStream(socket.getInputStream());
			String cadena = fentrada.readUTF();
			
		} catch (IOException e) {
			System.out.println("ERROR DE E/S");
			e.printStackTrace();
		}
	}
	
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("NUMERO DE CONEXIONES ACTUALES: " +comun.getACTUALES());
	
		//NADA MAS CONECTARSE LE ENVIO TODOS LOS MENSAJES
		String texto = comun.getMensajes();
		EnviarMensajesTodos(texto);
		
		while (true) {
			String cadena="";
			try {
				cadena=fentrada.readUTF();
				if (cadena.trim().equals("*")) {
					comun.setACTUALES(comun.getACTUALES()-1);
					System.out.println("NUMERO DE CONEXIONES ACTUALES: "+comun.getACTUALES());
					break;
				}
				comun.setMensajes(comun.getMensajes()+cadena+"\n");
				EnviarMensajesTodos(comun.getMensajes());
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
		
		//se cierra el socket del cliente
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//ENVIA LOS MENSAJES DEL CHAT A LOS CLIENTES
	private void EnviarMensajesTodos(String texto) {
		int i;
		//recorremos tabla de sockects para enviarles los mensajes
		for (i = 0; i < comun.getCONEXIONES(); i++) {
			Socket s1 = comun.getElementoTabla(i);
			if (!s1.isClosed()) {
				try {
					DataOutputStream fsalida= new DataOutputStream(s1.getOutputStream());
					fsalida.writeUTF(texto);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
