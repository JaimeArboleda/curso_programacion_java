
public class Referencia {
    public int atributo;
    
    public Referencia(int atributo){
        this.atributo = atributo;
    }

    public int metodo_1(int a){
        a++;
        return a;
    }

    public Referencia metodo_2(Referencia r){
        r.atributo++;
        return r;
    }
    public static void main(String[] args){
        int a;
        int b;
        Referencia c;
        Referencia d;
        a = 5;
        b = 5;
        c = new Referencia(a);
        d = new Referencia(b);
        System.out.println(a==b);
        System.out.println(c==d);

        c.metodo_1(a);
        System.out.println(a);
        d.metodo_2(c);
        System.out.println(c.atributo);
    }
}
