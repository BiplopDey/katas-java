package katasFactoriaF5.katas.snakesAndLadders.board;


public class Square {
    int row;
    int column;

    public Square(int row, int column) {
        this.row = row;
        this.column = row;
    }

    @Override
    public String toString(){
        return "("+ row +","+ column +")";
    }
}
