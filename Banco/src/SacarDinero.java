
public class SacarDinero extends Thread{
private Cuenta c;
public SacarDinero(String n, Cuenta _c ) {
	super(n);
	this.c = _c;
}
public void run() {
	for (int i = 0; i <= 4; i++) {
		c.RetirarDinero(10, getName());
		//Poner sleep si se pone el syncrhonized
		
		}
	}
}
