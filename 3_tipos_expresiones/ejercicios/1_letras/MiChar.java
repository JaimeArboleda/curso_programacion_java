public class MiChar {
    private char c;

    public MiChar(char c){
        this.c = c;
    }

    public char siguiente(){
        return (char) (c + 1);
    }

    public char anterior(){
        return (char) (c - 1);
    }

    public char aMayuscula(){
        return Character.toUpperCase(c);
    }

    public char aMinuscula(){
        return Character.toLowerCase(c);
    }

    public int aEntero(){
        return Integer.parseInt(String.valueOf(c));
    }

    public static void main(String[] args){
        MiChar mc1 = new MiChar('a');
        MiChar mc2 = new MiChar('2');
        System.out.println(mc1.aMayuscula());
        System.out.println(mc1.siguiente());
        System.out.println(mc2.aEntero());
        System.out.println(mc1.aEntero());
    }
    
}
