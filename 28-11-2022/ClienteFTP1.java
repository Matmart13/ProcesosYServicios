import java.io.IOException;
import java.net.SocketException;
import org.apache.commons.net.ftp.*;

public class ClienteFTP1 {
    public static void main(String[] args) throws SocketException, IOException {
        try {
            FTPClient cliente = new FTPClient();
            String servFTP = "ftp.rediris.es"; // servidor FTP

            System.out.println("Nos conectamos a: " + servFTP);
            cliente.connect(servFTP);

            // respuesta del servidor FTP
            System.out.println(cliente.getReplyString());
            // codigo de respuesta
            int respuesta = cliente.getReplyCode();

            System.out.println("Respuesta: " + respuesta);

            // comprobacion del codigo de respuesta
            if (!FTPReply.isPositiveCompletion(respuesta)) {

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
