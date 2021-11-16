package solvers;

import data.*;
import solvers.move.Move;
import solvers.move.MoveI;
import solvers.neighborhood.NeighborhoodI;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public class HillClimber implements Solver {

    MoveI movei;
    NeighborhoodI neighborhoodi;
    int interation;

    public HillClimber(MoveI movei, NeighborhoodI neighborhoodi, int interation) {
        this.movei = movei;
        this.neighborhoodi = neighborhoodi;
        this.interation=interation;
    }

    public void hillClimberSearch(Amphi xstar){
        Amphi x= xstar.deepCopy();
        Move selectmove;
        int i=0;
        Seat siegeSelect=choixSiege(x);
        while (critereArret(i)){
            selectmove = chooseMove(movei.getMoves(neighborhoodi.getNeighborhood(x,siegeSelect),x));
            if (isValid(selectmove,x)){
                xstar= xstar.occupiedSeats() < x.occupiedSeats()? xstar : x;
            }
            i++;
        }

    }

    public Boolean critereArret(int interation){
        return this.interation < interation;
    }

    public Seat choixSiege(Amphi amphi){
        Random r = new Random();
        return amphi.getListSeat().get(r.nextInt(amphi.getN()));
    }

    public Move chooseMove(List<Move> listmove){
        Random r= new Random();
        return listmove.get(r.nextInt(listmove.size()));
    }

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
        return 0;
    }

    @Override
    public boolean solve(Amphi amphi) {
        hillClimberSearch(amphi);
        return true;
    }
}
