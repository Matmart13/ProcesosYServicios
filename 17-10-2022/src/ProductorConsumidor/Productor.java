package ProductorConsumidor;

public class Productor extends Thread{

	ColaPutGet cola = new ColaPutGet();
	int n;
	public Productor(ColaPutGet _cola ) {
		// TODO Auto-generated constructor stub
		this.cola = _cola;
	}
	public void run() {
		synchronized( 	cola) {
		for (int i = 0; i < 5; i++) {
			cola.Put(i);
			cola.notify();
			System.out.println("Se hace un put con valor  " + i );
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
