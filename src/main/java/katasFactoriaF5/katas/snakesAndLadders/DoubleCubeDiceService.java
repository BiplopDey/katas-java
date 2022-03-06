package katasFactoriaF5.katas.snakesAndLadders;

public class DoubleCubeDiceService implements DiceService {
    private final int i, j;

    public DoubleCubeDiceService(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public boolean isValid(){
        return !(i < 0 || j < 0 || i > 6 || j > 6);
    }

    public boolean keepTurn(){
        return i==j;
    }

    public int getTotal(){
        return i+j;
    }
}
