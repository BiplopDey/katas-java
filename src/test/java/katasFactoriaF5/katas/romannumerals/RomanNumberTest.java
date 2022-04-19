package katasFactoriaF5.katas.romannumerals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RomanNumberTest {

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

}
