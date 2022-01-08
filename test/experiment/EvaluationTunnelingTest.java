package experiment;

import data.Amphi;
import data.Seat;
import org.junit.jupiter.api.Test;
import solvers.HillClimber;
import solvers.Solver;
import solvers.Tunneling;
import solvers.move.PossibleMove;
import solvers.neighborhood.AroundNeighborhood;
import solvers.neighborhood.Neighborhood;

import java.io.File;
import java.util.ArrayList;

public class EvaluationTunnelingTest {
    @Test
    void tunneling_test() {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);

        Solver s;
        Evaluation evaluation;
        // tunneling with neighborhood = 4 and only non occupied
        s = new Tunneling(new PossibleMove(false,false),new Neighborhood(amphi,true),100, Tunneling.MoveChoice.DEFAULT, Tunneling.StopChoice.ITERATION,20);
        evaluation = new Evaluation(s,100,amphi);

        evaluation.experiment();

        evaluation.exportCSV(new File("tunneling_4neighbor_non-occupied_test.csv"));

        // tunneling with neighborhood = 8 and only non occupied
        amphi = amphi.deepCopy();
        s = new Tunneling(new PossibleMove(false,false),new Neighborhood(amphi,false),100, Tunneling.MoveChoice.DEFAULT, Tunneling.StopChoice.ITERATION,20);
        evaluation = new Evaluation(s,100,amphi);

        evaluation.experiment();

        evaluation.exportCSV(new File("tunneling_8neighbor_non-occupied_test.csv"));

        // tunneling with neighborhood > beta and only non occupied
        amphi = amphi.deepCopy();
        s = new Tunneling(new PossibleMove(false,false),new AroundNeighborhood(amphi.getBeta()),100, Tunneling.MoveChoice.DEFAULT, Tunneling.StopChoice.ITERATION,20);
        evaluation = new Evaluation(s,100,amphi);

        evaluation.experiment();

        evaluation.exportCSV(new File("tunneling_betaneighbor_non-occupied_test.csv"));

        // tunneling with neighborhood = 4 and occupy/free places
        amphi = amphi.deepCopy();
        s = new Tunneling(new PossibleMove(true,false),new Neighborhood(amphi,true),100, Tunneling.MoveChoice.DEFAULT, Tunneling.StopChoice.ITERATION,20);
        evaluation = new Evaluation(s,100,amphi);

        evaluation.experiment();

        evaluation.exportCSV(new File("tunneling_4neighbor_occupy-free_test.csv"));

        // tunneling with neighborhood = 8 and occupy/free places
        amphi = amphi.deepCopy();
        s = new Tunneling(new PossibleMove(true,false),new Neighborhood(amphi,false),100, Tunneling.MoveChoice.DEFAULT, Tunneling.StopChoice.ITERATION,20);
        evaluation = new Evaluation(s,100,amphi);

        evaluation.experiment();

        evaluation.exportCSV(new File("tunneling_8neighbor_occupy-free_test.csv"));

        // tunneling with neighborhood > beta and occupy/free places
        amphi = amphi.deepCopy();
        s = new Tunneling(new PossibleMove(true,false),new AroundNeighborhood(amphi.getBeta()),100, Tunneling.MoveChoice.DEFAULT, Tunneling.StopChoice.ITERATION,20);
        evaluation = new Evaluation(s,100,amphi);

        evaluation.experiment();

        evaluation.exportCSV(new File("tunneling_betaneighbor_occupy-free_test.csv"));

        // tunneling with neighborhood = 4 and useless moves
        amphi = amphi.deepCopy();
        s = new Tunneling(new PossibleMove(false,true),new Neighborhood(amphi,true),100, Tunneling.MoveChoice.DEFAULT, Tunneling.StopChoice.ITERATION,20);
        evaluation = new Evaluation(s,100,amphi);

        evaluation.experiment();

        evaluation.exportCSV(new File("tunneling_4neighbor_useless-moves_test.csv"));

        // tunneling with neighborhood = 8 and useless moves
        amphi = amphi.deepCopy();
        s = new Tunneling(new PossibleMove(false,true),new Neighborhood(amphi,false),100, Tunneling.MoveChoice.DEFAULT, Tunneling.StopChoice.ITERATION,20);
        evaluation = new Evaluation(s,100,amphi);

        evaluation.experiment();

        evaluation.exportCSV(new File("tunneling_8neighbor_useless-moves_test.csv"));

        // tunneling with neighborhood > beta and useless moves
        amphi = amphi.deepCopy();
        s = new Tunneling(new PossibleMove(false,true),new AroundNeighborhood(amphi.getBeta()),100, Tunneling.MoveChoice.DEFAULT, Tunneling.StopChoice.ITERATION,20);
        evaluation = new Evaluation(s,100,amphi);

        evaluation.experiment();

        evaluation.exportCSV(new File("tunneling_betaneighbor_useless-moves_test.csv"));

    }
}
