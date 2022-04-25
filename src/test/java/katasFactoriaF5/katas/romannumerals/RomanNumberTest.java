package katasFactoriaF5.katas.romannumerals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RomanNumberTest {

    @Test
    void basisEnumContains(){
        assertTrue(RomanNumber.Basis.contains('I'));
        assertTrue(RomanNumber.Basis.contains('X'));
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
}
