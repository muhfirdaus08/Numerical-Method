package modul1;
import static java.lang.Math.abs;
import static java.lang.Math.exp;

import java.util.Scanner;

public class Modul1 {
    public static double fungsifx(double x)
    {
        double p;
        p=((x*x)- 2*(x)+ 1) - ((x*x*x)-((x+2)*exp(-2*x))+1);
        return p;
    }
    
    public static void main(String[] args) {
        System.out.println("\t   Metode Secant ");
        double x0=0,x1=0,eS=0;
        
        //Inputan
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan X0 = ");
        x0=input.nextDouble();
        System.out.print("Masukkan X1 = ");
        x1=input.nextDouble();
        System.out.print("Nilai Toleransi   = ");
        eS=input.nextDouble();
        
        System.out.println("|Iterasi ke-  | Xi| X0 | Y0 | Y1 | Error |");
         
        //Metode Secant
        int iterasi=1;
        double xi=0,err=10;
        while (err>eS){
            double f0=fungsifx(x0);
            double f1=fungsifx(x1);
            xi = x1-(f1*(x1-x0))/(f1-f0);
            err=abs((xi-x1)/xi);
            System.out.println("| "+iterasi+"           | "+x1+" | "+x0+" | "+fungsifx(x0)+" |"+fungsifx(x1)+" | "+err);
            x0=x1; x1=xi;
            iterasi++;
         }
         
         //output : titik potong 
         System.out.println("Kesimpulannya, ");
         System.out.println("Akarnya adalah "+xi);
         System.out.println("Dengan Titik Potong (x,y) = ( " + xi + ", " + fungsifx(x1));
         System.out.println("Error                 ="+err);
         System.out.println("Iterasi               ="+iterasi);
    }
    
}