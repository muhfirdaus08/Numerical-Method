import java.text.DecimalFormat;
import java.util.Scanner;
    public class Main {
        public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.###");
        Scanner input = new Scanner(System.in); 
        RungeKutta rk = new RungeKutta ();
        System.out.print("Input batas atas : ");
        double b=input.nextDouble();
        System.out.print("Nilai h : ");
        double h=input.nextDouble();
        int n=(int) (b/h);
        System.out.println("Jumlah langkah : "+n);
        double[] x = new double[n+1];
        double[] y = new double[n+1];
        double[] z = new double[n+1];
        x[0]=0;y[0]=1;z[0]=-8;
        rk.hitung(x, y, z, n, h);
    }
}