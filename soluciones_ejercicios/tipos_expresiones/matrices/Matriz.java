public class Matriz {
    int dim1;
    int dim2;
    double[][] datos = null;

    public Matriz(int dim1, int dim2){
        this.dim1 = dim1;
        this.dim2 = dim2;
        this.datos = new double[dim1][dim2];
    }

    public Matriz(double[][] d){
        datos = d;
        dim1 = d.length;
        dim2 = d[0].length;
    }

    public void set(int x, int y, double d){
        // Falta comprobar errores -por ejemplo, que nos pasemos de dimensión-
        datos[x][y] = d;
    }

    public Matriz multiplicar(Matriz m){
        // Falta comprobar que las dimensiones son compatibles
        Matriz resultado = new Matriz(dim1, m.dim2);
        for(int x=0; x < dim1; x++){
            for(int y=0; y<m.dim2; y++){
                double suma = 0;
                for(int j=0; j<dim2; j++){
                    suma += this.datos[x][j] * m.datos[j][y];
                }
                resultado.set(x, y, suma);
            }
        }
        return resultado;
    }

    public String toString(){
        String resultado = "";
        for(int x=0; x < dim1; x++, resultado = resultado + "\n"){
            for(int y=0; y<dim2; y++, resultado = resultado + "\t"){
                resultado = resultado + datos[x][y];
            }
        }
        return resultado;
    }

    public static void main(String[] args){
        double[][] d = {{1, 2, 3}, {4, 5, 6}};
        Matriz m1 = new Matriz(2, 2);
        m1.set(0, 0, 1);
        m1.set(0, 1, 1);
        m1.set(1, 0, 1);
        m1.set(1, 1, 1);
        Matriz m2 = new Matriz(d);
        String resultado = m1.multiplicar(m2).toString();
        System.out.println(resultado);
    }
    
}
