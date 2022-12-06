import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 

class Mochila {
    ArrayList<Character> elementos = new ArrayList<Character>();

    public Mochila(char[] elementos){
        for(char c : elementos){
            this.elementos.add(c);
        }
    }

    public HashSet<Character> encuentraDuplicados(){
        int numElementos = elementos.size();
        int numElementosPorCompartimento = numElementos / 2;
        HashSet<Character> compartimento1 = new HashSet<Character>();
        HashSet<Character> compartimento2 = new HashSet<Character>();
        compartimento1.addAll(elementos.subList(0, numElementosPorCompartimento));
        compartimento2.addAll(elementos.subList(numElementosPorCompartimento, numElementos));
        compartimento1.retainAll(compartimento2); // Ahora compartimento1 tiene la intersección
        return compartimento1;
    }

    public int puntuaDuplicados(){
        int puntuacion = 0;
        HashSet<Character> duplicados = encuentraDuplicados();
        for(char c: duplicados){
            if(Character.isLowerCase(c)){
                puntuacion += c - 'a' + 1;
            } else {
                puntuacion += c - 'A' + 27;
            }
        }
        return puntuacion;
    }
}

public class RuckSack {
    
    public static void main(String[] args){
        int puntuacionTotal = 0;
        int numLines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() != 0){
                    numLines++;
                    char[] letras = line.toCharArray();
                    Mochila mochila = new Mochila(letras);
                    puntuacionTotal += mochila.puntuaDuplicados();
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("La puntuacion total es " + puntuacionTotal);
        System.out.println("Total líneas leídas es " + numLines);
    }
}
