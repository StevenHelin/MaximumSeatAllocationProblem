package solvers;

import data.Amphi;

import java.util.Scanner;

public class MultiThreadHillClimber implements Solver{
    @Override
    public double executionTime() {
        // todo
        return 0d;
    }

    @Override
    public Amphi solve(Amphi amphi) {
        Scanner sc = new Scanner(System.in);
        int n=0;
        System.out.println("saisissez le nombre d'instance que vous souhaitez");
        n=sc.nextInt();
        for(int i=0;i<=n;i++){
            InstanceHillClimber instancehc= new InstanceHillClimber(
                    null,null,100,null,null,
                    amphi
            );
            instancehc.start();
        }
        // todo
        return null;
    }
}
