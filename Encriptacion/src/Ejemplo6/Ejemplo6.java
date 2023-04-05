package Ejemplo6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ejemplo6 {

	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		try {
			InputStream fileout = new FileInputStream("Datos.DAT");
			ObjectInputStream dataOS = new ObjectInputStream(fileout);
			Object o = dataOS.readObject();
			
			
			//Primera lectura
			String datos = (String)o;
			System.out.println("Datos : " + datos);
			
			//Segunda lectura se obtiene el resumen
			o = dataOS.readObject();
			byte resumenOriginal[] = (byte[]) o ;
			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(datos.getBytes());
			byte resumenActual[] = md.digest();
			if(MessageDigest.isEqual(resumenActual, resumenOriginal))
			{
				System.out.println("Datos Validos");
			}else 
			{
				System.out.println("Datos no Validos");	
			}
			dataOS.close();
			fileout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
