package solvers.move;

import data.Amphi;
import data.Seat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Move method that return only the possible moves
 */
public class PossibleMove implements MoveI{

    private boolean allowUnload;/* check if we can add moves with value_free = true */
    private boolean uselessMoves;/* if value_free = false, allow moves that are useless */

    public PossibleMove(){
        this(false, true);
    }
    public PossibleMove(boolean allowUnload, boolean uselessMoves){
        this.allowUnload = allowUnload;
        this.uselessMoves = uselessMoves;
    }

    public boolean isAllowUnload() {
        return allowUnload;
    }
    public void setAllowUnload(boolean allowUnload) {
        this.allowUnload = allowUnload;
    }
    public boolean isUselessMoves() {
        return uselessMoves;
    }
    public void setUselessMoves(boolean uselessMoves) {
        this.uselessMoves = uselessMoves;
    }

    private List<Move> getMovesFromSeats(List<Seat> list_seat, Amphi amphi) {
        List<Move> list_move = new ArrayList<>();
        for (Seat seat : list_seat) {
            boolean currentState = seat.isFree();
            seat.setFree(!currentState);
            if (amphi.isValid()) list_move.add(new Move(seat, !currentState));
            seat.setFree(currentState);
        }
        return list_move;
    }

    @Override
    public List<Move> getMoves(List<Seat> list_seat, Amphi amphi) {
        if((list_seat == null) || (amphi == null))return new ArrayList<>();
        if(list_seat.size() <= 0)return new ArrayList<>();

        if(!this.allowUnload){
            List<Move> list = new ArrayList<>(getMovesFromSeats(list_seat.stream().filter(Seat::isFree).collect(Collectors.toList()), amphi));
            if(uselessMoves)list_seat.stream().filter(f->!f.isFree()).forEach(s->list.add(new Move(s,false)));
            return list;
        }
        else return getMovesFromSeats(list_seat, amphi);
    }
}
