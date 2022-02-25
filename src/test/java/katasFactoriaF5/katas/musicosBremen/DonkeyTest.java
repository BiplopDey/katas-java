package katasFactoriaF5.katas.musicosBremen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DonkeyTest {
    Donkey asnoSinger;

    @BeforeEach

    void beforeEach() {
        asnoSinger = new Donkey("Garfield", "Canto esto");
    }
    @Test
    void asnoMessageIsNotSinging(){
        asnoSinger.stopSinging();

        assertEquals(asnoSinger.message(), "el asno " +  asnoSinger.getName()+ " no quiere cantar" );
    }
    @Test
    void catMessageIsSinging(){
        asnoSinger.startSinging();

        assertEquals(asnoSinger.message(), "El asno " + asnoSinger.getName() +" está cantado "+asnoSinger.getSong() );
    }

}
