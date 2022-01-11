package solvers;

import data.*;
import solvers.move.Move;
import solvers.move.MoveI;
import solvers.neighborhood.NeighborhoodI;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Tunneling implements Solver {
    MoveI movei;
    NeighborhoodI neighborhoodi;
    int interation;
    MoveChoice moveChoice;
    StopChoice stopChoice;

    /* if the solution has been improved during an iteration */
    private boolean asSolutionImproved;
    /* for the execution time measurement */
    long e,s;

    /* number of iteration for the tunneling phase */
    int randomIteration;

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

    public Tunneling(MoveI movei, NeighborhoodI neighborhoodi, int interation, int nbRandom) {
        this(movei,neighborhoodi,interation,MoveChoice.DEFAULT,StopChoice.DEFAULT,nbRandom);
    }

    public Tunneling(MoveI movei, NeighborhoodI neighborhoodi, int interation, MoveChoice moveChoice, StopChoice stopChoice, int nbRandom) {
        this.movei = movei;
        this.neighborhoodi = neighborhoodi;
        this.interation = interation;
        this.moveChoice = moveChoice;
        this.stopChoice = stopChoice;
        this.randomIteration = nbRandom;
    }

    public Amphi TunnelingSearch(Amphi xd, int nombreRandom){
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
                Amphi temp = phaseTunneling(x, randomIteration);
                if (temp.equals(x)){
                    Logger.getGlobal().info("Arrêt par move inexistant à " + siegeSelect + "et i = " + i);
                    break;
                }else{
                    selectmove = chooseMove(movei.getMoves(neighborhoodi.getNeighborhood(x,siegeSelect),x));
                    if(selectmove==null){
                        Logger.getGlobal().info("Arrêt par move inexistant à " + siegeSelect + "et i = " + i);
                        break;
                    }
                }
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
                }/*else{
                    x = phaseTunneling(x, randomIteration);
                }*/
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
    public double executionTime() {
        return (e - s) / 1000d;
    }

    @Override
    public Amphi solve(Amphi amphi) {
        return TunnelingSearch(amphi, randomIteration);
    }

    public Amphi phaseTunneling(Amphi amphi, int nbRandom){
        Random rand = new Random();
        Amphi x= amphi.deepCopy();
        List<Seat> remplis = amphi.getListSeat().stream().filter(L->!L.isFree()).collect(Collectors.toList());
        List<Seat> vides = amphi.getListSeat().stream().filter(L->L.isFree()).collect(Collectors.toList());

        Boolean valid = false;
        Seat s;
        int i = 0;
        while (i<nbRandom && !valid) {
            if(remplis.size()>0){
                s = amphi.getListSeat().get(amphi.getListSeat().indexOf(remplis.get(rand.nextInt(remplis.size()))));
                x.getListSeat().get(amphi.getListSeat().indexOf(s)).setFree(true);
                if(vides.size()>0){
                    x.getListSeat().get(amphi.getListSeat().indexOf(vides.get(rand.nextInt(vides.size())))).setFree(false);
                }
            }
            if (x.isValid()){
                valid = true;
            }
            i++;
        }

        if (valid){
            return x;
        }else{
            return amphi;
        }
    }
}
