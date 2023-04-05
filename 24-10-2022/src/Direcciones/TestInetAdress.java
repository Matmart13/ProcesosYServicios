package Direcciones;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAdress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress dir = null;
		try {
			System.out.println("=================================");
            dir = InetAddress.getByName(args[0]);
            pruebaMetodos (dir);
		} catch (UnknownHostException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void pruebaMetodos(InetAddress _dir) {
		System.out.println("\tMetodo getbyName(): " + _dir);
		
		//Usamos Metodos de la clase
		System.out.println("\tMetodo getHostName() : " + _dir.getHostName());
		System.out.println("\tMetodo getHostAddress() : " + _dir.getHostAddress());
		System.out.println("\tMetodo toString() : " + _dir.toString());
		System.out.println("\tMetodo getCanonicalHostName() : " + _dir.getCanonicalHostName());
		try {
			System.out.println("\tDirecciones Ip para: " + _dir.getHostName());
			InetAddress[] direcciones = 
					InetAddress.getAllByName(_dir.getHostName());
			for (int i = 0; i < direcciones.length; i++) {
				System.out.println("\t\t" + direcciones [i].toString());
			}
		} catch (UnknownHostException e) {
			// TODO: handle exception
			  e.printStackTrace();
		}
	}
}
