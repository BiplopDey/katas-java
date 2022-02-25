package katasFactoriaF5.katas.musicosBremen;

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

}
