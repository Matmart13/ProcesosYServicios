import java.io.Serializable;

public class Persona implements Serializable {
    String nombre;
    int edad;

    public Persona(String _nombre, int _edad) {
        super();
        this.nombre = _nombre;
        this.edad = _edad;
    }

    public Persona() {
        super();
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String _nombre) {
        this.nombre = _nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int _edad) {
        this.edad = _edad;
    }
}
