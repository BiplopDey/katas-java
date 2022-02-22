package katasFactoriaF5.katas.shopping;

import java.util.Objects;

public abstract class Product {
    protected String name;
    protected double price;
    protected double discount = 0;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return discount <= 0.0 ? price : price*(1-discount/100);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Product))
            return false;
        Product other = (Product) obj;
        return Objects.equals(name, other.name) && Objects.equals(price, other.price) && Objects.equals(discount, other.discount);
    }
}
