package katasFactoriaF5.katas.musicosBremen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DirectorTest {

    Director director;

    Singer cat = new Cat("Garfield", "Singing in the rain");
    Singer donkey = new Cat("Donkey", "Singing in the day");

    @BeforeEach
    void beforeEach(){
        director = new Director("Bob",List.of(cat,donkey));
    }

    @Test
    void directorHasAListOfAnimals(){
        assertEquals(director.getSingers(), List.of(cat,donkey));
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