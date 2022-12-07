class Nodo {
    String nombre;
    double peso;
    Nodo[] hijos;

    public Nodo(String nombre, double peso){
        this.nombre = nombre;
        this.peso = peso;
    }

    public void setDescendientes(Nodo[] hijos){
        this.hijos = hijos;
    }

    public String toString(){
        return nombre + "(" + peso + ")";
    }

}

class Arbol {
    Nodo raiz;

    public Arbol(Nodo raiz){
        this.raiz = raiz;
    }

    private String toString(int nivel){
        String espacios = "";
        String resultado = "";
        for (int i=0; i<nivel ; i++){
            espacios += "  ";
        }
        resultado += espacios + raiz.toString() + "\n";
        if (raiz.hijos != null){
            for(Nodo hijo : raiz.hijos){
                Arbol subarbol = new Arbol(hijo);
                resultado += subarbol.toString(nivel+1);
            }
        }
        return resultado;
    }

    public String toString(){
        return toString(0);
    }

    public int calculaProfundidad(){
        int maximaProfundidadHijos = 0;
        if (raiz.hijos != null){
            for(Nodo hijo : raiz.hijos){
                Arbol subarbol = new Arbol(hijo);
                int profundidadHijo = subarbol.calculaProfundidad();
                if (profundidadHijo > maximaProfundidadHijos){
                    maximaProfundidadHijos = profundidadHijo;
                }
            }
        }
        return maximaProfundidadHijos + 1;
    }

    public double calculaDistanciaAHojas(){
        double minimaDistancia = Double.MAX_VALUE;
        if (raiz.hijos != null){
            for(Nodo hijo : raiz.hijos){
                Arbol subarbol = new Arbol(hijo);
                double distanciaHijo = subarbol.calculaDistanciaAHojas();
                if (distanciaHijo < minimaDistancia){
                    minimaDistancia = distanciaHijo;
                }
            }
        } else {
            minimaDistancia = 0;
        }
        return minimaDistancia + raiz.peso;
    }

}

public class Main {
    public static void main(String[] args){
        Nodo a = new Nodo("a", 2);
        Nodo b = new Nodo("b", 3);
        Nodo c = new Nodo("c", 4);
        Nodo d = new Nodo("d", 2);
        Nodo e = new Nodo("e", 2);
        Nodo f = new Nodo("f", 2);
        Nodo g = new Nodo("g", 2);
        Nodo[] hijosA = {b, c};
        Nodo[] hijosB = {d};
        Nodo[] hijosC = {e};
        Nodo[] hijosE = {f, g};
        a.setDescendientes(hijosA);
        b.setDescendientes(hijosB);
        c.setDescendientes(hijosC);
        e.setDescendientes(hijosE);
        Arbol arbol = new Arbol(a);
        System.out.println(arbol.toString());
        System.out.println(arbol.calculaDistanciaAHojas());
        System.out.println(arbol.calculaProfundidad());
    }
}
