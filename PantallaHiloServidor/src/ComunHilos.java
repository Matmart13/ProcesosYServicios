
import java.net.Socket;

public class ComunHilos {

	int CONEXIONES; //N� DE CONEXIONES TOTALES, OCUPADAS EN EL ARRAY
	int ACTUALES; //N� DE CONEXIONES ACTUALES
	int MAXIMO; //N� DE CONEXIONES PERMITIDAS
	Socket tabla[] = new Socket[MAXIMO]; //Sockets conectados
	String mensajes; //Mensaes del chat
	
	public ComunHilos(int maximo, int actuales, int conexiones, Socket[] tabla){
        MAXIMO = maximo;
        ACTUALES = actuales;
        CONEXIONES = conexiones;
        this.tabla = tabla;
        mensajes="";
    }
	
	public ComunHilos(){
		super();
	}

	public int getCONEXIONES() {
		return CONEXIONES;
	}

	public synchronized void setCONEXIONES(int conexiones) {
		CONEXIONES = conexiones;
	}

	public int getACTUALES() {
		return ACTUALES;
	}

	public synchronized void setACTUALES(int actuales) {
		ACTUALES = actuales;
	}

	public int getMAXIMO() {
		return MAXIMO;
	}

	public synchronized void setMAXIMO(int maximo) {
		MAXIMO = maximo;
	}

	public String getMensajes() {
		return mensajes;
	}

	public synchronized void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}
	
	public synchronized void addTabla(Socket s, int i) {
		tabla[i]=s;
	}
	
	public Socket getElementoTabla(int i) {
		return tabla[i];
	}
	
}
