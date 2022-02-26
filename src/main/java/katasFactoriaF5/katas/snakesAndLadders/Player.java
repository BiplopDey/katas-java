package katasFactoriaF5.katas.snakesAndLadders;

import katasFactoriaF5.katas.snakesAndLadders.board.Board;
import lombok.Getter;

public class Player {
    @Getter
    private String name;
    private final static Board board = new Board();
    @Getter
    private PlayerStatus status = PlayerStatus.PLAYING;
    @Getter
    private int square = 1;

    public Player(String name) {
        this.name = name;
    }

    public void move(int AddSquares){
        square = (square + AddSquares)%board.getSize();
        square = board.moveToSquare(square);
        if(square == 0) status = PlayerStatus.WINNER;
    }

}
