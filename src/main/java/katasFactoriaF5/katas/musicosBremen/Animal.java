package katasFactoriaF5.katas.musicosBremen;

import java.util.Objects;

public abstract class Animal {
    protected String name;
    protected String sing;
    public boolean isSinging;

    public Animal(String name, String sing) {
        this.name = name;
        this.sing = sing;
    }

    public String getSing() {
        return sing;
    }

    public String getName() {
        return name;
    }

    public String startSinging(){
        isSinging = true;
        return sing;
    }

    public void stopSinging(){
        isSinging = false;
    }

    abstract String message();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        Animal person = (Animal) o;

        return Objects.equals(name, person.name)
                && Objects.equals(sing, person.sing);
    }

}
