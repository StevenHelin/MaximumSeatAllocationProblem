package data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatTest {

    @Test
    void copy() {
        Seat s1 = new Seat(3, 23, 35, true);
        Seat s2 = s1.copy();
        assertEquals(s1,s2);
    }
}