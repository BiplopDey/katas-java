package katasFactoriaF5.katas.musicosBremen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsnoTest {
    Asno asnoSinger;

    @BeforeEach

    void beforeEach() {
        asnoSinger = new Asno("Garfield", "Canto esto");
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
