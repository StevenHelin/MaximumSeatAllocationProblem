package solvers;

import data.Amphi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiThreadHillClimber implements Solver{
    @Override
    public long executionTime() {
        // todo
        return 0;
    }

    public boolean verifThread(List<InstanceHillClimber>instancelist){
        for (InstanceHillClimber ihc: instancelist){

        }

        return false;
    }

    @Override
    public Amphi solve(Amphi amphi) {
        List<InstanceHillClimber>instancelist=new ArrayList<InstanceHillClimber>();
        Scanner sc = new Scanner(System.in);
        int n=0;
        System.out.println("saisissez le nombre d'instance que vous souhaitez");
        n=sc.nextInt();
        for(int i=0;i<=n;i++){
            InstanceHillClimber instancehc= new InstanceHillClimber(
                    null,null,100,null,null,
                    amphi
            );
            instancelist.add(instancehc);
            instancehc.start();
        }
        // todo threadGroup
        return null;
    }
}
