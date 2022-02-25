package katasFactoriaF5.katas.snakesAndLadders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        game.dice(1,2);
        assertThat(game.getCurrentPlayer(), equalTo(player2));
        assertEquals(player1.getSquare(), 4);

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


}