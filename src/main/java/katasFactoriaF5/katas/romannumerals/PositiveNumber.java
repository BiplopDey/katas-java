package katasFactoriaF5.katas.romannumerals;

import lombok.Getter;

@Getter
public class PositiveNumber {
    private final Integer number;
//    private final List<Integer> base10descomp = new ArrayList<>();

    public PositiveNumber(Integer number){
        if(number<=0)
            throw new RuntimeException("Number must be postive");

        this.number = number;
    }

    public static PositiveNumber of(Integer number){
        return new PositiveNumber(number);
    }

    public int getUnits() {
        return number%10;
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
