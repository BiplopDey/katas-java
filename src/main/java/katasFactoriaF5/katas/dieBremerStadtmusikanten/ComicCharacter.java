package katasFactoriaF5.katas.dieBremerStadtmusikanten;

import lombok.Getter;

public class ComicCharacter implements Singer {
    private boolean isSinging=false;
    private String song;
    @Getter
    private String name;
    public ComicCharacter(String name, String song) {
        this.name = name;
        this.song = song;
    }

    @Override
    public String getSong() {
        return null;
    }

    @Override
    public String message() {
        return null;
    }

    @Override
    public boolean isSinging() {
        return isSinging;
    }

    @Override
    public void sing(boolean bool) {
        isSinging = true;
    }
}
