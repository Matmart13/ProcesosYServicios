
public class Hilos3 extends Thread{

	public Hilos3(String nombre) {
		super(nombre);
		System.out.println("Creamos hilo... " + getName());
	}
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("En el hilo ... " + getName() + "C = " + i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hilos3 h1 = new Hilos3("Hilo 1");
		Hilos3 h2 = new Hilos3("Hilo 2");
		Hilos3 h3 = new Hilos3("Hilo 3");
		h1.start();
		h2.start();
		h3.start();
	}

}
