package Proveedores;

import java.security.Provider;
import java.security.Security;

public class InfoProveedores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------");
		System.out.println("Proveedores instalados en el sistema");
		System.out.println("------------------------------------");
		Provider [] listaProv = Security.getProviders();
		for (int i = 0; i < listaProv.length; i++) {
			System.out.println("Num. proveedor " + (i+1));
			System.out.println("Nombre        : " + listaProv[i].getName());
			System.out.println("Version       : " + listaProv[i].getVersion());
			System.out.println("Informacion   : " + listaProv[i].getInfo());
			System.out.println("---------------------------------------------------------");
		}
	}

}
