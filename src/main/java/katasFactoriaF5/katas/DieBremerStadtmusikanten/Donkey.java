package katasFactoriaF5.katas.DieBremerStadtmusikanten;

public class Donkey extends Animal implements Singer{
    public boolean isSinging;
    private String song;

    public Donkey(String name, String song) {
        super(name);
        this.song = song;
    }

    @Override
    public String getSong() {
        return song;
    }

    @Override
    public String message() {
        return isSinging ? "El asno " + name +" está cantado "+song:
                "el asno " + name + " no quiere cantar";
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
