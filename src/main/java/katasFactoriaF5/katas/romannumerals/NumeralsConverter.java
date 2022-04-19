package katasFactoriaF5.katas.romannumerals;

import java.util.HashMap;
import java.util.Map;

public class NumeralsConverter {
    final private Map<PositiveNumber, String> basisArabicRoman = new HashMap<>();

    public String toRoman(PositiveNumber number) {
        basisArabicRoman.put(PositiveNumber.of(1), "I");
        basisArabicRoman.put(PositiveNumber.of(2), "II");
        basisArabicRoman.put(PositiveNumber.of(3), "III");
        basisArabicRoman.put(PositiveNumber.of(5), "V");

        return basisArabicRoman.get(number);
    }

}
