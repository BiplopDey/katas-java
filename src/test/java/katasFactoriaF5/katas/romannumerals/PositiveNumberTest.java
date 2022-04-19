package katasFactoriaF5.katas.romannumerals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositiveNumberTest {

    @Test
    void negativeAndZeroNumbers_are_invalid(){
        assertThrows(RuntimeException.class, () -> PositiveNumber.of(0));
        assertThrows(RuntimeException.class, () -> PositiveNumber.of(-10));
    }

    @Test
    void equalsPositiveNumbers(){
        assertEquals(PositiveNumber.of(1), PositiveNumber.of(1));
        assertNotEquals(PositiveNumber.of(1), PositiveNumber.of(2));
    }


}
