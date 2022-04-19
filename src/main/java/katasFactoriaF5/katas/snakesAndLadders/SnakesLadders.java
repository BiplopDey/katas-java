package katasFactoriaF5.katas.snakesAndLadders;

import katasFactoriaF5.katas.snakesAndLadders.utils.CycledList;
import katasFactoriaF5.katas.snakesAndLadders.board.Board;
import katasFactoriaF5.katas.snakesAndLadders.player.Player;
import katasFactoriaF5.katas.snakesAndLadders.player.PlayerStatus;

import java.util.List;

public class SnakesLadders {
    private final CycledList<Player> players;
    private GameStates state = GameStates.PLAYING;

    public SnakesLadders(List<Player> players, Board board) {
        players.forEach(player -> player.setBoard(board));
        this.players = new CycledList<>(players);
    }

    public Player nextPlayer() {
        return  players.next();
    }

    public Player currentPlayer(){
        return players.current();
    }

    public String getMessage(){
        if(state == GameStates.GAME_OVER)
            return "Game Over";
        if(state == GameStates.HAVE_WINNER)
            return "Player "+ currentPlayer().getName()+" wins";
        return "Player "+ currentPlayer().getName() +" is on square "+ currentPlayer().getSquare() ;
    }

    public void play(DiceService diceService){
        if(!diceService.isValid())
            throw new IllegalArgumentException("Invalid argument");

        if(state == GameStates.HAVE_WINNER){
            state = GameStates.GAME_OVER;
            return;
        }
        if(state != GameStates.PLAYING)
            return;
        currentPlayer().move(diceService);
        if(currentPlayer().getStatus() == PlayerStatus.WINNER){
            state = GameStates.HAVE_WINNER;
            return;
        }

        if(!diceService.keepTurn()) players.next();
    }


}
