package solvers.neighborhood;

import data.Amphi;
import data.Seat;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Return all the seat having a distance between min and max
 */
public class AroundNeighborhood implements NeighborhoodI{

    private double minDist,maxDist;

    public AroundNeighborhood(double minDist){
        this(minDist,Double.MAX_VALUE);
    }
    public AroundNeighborhood(double minDist, double maxDist) {
        this.minDist = minDist;
        this.maxDist = maxDist;
    }

    public double getMinDist() {
        return minDist;
    }
    public void setMinDist(double minDist) {
        if(minDist >= 0)this.minDist = minDist;
    }
    public double getMaxDist() {
        return maxDist;
    }
    public void setMaxDist(double maxDist) {
        if(maxDist >= minDist)this.maxDist = maxDist;
    }

    @Override
    public List<Seat> getNeighborhood(Amphi amphi, Seat seat) {
        return amphi.getListSeat().stream().filter(s->s.distance(seat) >= minDist && s.distance(seat) <= maxDist).collect(Collectors.toList());
    }
}
