package test.java.com.tennis;

import junit.framework.TestCase;
import main.java.com.tennis.Jugadores;
import main.java.com.tennis.TennisGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TennisGameTest extends TestCase {

    private TennisGame tennisGame;

    @BeforeEach
    public void setUp() throws Exception{
        tennisGame = new TennisGame();
    }

    @Test
    public void testIsGameFinished(){
        Jugadores jugadores = new Jugadores("Jugador 1","Jugador 2");
        Integer setNumbers = 1;
        assertEquals(true, tennisGame.TennisGame(jugadores,setNumbers));
    }

    @Test
    public void testJugarSet(){
        assertEquals(true,tennisGame.jugarSet(1,"Jugador 1","Jugador 2"));
    }

    @Test
    public void testTranslateScore(){
        assertEquals("Forty", tennisGame.translateScore("40"));
        assertEquals("Thirty", tennisGame.translateScore("30"));
        assertEquals("Fifteen", tennisGame.translateScore("15"));
        assertEquals("Love", tennisGame.translateScore("0"));
    }
}
