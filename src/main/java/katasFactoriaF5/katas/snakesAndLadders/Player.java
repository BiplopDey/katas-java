package katasFactoriaF5.katas.snakesAndLadders;

import katasFactoriaF5.katas.snakesAndLadders.board.Board;
import katasFactoriaF5.katas.snakesAndLadders.board.ClassicBoard;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {
    private String name;
    @Setter
    private Board board;
    private PlayerStatus status = PlayerStatus.PLAYING;
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
