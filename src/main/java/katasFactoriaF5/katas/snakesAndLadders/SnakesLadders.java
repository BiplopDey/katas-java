package katasFactoriaF5.katas.snakesAndLadders;

import katasFactoriaF5.katas.snakesAndLadders.TecnicalServices.CycledList;

import java.util.List;

public class SnakesLadders {
    private final CycledList<Player> players;

    private String message;
    private GameStates state = GameStates.PLAYING;
    public SnakesLadders(List<Player> players) {
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

    public void play(int i, int j){
        if(i < 0 || j < 0 || i > 6 || j > 6)
            throw new IllegalArgumentException("Dice must be between 1-6");

        if(state == GameStates.HAVE_WINNER){
            state = GameStates.GAME_OVER;
            return;
        }

        currentPlayer().move(i+j);
        if(currentPlayer().getStatus() == PlayerStatus.WINNER){
            state = GameStates.HAVE_WINNER;
            return;
        }

        if(i != j) players.next();
    }


}
