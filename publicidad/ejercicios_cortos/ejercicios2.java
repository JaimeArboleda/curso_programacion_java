public class ejercicios2 {

    static class Clase {
        String a;
        public Clase(String a) {
            this.a = a;
        }
    }
    
    static void metodo(int entero, String texto, Clase instancia) {
        entero++;
        texto += " HOLA ";
        instancia.a += " HOLA ";
        System.out.println("En metodo:");
        System.out.println(entero);
        System.out.println(texto);
        System.out.println(instancia.a);
    }

    public static void main(String[] args) {
        String texto = "cadena";
        int entero = 4;
        Clase instancia = new Clase(texto);
        metodo(entero, texto, instancia);
        System.out.println("Fuera de metodo:"); 
        System.out.println(entero);
        System.out.println(texto);
        System.out.println(instancia.a);
    }
}
