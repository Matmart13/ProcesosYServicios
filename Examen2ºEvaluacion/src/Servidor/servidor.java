package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Comun.ComunHilos;
import HiloServidor.HiloServidorChat;



public class servidor {
	static int MAXIMO = 50;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int PUERTO=6000;
		
		ServerSocket servidor= new ServerSocket(PUERTO);
		System.out.println("Servidor iniciado...");
		Socket tabla[]= new Socket[MAXIMO];//para controlar las conexiones
		Comun.ComunHilos comun = new ComunHilos(MAXIMO, 0, 0, tabla);
		try {
			while (comun.getCONEXIONES() < MAXIMO){
			    Socket socket = new Socket();
			    socket = servidor.accept();

			  
				comun.addTabla(socket, comun.getCONEXIONES());
			    comun.setACTUALES(comun.getACTUALES() + 1);
			    comun.setCONEXIONES(comun.getCONEXIONES() + 1);
			  
			    comun.setMensajes("Piensa en un numero del 1 al 100\n El numero es el 50" );
			   
			    HiloServidorChat hilo=new HiloServidorChat(socket, comun);
			    hilo.start();
	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	servidor.close();
	}

}
