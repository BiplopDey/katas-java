package katasFactoriaF5.katas.snakesAndLadders.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;

    @BeforeEach
    void beforeEach(){
        board = new Board();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,34,5,100})
    void getSquareListIndex(int i){
        assertEquals(board.getSquare(i), i);
    }

    @Test
    void climUpLeader(){
        assertEquals(board.moveToSquare(4), 20);
        assertEquals(board.moveToSquare(21), 21);
    }
}