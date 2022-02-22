package katasFactoriaF5.katas.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingChart {
    private List<Product> products = new ArrayList<>();
    private double price = 0;

    public double getPrice() {
        return price;
    }

    public ShoppingChart(List<Product> products) {
        this.products = products;
    }

    public ShoppingChart() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct( Product product){
        products.add(product);
        price+=product.getPrice();
    }

}
