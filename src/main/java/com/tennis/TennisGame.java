package main.java.com.tennis;

import java.util.ArrayList;
import java.util.Random;

public class TennisGame {

    public boolean TennisGame(Jugadores jug, Integer numberOfSets){
        String j1 = jug.jugador1;
        String j2 = jug.jugador2;
        System.out.println("INICIA EL PARTIDO");
        try{
            jugarSet(numberOfSets, j1, j2);
            return true;
        } catch (Exception e ){
            System.out.println("Error: " + e );
            return false;
        }
    }

    public boolean score(String j1, String j2) {

        Random rnd = new Random();
        int marcadorJug1 = 0;
        int marcadorJug2 = 0;
        String puntosJug1 = "0";
        String puntosJug2 = "0";
        String puntajeMayor = "0";
        boolean ganador = true;
        boolean finJuego = false;
        ArrayList<String> listaPuntaje = new ArrayList<>();
        listaPuntaje.add( "15");
        listaPuntaje.add( "30");
        listaPuntaje.add( "40");

        while (finJuego != true) {

            int randomGolpe = rnd.nextInt(2);
            String marcadorPuntos = "";
            String marcadorPuntosDeuce = "";

            if (randomGolpe == 0) {
                marcadorJug1 = marcadorJug1 + 1;

                if ((marcadorJug1 > 3) && (Math.abs(marcadorJug1 - marcadorJug2) > 1)) {
                    System.out.println( j1 + " Anotó - " + j1 + " gana el juego");
                    marcadorJug1 = 0;
                    marcadorJug2 = 0;
                    ganador = true;
                    finJuego = true;
                }
                for(int i = 1; i<4  ; i++){
                    if(marcadorJug1 == i){
                        puntosJug1 = listaPuntaje.get(i - 1);
                        marcadorPuntos = j1 + " Anotó \n" + puntosJug1 + " - " + puntosJug2 +
                                " // " + translateScore(puntosJug1) + " - " + translateScore(puntosJug2);
                    }
                }
            }

            if (randomGolpe == 1) {
                marcadorJug2 = marcadorJug2 + 1;

                if ((marcadorJug2 > 3) && (Math.abs(marcadorJug2 - marcadorJug1) > 1)) {
                    System.out.println(j2 + " Anotó - " + j2 + " gana el juego");
                    marcadorJug1 = 0;
                    marcadorJug2 = 0;
                    ganador = false;
                    finJuego = true;
                }
                for(int i = 1; i<4  ; i++){
                    if(marcadorJug2 == i){
                        puntosJug2 = listaPuntaje.get(i - 1);
                        marcadorPuntos = j2 + " Anotó \n" + puntosJug1 + " - " + puntosJug2 +
                                " // " + translateScore(puntosJug1) + " - " + translateScore(puntosJug2);
                    }
                }
            }
            if(marcadorJug1 >= 3 && marcadorJug2 >= 3){

                if(marcadorJug1 > marcadorJug2) {
                    puntosJug1 = "";
                    puntosJug2 = "";
                    puntajeMayor = "1";
                    marcadorPuntos = j1 + " Anotó - Advantage para " + j1;
                } else if (marcadorJug2 > marcadorJug1) {
                    puntosJug1 = "";
                    puntosJug2 = "";
                    puntajeMayor = "2";
                    marcadorPuntos = j2 + " Anotó - Advantage para " + j2;
                }
                if (marcadorJug1 == marcadorJug2) {
                    if(puntajeMayor == "1"){
                        marcadorPuntos = j2 + " Anotó " ;
                    }else if (puntajeMayor == "2"){
                        marcadorPuntos = j1 + " Anotó " ;
                    }
                    marcadorPuntosDeuce = "Deuce";
                }
            }

            System.out.println(marcadorPuntos);
            if ((marcadorPuntosDeuce != "")) {
                System.out.println(marcadorPuntosDeuce);
            }
        }
        return ganador;
    }

    public boolean jugarSet(float sets, String j1, String j2) {

        int juegosJug1 = 0;
        int juegosJug2 = 0;
        int setJug1 = 0;
        int setJug2 = 0;
        float set1 = (sets / 2);
        double set = set1 + 0.5;
        boolean finPartido = false;

        while (!finPartido) {
            boolean resultadoJuego = score(j1, j2);
            if (resultadoJuego) {
                juegosJug1 = juegosJug1 + 1;
            } else {
                juegosJug2 = juegosJug2 + 1;
            }

            if (juegosJug1 == 6 && juegosJug2 == 6) {
                System.out.println("Tie Break");
            }

            if (juegosJug1 >= 6 && (Math.abs(juegosJug1 - juegosJug2) > 1) || juegosJug1 == 7 && juegosJug2 == 6) {
                setJug1 = setJug1 + 1;
                System.out.println("* " + j1 + " gana el set por " + juegosJug1 + " a " + juegosJug2 + " *");
                System.out.println();
                juegosJug1 = 0;
                juegosJug2 = 0;
                if (setJug1 == set && setJug1 > setJug2) {
                    System.out.println("* " + j1 + " gana el partido por " + setJug1 + " sets a " + setJug2 + " *");
                    finPartido = true;
                }
            }
            if (juegosJug2 >= 6 && (Math.abs(juegosJug2 - juegosJug1) > 1) || juegosJug2 == 7 && juegosJug1 == 6) {
                setJug2 = setJug2 + 1;
                System.out.println("* " + j2 + " gana el set por " + juegosJug2 + " a " + juegosJug1 + " *");
                System.out.println();
                juegosJug1 = 0;
                juegosJug2 = 0;
                if (setJug2 == set && setJug2 > setJug1) {
                    System.out.println("* " + j2 + " gana el partido por " + setJug2 + " sets a " + setJug1 + " *");
                    finPartido = true;
                }
            }
        }
        return finPartido;
    }

    public String translateScore(String score) {
        switch (score) {
            case "40":
                return "Forty";
            case "30":
                return "Thirty";
            case "15":
                return "Fifteen";
            case "0":
                return "Love";
        }
        throw new IllegalArgumentException("Illegal score: " + score);
    }

}


