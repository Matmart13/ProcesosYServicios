
public class HiloSimple2 implements Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiloSimple2 hs = new HiloSimple2();
		Thread t = new Thread(hs);
		t.start();
		for (int i = 0; i < 5; i++) {
			System.out.println("Fuera del hilo...........");
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			System.out.println("En el hilo............ " + i);
		}
	}

}
