package katasFactoriaF5.katas.snakesAndLadders.board;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    private final int height =10;
    private final int weight =10;

    @Getter
    private final int size = height*weight;

    private final List<Integer> squares = IntStream.range(1,size+1).boxed().collect(Collectors.toList());
    private final Map<Integer, Integer> ladders = new HashMap<>(size);

    public Board(){
        ladders.put(4,20);
        ladders.put(7,10);
    }

    public int getSquare(int i){
        return squares.get(i-1);
    }

    public int moveToSquare(int square){
        return ladders.containsKey(square) ? ladders.get(square) : square;
    }

}
