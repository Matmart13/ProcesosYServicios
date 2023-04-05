import java.io.BufferedReader;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread {
    BufferedReader fentrada;
    PrintWriter fsalida;
    Socket socket = null;

    public HiloServidor(Socket s) throws IOException { // CONSTRUCTOR
        socket = s;
        // SE CREAN FLUJOS DE ENTRADA Y SALIDA
        fsalida = new PrintWriter(socket.getOutputStream(), true);
        fentrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run() { // TAREA A REALIZAR CON EL CLIENTE
        System.out.println("COMUNICO CON: " + socket.toString());

        String cadena = "";
        while (!cadena.trim().equals("*")) { // EL INDICA FIN DE CONEXIÓN
            try {
                cadena = fentrada.readLine(); // OBTENER CADENA
                fsalida.println(cadena.trim().toUpperCase()); // ENVIAR MAYÚSCULA
            } catch (IOException e) {
                e.printStackTrace();
            }
        } // FIN WHILE

        System.out.println("FIN CON: " + socket.toString());

        fsalida.close();
        try {
            fentrada.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}