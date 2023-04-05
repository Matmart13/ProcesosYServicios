
public class HiloEjemplo2_2 extends Thread{
public void run () {
	Thread.currentThread();
	System.out.println(
			"Dentro del hilo :" + Thread.currentThread().getName()+
			"\nPrioridad     :" + Thread.currentThread().getPriority()+
			"\nId            :" + Thread.currentThread().getId() +
			"\nHilos activos :" + Thread.activeCount()
			
			);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread.currentThread().setName("Principal");
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().toString());
		
		HiloEjemplo2_2 h1 = new HiloEjemplo2_2(); // crear hilo
		HiloEjemplo2_2 h2 = new HiloEjemplo2_2(); // crear hilo
		HiloEjemplo2_2 h3 = new HiloEjemplo2_2(); // crear hilo
		
		h1.setName("HILO 1");
		h2.setName("HILO 2");
		h3.setName("HILO 3");
		
		h1.setPriority(3);
		h2.setPriority(2);
		h3.setPriority(1);
		
		h1.start();
		h2.start();
		h3.start();
		System.out.println("Informacion del " + h1.getName() + " : " + h1.toString());
		System.out.println("Informacion del " + h2.getName() + " : " + h2.toString());
		System.out.println("Informacion del " + h3.getName() + " : " + h3.toString());
		
		System.out.println("3 HILOS CREADOS....");
		System.out.println("Hilos activos: " + Thread.activeCount());
	}

}
