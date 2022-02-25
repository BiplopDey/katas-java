package katasFactoriaF5.katas.musicosBremen;

import lombok.Getter;

public class Cat extends Animal implements Singer{

    private boolean isSinging;
    private String song;

    public Cat(String name, String song) {
        super(name);
        this.song = song;
    }

    @Override
    public String getSong() {
        return song;
    }

    @Override
    public String message() {
            return isSinging ? "El gato " + name +" está cantado "+song:
                    "el gato " + name + " no quiere cantar";
    }

    @Override
    public boolean isSinging() {
        return isSinging;
    }

    @Override
    public void sing(boolean bool) {
        isSinging = bool;
    }
}
