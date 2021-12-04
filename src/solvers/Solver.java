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
    public long executionTime();

    public Amphi solve(Amphi amphi);
}
