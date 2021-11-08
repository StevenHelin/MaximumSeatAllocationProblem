package solvers.move;

import data.Seat;

import java.util.List;

/**
 * General interface for the move method
 */
public interface MoveI {
    /**
     * With a neighborhood, list all the possible moves
     * @param list
     * @return the list of all the possible moves
     */
    public List<Move> getMoves(List<Seat> list);
}
