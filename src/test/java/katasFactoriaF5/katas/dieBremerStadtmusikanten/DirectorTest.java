package katasFactoriaF5.katas.dieBremerStadtmusikanten;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DirectorTest {

    Director director;

    Singer cat = new Cat("Garfield", "Singing in the rain");
    Singer donkey = new Donkey("Donkey", "Singing in the day");
    Singer comicCharacter = new ComicCharacter("Mafalda", "Don't want to sing");

    @BeforeEach
    void beforeEach(){
        director = new Director(List.of(cat, donkey, comicCharacter));
    }

    @Test
    void directorHasAListOfAnimals(){
        assertEquals(director.getSingers(), List.of(cat,donkey, comicCharacter));
    }

    @Test
    void directorCanMakeSingAnimals(){
        director.startSing();

        assertTrue(cat.isSinging());
        assertTrue(donkey.isSinging());
    }

    @Test
    void directorCanMakeStopToSingAnimals(){
        director.startSing();
        director.stopSing();

        assertFalse(cat.isSinging());
        assertFalse(donkey.isSinging());
    }

}