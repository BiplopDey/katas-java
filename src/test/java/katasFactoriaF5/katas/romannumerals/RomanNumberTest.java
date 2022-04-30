package katasFactoriaF5.katas.romannumerals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class RomanNumberTest {

    @Test
    void basisEnumContains(){
        assertTrue(RomanNumber.Symbols.contains('I'));
        assertTrue(RomanNumber.Symbols.contains('X'));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0","FX","AB","aXLOPAQW"})
    void invalidRomanNumbers(String number){
        assertThrows(RuntimeException.class, () -> RomanNumber.of(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"x","xlvi","XL","DMV"})
    void validRomanNumbers(String number){
        assertDoesNotThrow(() -> RomanNumber.of(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"x","xlvi","XL","DMV"})
    void equalsRomanNumber(String number){
        assertEquals(RomanNumber.of(number),RomanNumber.of(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"xixxxx","LLLLX", "iiiivvvvi"})
    void cantRepeatSymbolsMoreThan3timesConsecutively(String number){
        assertThrows(RuntimeException.class, () -> RomanNumber.of(number));
    }

    @ParameterizedTest
    @CsvSource(value= {
            "x,i",
            "xx,ii",
            "xxx,iii",
            "xl,iv",
            "l,v",
            "lx,vi",
            "xc,ix"
    })
    void multiplyByTen(String expected, String actual){
        assertEquals(RomanNumber.of(expected), RomanNumber.of(actual).multiplyByTen());
    }

    @Test
    void multiplyByHundred(){
        assertEquals(RomanNumber.of("c"), RomanNumber.of("i").multiplyByHundred());
    }

    @Test
    void multiplyByThousand(){
        assertEquals(RomanNumber.of("m"), RomanNumber.of("i").multiplyByThousand());
    }
}
