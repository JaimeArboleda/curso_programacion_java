class A {
    A otro;
    public A(A otro) {
        this.otro = otro;
        System.out.println("En constructor de A con tipo A");
    }

    public A(B otro) {
        this.otro = otro;
        System.out.println("En constructor de A con tipo B");
    }
    
    public static void metodoEstatico() {
        System.out.println("En metodo estatico de A");
    }

    public void metodo() {
        System.out.println("En metodo de A");
    }
}

class B extends A {
    public B(A otro) {
        super(otro);
        System.out.println("En constructor de B con tipo A");
    }

    public B(B otro) {
        super((A) otro);
        System.out.println("En constructor de B con tipo B");
    }

    public static void metodoEstatico() {
        System.out.println("En metodo estatico de B");
    }

    public void metodo() {
        System.out.println("En metodo de B");
    }
}

public class ejercicios4 {
    public static void main(String[] args) {
        B b = new B((B) null);
        A a = new A(b);
        A a2 = new A((A) b);
        ((A) b).metodo();
        ((A) b).metodoEstatico();
    }
    
}
