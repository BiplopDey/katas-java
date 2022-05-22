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
            "i,x",
            "ii,xx",
            "iii,xxx",
            "iv,xl",
            "v,l",
            "vi,lx",
            "ix,xc",
            "l,d",
            "c,m",
            "xxiv,ccxl"//24->240

    })
    void multiplyByTen(String actual, String expected){
        assertEquals(RomanNumber.of(expected),
                RomanNumber.of(actual).multiplyByDecimalBase(10));
    }

    @ParameterizedTest
    @ValueSource(strings = {"m","d", "dm", "dmm"})// , "icd"
    void cant_multiplyBy10_if_NumberExceed3999(String number){
        Exception exception = assertThrows(
                RomanNumber.NumberExceeds3999Exception.class,
                () -> RomanNumber.of(number).multiplyByDecimalBase(10));
        assertTrue(exception.getMessage().contains("The number Exceeds 3999"));
    }

    @ParameterizedTest
    @CsvSource(value= {
            "i,c",
            "ii,cc",
            "iii,ccc",
            "xxx,mmm"
    })
    void multiplyBy100(String actual,String expected){
        assertEquals(RomanNumber.of(expected),
                RomanNumber.of(actual).multiplyByHundred());
    }

    @ParameterizedTest
    @ValueSource(strings = {"c","l","m","d"})
    void cant_multiplyBy100_if_NumberExceed3999(String number){
        Exception exception = assertThrows(
                RomanNumber.NumberExceeds3999Exception.class,
                () -> RomanNumber.of(number).multiplyByHundred());
        assertTrue(exception.getMessage().contains("The number Exceeds 3999"));
    }

    @ParameterizedTest
    @CsvSource(value= {
            "i,m",
            "ii,mm",
            "iii,mmm"
    })
    void multiplyBy1000(String actual, String expected){
        assertEquals(RomanNumber.of(expected),
                RomanNumber.of(actual).multiplyByThousand());
    }

    @Test
    void illegal_multiplyByDecimalBase_argument(){
        assertThrows(IllegalArgumentException.class,
                ()-> RomanNumber.of("iv").multiplyByDecimalBase(11));
        assertThrows(IllegalArgumentException.class,
                ()-> RomanNumber.of("iv").multiplyByDecimalBase(99));
    }

    @Test
    void multiplyByDecimalBase(){
        assertEquals(RomanNumber.of("iv"),
                RomanNumber.of("iv").multiplyByDecimalBase(1));
    }

    @Test
    void multiplyByHundred(){
        assertEquals(RomanNumber.of("c"),
                RomanNumber.of("i").multiplyByHundred());
    }

    @Test
    void multiplyByThousand(){
        assertEquals(RomanNumber.of("m"),
                RomanNumber.of("i").multiplyByThousand());
    }

    @Test
    void concatenate(){
        assertEquals(RomanNumber.of("vi"),
                RomanNumber.of("v").concatenate(RomanNumber.of("i")));
        assertEquals(RomanNumber.of("v"),
                RomanNumber.of("v").concatenate(null));
    }

    @Test
    void cant_concatenate(){
        assertThrows(RuntimeException.class,
                ()->RomanNumber.of("ii").concatenate(RomanNumber.of("ii")));

    }
}
