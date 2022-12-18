class Cesar {
    public static final String ALFABETO = "abcdefghijklmnñopqrstuvwxyz ,.";   
    public int clave;

    public Cesar(int clave) {
        this.clave = clave;
    }

    public String cifrar(String input) {
        String lowerInput = input.toLowerCase();
        String salidaCifrada = "";
        for (int i = 0; i < lowerInput.length(); i++) {   
            int posLetra = ALFABETO.indexOf(lowerInput.charAt(i));   
            int posCodificada = (clave + posLetra) % ALFABETO.length();   
            char letraCodificada = ALFABETO.charAt(posCodificada);   
            
            // add encrypted char to encrypted string   
            salidaCifrada += letraCodificada;   
        }   
        return salidaCifrada;
    }

    public String descifrar(String input) {
        String salidaDecodificada = "";
        for (int i = 0; i < input.length(); i++) {   
            int posLetra = ALFABETO.indexOf(input.charAt(i));   
            int posDecodificada = (-clave + posLetra) % ALFABETO.length();   
            if (posDecodificada < 0) {
                posDecodificada += ALFABETO.length();
            }
            char letraDecodificada = ALFABETO.charAt(posDecodificada);   
            
            // add encrypted char to encrypted string   
            salidaDecodificada += letraDecodificada;   
        }   
        return salidaDecodificada;
    }

}
public class Main {
    public static void main(String[] args) {
        Cesar cesar = new Cesar(4);
        String input = "Hola, Zutano";
        String salida = cesar.cifrar(input);
        String check = cesar.descifrar(salida);
        System.out.println(salida);
        System.out.println(check);
    }
}
