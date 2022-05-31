import java.text.DecimalFormat;

public class Metode_InverseFinal{
    static DecimalFormat blkKoma = new DecimalFormat("0.0000");
    static int M_Row = 3;
    static int N_Collom = 2;

    public static double[][] invert(double a[][]) {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i) 
            b[i][i] = 1;
 
        //mengubah ke MSA
        eliminasi(a, index);
 
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                    	    -= a[index[j]][i]*b[index[i]][k];
        
        //backward substitutions                   
        for (int i=0; i<n; ++i) {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k) {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }
  
    public static void eliminasi(double a[][], int index[]) {
        int n = index.length;
        double c[] = new double[n];
 
  
        for (int i=0; i<n; ++i) 
            index[i] = i;
 
        for (int i=0; i<n; ++i) {
            double c1 = 0;
            for (int j=0; j<n; ++j){
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }
 
        int k = 0;
        for (int j=0; j<n-1; ++j) {
            double pi1 = 0;
            for (int i=j; i<n; ++i) {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) 
                {
                    pi1 = pi0;
                    k = i;
                }
            }
 
            int temp = index[j];
            index[j] = index[k];
            index[k] = temp;
            for (int i=j+1; i<n; ++i) {
                double pj = a[index[i]][j]/a[index[j]][j];
 
                a[index[i]][j] = pj;
 
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }

    public static double[][] kali(double[][] matrix_1, double[][] matrix_2){
        int baris_1 = matrix_1.length;
        int kolom_1 = matrix_1[0].length;

        int baris_2 = matrix_2.length;
        int kolom_2 = matrix_2[0].length;

        double[][] hasilKali = new double[baris_1][kolom_2];

        double buffer;
        for (int i = 0; i < baris_1; i++){
            for (int j = 0; j < kolom_2 ; j++){
                buffer = 0;
                for (int k = 0; k < kolom_1; k++){
                    buffer += matrix_1[i][k] * matrix_2[k][j];
                }
                hasilKali[i][j] = buffer;
            }
        }
        return hasilKali;
    }

    public static void printMatrix (double[][] matrikInput){
        for (int i=0; i<matrikInput.length; ++i) {
            for (int j=0; j<matrikInput[0].length; ++j){
                System.out.print(blkKoma.format(matrikInput[i][j])+"  ");
            }
            System.out.println();
        }
    }

    public static void main(String argv[]) {

        double A [][] = {
                            
            {0,3,2,1,3,6,8,9,2,1},
            {2,4,2,1,3,2,1,4,5,7},
            {9,3,1,6,7,5,3,4,5,3},
            {5,3,4,1,8,9,5,4,3,2},
            {4,4,3,2,1,5,6,7,8,9},
            {6,5,3,8,9,6,7,5,4,3},
            {4,7,5,1,9,7,5,6,7,8},
            {5,3,9,8,6,1,2,4,5,6},
            {5,3,1,2,8,9,6,4,5,6},
            {4,3,2,5,7,9,0,6,4,3}

            // {1,-4,-2},
            // {0,-3,-2},
            // {-3,4,1}
        };

        double B [][] = {
            {1},
            {-1},
            {1},
            {-1},
            {1},
            {-1},
            {1},
            {-1},
            {1},
            {-54},

            // {1},
            // {0},
            // {-3}
        };

        double inverseMatrix[][] = invert(A);
        System.out.println("\nMatrix A :");
        printMatrix(A);
        System.out.println("\nInverse Matrix A :");
        printMatrix(inverseMatrix);

        System.out.println("\nMatrix B :");
        printMatrix(B);

        System.out.println("\nMatriks B Transpose * Inverse Matrix A = ");
        double [][] hasiLKali = kali(inverseMatrix, B);
        printMatrix(hasiLKali);
    }	
}
