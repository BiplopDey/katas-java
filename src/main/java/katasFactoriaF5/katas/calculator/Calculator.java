package katasFactoriaF5.katas.calculator;


import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private double total = 0;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void add(double toAdd){
        total+=toAdd;
    }

    public void add(List<Double> list){
        total += list.stream().reduce(0d,(i,j)->i+j);
    }

    public void divide(double i) {
        if(i==0) throw new RuntimeException("Division by zero");
        total /= i;
    }

    public List<Integer> getGreaterThan5( List<Integer> list){
        return list.stream().filter((i)->i>=5).collect(Collectors.toList());
    }
}

