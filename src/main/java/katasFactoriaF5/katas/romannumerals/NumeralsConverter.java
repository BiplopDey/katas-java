package katasFactoriaF5.katas.romannumerals;

import java.util.HashMap;
import java.util.Map;

public class NumeralsConverter {
    final private Map<PositiveNumber, RomanNumber> arabicToRoman = new HashMap<>();
    public NumeralsConverter(){
        arabicToRoman.put(PositiveNumber.of(1), RomanNumber.of("I"));
        arabicToRoman.put(PositiveNumber.of(5), RomanNumber.of("V"));
        arabicToRoman.put(PositiveNumber.of(10), RomanNumber.of("X"));
        arabicToRoman.put(PositiveNumber.of(50), RomanNumber.of("L"));
        arabicToRoman.put(PositiveNumber.of(100), RomanNumber.of("C"));
        arabicToRoman.put(PositiveNumber.of(500), RomanNumber.of("D"));
        arabicToRoman.put(PositiveNumber.of(1000), RomanNumber.of("M"));

        arabicToRoman.put(PositiveNumber.of(2), RomanNumber.of("II"));
        arabicToRoman.put(PositiveNumber.of(3), RomanNumber.of("III"));
        arabicToRoman.put(PositiveNumber.of(4), RomanNumber.of("IV"));
        arabicToRoman.put(PositiveNumber.of(6), RomanNumber.of("VI"));
        arabicToRoman.put(PositiveNumber.of(7), RomanNumber.of("VII"));
        arabicToRoman.put(PositiveNumber.of(8), RomanNumber.of("VIII"));
        arabicToRoman.put(PositiveNumber.of(9), RomanNumber.of("IX"));

    }

    public RomanNumber toRoman(PositiveNumber number) {
        if(number.getNumber()/10 == 2)
            return RomanNumber.of("II").multiplyByTen();
        if(number.getNumber()/100 == 2)
            return RomanNumber.of("II").multiplyByHundred();

        return arabicToRoman.get(number);
    }

}
