package solvers;

/**
 * General interface for each solver
 */
public interface Solver {
    /**
     * Return the execution time of the last procedure call
     * @return : time in seconds
     */
    public long executionTime();

    public boolean solve();
}
