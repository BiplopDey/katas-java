package katasFactoriaF5.katas.romannumerals;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
        if(number.getNumber()>3999)
            throw new IllegalArgumentException("Numbre is greather than 3999");

        RomanNumber result = null;
        for (int i = 0; i < number.getBase10descomp().size(); i++) {
            int decimalBase = tenPower(i);
            int coef = number.getCoefOfDecimalBase(decimalBase);
            result = coef != 0 ?
                    getRomanNumber(coef)
                            .multiplyByDecimalBase(decimalBase)
                            .concatenate(result)
                    : result;
        }
        return result;
    }

    private int tenPower(int i){
        return (int) Math.pow(10,i);
    }

    public PositiveNumber toArabic(RomanNumber number) {
        var numberList = number.getNumber().stream()
                .map(RomanNumber::new)
                .map(i->getPositiveNumber(i).getNumber())
                .collect(Collectors.toList());

        for (int i = 0; i < numberList.size()-1; i++)
            numberList.set(i,
                    numberList.get(i)*(numberList.get(i) < numberList.get(i+1) ? -1 : 1));

        return PositiveNumber.of(numberList.stream()
                .mapToInt(Integer::intValue)
                .sum());
    }

    private PositiveNumber getPositiveNumber(RomanNumber number) {
        for (var i : arabicToRoman.entrySet())
            if(i.getValue().equals(number))
                return i.getKey();
        return null;
    }

    private RomanNumber getRomanNumber(int number) {
        return arabicToRoman
                .get(PositiveNumber.of(number));
    }
}
