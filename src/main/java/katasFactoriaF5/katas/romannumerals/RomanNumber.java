package katasFactoriaF5.katas.romannumerals;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EqualsAndHashCode
@Getter
public class RomanNumber {
    final private String number;

    public RomanNumber(String number) {
        number = number.toUpperCase();
        if(!isValid(number))
            throw new RuntimeException("Invalid roman number");

        this.number = number;
    }

    public RomanNumber(Basis number){
        this.number = String.valueOf(number.getNumber());
    }

    public static RomanNumber of(String number) {
        return new RomanNumber(number);
    }

    public static RomanNumber of(Basis number) {
        return new RomanNumber(number);
    }

    private boolean isValid(String number){
        return number.chars().filter(i -> Basis.contains( (char) i)).count() == number.length()
                && !consecutiveRepeateMoreThan3(number);
    }

    private boolean consecutiveRepeateMoreThan3(String number){
        for (int i = 0; i < number.length()-3; i++) {
            if(number.charAt(i) == number.charAt(i+1) &&
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

    @Getter
    @AllArgsConstructor
    enum Basis{
        I('I'){},
        V('V'){},
        X('X'){},
        L('L'){},
        C('C'){},
        D('D'){},
        M('M'){};

        private final Character number;

        private static final Set<Character> enumSet = Stream.of(Basis.values())
                .map(v->v.number).collect(Collectors.toSet());

        public static boolean contains(char i) {
            return enumSet.contains(i);
        }
    }
}
