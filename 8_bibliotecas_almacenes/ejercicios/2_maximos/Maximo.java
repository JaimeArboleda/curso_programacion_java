import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 
import java.util.*;

public class Maximo {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> listas = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        listas.add(current);

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() == 0){
                    current = new ArrayList<Integer>();
                    listas.add(current);
                } else {
                    current.add(Integer.parseInt(line));
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        TreeSet<Integer> cuentasOrdenadas = new TreeSet<Integer>(); 
        for (ArrayList<Integer> lista : listas){
            int sum = 0;
            for (Integer i : lista){
                sum+=i;
            }
            cuentasOrdenadas.add(sum);
        }
        Iterator maximos = cuentasOrdenadas.descendingIterator();
        System.out.println("La suma de los maximos es ");
        int suma = 0;
        for (int i=0; i<3; i++){
            suma = suma + (int) maximos.next();
            
        }
        System.out.println(suma);
    }
}
