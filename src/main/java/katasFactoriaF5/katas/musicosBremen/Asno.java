package katasFactoriaF5.katas.musicosBremen;

public class Asno extends Animal{
    public Asno(String name, String sing) {
        super(name, sing);
    }

    @Override
    public String message() {
        return isSinging ? "El asno " + name +" está cantado "+sing:
                "el asno " + name + " no quiere cantar";
    }
}
