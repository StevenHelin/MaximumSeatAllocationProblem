package data;

import org.junit.jupiter.api.Test;
import solvers.HillClimber;
import solvers.SimulatedAnnealing;
import solvers.move.PossibleMove;
import solvers.neighborhood.Neighborhood;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class AmphiUtilsTest {

    @Test
    /**
     * Check if a simple export works
     */
    void exportImage() {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        amphi.greedySolution();
        File f = new File("image.jpg");
        Logger.getGlobal().info("Exported to "+f.getAbsolutePath());
        try {
            assertTrue(AmphiUtils.exportImage(f, amphi));
        }catch (Exception e){
            fail();
        }
    }

    @Test
    /**
     * Check if a simple export works
     */
    void exportWrongFormatImage() {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        amphi.greedySolution();
        File f = new File("image.png");
        Logger.getGlobal().info("Exported to "+f.getAbsolutePath());
        try {
            assertFalse(AmphiUtils.exportImage(f, amphi));
        }catch (Exception e){
            fail();
        }
    }
}