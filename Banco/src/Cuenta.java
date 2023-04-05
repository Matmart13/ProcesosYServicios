
public class Cuenta {
	private int saldo;
	public Cuenta(int s) {
		// TODO Auto-generated constructor stub
		this.saldo = s;
	}
	int getSaldo() {
		return saldo;
	}
	void restar(int cantidad) {
		saldo = saldo - cantidad;
	}
	//Synchronized Para que se sincronice 
	void RetirarDinero(int cant, String nom) {
		if(getSaldo() >= cant) {
			System.out.println(nom + " Se va retirar saldo (Actual es : " + getSaldo() + " )");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
			}
			restar(cant);
			System.out.println("\t" + nom  + " retira => " + cant+ " Actual ( " + getSaldo()+" )");
		}else {
			System.out.println("No se puede retirar dinero , No hay saldo (" + getSaldo()+" )");
		}
		if (getSaldo()  < 0) {
			System.out.println("Ssldo Negativo => " + getSaldo());
		}
	}
}