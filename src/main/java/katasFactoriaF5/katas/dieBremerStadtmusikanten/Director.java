package katasFactoriaF5.katas.dieBremerStadtmusikanten;

import lombok.Getter;

import java.util.List;

public class Director{
    @Getter
    final List<Singer> singers;

    public Director(List<Singer> singers) {
        this.singers = singers;
    }

    public void startSing() {
        singers.forEach(Singer::startSinging);
    }

    public void stopSing() {
        singers.forEach(Singer::stopSinging);
    }
}
