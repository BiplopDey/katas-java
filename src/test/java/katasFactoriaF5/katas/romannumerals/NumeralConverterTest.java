package katasFactoriaF5.katas.romannumerals;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumeralConverterTest {
    NumeralsConverter converter;

    @BeforeEach
    void setUp(){
        converter = new NumeralsConverter();
    }

    @Test
    void cantConvertZero_and_throwExceptions(){
        assertThrows(RuntimeException.class, ()-> converter.toRoman(PositiveNumber.of(0)));
    }

    @Test
    void cantConvertNegative_and_throwExceptions(){
        assertThrows(RuntimeException.class, ()-> converter.toRoman(PositiveNumber.of(-1)));
    }

    @Test
    void I_is_1(){
        assertEquals("I", converter.toRoman(PositiveNumber.of(1)));
    }


    @Test
    void II_is_2(){
        assertEquals("II", converter.toRoman(PositiveNumber.of(2)));
    }

    @AllArgsConstructor
    private static class ArabicRomanPair{
        final PositiveNumber arabic;
        final String roman;
    }

    private static List<ArabicRomanPair> generateArabicRomanPairs(){
        return List.of(
                new ArabicRomanPair(PositiveNumber.of(1), "I"),
                new ArabicRomanPair(PositiveNumber.of(2), "II"),
                new ArabicRomanPair(PositiveNumber.of(3), "III"));
    }

    @ParameterizedTest
    @MethodSource("generateArabicRomanPairs")
    void paramtrizedTest(ArabicRomanPair pair){
        assertEquals(pair.roman, converter.toRoman(pair.arabic));
    }
}
