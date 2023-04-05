package Ejemplo9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;

public class CifraArchivo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String archivoClave = "Clave_secreta.key";
		String archivoOriginal = "foto.jpg";
		String archivoCifrado = "foto.cfr";
		try {
			//Recuperamos clave secreta del Fichero
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream(archivoClave));
			Key clavesecreta = (Key) oin.readObject();
			oin.close();
			//Se define el objeto Cipher
			Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE, clavesecreta);
			
			//Fichero a cifrar
			 FileInputStream filein = new FileInputStream(archivoOriginal);
			 
			 //Objeto CipherOutputStream 
			 CipherOutputStream out = new CipherOutputStream(new FileOutputStream(archivoCifrado), c);
			 int tambloque = c.getBlockSize();
			 byte[] bytes = new byte[tambloque];
			 
			 //Leemos bloques de bytes del fichero PDF 
			 //Y lo vamos escribiendo al cipherOutputStream
			 int i = filein.read(bytes);
			 while (i!= -1){
				out.write(bytes,0,i);
				i = filein.read(bytes);
			}
			 out.flush();
			 out.close();
			 filein.close();
			 System.out.println("Fichero cifrado con clave secreta");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error");
			e.printStackTrace();
		}
	}

}
