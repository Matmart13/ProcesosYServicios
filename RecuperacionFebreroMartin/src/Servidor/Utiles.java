package Servidor;

public class Utiles {
	// CONVIERTE UN ARRAY DE BYTES A HEXADECIMAL
		//------------------------------------------
		public String ByteArrayTohexString(byte[] resumen) {
			String hex = "";
			for (int i = 0; i < resumen.length; i++) {
				String h = Integer.toHexString(resumen[i] & 0xFF);
				if (h.length() == 1)
					hex += "0";
				hex += h;
			}
			return hex.toUpperCase();
		}// Hexadecimal
		
		/* s must be an even-length string. */
		public byte[] hexStringToByteArray(String s) {
		    int len = s.length();
		    byte[] data = new byte[len / 2];
		    for (int i = 0; i < len; i += 2) {
		        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
		                             + Character.digit(s.charAt(i+1), 16));
		    }
		    return data;
		}	
}
