package katasFactoriaF5.katas.snakesAndLadders.player;

import katasFactoriaF5.katas.snakesAndLadders.DiceService;
import katasFactoriaF5.katas.snakesAndLadders.DoubleCubeDiceService;
import katasFactoriaF5.katas.snakesAndLadders.board.Board;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

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
        square = board.moveToSquare(square + diceService.getTotal());
        if(board.isHomeSquare(square) && !diceService.keepTurn()) status = PlayerStatus.WINNER;
    }

}
