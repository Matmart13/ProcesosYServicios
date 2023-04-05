import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPObjetoServidor1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int numeroPuerto = 8000;
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        System.out.println("Esperando al cliente....");
        Socket cliente = servidor.accept();

        // Se prepara un flujo de salida para objeto
        ObjectOutputStream outObject = new ObjectOutputStream(cliente.getOutputStream());

        // Se prepara un objeto y se envia
        Persona per = new Persona("Martin", 20);
        outObject.writeObject(per);
        System.out.println("Envio: " + per.getNombre() + " - " + per.getEdad());

        // Se obtiene un strea, para leer objetos
        ObjectInputStream inObject = new ObjectInputStream(cliente.getInputStream());
        Persona dato = (Persona) inObject.readObject();
        System.out.println("Recibo: " + dato.getNombre() + " - " + dato.getEdad());

        // Cerrar Streams y Sockets
        outObject.close();
        inObject.close();
        cliente.close();
        servidor.close();
    }
}
