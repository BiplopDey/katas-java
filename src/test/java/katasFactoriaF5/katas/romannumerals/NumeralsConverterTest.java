package katasFactoriaF5.katas.romannumerals;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumeralsConverterTest {
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

    @AllArgsConstructor
    private static class ArabicRomanPair{
        final PositiveNumber arabic;
        final RomanNumber roman;
    }

    private static List<ArabicRomanPair> generateExp_10_ArabicRomanPairs(){
        return List.of(
                new ArabicRomanPair(PositiveNumber.of(1), RomanNumber.of(RomanNumber.Symbols.I)),
                new ArabicRomanPair(PositiveNumber.of(10), RomanNumber.of(RomanNumber.Symbols.X)),
                new ArabicRomanPair(PositiveNumber.of(100), RomanNumber.of(RomanNumber.Symbols.C)),
                new ArabicRomanPair(PositiveNumber.of(1000), RomanNumber.of(RomanNumber.Symbols.M))
                );
    }

    private static List<ArabicRomanPair> generateExp_5_ArabicRomanPairs(){
        return List.of(
                new ArabicRomanPair(PositiveNumber.of(5), RomanNumber.of(RomanNumber.Symbols.V)),
                new ArabicRomanPair(PositiveNumber.of(50), RomanNumber.of(RomanNumber.Symbols.L)),
                new ArabicRomanPair(PositiveNumber.of(500), RomanNumber.of(RomanNumber.Symbols.D)));
    }

    @ParameterizedTest
    @MethodSource("generateExp_10_ArabicRomanPairs")
    void convertExp10ArabicToRoman(ArabicRomanPair pair){
        assertEquals(pair.roman, converter.toRoman(pair.arabic));
    }

    @ParameterizedTest
    @MethodSource("generateExp_5_ArabicRomanPairs")
    void convertExp5ArabicToRoman(ArabicRomanPair pair){
        assertEquals(pair.roman, converter.toRoman(pair.arabic));
    }

    @Test
    void oneToTen(){
        assertEquals(RomanNumber.of("ii"), converter.toRoman(PositiveNumber.of(2)));
        assertEquals(RomanNumber.of("iii"), converter.toRoman(PositiveNumber.of(3)));
        assertEquals(RomanNumber.of("viii"), converter.toRoman(PositiveNumber.of(8)));
    }

    @Test
    void twoAndZeros(){
        assertEquals(RomanNumber.of("xx"), converter.toRoman(PositiveNumber.of(20)));
        assertEquals(RomanNumber.of("cc"), converter.toRoman(PositiveNumber.of(200)));
    }
}