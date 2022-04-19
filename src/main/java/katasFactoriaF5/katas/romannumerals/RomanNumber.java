package katasFactoriaF5.katas.romannumerals;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Set;

@EqualsAndHashCode
@Getter
public class RomanNumber {
    final private String number;
    final private Set<Character> romanNumeralBasis = Set.of('I','V','X','M','D','L');

    public RomanNumber(String number) {
        number = number.toUpperCase();
        if(!isValid(number))
            throw new RuntimeException("Invalid roman number");

        this.number = number;
    }

    public static RomanNumber of(String number) {
        return new RomanNumber(number);
    }

    private boolean isValid(String number){
        return number.chars().filter(i -> romanNumeralBasis.contains((char) i)).count() == number.length();
    }
}
