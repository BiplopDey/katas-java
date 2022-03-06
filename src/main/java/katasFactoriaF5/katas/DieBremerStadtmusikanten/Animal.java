package katasFactoriaF5.katas.DieBremerStadtmusikanten;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;


public abstract class Animal{
    @Getter
    protected String name;

    public Animal(String name) {
        this.name = name;
    }
}
