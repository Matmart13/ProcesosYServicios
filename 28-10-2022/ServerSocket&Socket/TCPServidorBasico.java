
import java.net.ServerSocket;

class TCPServidorBasico {
    public static void main(String[] args) throws IOException {
        int Puerto = 6000;// Puerto
        ServerSocket Servidor = new ServerSocket(Puerto);

        System.out.println("Escuchando en " + Servidor.getLocalPort());
        Socket cliente1 = Servidor.accept();// Esperando a un cliente
        // realizar acciones con cliente1
        System.out.println("Esperando segunda conexion");
        Socket cliente2 = Servidor.accept();
        // realizar acciones con cliente2
        System.out.println("Fin");
        Servidor.close();// Cierro socket servidor
    }
}
