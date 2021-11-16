package solvers;

import data.*;

public class HillClimber {
    int solutioninit=0;
    int solution;
    boolean stop = false;

    public HillClimber(int solutioninit, int solution, boolean stop) {
        this.solutioninit = solutioninit;
        this.solution = solution;
        this.stop = stop;
    }

    public int getSolutioninit() {
        return solutioninit;
    }

    public void setSolutioninit(int solutioninit) {
        this.solutioninit = solutioninit;
    }

    public int getSolution() {
        return solution;
    }

    public void setSolution(int solution) {
        this.solution = solution;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public void hillClimberSearch(){
        while(!stop){
            solution=solutioninit;
            //select a move in the list of move
            //
            //if (le mouvement existe){
            //solution=m(x)
           // }
           // else{ stop=true }
        }

    }

}
