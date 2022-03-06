package katasFactoriaF5.katas.dieBremerStadtmusikanten;

import lombok.Getter;


public abstract class Animal{
    @Getter
    protected String name;

    public Animal(String name) {
        this.name = name;
    }
}
