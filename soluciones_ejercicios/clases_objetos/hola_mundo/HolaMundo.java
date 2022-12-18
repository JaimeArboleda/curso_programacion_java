public class HolaMundo {
    String saludo = "Hola ";
    String defaultName = "Pepe";
    String nombre;

    public HolaMundo() {
        this.nombre = defaultName;
    }

    public HolaMundo(String nombre) {
        this.nombre = nombre;
    }

    public String hacerSaludo() {
        return saludo + nombre;
    } 

    public static void main(String[] args){
        HolaMundo holaMundo;
        if (args.length == 0){
            holaMundo = new HolaMundo();
        } else {
            holaMundo = new HolaMundo(args[0]);
        }
        System.out.println(holaMundo.hacerSaludo());
    }
}