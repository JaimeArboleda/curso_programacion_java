interface Cola {
    public void push(String element);
    public String pop();
    public Boolean isEmpty();
    public int length();
}

class ColaArray implements Cola {
    public int STEP = 3; // It should be bigger, but for testing... 
    public int length = 0;
    public String[] elements = new String[STEP];

    public void push(String element) {
        if (elements.length == length) {
            String[] new_elements = new String[STEP * ((length / STEP) + 1) ];
            for (int i = 0; i < length; i++) {
                new_elements[i] = elements[i];
            }
            elements = new_elements;
        }
        elements[length] = element;
        length += 1;
    }

    public String pop() {
        if (length == 0) {
            return null;
        }
        length -= 1;
        return elements[length];
    }

    public Boolean isEmpty() {
        return (length == 0);
    }

    public int length() {
        return length;
    }

    public String toString() {
        String salida = "Cola de tamaño " + length + "\n";
        for (int i = 0; i < length; i++) {
            salida += elements[i] + "\n";
        }
        return salida;
    }
}

public class Main {
    public static void main(String[] args) {
        ColaArray cola = new ColaArray();
        System.out.println(cola.isEmpty());
        cola.push("Primero");
        System.out.println(cola.toString());
        System.out.println(cola.pop());
        System.out.println(cola.isEmpty());
        cola.push("Primero");
        cola.push("Segundo");
        cola.push("Tercero");
        cola.push("Cuarto");
        cola.push("Quinto");
        System.out.println(cola.toString());
    }
}