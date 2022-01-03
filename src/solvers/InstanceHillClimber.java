package solvers;

import data.Amphi;
import solvers.move.MoveI;
import solvers.move.PossibleMove;
import solvers.neighborhood.Neighborhood;
import solvers.neighborhood.NeighborhoodI;

public class InstanceHillClimber extends Thread{

    private Amphi amphi;
    public InstanceHillClimber(MoveI movei, NeighborhoodI neighborhoodi, int interation, HillClimber.MoveChoice moveChoice, HillClimber.StopChoice stopChoice, Amphi amphi){
        this.amphi = amphi;
    }

    public void run() {
        try {
            HillClimber hillClimber = new HillClimber(new PossibleMove(), new Neighborhood(amphi, true), 100, HillClimber.MoveChoice.DEFAULT, HillClimber.StopChoice.ITERATION);
        } catch (InterruptedException ex) {
            System.out.println("Processus léger interrompu");
        }
    }
}
