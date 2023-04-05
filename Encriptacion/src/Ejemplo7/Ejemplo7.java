package Ejemplo7;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Ejemplo7 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		String ArchivoClave = "Clave_Secreta.key";
		try {
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			/*
			 * AES 128
			 * DES 56
			 * DESede 169
			 * HmacSHA1
			 * HmacSHA256
			 */
			kg.init(128);
			
			SecretKey clave = kg.generateKey();
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ArchivoClave));
			out.writeObject(clave);
			out.close();
			System.out.println("FIchero clave.secreta creado");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
