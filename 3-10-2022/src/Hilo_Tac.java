
public class Hilo_Tac extends Thread{
	public void run() {
        while (true) {
            System.out.println("Tac");
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e)    {

            }

        }
    }
}
