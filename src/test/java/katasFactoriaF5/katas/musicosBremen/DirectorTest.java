package katasFactoriaF5.katas.musicosBremen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DirectorTest {

    Director director;

    Animal cat = new Cat("Garfield", "Singing in the rain");
    Animal donkey = new Cat("Donkey", "Singing in the day");

    @BeforeEach
    void beforeEach(){
        director = new Director(List.of(cat,donkey));
    }

    @Test
    void directorHasAListOfAnimals(){
        assertEquals(director.getSingers(), List.of(cat,donkey));
    }
}