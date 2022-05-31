import java.text.DecimalFormat;
import java.util.Random;

import java.util.Scanner;
public class Metode_Invers_Uncompleted {
    
    static DecimalFormat blkKoma = new DecimalFormat("0.0");
    private static double matriksInverse [][];
    private double A [][] = {
                            
                            // {1,3,2,1,3,6,8,9,2,1},
                            // {2,4,2,1,3,2,1,4,5,7},
                            // {9,3,1,6,7,5,3,4,5,3},
                            // {5,3,4,1,8,9,5,4,3,2},
                            // {4,4,3,2,1,5,6,7,8,9},
                            // {6,5,3,8,9,6,7,5,4,3},
                            // {4,7,5,1,9,7,5,6,7,8},
                            // {5,3,9,8,6,1,2,4,5,6},
                            // {5,3,1,2,8,9,6,4,5,6},
                            // {4,3,2,5,7,9,0,6,4,3}

                            {1,-4,-2},
                            {0,-3,-2},
                            {-3,4,1}
                        };

    private double B [][];

    boolean cekDiagonal (int a){
        if (a>10*A.length){
            return false;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i][i]==0){
                Random acak = new Random();
                int k=(i+acak.nextInt(A.length))%A.length;
                for (int j = 0; j < A.length; j++) {
                    double temp = A[i][j];
                    A[i][j] = A[k][j];
                    A[k][j] = temp;

                    temp = B[i][j];
                    B[i][j] = B[k][j];
                    B[k][j] = temp;
                }
                return cekDiagonal (a+1);
            }
        }
        return true;
    }

    void hitung(){

        B = new double [A.length][A[0].length];
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                if (i==j){
                    B[i][j]=1.0;
                }else {
                    B[i][j]=0.0;
                }
            }
        } 

        cekDiagonal(0);

        for (int k = 0; k < A.length; k++) {
            double p = A[k][k];
            if (p==0){
                System.out.println("Tidak bisa dihitung");
                return;
            }
            for (int j = 0; j < A[0].length; j++) {
                A[k][j] /= p;    
            }
            for (int i = k+1; i < A.length; i++) {
                p = A[i][k];
                for (int j = 0; j < A[0].length; j++) {
                    A[i][j] -= A[k][j]*p;
                    B[i][j] -= B[k][j]*p;
                }
             }
        } 

        for (int k = A.length -1 ; k >= 0; k--) {
            for (int i = k-1; i >= 0; i--) {
                double p = A[i][k];
                for (int j = A.length -1; j >= 0; j--) {
                    A[i][j] -= A[k][j]*p;
                    B[i][j] -= B[k][j]*p;
                }
             }
        } 

        matriksInverse = B;

        // System.out.println("Matrix A : ");
        // for (int i=0; i<B.length; ++i) {
        //     for (int j=0; j<B.length; ++j){
        //         System.out.print(blkKoma.format(A[i][j])+"  ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        // System.out.println("Matrix B : ");
        // for (int i=0; i<B.length; ++i) {
        //     for (int j=0; j<B[0].length; ++j){
        //         System.out.print(blkKoma.format(B[i][j])+"  ");
        //     }
        //     System.out.println();
        // }      
    }

    void printMatriks (double[][] matrikInput){
        for (int i=0; i<matrikInput.length; ++i) {
            for (int j=0; j<matrikInput[0].length; ++j){
                System.out.print(blkKoma.format(matrikInput[i][j])+"  ");
            }
            System.out.println();
        }
    }
   
    public static void main(String[] args) throws Exception {
        
        Metode_Invers_Uncompleted run = new Metode_Invers_Uncompleted();    
        run.hitung();
        run.printMatriks(matriksInverse);

        //insert matrix 10x10
        // Scanner input = new Scanner(System.in);
        // System.out.println("Matrix axa adalah matrix persegi");
        // System.out.print("Masukan nilai a : ");
        // n = input.nextInt();
        // double [][]matrixPersegi = new double[n][n];
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print("Masukan baris ["+i+"] kolom ["+j+"] : ");
        //         matrixPersegi[i][j] = input.nextDouble();
        //     }            
        // }
         
    }
}
