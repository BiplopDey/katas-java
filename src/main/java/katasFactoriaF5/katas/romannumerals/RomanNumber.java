package katasFactoriaF5.katas.romannumerals;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EqualsAndHashCode
@Getter
public class RomanNumber {
    final private List<Symbols> number;

    public RomanNumber(String number) {
        number = number.trim().toUpperCase();
        if(!isValid(number))
            throw new RuntimeException("Invalid roman number");

        this.number = number.chars()
                .mapToObj(i -> Symbols.valueOf(String.valueOf((char) i)))
                .collect(Collectors.toList());
    }

    public RomanNumber(Symbols number){
        this.number = List.of(number);
    }

    public static RomanNumber of(String number) {
        return new RomanNumber(number);
    }

    public static RomanNumber of(Symbols number) {
        return new RomanNumber(number);
    }

    private boolean isValid(String number){
        return number.chars().filter(i -> Symbols.contains( (char) i)).count() == number.length()
                && !consecutiveRepeateMoreThan3(number);
    }

    private boolean consecutiveRepeateMoreThan3(String number){
        for (int i = 0; i < number.length()-3; i++) {
            if (number.charAt(i) == number.charAt(i+1) &&
                    number.charAt(i+1) == number.charAt(i+2) &&
                    number.charAt(i+2) == number.charAt(i+3))
                return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return number;
    }

    public RomanNumber multiplyByTen() {
        Map<Character,Character> mapMultiplyTen = new HashMap<>();
        mapMultiplyTen.put(Symbols.I.getNumber(),Symbols.X.getNumber());
        mapMultiplyTen.put(Symbols.V.getNumber(),Symbols.L.getNumber());
        mapMultiplyTen.put(Symbols.X.getNumber(),Symbols.C.getNumber());

        String multipliedNum="";
        for (char ch : number.toCharArray()) {
            multipliedNum+=mapMultiplyTen.get(ch);
        }
        return RomanNumber.of(
            multipliedNum
        );

    }

    public RomanNumber multiplyByHundred() {
        return this.multiplyByTen().multiplyByTen();
    }

    public RomanNumber multiplyByThousand() {
        return RomanNumber.of("m");
    }

    @Getter
    @AllArgsConstructor
    enum Symbols {
        I('I'){},
        V('V'){},
        X('X'){},
        L('L'){},
        C('C'){},
        D('D'){},
        M('M'){};

        private final Character number;

        private static final Set<Character> enumSet = Stream.of(Symbols.values())
                .map(v->v.number).collect(Collectors.toSet());

        public static boolean contains(char i) {
            return enumSet.contains(i);
        }
    }
}
