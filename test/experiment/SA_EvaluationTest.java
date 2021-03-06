package experiment;

import data.Amphi;
import data.Seat;
import org.junit.jupiter.api.Test;
import solvers.HillClimber;
import solvers.SimulatedAnnealing;
import solvers.move.PossibleMove;
import solvers.neighborhood.AroundNeighborhood;
import solvers.neighborhood.Neighborhood;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;

public class SA_EvaluationTest {
    @Test
    void voisinageTest() {
        int beta = 100;
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi = new Amphi(listSeats.size(), beta, listSeats);

        SimulatedAnnealing voisin4 = new SimulatedAnnealing(new PossibleMove(),new Neighborhood(amphi,false),100, HillClimber.MoveChoice.DEFAULT);

        Evaluation evaluation = new Evaluation(voisin4,100,amphi.deepCopy());
        evaluation.experiment();
        evaluation.exportCSV(new File("sa_experience/voisin4-"+beta+".csv"));

        /* voisinage 8 */
        SimulatedAnnealing voisin8 = new SimulatedAnnealing(new PossibleMove(),new Neighborhood(amphi,true),100, HillClimber.MoveChoice.DEFAULT);

        evaluation = new Evaluation(voisin8,100,amphi.deepCopy());
        evaluation.experiment();
        evaluation.exportCSV(new File("sa_experience/voisin8-"+beta+".csv"));

        /* voisinage par distance */
        SimulatedAnnealing distance = new SimulatedAnnealing(new PossibleMove(),new AroundNeighborhood(beta),100, HillClimber.MoveChoice.DEFAULT);

        evaluation = new Evaluation(distance,100,amphi.deepCopy());
        evaluation.experiment();
        evaluation.exportCSV(new File("sa_experience/distance-"+beta+".csv"));
    }

    @Test
    void moveTest(){
        Evaluation evaluation;
        SimulatedAnnealing distance;
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);

        for(int beta = 100 ; beta <= 200 ; beta += 20){
            Logger.getGlobal().info("Bêta = "+beta);
            Amphi amphi = new Amphi(listSeats.size(), beta, listSeats);

            /* allow free <- true */
            distance = new SimulatedAnnealing(new PossibleMove(true,true),new AroundNeighborhood(beta),100, HillClimber.MoveChoice.DEFAULT);

            evaluation = new Evaluation(distance,100,amphi.deepCopy());
            evaluation.experiment();
            evaluation.exportCSV(new File("sa_experience/possible_rewind-"+beta+".csv"));

            /* forbid free <- true and useless moves*/
            distance = new SimulatedAnnealing(new PossibleMove(false,true),new AroundNeighborhood(beta),100, HillClimber.MoveChoice.DEFAULT);

            evaluation = new Evaluation(distance,100,amphi.deepCopy());
            evaluation.experiment();
            evaluation.exportCSV(new File("sa_experience/possible_useless-"+beta+".csv"));

            /* forbid free <- true and not useless moves*/
            distance = new SimulatedAnnealing(new PossibleMove(false,false),new AroundNeighborhood(beta),100, HillClimber.MoveChoice.DEFAULT);

            evaluation = new Evaluation(distance,100,amphi.deepCopy());
            evaluation.experiment();
            evaluation.exportCSV(new File("sa_experience/possible_not_useless-"+beta+".csv"));
        }
    }

    @Test
    void iterationTest(){
        int beta = 100;
        Evaluation evaluation;
        SimulatedAnnealing distance;
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);

        for(int it = 100 ; it <= 500 ; it+= 100) {
            Logger.getGlobal().info("Bêta = " + beta + "+ iteration : " + it);
            Amphi amphi = new Amphi(listSeats.size(), beta, listSeats);

            distance = new SimulatedAnnealing(new PossibleMove(false, false), new AroundNeighborhood(beta), it, HillClimber.MoveChoice.DEFAULT);

            evaluation = new Evaluation(distance, 100, amphi.deepCopy());
            evaluation.experiment();
            evaluation.exportCSV(new File("sa_experience/iteration/eval-" + it + ".csv"));
        }
    }

    @Test
    /**
     * Similar to iterationTest where we can unload seat
     */
    void iterationTest2(){
        int beta = 100;
        Evaluation evaluation;
        SimulatedAnnealing distance;
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);

        for(int it = 100 ; it <= 500 ; it+= 100) {
            Logger.getGlobal().info("Bêta = " + beta + "+ iteration : " + it);
            Amphi amphi = new Amphi(listSeats.size(), beta, listSeats);

            distance = new SimulatedAnnealing(new PossibleMove(true, false), new AroundNeighborhood(beta), it, HillClimber.MoveChoice.DEFAULT);

            evaluation = new Evaluation(distance, 100, amphi.deepCopy());
            evaluation.experiment();
            evaluation.exportCSV(new File("sa_experience/iteration2/eval-" + it + ".csv"));
        }
    }

    @Test
    void finalTest(){
        int it = 200;
        Evaluation evaluation;
        SimulatedAnnealing distance;
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi;

        for(int beta = 100 ; beta <= 200 ; beta += 20) {
            Logger.getGlobal().info("Bêta = " + beta + "+ iteration : " + it +" sans greedy");
            amphi = new Amphi(listSeats.size(), beta, listSeats);

            distance = new SimulatedAnnealing(new PossibleMove(false, false), new AroundNeighborhood(beta), it, HillClimber.MoveChoice.DEFAULT);

            evaluation = new Evaluation(distance, 100, amphi.deepCopy());
            evaluation.experiment();
            evaluation.exportCSV(new File("sa_experience/final/eval-" + beta + "sg.csv"));

            Logger.getGlobal().info("Bêta = " + beta + "+ iteration : " + it +" avec greedy");
            amphi = new Amphi(listSeats.size(), beta, listSeats);
            amphi.greedySolution();
            distance = new SimulatedAnnealing(new PossibleMove(true, false), new AroundNeighborhood(beta), it, HillClimber.MoveChoice.DEFAULT);

            evaluation = new Evaluation(distance, 100, amphi.deepCopy());
            evaluation.experiment();
            evaluation.exportCSV(new File("sa_experience/final/eval-" + beta + "ag.csv"));
        }
    }

    @Test
    /**
     * Test when we increase the number of iteration
     */
    void bigIterationTest(){
        int it = 1000;
        Evaluation evaluation;
        SimulatedAnnealing distance;
        Seat seat = new Seat(true);
        ArrayList<Seat> listSeats = new ArrayList<>();
        seat.loadSeat(listSeats);
        Amphi amphi;

        for(int beta = 100 ; beta <= 200 ; beta += 20) {
            Logger.getGlobal().info("Bêta = " + beta + "+ iteration : " + it);
            amphi = new Amphi(listSeats.size(), beta, listSeats);
            amphi.greedySolution();
            distance = new SimulatedAnnealing(new PossibleMove(true, false), new AroundNeighborhood(beta), it, HillClimber.MoveChoice.DEFAULT);

            evaluation = new Evaluation(distance, 10, amphi.deepCopy());
            evaluation.experiment();
            evaluation.exportCSV(new File("sa_experience/big_iteration/" + beta + ".csv"));
        }
    }
}
