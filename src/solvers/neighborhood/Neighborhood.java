package solvers.neighborhood;

import data.Amphi;

public class Neighborhood {
    Amphi A= new Amphi();

    public int[][] buildMatrix(Amphi A){
        int[][] matrix = new int[0][0];
        for (int i =0; i<A.getN();i++){
            for(int j=0; j<A.getN();j++){
                if(!A.getListSeat().get(i).isFree()){
                 matrix[i][j]=0;
                }
                else{
                    matrix[i][j]=1;
                }
            }

        }
        return matrix;
    }

}

