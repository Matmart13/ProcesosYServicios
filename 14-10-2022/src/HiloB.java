/*----------------------------------

Archivo:HiloB.java
Descripcion: Este archivo contiene la programación de otro hilo y realiza una tarea 
			 diferente que el archivo HiloA.java, contiene la programacion del constructor
			 y del méotodo run.

   Fecha   / Autor / Version
   14-10-22/ Martin / 1.0 Versión Inicial
   17-10-22/ Martin / 2.0 Revisión 
   
--------------------------------------*/

public class HiloB extends Thread{
	// Variables
	private String n;
	private Contador c;
	/*
	 * Constructor que pide un String y un Contador
	 */
	public HiloB(String n, Contador c){
		this.n = n;
		this.c = c;
	}
	/*
	 * Metodo run que ejecuta el hilo 
	 */
	public void run() {
		try {
		for (int i = 0; i < 100; i++) {
			c.decrementa();
			System.out.println(c.valor());
			Thread.sleep(100);
		}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Se ha producido una excepcion");
		}
	}
		
		
}
