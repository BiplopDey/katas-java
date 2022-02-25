package katasFactoriaF5.katas.musicosBremen;

import lombok.Getter;

import java.util.Objects;

public abstract class Animal {
    @Getter
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        Animal person = (Animal) o;

        return Objects.equals(name, person.name);
    }

}
