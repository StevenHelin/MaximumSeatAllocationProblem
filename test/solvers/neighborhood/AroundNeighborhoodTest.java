package solvers.neighborhood;

import data.Amphi;
import data.Seat;
import org.junit.jupiter.api.Test;
import solvers.HillClimber;
import solvers.SimulatedAnnealing;
import solvers.move.PossibleMove;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class AroundNeighborhoodTest {

    @Test
    void getNeighborhood() {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        AroundNeighborhood neighborhood = new AroundNeighborhood(150);
        List<Seat> list = neighborhood.getNeighborhood(amphi,amphi.getListSeat().get(0));
        Logger.getGlobal().info(list.toString());
        assertNotEquals(0,list.size());
    }

    @Test
    void getNeighborhood2() {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        AroundNeighborhood neighborhood = new AroundNeighborhood(1500);
        List<Seat> list = neighborhood.getNeighborhood(amphi,amphi.getListSeat().get(0));
        Logger.getGlobal().info(list.toString());
        assertEquals(0,list.size());
    }
}