package empresa;
import persona.Persona;
import java.util.ArrayList;

public class Empresa {
    String nombre;
    ArrayList<Persona> empleados = new ArrayList<Persona>();

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public void addEmpleado(Persona p) {
        empleados.add(p);
    }

    public String toString() {
        String empleadosTexto = "";
        for (Persona p : empleados) {
            empleadosTexto += p.nombre + " ";
        }
        return "Empresa: " + nombre + "\nEmpleados: " + empleadosTexto;
    }
}
