import java.util.ArrayList;

abstract class A {
    int a;
    public A(int a) {
        this.a = a;
    }
    abstract public int opera();
}

class B extends A {
    public B(int a) {
        super(a);
    }

    public int opera() {
        return this.a + 1;
    }
}

class C extends A {
    public C(int a) {
        super(a);
    }

    public int opera() {
        return this.a + 2;
    }
}

public class ejercicios3 {
    public static void main(String[] args) {
        ArrayList<A> miarray = new ArrayList<A>();
        miarray.add(new B(3));
        miarray.add(new C(5));
        for (A elemento : miarray) {
            System.out.println(elemento.opera());
        }

    }
    
}
