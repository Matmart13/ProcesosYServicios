import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ejemplo2urlCon {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost/Proceso/28-10-2022/vernombre.php");
            URLConnection conexion = url.openConnection();
            conexion.setDoOutput(true);

            String cadena = "nombre=Martin&apellidos=Mancini";

            // Escribir en la url
            PrintWriter output = new PrintWriter(conexion.getOutputStream());
            output.write(cadena);
            output.close();

            // Leer de la URL = stream de entrada
            BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            reader.close();
        } catch (MalformedURLException e) {
            // TODO: handle exception
            System.out.println("MalformedURLException" + e);
        } catch (IOException ioe) {
            System.out.println("IOexception" + ioe);
        }
    }
}