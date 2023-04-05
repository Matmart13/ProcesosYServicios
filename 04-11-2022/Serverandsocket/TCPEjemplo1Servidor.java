import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEjemplo1Servidor {
    public static void main(String[] args) throws IOException {
        int numeroPuerto = 7000;
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        Socket clienteConectado = null;
        System.out.println("Esperando al cliente....");
        clienteConectado = servidor.accept();

        // CREO FLUJO DE ENTRADA DEL CLIENTE
        InputStream entrada = null;
        entrada = clienteConectado.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);

        // EL CLIENTE ME ENVIA UN MENSAJE
        System.out.println("Recibiendo del Cliente: \n\t" + flujoEntrada.readUTF());

        // CREO FLUJO DE SALIDA AL CLIENTE
        OutputStream salida = null;
        salida = clienteConectado.getOutputStream();
        DataOutputStream flujosalida = new DataOutputStream(salida);

        // ENVIO UN SALUDO AL CLIENTE
        flujosalida.writeUTF("SALUDOS AL CLIENTE DEL SERVIDOR");

        // CERRAR STREAMS Y SOCKETS
        entrada.close();
        flujoEntrada.close();
        salida.close();
        flujosalida.close();
        clienteConectado.close();
        servidor.close();
    }// MAIN
}// FIN
