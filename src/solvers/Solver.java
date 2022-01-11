package solvers;

import data.Amphi;
/**
 * General interface for each solver
 */
public interface Solver {
    /**
     * Return the execution time of the last procedure call
     * @return : time in seconds
     */
    public double executionTime();

    public Amphi solve(Amphi amphi);
}
