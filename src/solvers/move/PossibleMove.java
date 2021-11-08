package solvers.move;

import data.Amphi;
import data.Seat;

import java.util.ArrayList;
import java.util.List;

/**
 * Move method that return only the possible moves
 */
public class PossibleMove implements MoveI{

    @Override
    public List<Move> getMoves(List<Seat> list_seat, Amphi amphi) {
        List<Move> list_move = new ArrayList<>();
        for(Seat seat : list_seat){
            seat.setFree(false);
            if(amphi.isValid())list_move.add(new Move(seat,false));
            seat.setFree(true);
        }
        return list_move;
    }
}
