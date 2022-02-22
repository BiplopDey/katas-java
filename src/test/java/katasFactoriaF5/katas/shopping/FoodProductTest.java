package katasFactoriaF5.katas.shopping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class FoodProductTest {
    FoodProduct foodProduct;

    @BeforeEach
    void beforEach(){
        foodProduct = new FoodProduct("apple", 2);
    }

    @Test
    void priceWithoutDiscount(){
        assertThat(foodProduct.getPrice(),equalTo(2.0));
    }

    @Test
    void priceWithDiscount(){
        foodProduct.setDiscount(20);

        assertThat(foodProduct.getPrice(), equalTo(1.6));
    }

}