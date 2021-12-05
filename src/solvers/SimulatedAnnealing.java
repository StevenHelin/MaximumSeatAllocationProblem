package solvers;

import data.Amphi;
import data.Seat;
import solvers.move.Move;
import solvers.move.MoveI;
import solvers.neighborhood.NeighborhoodI;

import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;

public class SimulatedAnnealing extends HillClimber{

    private boolean asSolutionImproved;

    private double temperature;
    private Random r;

    public SimulatedAnnealing(MoveI movei, NeighborhoodI neighborhoodi, int interation, MoveChoice moveChoice) {
        super(movei, neighborhoodi, interation, moveChoice, StopChoice.ITERATION);
        this.r = new Random();
    }

    private void initTemperature(){
        this.temperature = 10;
    }
    private void updateTemperature(){
        this.temperature*=0.95;
    }

    @Override
    public Amphi solve(Amphi xd) {
        // todo
        s = System.currentTimeMillis();/* for execution time only */
        Amphi x= xd.deepCopy(),xstar = xd.deepCopy();
        Move selectmove;
        int i=0;
        initTemperature();
        /* choose a seat to start */
        Seat siegeSelect = choixSiege(x);
        while (critereArret(i)){
            this.asSolutionImproved = false;
            /* select a move between all possible moves */
            selectmove = chooseMove(movei.getMoves(neighborhoodi.getNeighborhood(x,siegeSelect),x));
            if(selectmove==null){
                Logger.getGlobal().info("Arrêt par move inexistant à " + siegeSelect + "et i = " + i);
                break;
            }
            /* change the current solution if the affection is allowed */
            if (isValid(selectmove,x)){
                /* find the seat used for the move */
                Move finalSelectmove = selectmove;
                Optional<Seat> seat=x.getListSeat().stream().filter(L->L.getID()== finalSelectmove.getSeat().getID()).findFirst();
                if(seat.isPresent()){
                    /* change the current solution */
                    seat.get().setFree(finalSelectmove.isValue_free());

                    int delta = x.occupiedSeats() - xstar.occupiedSeats();
                    if(delta > 0){
                        /* change xstar if the current solution is better */
                        asSolutionImproved = true;
                        xstar = x.deepCopy();
                        siegeSelect=seat.get();
                    }else if(r.nextDouble() > Math.exp(-1 / temperature)){
                        asSolutionImproved = true;
                        xstar = x.deepCopy();
                        siegeSelect=seat.get();
                    }else{
                        seat.get().setFree(!finalSelectmove.isValue_free());
                    }
                }else Logger.getGlobal().warning("Can't find the seat");
            }
            i++;
            updateTemperature();
        }
        /* for execution time update */
        e = System.currentTimeMillis();
        return xstar;
    }
}
