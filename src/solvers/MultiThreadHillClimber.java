package solvers;

import data.Amphi;
import solvers.move.MoveI;
import solvers.neighborhood.NeighborhoodI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiThreadHillClimber implements Solver{
    MoveI movei;
    NeighborhoodI neighborhoodi;
    int interation;
    HillClimber.MoveChoice moveChoice;
    HillClimber.StopChoice stopChoice;

    @Override
    public double executionTime() {
        // todo
        return 0d;
    }

    public MultiThreadHillClimber(MoveI movei, NeighborhoodI neighborhoodi, int interation, HillClimber.MoveChoice moveChoice, HillClimber.StopChoice
        stopChoice) {
            this.movei = movei;
            this.neighborhoodi = neighborhoodi;
            this.interation = interation;
            this.moveChoice = moveChoice;
            this.stopChoice = stopChoice;
        }

    public Amphi verifResults(List<InstanceHillClimber>instancelist){
        boolean valideInstance=false;
        Amphi bestAmphi= new Amphi();
        List <Amphi> amphiSolutionlist= new ArrayList<Amphi>();
        for (InstanceHillClimber ihc: instancelist){
            if (!valideInstance){
                valideInstance= verifInstance(ihc);
            }
            amphiSolutionlist.add(ihc.getAmphisoluce());
        }
        for (Amphi a: amphiSolutionlist){
            if(a.occupiedSeats()>bestAmphi.occupiedSeats()){
                bestAmphi=a;
            }
        }

        return bestAmphi;
    }

    public boolean verifInstance(InstanceHillClimber instanceh){
        while (instanceh.isAlive()){
            Thread.yield();;
        }
        return true;
    }

    @Override
    public Amphi solve(Amphi amphi) {
        List<InstanceHillClimber>instancelist=new ArrayList<InstanceHillClimber>();
        Amphi solution = new Amphi();
        //Scanner sc = new Scanner(System.in);
        //int n=0;
        //System.out.println("saisissez le nombre d'instance que vous souhaitez");
        //n=sc.nextInt();
        for(int i=0;i<=1;i++){
            InstanceHillClimber instancehc= new InstanceHillClimber(
                    null,null,100,null,null,
                    amphi
            );
            instancehc.start();
            instancelist.add(instancehc);

        }
        solution = verifResults(instancelist);
        // todo
        return solution;
    }
}
