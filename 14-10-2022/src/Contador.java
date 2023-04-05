/*----------------------------------

Archivo:Contador.java
Descripcion: En este archivo se encuentran los metodos que hacen funcionar al contador
			 el método incrementar, decrementar y valor. 

   Fecha   / Autor / Version
   14-10-22/ Martin / 1.0 Versión Inicial
   17-10-22/ Martin / 2.0 Revisión 
   
--------------------------------------*/
public class Contador {
	//variable
	int c;
	/*
	 * Constructor de la clase que pide un entero.
	 */
	public Contador(int c ) {
		// TODO Auto-generated constructor stub
		this.c=c;
	}
	/*
	 * Metodo incrementa sirve para incrementar el valor del contador
	 */
	public  void incrementa() {
		c++;
		System.out.println("Incrementa");
	}
	// synchronized sirve para sincronizar los hilos 
	/*
	 * Metodo decrementa sirve para decrementar el valor del contador
	 */
	public synchronized  void decrementa() {
		c--;
		System.out.println("Decrementa");
	}
	/*
	 * Metodo valor sirve para devolver el valor del contador
	 */
	public synchronized int valor() {
		return c;
	}
}