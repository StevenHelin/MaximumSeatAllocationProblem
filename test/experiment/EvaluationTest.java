package experiment;

import data.Amphi;
import data.Seat;
import org.junit.jupiter.api.Test;
import solvers.HillClimber;
import solvers.Solver;
import solvers.move.PossibleMove;
import solvers.neighborhood.AroundNeighborhood;
import solvers.neighborhood.Neighborhood;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EvaluationTest {

    @Test
    void hillClimber_test() {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 200, listSeats);

        Solver s = new HillClimber(new PossibleMove(),
            new AroundNeighborhood(amphi.getBeta()),100,
                HillClimber.MoveChoice.DEFAULT, HillClimber.StopChoice.ITERATION);
        Evaluation evaluation = new Evaluation(s,100,amphi);

        evaluation.experiment();

        evaluation.exportCSV(new File("hillclimber_test.csv"));
    }
}