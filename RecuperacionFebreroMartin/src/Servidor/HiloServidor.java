package Servidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import Servidor.Utiles;

public class HiloServidor extends Thread {

	DataInputStream fentrada;
	DataOutputStream fsalida;
	Socket socket = null;
	JTextArea j;
	JPanel pelota;
	JLabel tiempo;
	HiloContador hc ;

	public HiloServidor(Socket s, JTextArea j,JPanel _pelota, JLabel tiempo) {
		this.socket = s;
		this.j = j;
		this.pelota = _pelota;
		this.tiempo = tiempo;
		try {
			// CREO FLUJO DE ENTRADA PARA LEER LOS MENSAJES
			fentrada = new DataInputStream(socket.getInputStream());
			String cadena = "";
			cadena = fentrada.readUTF();
			URL miUrl = new URL("http://localhost/htdocs/Procesos/Recu/claves_bbdd.php?nombre="+ cadena);
			// URL miUrl = new
			// URL("https://gs.litterator.info/php/prueba_conexion_com_servidor.php");
			j.setText("" + miUrl.toString());
			HttpURLConnection miHtp = (HttpURLConnection) miUrl.openConnection();
			miHtp.setRequestMethod("GET");
			InputStream miEntrada = miHtp.getInputStream();
			InputStreamReader miLector = new InputStreamReader(miEntrada);
			BufferedReader miBufferLector = new BufferedReader(miLector);
			String Linea = miBufferLector.readLine().toString();
			if(Linea.equals("ERROR")){
				j.setText("Error");
			}else {
				j.setText("Contraseña");
			}
			Thread.sleep(1000);
			cadena ="";
			cadena = fentrada.readUTF();
			if (cadena.equals(Linea)) {
				j.setText("Es correcto");
			} else {
				j.setText("No es Correcto");
			}
			hc= new HiloContador(tiempo);
			hc.start();

		} catch (Exception e) {
			System.out.println("ERROR DE E/S");
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
            String cadena="";
            try {
                cadena=fentrada.readUTF();
                Utiles u = new Utiles();
                byte [] recibir = u.hexStringToByteArray(cadena);
                String desencriptado = desencriptar(recibir);
                try {
                    DataOutputStream fsalida = new DataOutputStream(socket.getOutputStream());
                    if (cadena.equals("*")){
                    	hc.label.setText("0");
                    	break;
                    }
                    if(desencriptado.equals("pelota")) {
                    	HiloPelota hp = new HiloPelota(pelota);
                    	hp.start();
                    	 j.append("\n"+desencriptado);
                    }
                        j.setText("");
                        j.append("\n"+desencriptado);
                       fsalida.writeUTF(desencriptado);
                    }catch (IOException e) {
                    e.printStackTrace();
                }
                } catch (Exception e) {
                e.printStackTrace();
                break;
            }
            	
        }

		// se cierra el socket del cliente

	}

	public String desencriptar(byte[] s) throws FileNotFoundException, IOException, ClassNotFoundException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        
		String clave= "clave_secreta.key";
        ObjectInputStream oin= new ObjectInputStream(new FileInputStream(clave));
        Key clavesecreta= (Key) oin.readObject();
        oin.close();

        Cipher c= Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, clavesecreta);
        byte textoDescifrado[]=c.doFinal(s);
        String result= new String(textoDescifrado);
        return result;
    }
}
