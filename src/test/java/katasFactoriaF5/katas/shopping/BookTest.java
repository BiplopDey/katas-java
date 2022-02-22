package katasFactoriaF5.katas.shopping;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void cantAplyDiscountMoreThan10(){
        Book book = new Book("foo", 1, "Description");
        Throwable exception  = assertThrows(RuntimeException.class, ()->book.setDiscount(10.1));
        assertEquals("Can apply discount greater than 10", exception.getMessage());
    }
}