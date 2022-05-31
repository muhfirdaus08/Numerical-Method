import java.text.DecimalFormat;
public class nomor1abc {
    static DecimalFormat decfor = new DecimalFormat("#.#######");
    private static final double EPSILON = 1e-10;
        static void view(double[] arr) {
        decfor.setMinimumFractionDigits(1);
        for(int i=0;i<arr.length;i++) {
        System.out.format("%11s", decfor.format(arr[i]));}
        System.out.println();
    }

    static void view(double[][] arr) {
        decfor.setMinimumFractionDigits(1);
            for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++)
                System.out.format("%11s", decfor.format(arr[i][j]));
                System.out.println();
            }
    }
    
    public static double[] eliminasigaus(double[][] A1, double[] b) {
        int n = b.length;
        for (int x = 0; x < n; x++) {
            int max = x;
            for (int i = x + 1; i < n; i++)
            if (Math.abs(A1[i][x]) > Math.abs(A1[max][x]))
            max = i;
            double[] temp = A1[x]; A1[x] = A1[max]; A1[max] = temp;
            double t = b[x]; b[x] = b[max]; b[max] = t;
            if (Math.abs(A1[x][x]) <= EPSILON)
            throw new ArithmeticException("Matrix is singular or nearly singular");
            for (int i = x + 1; i < n; i++) {
                double alpha = A1[i][x] / A1[x][x];
                b[i] -= alpha * b[x];
                for (int j = x; j < n; j++)
                A1[i][j] -= alpha * A1[x][j];
            }
        }
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++)
            sum += A1[i][j] * x[j];
            x[i] = (b[i] - sum) / A1[i][i];
        }
        return x;
    }
    public static double[] curvafitting(double[][] soal, int N) {
        double n = soal.length;
        double[][] A2 = new double[N][N];;
        for(int i=0;i<N;i++)
        for(int j=0;j<N;j++)
        A2[i][j] = 0;
        for(int i=0;i<N;i++)
        for(int j=0;j<N;j++)
        for(int k=0;k<n;k++)
        A2[i][j] = A2[i][j] += Math.pow(soal[k][0], i+j);
        A2[0][0] = n;
        System.out.println("Matriks A:");
        view(A2);
        double[] B2 = new double[N];;
        for(int i=0;i<N;i++)
        B2[i] = 0;
        for(int i=0;i<N;i++)
        for(int k=0;k<n;k++)
        B2[i] += Math.pow(soal[k][0], i) * soal[k][1];
        System.out.println("Matriks B:");
        view(B2);
        return eliminasigaus(A2, B2);
    }
    public static void main(String[] args) {
        double[][] dataTabel = {
            {1, 1.5577}, {2, 1.2131}, {3, 0.9447},
            {4, 0.7358}, {5, 0.5730}, {6, 0.4462},
            {7, 0.3476}, {8, 0.2706}
        };

        System.out.println("Matriks soal:");
        System.out.println("\tx    |    y");
        view(dataTabel);
        double[] hasil;
        double err = 0;
        System.out.println("\nPenyelesaian a0+a1x:");
        hasil = curvafitting(dataTabel, 2);

        System.out.format("Persamaan: (%s) + (%s)x", 
        decfor.format(hasil[0]), decfor.format(hasil[1]));
        
        for(int i=0;i<dataTabel.length;i++)
        err += Math.pow((hasil[0] + hasil[1] * dataTabel[i][0]) -
        dataTabel[i][1], 2);
        err = Math.sqrt(err/dataTabel.length);
        System.out.println("\nDengan error: " + err);
        System.out.println("\nPenyelesaian a0x^2+a1x+a2:");
        hasil = curvafitting(dataTabel, 3);
        System.out.format("Persamaan:(%s)x^2+(%s)x+(%s)", 
        decfor.format(hasil[2]),decfor.format(hasil[1]), decfor.format(hasil[0]));
        err = 0;
        for(int i=0;i<dataTabel.length;i++)
        err += Math.pow((hasil[2] * Math.pow(dataTabel[i][0], 2) + hasil[1] * 
        dataTabel[i][0] + hasil[0]) - dataTabel[i][1], 2);
        err = Math.sqrt(err/dataTabel.length);
        System.out.println("\nDengan error: " + err);
        System.out.println("\nPenyelesaian ab^x:");
        double[][] soalLog = new 
        double[dataTabel.length][dataTabel[0].length];
        for(int i=0;i<soalLog.length;i++)
        for(int j=0;j<soalLog[0].length;j++)
        soalLog[i][j] = Math.log(dataTabel[i][j]);
        hasil = curvafitting(soalLog, 2);
        System.out.format("Persamaan: (%s)x^(%s)", decfor.format(hasil[0]), 
        decfor.format(hasil[1])); err = 0;
        for(int i=0;i<dataTabel.length;i++)
        err += Math.pow((hasil[0] * Math.pow(dataTabel[i][0], hasil[1])) -
        dataTabel[i][1], 2); err = Math.sqrt(err/dataTabel.length);
        System.out.println("\nDengan error: " + err);
        System.out.println();
    }
}
