package solvers;

import data.Amphi;
import data.Seat;
import org.junit.jupiter.api.Test;
import solvers.move.PossibleMove;
import solvers.neighborhood.Neighborhood;

import java.util.ArrayList;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class SimulatedAnnealingTest {

    @Test
    void solve() {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        SimulatedAnnealing sa = new SimulatedAnnealing(new PossibleMove(),new Neighborhood(amphi,true),100, HillClimber.MoveChoice.DEFAULT);
        //amphi.greedySolution();
        amphi = sa.solve(amphi);
        Logger.getGlobal().info("valide? : " + amphi.isValid() + " nb sieges occupés : " + amphi.occupiedSeats());
        for (Seat s : amphi.getListSeat())
        {
            if (!s.isFree()) {
                Logger.getGlobal().info("ID : " + s.getID()
                        + " x : " + s.getX()
                        + " Y : " + s.getY()
                        + " Libre ? : " + s.isFree());
            }
        }
        Logger.getGlobal().info("Execution time = "+sa.executionTime()+"s");
        assertTrue(amphi.occupiedSeats()>0);
        assertTrue(amphi.isValid());
    }
}