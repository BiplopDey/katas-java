package katasFactoriaF5.katas.snakesAndLadders;

import katasFactoriaF5.katas.snakesAndLadders.board.Board;
import lombok.Getter;

public class Player {
    private String name;
    private final static Board board = new Board();

    @Getter
    private int square = 1;

    public Player(String name) {
        this.name = name;
    }

    public void move(int AddSquares){
        square = (square + AddSquares)%100;
        square = board.moveToSquare(square);
    }
}
