package katasFactoriaF5.katas.shopping;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {


    @Test
    void getNameAndPrice() {
        Product product = new Product("prod1",2) {
        };
        assertThat(product.getName(), equalTo("prod1"));
        assertThat(product.getPrice(), equalTo(2d));
    }

    @Test
    void testEquals(){
        Product product1 = new Product("prod1",2) {
        };
        Product product2 = new Product("prod1",2) {
        };
        assertThat(product1,equalTo(product2));
    }
}