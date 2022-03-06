package katasFactoriaF5.katas.snakesAndLadders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SnakesLaddersTest {
    SnakesLadders game;
    Player player1;
    Player player2;

    @BeforeEach
    void beforeEach(){
        player1 = spy(new Player("red"));
        player2 = spy(new Player("blue"));
        game = new SnakesLadders(List.of(player1,player2));
    }

    @Test
    void playersStartOnSquare1(){
        assertThat(game.currentPlayer().getSquare(), equalTo(1));
        assertThat(game.nextPlayer().getSquare(), equalTo(1));
        verify(player1).getSquare();
        verify(player2).getSquare();
    }

    @Test
    void playersAlternates(){
        assertThat(game.nextPlayer(), equalTo(player2));
        assertThat(game.nextPlayer(), equalTo(player1));
        assertThat(game.nextPlayer(), equalTo(player2));
        assertThat(game.nextPlayer(), equalTo(player1));
    }

    @Test
    void rollDiceBetweenPlayers(){
        game.play(new DiceService(1,4));

        assertThat(game.currentPlayer(), equalTo(player2));
        assertEquals(player1.getSquare(), 6);

        game.play(new DiceService(3,2));

        assertThat(game.currentPlayer(), equalTo(player1));
        assertEquals(player2.getSquare(), 6);
    }

    @Test
    void doubleDiceHasAnOtherGo(){
        game.play(new DiceService(1,1));//1,1);
        assertThat(game.currentPlayer(), equalTo(player1));
        assertEquals(player1.getSquare(), 3);

        game.play(new DiceService(3,2));//3,2);
        assertThat(game.currentPlayer(), equalTo(player2));
        assertEquals(player1.getSquare(), 8);
    }

    @Test
    void diceHasToBeBetween1And6(){
        assertThrows(IllegalArgumentException.class, ()->{game.play( new DiceService(2,7));});
        assertThrows(IllegalArgumentException.class, ()->{game.play( new DiceService(-2,1));});
    }

    @Test
    void landOnBottomOfLadderSquare4andGoTo20(){
        game.play(new DiceService(2,1));//2,1);
        assertEquals(player1.getSquare(), 20);
    }

    @Test
    void landOnBottomOfLadderSquare4andGoTo20EventRolledDouble(){
        game.play(new DiceService(3,3));//3,3);
        assertEquals(player1.getSquare(), 10);

        game.play(new DiceService(1,1));//1,1);
        assertEquals(player1.getSquare(), 12);
    }

    @Test
    void landOnTopSnakeSquare16AndGoTo6(){
        game.play(new DiceService(6,6));//6,6);
        game.play(new DiceService(2,1));//2,1);

        assertEquals(player1.getSquare(), 6);
    }

    @Test
    void playerLandSquare100WithoutAnyMovesLeftWin(){
        player1.move(new DiceService(96,0));//(96);
        game.play(new DiceService(2,1));//2,1);
        assertEquals(game.getMessage(), "Player red wins" );
    }

    @Test
    void returnGameOverIfAPlayerWinsAndAnotherTriesToPlay(){
        player1.move(new DiceService(96,0));//(96);
        game.play(new DiceService(2,1));//2,1
        game.play(new DiceService(1,3));//;1,3);

        assertEquals(game.getMessage(), "Game Over" );
    }

    @Test
    void getMessageOfCurrentPlayerSquare(){
        game.play(new DiceService(1,4));//1,4);
        game.play(new DiceService(1,6));//1,6);
        assertEquals(game.getMessage(), "Player red is on square 6" );
    }
}