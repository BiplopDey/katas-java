package katasFactoriaF5.katas.musicosBremen;

public class Cat extends Animal{

    public Cat(String name, String sing) {
        super(name, sing);
    }

    @Override
    public String message() {
            return isSinging ? "El gato " + name +" está cantado "+sing:
                    "el gato " + name + " no quiere cantar";
    }
}
