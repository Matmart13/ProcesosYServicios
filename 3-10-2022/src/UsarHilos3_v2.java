
public class UsarHilos3_v2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hilos3_v2 h1 = new Hilos3_v2("Hilo 1");
		Hilos3_v2 h2 = new Hilos3_v2("Hilo 2");
		Hilos3_v2 h3 = new Hilos3_v2("Hilo 3");
		h1.start();
		h2.start();
		h3.start();
	}

}
