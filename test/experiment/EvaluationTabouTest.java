package experiment;

import data.Amphi;
import data.Seat;
import org.junit.jupiter.api.Test;
import solvers.HillClimber;
import solvers.Solver;
import solvers.Tabou;
import solvers.move.PossibleMove;
import solvers.neighborhood.Neighborhood;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EvaluationTabouTest
{
    @Test
    void tabou_test()
    {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), 100, listSeats);

        Solver s = new Tabou(new PossibleMove(),
                new Neighborhood(amphi,true),100,
                Tabou.MoveChoice.DEFAULT, Tabou.StopChoice.ITERATION);
        Evaluation evaluation = new Evaluation(s,100,amphi);

        evaluation.experiment();

        evaluation.exportCSV(new File("tabou_test.csv"));
    }

    @Test
    void tabouTestV4()
    {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        for(int beta = 100; beta <= 200; beta = beta + 20)
        {
            Amphi amphi = new Amphi(listSeats.size(), beta, listSeats);

            Solver s = new Tabou(new PossibleMove(),
                    new Neighborhood(amphi,true),100,
                    Tabou.MoveChoice.DEFAULT, Tabou.StopChoice.ITERATION);
            Evaluation evaluation = new Evaluation(s,100,amphi);

            evaluation.experiment();

            evaluation.exportCSV(new File("sa_experience/tabouTest/Voisinage4/tabouTestV4Beta"+ beta +".csv"));
        }
    }

    @Test
    void tabouTestV8()
    {
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        for(int beta = 100; beta <= 200; beta = beta + 20)
        {
            Amphi amphi = new Amphi(listSeats.size(), beta, listSeats);

            Solver s = new Tabou(new PossibleMove(),
                    new Neighborhood(amphi,false),100,
                    Tabou.MoveChoice.DEFAULT, Tabou.StopChoice.ITERATION);
            Evaluation evaluation = new Evaluation(s,100,amphi);

            evaluation.experiment();

            evaluation.exportCSV(new File("sa_experience/tabouTest/Voisinage8/tabouTestV8Beta"+ beta +".csv"));
        }
    }
}