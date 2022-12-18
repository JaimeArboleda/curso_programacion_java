import java.util.Scanner;  // Import the Scanner class

public class InputOutput {
    public static void main(String[] args){
        boolean exit = false;
        while(!exit){
            Scanner textoEntrada = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Escribe una frase... Teclea Q para salir");
            String frase = textoEntrada.nextLine();  // Read user input
            if(!frase.equals("Q")){
                System.out.println("La frase en mayúsculas es: \n" + frase.toUpperCase());  // Output user input
            } else{
                System.out.println("Saliendo...");
                exit = true;
            }
        }
    }
}
