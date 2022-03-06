package katasFactoriaF5.katas.snakesAndLadders;

import katasFactoriaF5.katas.snakesAndLadders.board.ClassicBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void goingPast100StraigtInOrigin(){
        Player player = new Player("red");
        player.setBoard(new ClassicBoard());
        player.move(new DiceService(98,0));
        assertEquals(player.getSquare(),99);

        player.move(new DiceService(2,0));
        assertEquals(player.getSquare(),1);
    }

    @Test
    void landExactilySquare100ToWin(){
        Player player = new Player("red");
        player.setBoard(new ClassicBoard());
        player.move(new DiceService(99,0));//(99);
        assertEquals(player.getStatus(), PlayerStatus.WINNER);
    }
}