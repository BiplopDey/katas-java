package katasFactoriaF5.katas.DieBremerStadtmusikanten;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatTest {
    Cat catSinger;

    @BeforeEach
    void beforeEach(){
        catSinger = new Cat("Garfield", "Canto esto");
    }


    @Test
    void catGetName(){
        assertEquals(catSinger.getName(), "Garfield");
        assertEquals(catSinger.getSong(),"Canto esto");
    }

    @Test
    void catSing(){
        assertEquals(catSinger.startSinging(),"Canto esto" );
    }

    @Test
    void catCanStopSinging() {
        catSinger.stopSinging();

        assertFalse(catSinger.isSinging());
    }
    @Test
    void catMessageIsSinging(){
        catSinger.startSinging();

        assertEquals(catSinger.message(), "El gato " + catSinger.getName() +" está cantado "+catSinger.getSong() );
    }

    @Test
    void catMessageIsNotSinging(){
        catSinger.stopSinging();

        assertEquals(catSinger.message(), "el gato " +  catSinger.getName()+ " no quiere cantar" );
    }
}