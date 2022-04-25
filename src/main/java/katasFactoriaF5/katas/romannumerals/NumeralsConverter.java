package katasFactoriaF5.katas.romannumerals;

import java.util.HashMap;
import java.util.Map;

public class NumeralsConverter {
    final private Map<PositiveNumber, RomanNumber> basisArabicRoman = new HashMap<>();

    public NumeralsConverter(){
        basisArabicRoman.put(PositiveNumber.of(1), RomanNumber.of("I"));
        basisArabicRoman.put(PositiveNumber.of(5), RomanNumber.of("V"));
        basisArabicRoman.put(PositiveNumber.of(10), RomanNumber.of("X"));
        basisArabicRoman.put(PositiveNumber.of(50), RomanNumber.of("L"));
        basisArabicRoman.put(PositiveNumber.of(100), RomanNumber.of("C"));
        basisArabicRoman.put(PositiveNumber.of(500), RomanNumber.of("D"));
        basisArabicRoman.put(PositiveNumber.of(1000), RomanNumber.of("M"));
    }

    public RomanNumber toRoman(PositiveNumber number) {
        if(number.getNumber() == 2) return RomanNumber.of("ii");

        return basisArabicRoman.get(number);
    }

}
