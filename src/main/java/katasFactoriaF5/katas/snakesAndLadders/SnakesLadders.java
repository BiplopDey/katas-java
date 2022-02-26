package katasFactoriaF5.katas.snakesAndLadders;

import katasFactoriaF5.katas.snakesAndLadders.TecnicalServices.CycledList;
import lombok.Getter;

import java.util.Iterator;
import java.util.List;

public class SnakesLadders {
    private final CycledList<Player> players;

    public SnakesLadders(List<Player> players) {
        this.players = new CycledList<>(players);
    }

    public Player nextPlayer() {
        players.next();
        return players.current();
    }

    public Player getCurrentPlayer(){
        return players.current();
    }

    public void dice(int i, int j){
        if(i < 0 || j < 0 || i > 6 || j > 6) throw new IllegalArgumentException("Dice must be between 1-6");

        getCurrentPlayer().move(i+j);

        if(i != j ) players.next();
    }


}
