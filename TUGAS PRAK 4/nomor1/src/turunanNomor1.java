public class turunanNomor1{
    double fx(double x0, double h){
        double x0h = x0+h;
        double F = ((4*x0h) - Math.pow((x0h),
        3.0))*Math.exp(Math.pow((x0h), 2)) -((4*(x0)) - Math.pow((x0),
        3.0))*Math.exp(Math.pow((x0), 2));
        F = F/h;
        return F;
    }
    double fxAk(double x0, double h){
        double x0h = x0+h;
        x0 = x0-h;
        double F = ((4*x0h) - Math.pow((x0h),
        3.0))*Math.exp(Math.pow((x0h), 2)) -((4*(x0)) - Math.pow((x0),
        3.0))*Math.exp(Math.pow((x0), 2));
        F = F/(2*h);
        return F;
    }
    double turunan(double x, double h){
        double f = fx(x,h);
        return f;
    }
    double turunanf(double x, double h){
        double fAksen = fxAk(x,h);
        return fAksen;
    }
    double galat(double x, double x2){
        double error = Math.abs(x-x2);
        return error;
    }
    void hitungTurunan (double nilai_eksak, double nilai_h[]){
        for (int i=0; i<nilai_h.length; i++){
            System.out.println();
            double error = Math.abs( nilai_eksak-turunan(0.5, nilai_h[i]) );
            System.out.printf("Nilai h \t\t= %.4f\n",nilai_h[i]);

            System.out.println("1.a Turunan sel maju \t= " + turunan(0.5, nilai_h[i]));
            System.out.printf("1.b error sel maju \t= %.12f\n", error);
            
            System.out.println("2.a Turunan sel pusat \t= " + turunanf(0.5, nilai_h[i]));
            error = Math.abs( nilai_eksak-turunanf(0.5, nilai_h[i]) );

            System.out.printf("2.b error sel pusat \t= %.12f\n", error);
        }
    }
    public static void main(String[] args) {  
        System.out.println("\nPersamaan f(t) \t\t= (4t-t^3)e(t^2)");
        System.out.println("Nilai eksak turunan     = 6.580630260524675");

        double eksak = 6.580630260524675;   
        double h[] = {0.01, 0.001, 0.0001};
        
        turunanNomor1 nomor1 = new turunanNomor1();
        nomor1.hitungTurunan(eksak, h);
        System.out.println();
    }
}
