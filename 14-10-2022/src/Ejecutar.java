/*----------------------------------

Archivo:Ejecutar.java
Descripcion: Este archivo sirve para instanciar los hilos  y ejecutar la apliación

   Fecha   / Autor / Version
   14-10-22/ Martin / 1.0 Versión Inicial
   17-10-22/ Martin / 2.0 Revisión
   
--------------------------------------*/
public class Ejecutar {
	/*
	 * Metodo main
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Instanciacion del Contador
		Contador cont = new Contador(200);
		//Instanciacion de los hilo
		HiloA a = new HiloA("Hilo A", cont);
		HiloB b = new HiloB("Hilo B", cont);
		//Start de los hilos
		a.start();
		b.start();
		System.out.println("El valor es : "+cont.valor());
	}

}
