package katasFactoriaF5.katas.shopping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingChartTest {
    ShoppingChart shoppingChart;

    @BeforeEach
    void beforeEach(){
        shoppingChart = new ShoppingChart();
    }

    @Test
    void shoppingChartProductsIsZeroByDefault(){
        assertThat(shoppingChart.getProducts(), empty());
    }

    @Test
    void addProducts(){
        shoppingChart.addProduct(new FreeProduct("orange"));

        assertThat(shoppingChart.getProducts(), contains(new FreeProduct("orange")));
    }

    @Test
    void getPrice(){
        shoppingChart.addProduct(new FreeProduct("orange"));
        shoppingChart.addProduct(new FoodProduct("beans", 20));
        shoppingChart.addProduct(new FoodProduct("beans", 30));

        assertThat(shoppingChart.getPrice(), equalTo(50.0));
    }


}