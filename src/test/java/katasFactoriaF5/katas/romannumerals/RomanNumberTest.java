package katasFactoriaF5.katas.romannumerals;

import org.junit.jupiter.api.Disabled;
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
    @ValueSource(strings = {"0","FX","AB","aXLOPAQW",""})
    void illegalRomanSymbols(String number){
        assertThrows(IllegalArgumentException.class, () -> RomanNumber.of(number));
    }

    @Test
    void nullNumber() {
        String s=null;
        assertThrows(IllegalArgumentException.class, () -> RomanNumber.of(s));
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

    @Test
    @Disabled
    void numberIsZero(){
        assertThrows(RuntimeException.class, () -> RomanNumber.of("ddm"));
        assertThrows(RuntimeException.class, () -> RomanNumber.of("llc"));
    }

    @ParameterizedTest
    @CsvSource(value= {
            "x,i",
            "xx,ii",
            "xxx,iii",
            "xl,iv",
            "l,v",
            "lx,vi",
            "xc,ix",
            "d,l",
            "m,c",
            "ccxl,xxiv"//24->240
    })
    void multiplyByTen(String expected, String actual){
        assertEquals(RomanNumber.of(expected), RomanNumber.of(actual).multiplyByTen());
    }

    @ParameterizedTest
    @ValueSource(strings = {"m","d", "dm", "dmm"})
    void multiplyByTenFail_ifNumberExceed3000(String number){
        Exception exception = assertThrows(
                RomanNumber.NumberExceeds3000Exception.class, () -> RomanNumber.of(number).multiplyByTen());
        assertTrue(exception.getMessage().contains("The number Exceeds 3000"));
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
