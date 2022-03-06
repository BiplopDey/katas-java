package katasFactoriaF5.katas.snakesAndLadders.board;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ClassicBoard extends Board{
    public ClassicBoard(){
        super(10,10);
        ladders.put(4,20);
        ladders.put(7,10);
        snakes.put(16,6);
    }
}
