import java.text.DecimalFormat;
public class RungeKutta {
        DecimalFormat df = new DecimalFormat("#.###");    
        public double gx(double x,double y,double z){        
        double g = (4*((-64*x*z)-y));
        return g;
    }
    public double fx(double x,double y,double z){        
        return z;
    }
    public void hitung(double[] x,double[] y,double[] z, double n, double h){
        double K1,K2,k3;
        double L1,L2,L3;
        for(int i=1; i<=n; i++){
            System.out.println();
            K1= Double.parseDouble(df.format( h * fx(x[i-1],y[i-1],z[i-1])));
            System.out.println("Nilai K1 = "+K1);
            L2 = Double.parseDouble(df.format( h * gx(x[i-1],y[i-1],z[i-1])));
            System.out.println("Nilai L1 = "+L2); 
            K2 = Double.parseDouble(df.format( h * fx(x[i-1]+h/2,y[i-1]+K1/2,z[i-1]+L2/2)));
            System.out.println("Nila K2 = "+K2);
            L2 = Double.parseDouble(df.format( h * gx(x[i-1]+h/2,y[i-1]+K1/2,z[i-1]+L2/2)));
            System.out.println("NilaiL2 = "+L2);
            k3 = Double.parseDouble(df.format( h * fx(x[i-1]+h,
            y[i-1]-K1+2*K2,z[i-1]-L2+2*L2)));
            System.out.println("Nilai K3 = "+k3);
            L3 = Double.parseDouble(df.format( h * gx(x[i-1]+h,y[i-1]-K1+2*K2,z[i-1]-L2+2*L2)));
            System.out.println("Nilai L3 = "+L3);
            y[i] = Double.parseDouble(df.format( y[i-1] + ((K1 + (4*K2) + k3)/6 )));
            z[i]= Double.parseDouble(df.format( z[i-1] + ((L2 + (4*L2) + L3)/6 ))); 
            x[i]=x[i-1]+h;
            System.out.println("Nilai y"+i+" dengan Metode RungeKutta Orde 3 = "+y[i]);
            System.out.println("Nilai z"+i+" dengan Metode RungeKutta Orde 3 = "+z[i]);
       }
   }
}

