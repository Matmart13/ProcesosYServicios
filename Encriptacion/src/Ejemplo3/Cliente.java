package Ejemplo3;

import java.net.Socket;

public class Cliente {

	//@SuppressWarnings({ "removal", "deprecation" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Host = "localhost";
		int Puerto = 6500;
		//System.setSecurityManager(new SecurityManager());
		try {
			Socket Cliente = new Socket(Host,Puerto);
			System.out.println("Cliente Iniciado..");
			Cliente.close();
			System.out.println("Cliente Finalizado");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error => " + e.toString());
		}
	}

}
