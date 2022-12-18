import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 
import java.util.ArrayList;

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
        int maximo = 0;
        for (ArrayList<Integer> lista : listas){
            int sum = 0;
            for (Integer i : lista){
                sum+=i;
            }
            if (sum > maximo){
                maximo = sum;
            }
        }
        System.out.println("El maximo es " + maximo);
    }
}
