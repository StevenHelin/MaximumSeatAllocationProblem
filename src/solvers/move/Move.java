package solvers.move;

import data.Seat;

/**
 * Class for a move
 */
public class Move {
    /**
     * The modified seat
     */
    private Seat seat;
    /**
     * New value for free
     */
    private boolean value_free;

    public Move(Seat seat, boolean value_free) {
        this.seat = seat;
        this.value_free = value_free;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public boolean isValue_free() {
        return value_free;
    }

    public void setValue_free(boolean value_free) {
        this.value_free = value_free;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Move{");
        sb.append("seat=").append(seat);
        sb.append(", value_free=").append(value_free);
        sb.append('}');
        return sb.toString();
    }
}
