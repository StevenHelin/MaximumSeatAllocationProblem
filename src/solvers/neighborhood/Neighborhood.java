package solvers.neighborhood;

import data.Amphi;
import data.Seat;

import java.util.List;

/**
 * General interface the neightborhood
 */
public interface Neighborhood {
    /**
     * Get all the neighborhood
     * @param amphi
     * @param seat
     * @return list of seat in the neighborhood
     */
    public List<Seat> getNeighborhood(Amphi amphi, Seat seat);
}
