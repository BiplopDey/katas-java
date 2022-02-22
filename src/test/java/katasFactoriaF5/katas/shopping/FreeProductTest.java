package katasFactoriaF5.katas.shopping;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class FreeProductTest {

    @Test
    void freeProductsPriceIsAlwaysZero(){
        FreeProduct freeProduct = new FreeProduct("apple");
        assertThat(freeProduct.getPrice(),equalTo(0.0));
    }
}