package solvers;

import data.*;
import solvers.move.Move;
import solvers.move.MoveI;
import solvers.neighborhood.NeighborhoodI;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;

public class HillClimber implements Solver {
    MoveI movei;
    NeighborhoodI neighborhoodi;
    int interation;
    MoveChoice moveChoice;
    StopChoice stopChoice;

    /* if the solution has been improved during an iteration */
    private boolean asSolutionImproved;
    /* for the execution time measurement */
    long e,s;

    /* list all the possible ways to choose a move */
    public enum MoveChoice{
        RANDOM,FIRST,LAST;

        public static final MoveChoice DEFAULT = MoveChoice.RANDOM;
    }
    /* list all the possible "critères d'arrêt" */
    public enum StopChoice{
        ITERATION,NO_IMPROVE;

        public static final StopChoice DEFAULT = NO_IMPROVE;
    }

    public HillClimber(MoveI movei, NeighborhoodI neighborhoodi, int interation) {
        this(movei,neighborhoodi,interation,MoveChoice.DEFAULT,StopChoice.DEFAULT);
    }

    public HillClimber(MoveI movei, NeighborhoodI neighborhoodi, int interation, MoveChoice moveChoice, StopChoice stopChoice) {
        this.movei = movei;
        this.neighborhoodi = neighborhoodi;
        this.interation = interation;
        this.moveChoice = moveChoice;
        this.stopChoice = stopChoice;
    }

    public Amphi hillClimberSearch(Amphi xd){
        s = System.currentTimeMillis();/* for execution time only */
        Amphi x= xd.deepCopy(),xstar = xd.deepCopy();
        Move selectmove;
        int i=0;
        /* choose a seat to start */
        Seat siegeSelect=choixSiege(x);
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
                    siegeSelect=seat.get();
                }else Logger.getGlobal().warning("Can't find the seat");

                /* change xstar if the current solution is better */
                if(xstar.occupiedSeats() < x.occupiedSeats()){
                    asSolutionImproved = true;
                    xstar = x.deepCopy();
                }
            }
            i++;
        }
        /* for execution time update */
        e = System.currentTimeMillis();
        return xstar;
    }

    /**
     * Return if the hillclimber needs to stop
     * @param interation
     * @return
     */
    public Boolean critereArret(int interation){
        switch (this.stopChoice){
            case ITERATION: return interation < this.interation;
            case NO_IMPROVE:return asSolutionImproved;
        }
        return true;
    }

    public Seat choixSiege(Amphi amphi){
        Random r = new Random();
        return amphi.getListSeat().get(r.nextInt(amphi.getN()));
    }

    /**
     * Make the choice between all possibles moves
     * @param listmove
     * @return
     */
    public Move chooseMove(List<Move> listmove){
        if(listmove.size() == 0)return null;

        switch (this.moveChoice){
            case FIRST:return listmove.get(0);
            case LAST:return listmove.get(listmove.size()-1);
            case RANDOM:{
                Random r= new Random();
                return listmove.get(r.nextInt(listmove.size()));
            }
        }
        return null;
    }

    /**
     * Return if the move can be done in the amphi
     * @param move
     * @param amphi
     * @return
     */
    public boolean isValid(Move move,Amphi amphi){
        Amphi temp = amphi.deepCopy();
        Optional<Seat> seat=temp.getListSeat().stream().filter(L->L.getID()==move.getSeat().getID()).findFirst();
        if(seat.isPresent()){
            seat.get().setFree(move.isValue_free());
        }
        return temp.isValid();
    }

    @Override
    public long executionTime() {
        return (e - s) / 1000L;
    }

    @Override
    public Amphi solve(Amphi amphi) {
        return hillClimberSearch(amphi);
    }
}
