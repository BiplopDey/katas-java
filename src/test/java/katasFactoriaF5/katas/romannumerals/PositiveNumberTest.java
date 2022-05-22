package katasFactoriaF5.katas.romannumerals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

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
        assertEquals(expected, PositiveNumber.of(number).getCoefOfDecimalBase(10));
    }

    @Test
    void cant_getTenth(){
        assertThrows(RuntimeException.class, ()->PositiveNumber.of(5).getCoefOfDecimalBase(10));
        assertThrows(RuntimeException.class, ()->PositiveNumber.of(7).getCoefOfDecimalBase(10));
    }

    @Test
    void illegal_base(){
        assertThrows(IllegalArgumentException.class,
                ()->PositiveNumber.of(15).getCoefOfDecimalBase(110));
        assertThrows(IllegalArgumentException.class,
                ()->PositiveNumber.of(5).getCoefOfDecimalBase(9));
    }

    @ParameterizedTest
    @CsvSource(value= {"0,30", "1,21", "3,213","4,1234"})
    void getUnits(int expected, int number){
        assertEquals(expected, PositiveNumber.of(number).getCoefOfDecimalBase(1));
    }

    @ParameterizedTest
    @CsvSource(value= {"1,131", "2,246", "1,2104","3,12344", "0,1024"})
    void getHundreds(int expected,int number){
        assertEquals(expected, PositiveNumber.of(number).getCoefOfDecimalBase(100));
    }

    @Test
    void cant_getHundreds(){
        assertThrows(RuntimeException.class, ()->PositiveNumber.of(5).getCoefOfDecimalBase(100));
        assertThrows(RuntimeException.class, ()->PositiveNumber.of(70).getCoefOfDecimalBase(100));
    }

    @ParameterizedTest
    @CsvSource(value= {"1,1314", "2,2464", "1,21043","3,123442", "0,10249"})
    void getThousands(int expected,int number){
        assertEquals(expected, PositiveNumber.of(number).getCoefOfDecimalBase(1000));
    }

    @Test
    void cant_getThousands(){
        assertThrows(RuntimeException.class, ()->PositiveNumber.of(5).getCoefOfDecimalBase(1000));
        assertThrows(RuntimeException.class, ()->PositiveNumber.of(70).getCoefOfDecimalBase(1000));
        assertThrows(RuntimeException.class, ()->PositiveNumber.of(700).getCoefOfDecimalBase(1000));
    }

    @Test
    void get10descomp(){
        assertEquals(PositiveNumber.of(1234).getBase10descomp(), List.of(1,2,3,4));
    }

}
