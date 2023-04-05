
public class HiloEjemploInterrup extends Thread{
	public void run() {
		try {
			while(!isInterrupted()) {
				System.out.println("En el hilo ");
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("Ha ocurrido una excepcion ");
		}
		System.out.println("Fin del hilo");
	}
	public void interrumpir() {
		interrupt();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiloEjemploInterrup h = new HiloEjemploInterrup();
		h.start();
		for (int i = 0; i < 500000000; i++) {}
		for (int i = 0; i < 500000000; i++) {}
		for (int i = 0; i < 500000000; i++) {}
		h.interrumpir();
	}

}