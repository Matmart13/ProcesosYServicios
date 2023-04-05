package Ejemplo8;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Ejemplo8 {

	public static void main(String[] args) throws NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
		//Se crea el par de claves
		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
			keyGen.initialize(1024);
			KeyPair par = keyGen.generateKeyPair();
			PrivateKey clavepriv = par.getPrivate();
			PublicKey clavepub = par.getPublic();
			
			Cipher c = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			c.init(Cipher.ENCRYPT_MODE, clavepub);
			
			//Ciframos texto 
			byte textoPlano[] = args[0].getBytes();
			byte textoCifrado[] = c.doFinal(textoPlano);
			
			System.out.println("Encriptado : " + new String(textoCifrado));
			
			//Desciframos texto
			c.init(Cipher.DECRYPT_MODE, clavepriv);
			byte desencriptado[] = c.doFinal(textoCifrado);
			System.out.println("Desencriptado: " + new String(desencriptado));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
