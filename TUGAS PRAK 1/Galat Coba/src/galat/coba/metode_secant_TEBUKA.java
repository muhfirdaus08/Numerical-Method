/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galat.coba;
import static java.lang.Math.abs;
import static java.lang.Math.exp;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class metode_secant_TEBUKA {
    
    public static double fX(double x)
    {
        double t;
        //t = x*x-(x+1)*exp(x);
        //t=x*x*x+6*x-3;
        //y=1/3x3 + 1/2x2  -2x+1 
        t=2*x+(2*x+1)*exp(-2*x);
        //t=x*exp(-x)+1;
        return t;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("nilai f(x=0)= "+fX(0));
        System.out.println("Metode Secant");
        double x0,x1,eS;
        
         Scanner sc = new Scanner(System.in);
         System.out.print("Input nilai x0 = ");
         x0=sc.nextDouble();
         
         System.out.print("Input nilai x1 = ");
         x1=sc.nextDouble();
         System.out.print("Error Tol eS   = ");
         eS=sc.nextDouble();
         
         //algoritma secant
         int it=0;
         double xn=0,err=100;
         while (err>eS){
             double f0=fX(x0);
             double f1=fX(x1);
             xn=x1-(f1*(x1-x0))/(f1-f0);
             err=abs(fX(xn));
             
             //tukar nilai
             x0=x1; x1=xn;
             it++;
         }
         
         System.out.println("Salah satu akarnya adalah "+xn);
         System.out.println("Errornya ="+err);
         System.out.println("Iterasinya="+it);
    }
    
}
