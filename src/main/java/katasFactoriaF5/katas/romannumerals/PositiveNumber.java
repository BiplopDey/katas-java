package katasFactoriaF5.katas.romannumerals;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class PositiveNumber {
    private final Integer number;
    private final List<Integer> base10descomp;
    private final Set<Integer> base10 = Set.of(1,10,100,1000);

    public PositiveNumber(Integer number){
        if(number<=0)
            throw new RuntimeException("Number must be postive");

        this.number = number;

        base10descomp = base10.stream()
                .sorted(Comparator.reverseOrder())
                .filter(this::hasCoefOfDecimalBase)
                .map(this::getCoefOfDecimalBase)
                .collect(Collectors.toList());
    }

    public List<Integer> getBase10descomp() {
        return base10descomp;
    }

    public static PositiveNumber of(Integer number){
        return new PositiveNumber(number);
    }

    public int getUnits() {
        return number%10;
    }


    public int getCoefOfDecimalBase(Integer i) {
        if(!base10.contains(i))
            throw new IllegalArgumentException("Base must be decimal");
        if(!hasCoefOfDecimalBase(i))
            throw new RuntimeException("Number does not have coef of base "+i);

        return (number%(i*10))/i;
    }

    private boolean hasCoefOfDecimalBase(int i) {
        return number >= i;
    }

    public int getTens() {
        if(!hasTens())
            throw new RuntimeException("Number does not have tens");
        return (number%100)/10;
    }

    public boolean canGetTens() {
        return hasTens() && getTens() != 0;
    }

    public int getHundreds(){
        if(!hasHundreds())
            throw new RuntimeException("Number does not have hundreds");
        return (number%1000)/100;
    }

    public int getThousands() {
        if(!hasThousands())
            throw new RuntimeException("Number does not have a thousand");
        return (number%10000)/1000;
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (number.equals(obj))
            return true;

        if (getClass() != obj.getClass())
            return false;
        PositiveNumber other = (PositiveNumber) obj;
        return number.equals(other.number);
    }

    private boolean hasThousands() {
        return number >= 1000;
    }

    private boolean hasHundreds() {
        return number >= 100;
    }

    private boolean hasTens() {
        return number >= 10;
    }

    public boolean canGetUnits() {
        return getUnits()!=0;
    }

    public boolean canGetHundreds() {
        return hasHundreds() && getHundreds() != 0;
    }

    public boolean canGetThousands() {
        return hasThousands();
    }


}
