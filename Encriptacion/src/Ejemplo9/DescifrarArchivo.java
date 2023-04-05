package Ejemplo9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

public class DescifrarArchivo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String archivoClave = "Clave_secreta.key";
		String archivoCifrado = "foto.cfr";
		String archivoOriginal = "foto.png";
		try {
			//Recumperamos clave secreta del fichero
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream(archivoClave));
			Key clavesecreta = (Key)oin.readObject();
			oin.close();
			
			//
			Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
			c.init(Cipher.DECRYPT_MODE, clavesecreta);
			CipherInputStream in = new CipherInputStream(new FileInputStream(archivoCifrado), c);
			int tambloque = c.getBlockSize();
			byte[] bytes = new byte[tambloque];
			int i = in.read(bytes);
			FileOutputStream fileout = new FileOutputStream(archivoOriginal);
			while(i!=-1) {
				fileout.write(bytes,0,i);
				i = in.read(bytes);
			}
			fileout.close();
			in.close();
			System.out.println("Fichero descifrado con clave secreta");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error");
			e.printStackTrace();
		}
	}

}
