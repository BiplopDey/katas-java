package katasFactoriaF5.katas.dieBremerStadtmusikanten;

public interface Singer {

    String getSong();
    String message();
    boolean isSinging();
    void sing(boolean bool);

    default String startSinging(){
        sing(true);
        return getSong();
    }

    default void stopSinging(){
        sing(false);
    }

}
