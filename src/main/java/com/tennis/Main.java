package main.java.com.tennis;

public class Main {
    public static void main(String[] args) {
        TennisGame game = new TennisGame();
        Jugadores jugadores = new Jugadores("Gianfranco", "Alessandro");
        String j1 = jugadores.jugador1;
        String j2 = jugadores.jugador2;
        System.out.println("INICIA EL PARTIDO");
        game.jugarSet(1, j1, j2);
    }
}
