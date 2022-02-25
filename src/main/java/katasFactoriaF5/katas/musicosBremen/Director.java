package katasFactoriaF5.katas.musicosBremen;

import lombok.Getter;

import java.util.List;


public class Director extends Animal{

    @Getter
    final List<Singer> singers;

    public Director(String name, List<Singer> singers) {
        super(name);
        this.singers = singers;
    }

    public void startSing() {
        singers.forEach(Singer::startSinging);
    }

    public void stopSing() {
        singers.forEach(Singer::stopSinging);
    }
}
