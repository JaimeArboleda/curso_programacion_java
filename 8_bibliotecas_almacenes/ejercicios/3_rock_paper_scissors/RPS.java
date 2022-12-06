import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 

enum Jugada {
    PIEDRA,
    PAPEL,
    TIJERA
}

enum Resultado {
    PERDER,
    EMPATAR, 
    GANAR
}

class Partida {
    Jugada jugada; 
    Jugada jugadaOponente;

    public Partida(Jugada jugada, Jugada jugadaOponente){
        this.jugada = jugada;
        this.jugadaOponente = jugadaOponente;
    }

    public Resultado calculaResultado(){
        if (jugada.equals(jugadaOponente)){
            return Resultado.EMPATAR;
        }
        switch(jugada){
            case PIEDRA: {
                if (jugadaOponente.equals(Jugada.PAPEL)){
                    return Resultado.PERDER;
                } else {
                    return Resultado.GANAR;
                }
            }
            case PAPEL: {
                if (jugadaOponente.equals(Jugada.TIJERA)){
                    return Resultado.PERDER;
                } else {
                    return Resultado.GANAR;
                }
            }
            case TIJERA: {
                if (jugadaOponente.equals(Jugada.PIEDRA)){
                    return Resultado.PERDER;
                } else {
                    return Resultado.GANAR;
                }
            }
            default: return Resultado.PERDER; // Nunca va a salir por aquí. 
        }
    }
}

class Configuracion {
    HashMap<String, Jugada> jugadaDict = new HashMap<String, Jugada>();
    HashMap<String, Jugada> jugadaOponenteDict = new HashMap<String, Jugada>();
    HashMap<Jugada, Integer> puntuacionJugada = new HashMap<Jugada, Integer>();
    HashMap<Resultado, Integer> puntuacionResultado = new HashMap<Resultado, Integer>();
    public Configuracion(){
        jugadaDict.put("X", Jugada.PIEDRA);
        jugadaDict.put("Y", Jugada.PAPEL);
        jugadaDict.put("Z", Jugada.TIJERA);
        jugadaOponenteDict.put("A", Jugada.PIEDRA);
        jugadaOponenteDict.put("B", Jugada.PAPEL);
        jugadaOponenteDict.put("C", Jugada.TIJERA);
        puntuacionJugada.put(Jugada.PIEDRA, 1);
        puntuacionJugada.put(Jugada.PAPEL, 2);
        puntuacionJugada.put(Jugada.TIJERA, 3);
        puntuacionResultado.put(Resultado.PERDER, 0);
        puntuacionResultado.put(Resultado.EMPATAR, 3);
        puntuacionResultado.put(Resultado.GANAR, 6);
    }
}

public class RPS {
    public static void main(String[] args){
        Configuracion configuracion = new Configuracion();
        int puntuacionTotal = 0;
        int numLines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() != 0){
                    numLines++;
                    String[] letras = line.split(" ");
                    Jugada jugada = configuracion.jugadaDict.get(letras[1]);
                    Jugada jugadaOponente = configuracion.jugadaOponenteDict.get(letras[0]);
                    Partida partida = new Partida(jugada, jugadaOponente);
                    Resultado resultado = partida.calculaResultado();
                    puntuacionTotal += configuracion.puntuacionJugada.get(jugada);
                    puntuacionTotal += configuracion.puntuacionResultado.get(resultado);
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("La puntuacion total es " + puntuacionTotal);
        System.out.println("Total líneas leídas es " + numLines);
    }
}
