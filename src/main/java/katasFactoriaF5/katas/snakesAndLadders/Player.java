package katasFactoriaF5.katas.snakesAndLadders;

import lombok.Getter;

public class Player {
    private String name;

    @Getter
    private int square = 1;

    public Player(String name) {
        this.name = name;
    }

    public void move(int AddSquares){
        square = (square + AddSquares)%100;
        if(square == 4) square = 20;
    }
}
