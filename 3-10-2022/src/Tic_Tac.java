
public class Tic_Tac extends Thread{
	public void run() {
		while(true) {
			System.out.println("TIC");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Primer hilo 
		Tic_Tac hilo1 = new Tic_Tac();
		hilo1.start();
		
		//Segundo hilo
		Hilo_Tac hilo2 = new Hilo_Tac();
		hilo2.start();
	}

}
