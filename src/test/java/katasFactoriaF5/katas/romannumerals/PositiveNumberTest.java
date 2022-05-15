package katasFactoriaF5.katas.romannumerals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

        assertEquals(PositiveNumber.of(3), 3);
        assertNotEquals(3, PositiveNumber.of(3));
        assertEquals(PositiveNumber.of(3), Integer.parseInt("3"));
        assertNotEquals(PositiveNumber.of(1), 2);


    }

    @ParameterizedTest
    @CsvSource(value= {"3,31", "2,24", "1,210","3,1234", "0,102"})
    void getTens(int expected,int number){
        assertEquals(expected, PositiveNumber.of(number).getTens());
    }

    @Test
    void cant_getTenth(){
        assertThrows(RuntimeException.class, ()->PositiveNumber.of(5).getTens());
        assertThrows(RuntimeException.class, ()->PositiveNumber.of(7).getTens());
    }

    @ParameterizedTest
    @CsvSource(value= {"0,30", "1,21", "3,213","4,1234"})
    void getUnits(int expected,int number){
        assertEquals(expected, PositiveNumber.of(number).getUnits());
    }

    @ParameterizedTest
    @CsvSource(value= {"1,131", "2,246", "1,2104","3,12344", "0,1024"})
    void getHundreds(int expected,int number){
        assertEquals(expected, PositiveNumber.of(number).getHundreds());
    }

    @Test
    void cant_getHundreds(){
        assertThrows(RuntimeException.class, ()->PositiveNumber.of(5).getHundreds());
        assertThrows(RuntimeException.class, ()->PositiveNumber.of(70).getHundreds());
    }

    @ParameterizedTest
    @CsvSource(value= {"1,1314", "2,2464", "1,21043","3,123442", "0,10249"})
    void getThousands(int expected,int number){
        assertEquals(expected, PositiveNumber.of(number).getThousands());
    }

    @Test
    void cant_getThousands(){
        assertThrows(RuntimeException.class, ()->PositiveNumber.of(5).getThousands());
        assertThrows(RuntimeException.class, ()->PositiveNumber.of(70).getThousands());
        assertThrows(RuntimeException.class, ()->PositiveNumber.of(700).getThousands());
    }


}
