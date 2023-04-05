package Ejemplo3;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	//@SuppressWarnings({ "removal", "deprecation" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeroPuerto = 6000;
		ServerSocket servidor = null;
		
		System.setProperty("java.security.policy","C:\\Users\\marti\\OneDrive\\DAM\\2ºAÑO\\Procesos y Servicios\\Encriptacion\\Politica4.policy" );
		//System.setSecurityManager(new SecurityManager());
		try {
			servidor = new ServerSocket(numeroPuerto);
			System.out.println("Esperando al cliente...");
			Socket clienteConectado = servidor.accept();
			System.out.println("Cliente Conectado...");
			clienteConectado.close();
			System.out.println("Cliente Desconectado...");
			servidor.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error => " + e.toString());
		}
	}

}
