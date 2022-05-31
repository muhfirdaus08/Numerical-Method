public class integrealNomor2 {
    double integral (double h0){
        double genap=0, ganjil=0;
        //double awal = ((4*0) - Math.pow((0),3.0))*Math.exp(Math.pow((0), 2));
        double awal = (1/(1+0));
        double h=0;
        h=h0;
        int i = 2;
        while (h<1){
            //double F = ((4*h) - Math.pow((h),3.0))*Math.exp(Math.pow((h), 2));
            double F = (1/(1+h));
            if(i%2 == 0){genap+=F;}
            else {ganjil+=F;}
            h+=h0;i++;
        }
        double fx = (1/(1+1));
        double hasil = h0/3*(awal+(4*ganjil)+(2*genap)+fx);
        return hasil;
    }
    void hitungIntegral (double nilai_eksak, double nilai_h[]){
        for (int i=0;i<nilai_h.length;i++){
            System.out.println();
            double error = Math.abs(nilai_eksak-integral(nilai_h[i]));
            System.out.printf("Nilai h \t\t= %.4f\n",nilai_h[i]);
            System.out.println("Integral \t\t= "+integral(nilai_h[i]));
            System.out.printf("Nilai error \t\t= %.12f\n", error);
        }
    }
    public static void main(String[] args) {
        System.out.println("\nPersamaan \t\t= f(t)=(4tt^3)e^(t^2)");     
        System.out.println("Nilai eksak integral    = 2.9365636569180904");

        double h[] = {0.125, 0.001, 0.0001};
        double eksak = 2.9365636569180904;
        
        integrealNomor2 nomor2 = new integrealNomor2();
        nomor2.hitungIntegral(eksak, h);
        System.out.println();
    }
}
