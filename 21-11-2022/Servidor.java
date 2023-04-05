
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import multiplesHilos.HiloServidor;

public class Servidor {
	static final int MAXIMO = 15;// MAXIMO DE CONEXIONES PERMITIDAS

	public static void main(String[] args) throws IOException {
		int PUERTO = 6000;

		ServerSocket servidor = new ServerSocket(PUERTO);
		System.out.println("Servidor iniciado...");

		Socket tabla[] = new Socket[MAXIMO];// para controlar las conexiones
		ComunHilos comun = new ComunHilos(MAXIMO, 0, 0, tabla);

		while (comun.getCONEXIONES() < MAXIMO) {
			Socket socket = new Socket();
			socket = servidor.accept();

			comun.addTabla(socket, comun.getCONEXIONES());
			comun.setACTUALES(comun.getACTUALES() + 1);
			comun.setCONEXIONES(comun.getCONEXIONES() + 1);

			HiloServidorChat hilo = new HiloServidorChat(socket, comun);
			hilo.start();
		}
		servidor.close();

	}

}
