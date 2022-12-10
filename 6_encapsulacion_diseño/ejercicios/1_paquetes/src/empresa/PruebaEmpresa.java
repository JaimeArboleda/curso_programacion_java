package empresa;
import empresa.Empresa;
import persona.Persona;

public class PruebaEmpresa {
    public static void main(String[] args) {
        Persona p = new Persona("Pepe");
        Empresa e = new Empresa("Mercadona");
        e.addEmpleado(p);
        System.out.println(e.toString());
    }
}
