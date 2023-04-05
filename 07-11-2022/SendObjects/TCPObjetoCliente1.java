import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPObjetoCliente1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String host = "localhost";
        int puerto = 8000;
        System.out.println("PROGRAMA CLIENTE INICIADO....");
        Socket cliente = new Socket(host, puerto);

        // Flujo de entrada para objetos
        ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());
        Persona dato = (Persona) perEnt.readObject(); // Recibo objeto
        System.out.println("Recibo: " + dato.getNombre() + " - " + dato.getEdad());

        // Modifico el objeto
        dato.setNombre("Andrea");
        dato.setEdad(22);

        // FLujo de salida para objetos
        ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());
        // Se envia el objeto
        perSal.writeObject(dato);
        System.out.println("Envio: " + dato.getNombre() + " - " + dato.getEdad());

        // Cerrar Streams y Sockets
        perEnt.close();
        perSal.close();
        cliente.close();
    }
}