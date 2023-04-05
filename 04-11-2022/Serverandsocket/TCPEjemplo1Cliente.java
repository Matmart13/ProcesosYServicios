import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class TCPEjemplo1Cliente {
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int Puerto = 7000;

        System.out.println("Programa cliente iniciado....");
        Socket Cliente = new Socket(host, Puerto);

        // Creo Flujo de Salida al servidor
        DataOutputStream flujosalida = new DataOutputStream(Cliente.getOutputStream());

        // Enivo un Saludo al servidor
        flujosalida.writeUTF("Saludos al servidor desde el cliente");

        // Creo flujo de entrada al servidor

        DataInputStream flujoentrada = new DataInputStream(Cliente.getInputStream());

        // El servidor me envia un mensaje

        System.out.println("Recibiendo del Servidor: \n\t" + flujoentrada.readUTF());

        // Cerrar Streams y sockets
        flujoentrada.close();
        flujosalida.close();
        Cliente.close();
    }
}
