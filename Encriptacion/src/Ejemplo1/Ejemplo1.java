package Ejemplo1;

public class Ejemplo1 {
/*
 * Para la run configuration
 * Djava.security.policy=Politica1.policy
 */


	@SuppressWarnings({ "removal", "deprecation" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t[] = {"java.class.path","java.home", "java.version","os.name","os.version","java.vendor","user.dir","user.home", "user.name"};
		
		//Gestor de Seguridad:
		System.setSecurityManager(new SecurityManager());
		
		for (int i = 0; i < t.length; i++) {
			System.out.println("Propiedad:" + t[i]);
			try {
				String s = System.getProperty(t[i]);
				System.out.println("\t==> " + s);
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("\n\tExcepcion " + e.toString());
			}
		}
		
	}

}
