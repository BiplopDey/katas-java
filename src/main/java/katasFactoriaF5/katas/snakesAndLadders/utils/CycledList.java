package katasFactoriaF5.katas.snakesAndLadders.utils;

import java.util.List;

public class CycledList<E> {
    private final List<E> items;
    private int currentIndex = 0;

    public CycledList(List<E> items) {
        this.items = items;
    }

    public E next(){
        currentIndex = (currentIndex+1)%items.size();
        return current();
    }

    public E current(){
        return items.get(currentIndex);
    }
}
