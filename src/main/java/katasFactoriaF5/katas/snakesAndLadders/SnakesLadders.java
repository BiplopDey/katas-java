package katasFactoriaF5.katas.snakesAndLadders;

import katasFactoriaF5.katas.snakesAndLadders.TecnicalServices.CycledList;
import katasFactoriaF5.katas.snakesAndLadders.board.ClassicBoard;

import java.util.List;

public class SnakesLadders {
    private final CycledList<Player> players;
    private String message;
    private GameStates state = GameStates.PLAYING;

    public SnakesLadders(List<Player> players) {
        players.stream().forEach(player -> player.setBoard(new ClassicBoard()));
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
            throw new IllegalArgumentException("Dice must be between 1-6");
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
