package Ejemplo2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Gestor de Seguridad:
		//System.setSecurityManager(new SecurityManager()); Esto sirve para que no se pueda acceder. 
		try {
			//escritura en fichero 
			BufferedWriter fichero = new BufferedWriter(new FileWriter("ejemplo.txt"));
			fichero.write("Hola andrea");
			fichero.newLine();
			fichero.close();
			System.out.println("Final proceso de escritura...");
			//Lectura en fichero
			
			BufferedReader fichero2 = new BufferedReader(new FileReader("ejemplo.txt"));
			String linea = fichero2.readLine();
			System.out.println("Contenido del fichero: ");
			System.out.println("\t" + linea);
			fichero2.close();
			System.out.println("Final de proceso de lectura...");
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("No se ha encontrado el archivo");
		}catch(IOException e) {
			
		}catch(Exception e) {
			
		}
	}

}
