package solvers;

import data.Amphi;
import solvers.move.MoveI;
import solvers.move.PossibleMove;
import solvers.neighborhood.Neighborhood;
import solvers.neighborhood.NeighborhoodI;

public class InstanceHillClimber extends Thread{

    private Amphi amphi;
    private Amphi amphisoluce;
    private MoveI movei;
    private NeighborhoodI neighborhoodi;
    private int interation;
    private HillClimber.MoveChoice moveChoice;
    private HillClimber.StopChoice stopChoice;

    public InstanceHillClimber(MoveI movei, NeighborhoodI neighborhoodi, int interation, HillClimber.MoveChoice moveChoice, HillClimber.StopChoice stopChoice, Amphi amphi){
        this.amphi = amphi;
        this.movei = movei;
        this.neighborhoodi = neighborhoodi;
        this.interation = interation;
        this.moveChoice = moveChoice;
        this.stopChoice = stopChoice;
        this.amphisoluce =this.amphi;
    }

    public void run() {
        HillClimber hillClimber = new HillClimber(movei, neighborhoodi, interation, moveChoice, stopChoice);
        amphisoluce=hillClimber.solve(amphi);
    }

    public Amphi getAmphisoluce() {
        return amphisoluce;
    }

    public void setAmphisoluce(Amphi amphisoluce) {
        this.amphisoluce = amphisoluce;
    }
}
