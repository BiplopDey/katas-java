package katasFactoriaF5.katas.snakesAndLadders;

import katasFactoriaF5.katas.snakesAndLadders.board.ClassicBoard;
import lombok.Getter;

public class Player {
    @Getter
    private String name;
    private final static ClassicBoard board = new ClassicBoard();
    @Getter
    private PlayerStatus status = PlayerStatus.PLAYING;
    @Getter
    private int square = 1;

    public Player(String name) {
        this.name = name;
    }

    public void move(DiceService diceService){
        square = (square + diceService.getPoints())%board.getSize();
        square = board.moveToSquare(square);
        if(square == 0 && !diceService.keepTurn()) status = PlayerStatus.WINNER;
    }

}
