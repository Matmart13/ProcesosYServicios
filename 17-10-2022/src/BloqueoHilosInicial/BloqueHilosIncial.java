package BloqueoHilosInicial;

public class BloqueHilosIncial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjetoCompartido1 cont = new ObjetoCompartido1();
		HilosCadena1 a = new HilosCadena1(cont, "A");
		HilosCadena1 b = new HilosCadena1(cont, "B");
		a.start();
		b.start();
	}

}