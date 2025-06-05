package es.vedruna;

import java.util.HashSet;
import java.util.Set;

public class Ahorcado {

    private final String palabra; // Palabra a adivinar (mayúsculas)
    private final StringBuilder palabraOculta; // Estado actual con _ y letras acertadas
    private final Set<Character> letrasIntentadas; // Letras que ya se han probado
    private int fallos; // Número de fallos cometidos
    private final int maxFallos = 5; // Fallos permitidos
    private int rondas; // Número de intentos

    public Ahorcado(String palabra) {
        this.palabra = palabra.toUpperCase();
        this.palabraOculta = new StringBuilder(palabra.replaceAll("[A-Z]", "_"));
        this.letrasIntentadas = new HashSet<>();
        this.fallos = 0;
        this.rondas = 0;
    }

    public boolean intentarLetra(char letra) {
        letra = Character.toUpperCase(letra);

        if (letrasIntentadas.contains(letra)) {
            throw new IllegalArgumentException("La letra '" + letra + "' ya fue intentada.");
        }

        letrasIntentadas.add(letra);
        rondas++;

        if (palabra.indexOf(letra) >= 0) {
            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) == letra) {
                    palabraOculta.setCharAt(i, letra);
                }
            }
            return true;
        } else {
            fallos++;
            return false;
        }
    }

    public String getPalabraOculta() {
        return palabraOculta.toString();
    }

    public boolean isGanado() {
        return palabraOculta.indexOf("_") == -1;
    }

    public boolean isPerdido() {
        return fallos >= maxFallos;
    }

    public int getFallos() {
        return fallos;
    }

    public int getRondas() {
        return rondas;
    }

    public Set<Character> getLetrasIntentadas() {
        return new HashSet<>(letrasIntentadas);
    }

    public int getMaxFallos() {
        return maxFallos;
    }

    public String getPalabra() {
        return palabra;
    }
}
