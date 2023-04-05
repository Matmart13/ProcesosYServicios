package ProductorConsumidor;

public class ColaPutGet {
 int numero ;
 boolean disponible = false;
 
 	int get () {
 		if (disponible ) {
 			disponible = false;
 			return numero;
 		}else {
 			return 999;
 		}
 	}
 	void Put (int valor){
 		numero = valor;
 		disponible = true;
 	}
}