
public class HiloSimple extends Thread{
public void run () {
	for (int i = 0; i < 5; i++) {
		System.out.println("En el hilo..... " + i);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiloSimple hs = new HiloSimple();
		hs.start();
		for (int i = 0; i < 5; i++) {
			System.out.println("Fuera del hilo.........");
		}
	}

}
