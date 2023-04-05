package Direcciones;

import java.net.MalformedURLException;
import java.net.URL;

public class Ejemplo1URL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url;
		try {
			System.out.println("Constructor simple para una URL:");
			url = new URL("https://www.google.com/");
			Visualizar(url);
			
			System.out.println("Otro constructor simple para una URL");
			url = new URL("http://localhost/htdocs/Gestión Empresarial");
			Visualizar(url);
			
			System.out.println("Const. para protocolo  + Url  + directorio:");
			url = new URL("http","docs.oracle.com","/javase/9");
			Visualizar(url);
			
			System.out.println("Constructor para protocolo + URl + puerto + directorio");
			url = new URL("http","localhost",8084,"htdocs/Gestión Empresarial");
			Visualizar(url);
		} catch (MalformedURLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	@SuppressWarnings("unused")
	private static void Visualizar( URL _url) {
		System.out.println("\tURL completa: " + _url.toString());
		System.out.println("\tgetProtocol (): " + _url.getProtocol());
		System.out.println("\tgetHost(): " + _url.getHost());
		System.out.println("\tgetPort(): " + _url.getPort());
		System.out.println("\tgetFile(): " + _url.getFile());
		System.out.println("\tgetUserInfo(): " +_url.getUserInfo());
		System.out.println("\tgetPath(): " + _url.getPath());
		System.out.println("\tgetAuthority(): " +_url.getAuthority());
		System.out.println("\tgetQuery(): " + _url.getQuery());
		System.out.println("\tgetDefaultPort(): " + _url.getDefaultPort());
		System.out.println("============================================");
	}

}
