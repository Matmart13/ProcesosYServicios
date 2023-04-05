/*----------------------------------

Archivo: HiloA.java
Descripcion: Este archivo contiene la programacion del hiloA del ejercicio,
			 que contiene  el constructor y el metodo run del hilo.

   Fecha   / Autor / Version
   14-10-22/ Martin / 1.0 Versión Inicial
   17-10-22/ Martin / 2.0 Revisión 
   
--------------------------------------*/
public class HiloA extends Thread{
  //Variables
   private Object Contador ;
   private Contador c;
   private  String n ;
   /*
    * Constructor que pide un String para el nombre y un Contador
    */
	  public HiloA (String n, Contador c){
		  this.n = n;
		  this.c = c;
	  }
	  @Override
	  /*
	   * Metodo run que sirve para ejecutar el hilo 
	   */
		public void run() {
			// TODO Auto-generated method stub
		  	
		  	try {
		  		for (int i = 0; i < 100; i++) {
		  			//c.incrementa(); Ejercicio anterior
		  			c.decrementa();
		  			System.out.println(c.valor());
			  		Thread.sleep(100);
			  		
				}
	
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Se ha producido una excepcion");
			}
	  }
}
