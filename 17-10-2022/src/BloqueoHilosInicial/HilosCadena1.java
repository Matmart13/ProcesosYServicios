package BloqueoHilosInicial;

public class HilosCadena1 extends Thread{
	private ObjetoCompartido1 objeto;
	String cad;
	public HilosCadena1(ObjetoCompartido1 _obj, String _cad) {
		// TODO Auto-generated constructor stub
		this.objeto = _obj;
		this.cad = _cad;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		synchronized  (objeto) {
			for (int i = 0; i < 10; i++) {
				objeto.PintaCadena(cad);
				objeto.notify(); // aviso que ya he usado el objeto 
				try {
					objeto.wait(); // esperar a que llegue un notify 
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				objeto.notify();
			}
			
		}
		System.out.println("\n" + cad + " finalizado");
	}
}
