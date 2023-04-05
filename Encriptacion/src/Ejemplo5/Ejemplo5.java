package Ejemplo5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ejemplo5 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fileout = new FileOutputStream("Datos.DAT");
			ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			String datos = "Hola buenos dias";
			byte dataBytes[] = datos.getBytes();
			md.update(dataBytes);
			byte resumen[] = md.digest();
			dataOS.writeObject(datos);
			dataOS.writeObject(resumen);
			dataOS.close();
			fileout.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}catch(NoSuchFieldError e) {
			e.printStackTrace();
		}
	}

}
