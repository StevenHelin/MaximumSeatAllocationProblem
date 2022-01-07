package experiment;

import data.Amphi;
import solvers.Solver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Evaluation {
    private Solver solver;
    private int nbEvaluations;
    private Amphi amphi;

    private long[] cpu_Time;
    private int[] nbSeats;
    private int[] nbSeatsAdded;/* number of seats found thanks to the solver */

    public Evaluation(Solver solver, int nbEvaluations, Amphi amphi){
        this.solver = solver;
        this.nbEvaluations = nbEvaluations;
        this.amphi = amphi;
        this.cpu_Time = new long[nbEvaluations];
        this.nbSeats = new int[nbEvaluations];
        this.nbSeatsAdded = new int[nbEvaluations];
    }

    public void experiment(){
        int nbSeatDefault = amphi.occupiedSeats();
        for(int i = 0 ; i < nbEvaluations ; i++) {
            Amphi result = solver.solve(amphi.deepCopy());
            cpu_Time[i] = solver.executionTime();
            nbSeats[i] = result.occupiedSeats();
            nbSeatsAdded[i] = nbSeats[i] - nbSeatDefault;
        }
    }

    public void exportCSV(File file){
        try {
            FileOutputStream outS = new FileOutputStream(file);
            PrintWriter outStream = new PrintWriter(outS);
            outStream.println("i;nbseat;nb_added;execution_time");
            for(int i = 0 ; i < nbEvaluations ; i++){
                outStream.println(i+";"+nbSeats[i]+";"+nbSeatsAdded[i]+";"+cpu_Time[i]);
            }
            outStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
