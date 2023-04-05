import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.FileSystemAlreadyExistsException;

public class Cliente {
    public static void main(String[] args) throws Exception {
        BufferedReader fentrada;
        PrintWriter fsalida;
        String host = "localhost";
        int puerto = 9000;
        Socket Cliente = new Socket(host, puerto);

        // Flujo de Salida y entrada al servidor
        fsalida = new PrintWriter(Cliente.getOutputStream(), true);
        fentrada = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));

        // Flujo para entrada estandar
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String cadena;
        String eco = "";
        do {
            System.out.println("Introduce cadena:");
            cadena = in.readLine();
            fsalida.println(cadena);
            eco = fentrada.readLine();
            System.out.println(" =>Recibido: " + eco);
        } while (!cadena.trim().equals("*")); // El * es fin de conexion
        fsalida.close();
        fentrada.close();
        System.out.println("Fin del envio....");
        in.close();
        Cliente.close();
    }

}
