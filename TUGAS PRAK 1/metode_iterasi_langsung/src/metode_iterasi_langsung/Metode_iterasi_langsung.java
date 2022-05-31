package metode_iterasi_langsung;
import java.util.Scanner;
import static java.lang.Math.abs;
import static java.lang.Math.exp;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Metode_iterasi_langsung {

    static double g(double x){
        //y = x*x-x*x*x-2*x+x*exp(-2*x)+2*exp(-2*x);
        double y = (x*x)-(2*x)-(x*x*x)+(x*(exp(-2*x)))+(2*(exp(-2*x)));
        double y1 = pow(y,0.5);
        return y1;
    }
    
    static double gx(double x){
        double y = 1/(sqrt(x*x)-(2*x)-(x*x*x)+(x*(exp(-2*x)))+(2*(exp(-2*x))));
        return y;
    }
        
    public static void main(String[] args) {
        double a, eS, Max;
        
        Scanner input = new Scanner (System.in);
        System.out.println("\t   Metode Iterasi Langsung \n");
        System.out.print("Masukan taksiran awal (x) : ");
        a = input.nextDouble();
        System.out.print("Masukan iterasi maksimum : ");
        Max = input.nextInt();
        System.out.print("Masukan nilai eS : ");
        eS = input.nextDouble();
        
        int i=0;
        double c = gx(a);
        do {
            i++;
            double b = a;
            a = gx(a);
            Max = b - a;
            System.out.println(" "+i+ "  =     " +a+ "          =  " +Max);
        }while (Math.abs(Max) > c);
            if(i <= Max){
                System.out.println("sudut potong = "+ a);
                System.out.println("Es = " +Math.abs(Max));
            }else{
                System.out.println(" NOTE:");
                System.out.println(" Not Detected");
        }
    }
}

//        for (int i = 0; i < i_max; i++) {
//           x1 = gx(x); //x(i+1)
//           eR = error(x, x1);
//            
//           if (eR < eS){
//                double y = x*x-2*x+1;
//                System.out.println("\nAkarnya (nilai x)      : "+x);
//                System.out.println("Errornya               : "+eR);
//                System.out.println("Iterasi ke             : "+i);
//                System.out.println("Titik potong (x,y)     : ("+x+","+y+")");
//                break;
//           }
//        }
        
//    }
//    
//}
