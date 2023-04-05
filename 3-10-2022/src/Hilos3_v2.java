
public class Hilos3_v2 extends Thread{

	public Hilos3_v2(String nombre) {
		super(nombre);
		System.out.println("Creamos hilo... " + getName());
	}
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("En el hilo ... " + getName() + " C = " + i);
		}
	}
}
