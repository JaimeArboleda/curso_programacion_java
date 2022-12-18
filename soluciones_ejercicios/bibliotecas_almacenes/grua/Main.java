import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 

class Stack {
    public ArrayList<String> content = new ArrayList<String>();

    public void push(String s) {
        content.add(s);
    }

    public String pop() {
        return content.remove(content.size()-1);
    }

    public void init(ArrayList<String> elements) {
        for (int i=elements.size()-1; i>=0; i--) {
            content.add(elements.get(i));
        }
    }

    public int length() {
        return content.size();
    }
}

class Move {
    public int n;
    public int from;
    public int to;

    public Move(String move) {
        String[] parts = move.split(" ");
        this.n = Integer.parseInt(parts[1]);
        this.from = Integer.parseInt(parts[3]);
        this.to = Integer.parseInt(parts[5]);
    }
}

class Cargo {
    public HashMap<Integer, Stack> stacks = new HashMap<Integer, Stack>();
    public int numStacks;

    public Cargo(int n) {
        numStacks = n;
        for(int i=1; i<=n; i++) {
            stacks.put(Integer.valueOf(i), new Stack());
        }
    }

    public void init(ArrayList<ArrayList<String>> inits) {
        for(int i=1; i<=numStacks; i++) {
            stacks.get(i).init(inits.get(i-1));
        }
    }

    public void move(Move m) {
        for (int i=0; i<m.n; i++) {
            String s = stacks.get(m.from).pop();
            stacks.get(m.to).push(s);
        }
    }

    public int length() {
        int length = 0;
        for (int i=1; i<=numStacks; i++) {
            if (stacks.get(i).length() > length) {
                length = stacks.get(i).length();
            }
        }
        return length;
    }

    public String toString() {
        var lineas = new ArrayList<String>();
        String[] s = new String[numStacks];
        for (int i=1; i<= numStacks; i++) {
            s[i-1] = String.valueOf(i);
        }
        lineas.add(" " + String.join("   ", s));
        for (int level=0; level<length(); level++) {
            String linea = "";
            for (int i=1; i <= numStacks; i++) {
                if (level  < stacks.get(i).length()) {
                    linea += "[" + stacks.get(i).content.get(level) + "]";
                } else {
                    linea += "   ";
                }
                linea += " ";
            }
            lineas.add(linea);
        }
        String salida = "";
        for (int j=lineas.size()-1; j>=0; j--) {
            salida += lineas.get(j) + "\n";
        }
        return salida;
    }
} 

public class Main {

    public static int getNumeroStacks(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() != 0){
                    if(line.contains("[")) {
                        continue;
                    } else {
                        br.close();
                        return line.trim().split("\\s+").length;
                    }
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return -1;
    }
    public static void main(String[] args) {
        int numeroStacks = getNumeroStacks(args[0]);
        var cargo = new Cargo(numeroStacks);
        var inits = new ArrayList<ArrayList<String>>();
        for (int i=0; i<numeroStacks; i++) {
            inits.add(new ArrayList<String>());
        }
        boolean iniciado = false;
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() != 0){
                    if(line.contains("[")) {
                        for(int i=0; i<numeroStacks; i++) {
                            int posicion = 1 + (i*4);
                            String element = line.substring(posicion, posicion+1);
                            if (!element.equals(" ")) {
                                inits.get(i).add(element);
                            }
                        }
                    }
                    if(line.contains("move")) {
                        if (!iniciado) {
                            cargo.init(inits);
                            iniciado = true;
                        }
                        var move = new Move(line);
                        cargo.move(move);
                    }
                }
            }
            br.close();
        } catch(IOException e){
            e.printStackTrace();
        }

        if (!iniciado) {
            cargo.init(inits);
        }
        System.out.println("La situacion es: ");
        System.out.println(cargo.toString());
    }
}