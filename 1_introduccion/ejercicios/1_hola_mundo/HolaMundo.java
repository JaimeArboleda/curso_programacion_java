public class HolaMundo {

    public static void main(String[] args){
        String saludo = "Hola ";
        String defaultName = "Pepe";
        String nombre;
        if (args.length == 0){
            nombre = defaultName;
        } else {
            nombre = args[0];
        }
        System.out.println(saludo + nombre);
    }
}