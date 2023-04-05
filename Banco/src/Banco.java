
public class Banco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuenta c = new Cuenta(40);
		SacarDinero h1 = new SacarDinero("Martin", c);
		SacarDinero h2 = new SacarDinero("Andrea", c);
		h1.start();
		h2.start();
	}

}
