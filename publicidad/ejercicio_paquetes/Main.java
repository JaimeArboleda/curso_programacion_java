import java.util.*;
import java.io.IOException;
import java.nio.file.*;

class EntradaInvalidaException extends Exception { 
    public EntradaInvalidaException(String errorMessage) {
        super(errorMessage);
    }
}

class LineaParseada {
    String referencia;
    int nivel;
    double peso;
    boolean esPaquete;

    public LineaParseada(String linea) {
        int espacios = 0;
        for (int i = 0; i < linea.length(); i++) {
            if (linea.charAt(i) == ' ') {
                espacios++;
            } else {
                break;
            }
        }
        nivel = espacios / 2;
        esPaquete = true;
        peso = 0;
        referencia = linea.substring(espacios);
        if (linea.contains("(")) {
            esPaquete = false;
            String[] trozos = referencia.split("\\(");
            referencia = trozos[0];
            peso = Double.parseDouble(trozos[1].split("\\)")[0]);
        }
    }
}


abstract class Elemento {
    public String referencia;
    public static HashSet<String> referencias = new HashSet<String>();
    
    public Elemento(String referencia) throws EntradaInvalidaException {
        if (referencias.contains(referencia)) {
            throw new EntradaInvalidaException("La referencia ya existe " + referencia);
        }
        this.referencia = referencia;
        this.referencias.add(referencia);
    }

    abstract public String toString();
    abstract public double getPeso();

    protected String toString(int nivel) {
        String espacios = "";
        for (int i=0; i<nivel; i++) {
            espacios += espacios + "  ";
        }
        String salida = toString();
        String salidaIndentada = "";
        for (String linea : salida.split("\n")) {
            salidaIndentada += espacios + linea + "\n";
        }
        return salidaIndentada.substring(0, salidaIndentada.length()-1);
    }
}

class Item extends Elemento {
    public double peso;

    public Item(String referencia, double peso) throws EntradaInvalidaException {
        super(referencia);
        this.peso = peso;
    }
    
    public String toString() {
        return this.referencia + "(" + this.peso + ")";
    }


    public double getPeso() {
        return peso;
    }
}

class Paquete extends Elemento {
    public ArrayList<Elemento> elementos = new ArrayList<Elemento>();

    private Paquete(String referencia, String definicionElementos, int nivel) throws EntradaInvalidaException {
        super(referencia);
        boolean enPaqueteAnidado = false;
        String referenciaPaqueteAnidado = "";
        String definicionPaqueteAnidado = "";
        for (String linea : definicionElementos.split("\n")) {
            if (!linea.equals("")) {
                LineaParseada lineaParseada = new LineaParseada(linea);
                if (lineaParseada.nivel == nivel + 1) {
                    // Es una linea de mi nivel
                    if (enPaqueteAnidado) {
                        // He llegado al final de un bloque que define un paquete anidado
                        Paquete paquete = new Paquete(referenciaPaqueteAnidado, definicionPaqueteAnidado, nivel + 1);
                        elementos.add(paquete);
                    } 
                    // Ahora añado el nuevo elemento, que puede ser un paquete o no. 
                    if (lineaParseada.esPaquete) {
                        enPaqueteAnidado = true;
                        referenciaPaqueteAnidado = lineaParseada.referencia;
                        definicionPaqueteAnidado = "";
                    } else {
                        enPaqueteAnidado = false;
                        Item item = new Item(lineaParseada.referencia, lineaParseada.peso);
                        elementos.add(item);
                    }
                    
                } else {
                    // No es una linea de mi nivel, por lo que estoy en un paquete anidado. 
                    definicionPaqueteAnidado += "\n" + linea;
                }
            }
        }
        if (enPaqueteAnidado) {
            // He llegado al final de un bloque que define un paquete anidado. Debo repescar este bloque
            Paquete paquete = new Paquete(referenciaPaqueteAnidado, definicionPaqueteAnidado, nivel + 1);
            elementos.add(paquete);
        } 
    }

    public static Paquete PaqueteFactory(String definicion) throws EntradaInvalidaException {
        String[] lineas = definicion.split("\n");
        LineaParseada primeraLinea = new LineaParseada(lineas[0]);
        String restoLineas = definicion.split("\n", 2)[1];
        return new Paquete(primeraLinea.referencia, restoLineas, 0);
    }

    public String toString() {
        String salida = referencia + "\n";
        for (Elemento e : elementos) {
            salida += e.toString(1) + "\n";
        }
        return salida;
    }

    public double getPeso() {
        double pesoTotal = 0;
        for (Elemento e : elementos) {
            pesoTotal += e.getPeso();
        }
        return pesoTotal;
    }
}

public class Main {
    public static void main(String[] args) throws IOException, EntradaInvalidaException {
        Path filePath = Path.of(args[0]);
        String content = Files.readString(filePath);
        Paquete paquete = Paquete.PaqueteFactory(content);
        System.out.println(paquete.toString());
        System.out.println(paquete.getPeso());
    }
    
}
