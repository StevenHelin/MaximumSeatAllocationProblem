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
    void exportImage() throws IOException {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);
        amphi.greedySolution();
        File f = new File("image.jpg");
        Logger.getGlobal().info("Exported to "+f.getAbsolutePath());
        AmphiUtils.exportImage(f,amphi);
    }
}