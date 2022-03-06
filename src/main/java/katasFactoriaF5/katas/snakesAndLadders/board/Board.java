package katasFactoriaF5.katas.snakesAndLadders.board;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Board {
    private final int height;
    private final int weight;
    private final int size;
    private final List<Integer> squares;
    protected final Map<Integer, Integer> ladders;
    protected final Map<Integer, Integer> snakes;

    public Board(int height, int weight) {
        this.height = height;
        this.weight = weight;
        size = height*weight;
        squares = IntStream.range(1,size+1).boxed().collect(Collectors.toList());
        ladders = new HashMap<>(size);
        snakes = new HashMap<>(size);
    }

    public int getSquare(int i){
        return squares.get(i-1);
    }

    public int moveToSquare(int squares){
        squares = squares%size;
        squares = ladders.getOrDefault(squares, squares);
        squares = snakes.getOrDefault(squares, squares);
        return squares;
    }

    public boolean isHomeSquare(int square){
        return square == 0;
    }

}
