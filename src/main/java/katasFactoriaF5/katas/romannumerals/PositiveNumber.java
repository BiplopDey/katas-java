package katasFactoriaF5.katas.romannumerals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class PositiveNumber {
    private final Integer number;

    public PositiveNumber(Integer number){
        if(number<=0)
            throw new RuntimeException("Number must be postive");
        this.number = number;
    }
    public static PositiveNumber of(Integer number){
        return new PositiveNumber(number);
    }
}
