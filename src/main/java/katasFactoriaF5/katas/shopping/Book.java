package katasFactoriaF5.katas.shopping;

public class Book extends Product{

    private String description;
    public Book(String name, double price, String description) {
        super(name, price);
        this.description = description;
    }

    @Override
    public void setDiscount(double discount) {
        if(discount > 10.0) throw new RuntimeException("Can apply discount greater than 10");
        this.discount = discount;
    }
}
