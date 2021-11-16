package data;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AmphiTest {

    @Test
    void greedy() {
    }

    @Test
    void greedySolution() {
    }

    @Test
    void deepCopy() {
        List<Seat> seats = new ArrayList<>();
        Random r = new Random();
        for (int i = 1 ; i < 50; i++){
            seats.add(new Seat(i,i*25,i*25,r.nextBoolean()));
        }
        Amphi a1 = new Amphi(49,100,seats);
        Amphi a2 = a1.deepCopy();
        assertEquals(a1,a2);
    }
}