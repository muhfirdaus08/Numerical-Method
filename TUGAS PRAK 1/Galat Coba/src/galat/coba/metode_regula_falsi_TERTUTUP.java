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
public class metode_regula_falsi_TERTUTUP {
    
    public static double fX(double x)
    {
        //double t=x*x-2*x-8;
        //double t=1+x*exp(-x);
        double t=x*x-4;
        return t;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        double a,b,eS;
        int mIt;
        
         Scanner sc = new Scanner(System.in);
         
         System.out.println("REGULA FALSI\n");
         System.out.print("Input nilai a = ");
         a=sc.nextDouble();
         
         System.out.print("Input nilai b = ");
         b=sc.nextDouble();
         
         System.out.print("Max Iterasi mIt = ");
         mIt=sc.nextInt();
         
         System.out.print("Error Tol eS = ");
         eS=sc.nextDouble();         
         
         double fa=fX(a);
         double fb=fX(b);
         double x=0.0;
        if((fa*fb)>0){
            System.out.println("Sorry bro no solusi");
        } 
        else 
         {
             int i=1;double fx1=10.0;
             while (abs(fx1)>eS){
                  x=(fb*a-fa*b)/(fb-fa);
                  fx1=fX(x);
                  if ((fx1*fa)<0){
                      b=x;
                      fb=fx1;
                  }else {
                      a=x;
                      fa=fx1;
                  }
                  //if (abs(fx1)<=eS) break;
                  i++;
             }     
             System.out.println("Salah satu akarnya adalah "+x);
             System.out.println("Errornya = "+abs(fx1));
             System.out.println("Iterasinya = "+i);
         }
        
    }
    
}
