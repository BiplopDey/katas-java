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
    void playersStartOnSquare0(){
        assertThat(game.getCurrentPlayer().getSquare(), equalTo(1));
        assertThat(game.nextPlayer().getSquare(), equalTo(1));
        verify(player1).getSquare();
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
        game.dice(1,4);
        assertThat(game.getCurrentPlayer(), equalTo(player2));
        assertEquals(player1.getSquare(), 6);

        game.dice(3,2);
        assertThat(game.getCurrentPlayer(), equalTo(player1));
        assertEquals(player2.getSquare(), 6);
    }

    @Test
    void doubleDiceHasAnOtherGo(){
        game.dice(1,1);
        assertThat(game.getCurrentPlayer(), equalTo(player1));
        assertEquals(player1.getSquare(), 3);

        game.dice(3,2);
        assertThat(game.getCurrentPlayer(), equalTo(player2));
        assertEquals(player1.getSquare(), 8);
    }

    @Test
    void diceHasToBeBetween1And6(){
        assertThrows(IllegalArgumentException.class, ()->{game.dice( 7,-1);});
        assertThrows(IllegalArgumentException.class, ()->{game.dice( 1,-1);});
    }

    @Test
    void landOnBottomOfLadderSquare4andGoTo20(){
        game.dice(2,1);
        assertEquals(player1.getSquare(), 20);
    }

    @Test
    void landOnBottomOfLadderSquare4andGoTo20EventRolledDouble(){
        game.dice(3,3);
        assertEquals(player1.getSquare(), 10);

        game.dice(1,1);
        assertEquals(player1.getSquare(), 12);
    }

}