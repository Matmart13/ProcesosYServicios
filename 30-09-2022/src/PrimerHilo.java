
public class PrimerHilo extends Thread{
	private int x;
	public PrimerHilo(int x) {
		// TODO Auto-generated constructor stub
		this.x=x;
		
	}

	public void run() {
		for (int i = 0; i < x; i++) {
			System.out.println("Estamos en hilo " + i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimerHilo p = new PrimerHilo (150);
		p.start();
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
		System.out.println("a");
	}

}
