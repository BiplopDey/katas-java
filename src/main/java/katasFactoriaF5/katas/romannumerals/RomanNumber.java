package katasFactoriaF5.katas.romannumerals;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EqualsAndHashCode
public class RomanNumber {
    @Getter
    final private List<Symbols> number;
    final private Map<Symbols,Symbols> mapMultiplyTen = Map.of(
            Symbols.I,Symbols.X,
            Symbols.X,Symbols.C,
            Symbols.C,Symbols.M,
            Symbols.V,Symbols.L,
            Symbols.L,Symbols.D
            );

    public RomanNumber(String number) {
        number = formatNumber(number);
        if(!isValid(number))
            throw new IllegalArgumentException();

        this.number = number
                .chars()
                .mapToObj(i -> Symbols.valueOf(String.valueOf((char) i)))
                .collect(Collectors.toList());
    }

    private String formatNumber(String number){
        if(number == null || number.isBlank())
            throw new IllegalArgumentException();
        return number.trim().toUpperCase();
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
        return  number
                .chars()
                .filter(i -> Symbols.contains((char) i))
                .count() == number.length()
                && !consecutiveRepeatedMoreThan3(number);
    }

    private boolean consecutiveRepeatedMoreThan3(String number){
        for (int i = 0; i < number.length()-3; i++)
            if (
                    number.charAt(i) == number.charAt(i+1) &&
                    number.charAt(i+1) == number.charAt(i+2) &&
                    number.charAt(i+2) == number.charAt(i+3)
            )
                return true;
        return false;
    }

    public RomanNumber multiplyByTen() {
        String multipliedNum = number
                .stream()
                .map(s->multiplyByTen(s).number+"")
                .reduce("",(s1,s2)->s1+s2);

        return RomanNumber.of(multipliedNum);
    }

    private Symbols multiplyByTen(Symbols s){
        if(!mapMultiplyTen.containsKey(s))
            throw new NumberExceeds3999Exception();
        return mapMultiplyTen.get(s);
    }

    public RomanNumber multiplyByDecimalBase(int i){
        if(!Set.of(1,10,100,1000).contains(i))
            throw new IllegalArgumentException();

        RomanNumber romanNumber = this;
        while(i/10!=0){
            romanNumber = romanNumber.multiplyByTen();
            i/=10;
        }
        return romanNumber;
    }

    public RomanNumber multiplyByHundred() {
        return multiplyByDecimalBase(100);
    }

    public RomanNumber multiplyByThousand() {
        return multiplyByDecimalBase(1000);
    }

    public RomanNumber concatenate(RomanNumber i) {
        if(i!=null)
            this.number.addAll(i.getNumber());
        return RomanNumber.of(toString());
    }

    public class NumberExceeds3999Exception extends RuntimeException{
        public NumberExceeds3999Exception() {
            super("The number Exceeds 3999");
        }
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

        private static final Set<Character> enumSet = Stream
                .of(Symbols.values())
                .map(v->v.number)
                .collect(Collectors.toSet());

        public static boolean contains(char i) {
            return enumSet.contains(i);
        }
    }

    @Override
    public String toString(){
        return number
                .stream()
                .map(s->String.valueOf(s.getNumber()))
                .reduce("",(a,b)->a+b);
    }
}
