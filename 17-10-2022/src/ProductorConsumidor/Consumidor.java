package ProductorConsumidor;

public class Consumidor extends Thread{
	ColaPutGet cola;
	public Consumidor(ColaPutGet _cola) {
		// TODO Auto-generated constructor stub
		this.cola = _cola;
	}
	public void run() {
		int Valor = 0;
		synchronized (cola) {
		for (int i = 0; i < 5; i++) {
			Valor = cola.get();
			cola.notify();
			System.out.println( "Get valor leido " + Valor );
			try {
				cola.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cola.notify();
		}
		}
	}
}
