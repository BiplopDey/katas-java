package katasFactoriaF5.katas.DieBremerStadtmusikanten;

import lombok.Getter;

public abstract class ChoirMember implements Singer {
    private boolean isSinging=false;
    private String song;

    public ChoirMember(String song) {
        this.song = song;
    }

    @Override
    public String getSong() {
        return song;
    }

    @Override
    public boolean isSinging() {
        return isSinging;
    }

    @Override
    public void sing(boolean bool) {
        isSinging=bool;
    }
}
