class Punto {
    private double x;
    private double y;

    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public String toString(){
        return "(" + x + "," + y + ")";
    }

    public double distanciaA(Punto p){
        return Math.sqrt(Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2));
    }

    public boolean equals(Punto p){
        return (p.x==x) & (p.y==y);
    }
}

class Triangulo {
    private Punto vertice1;
    private Punto vertice2;
    private Punto vertice3;

    public Triangulo(Punto vertice1, Punto vertice2, Punto vertice3){
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.vertice3 = vertice3;
    }

    public void setVertice1(Punto p){
        vertice1 = p;
    }

    public void setVertice2(Punto p){
        vertice2 = p;
    }

    public void setVertice3(Punto p){
        vertice3 = p;
    }

    public Punto getVertice1(){
        return vertice1;
    }

    public Punto getVertice2(){
        return vertice2;
    }

    public Punto getVertice3(){
        return vertice3;
    }

    public String toString(){
        return "[" + vertice1.toString() + "," + vertice2.toString() + "," + vertice3.toString() + "]";
    }

    public double area(){
        double lado1 = vertice1.distanciaA(vertice2);
        double lado2 = vertice1.distanciaA(vertice3);
        double lado3 = vertice2.distanciaA(vertice3);
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s-lado1) * (s-lado2) * (s-lado3));
    }

    private boolean dumbEquals(Triangulo t){
        // This method does not take into account order
        return (t.vertice1.equals(vertice1)) & (t.vertice2.equals(vertice2)) & (t.vertice3.equals(vertice3));
    }

    public boolean equals(Triangulo t){
        // (1, 2, 3), (1, 3, 2), (2, 1, 3), (2, 3, 1), (3, 1, 2), (3, 2, 1)
        // Veremos formas mucho mejores de hacer esto!
        Triangulo t1 = new Triangulo(t.vertice1, t.vertice3, t.vertice2);
        Triangulo t2 = new Triangulo(t.vertice2, t.vertice1, t.vertice3);
        Triangulo t3 = new Triangulo(t.vertice2, t.vertice3, t.vertice1);
        Triangulo t4 = new Triangulo(t.vertice3, t.vertice1, t.vertice2);
        Triangulo t5 = new Triangulo(t.vertice3, t.vertice2, t.vertice1);
        return (this.dumbEquals(t)) | (this.dumbEquals(t1)) | (this.dumbEquals(t2)) | (this.dumbEquals(t3)) | (this.dumbEquals(t4)) | (this.dumbEquals(t5));
    }

}

public class TestTriangulo{
    public static void main(String[] args){
        Triangulo t = new Triangulo(
            new Punto(0, 0),
            new Punto (1, 2),
            new Punto(2, 1)
        );
        System.out.println(t.toString());
        System.out.println(t.area());
        Triangulo t2 = new Triangulo(
            new Punto (1, 2),
            new Punto(0, 0),
            new Punto(2, 1)
        );
        Triangulo t3 = new Triangulo(
            new Punto (1, 2),
            new Punto(0, 0),
            new Punto(2, 8)
        );
        System.out.println(t.equals(t2));
        System.out.println(t.equals(t3));
    }
}