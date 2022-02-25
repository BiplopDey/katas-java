package katasFactoriaF5.katas.snakesAndLadders;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void move(){
        Player player = new Player("red");
        player.move(98);
        assertEquals(player.getSquare(),99);

        player.move(2);
        assertEquals(player.getSquare(),1);
    }
}