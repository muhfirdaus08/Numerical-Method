/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galat.coba;
import static java.lang.Math.abs;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static galat.coba.Galat_Pend_Deret_Taylor.lnDx;
import static galat.coba.Galat_Pend_Deret_Taylor.lnFx;
import java.util.Scanner;
/**
 *
 * @author USER
 */
public class Galat_Pend_Biseksi {
    
    public static double fX(double x)
    {
        //double t=1+x*exp(-x);
        double t=x*x-x-2;
        return t;
    }

    public static float fX(float x)
    {
        //float t=(float) (1+x*exp(-x));
        float t=(float) (x*x-x-2);
        return t;
    }
    
    public static void biSection(double a, double b, double eS, int mIt)
    {
        double fa=fX(a);
        double fb=fX(b);
        double x=0.0;
        if((fa*fb)>0){
            System.out.println("Sorry bro no solusi");
        }
        else
        {
             int i=0;double fx1=100.0;
             while (abs(fx1)>eS){
                  x=(a+b)/2;
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
             System.out.println("Hasil Pendekatan DOUBLE:");
             System.out.println("Salah satu akarnya adalah "+x);
             System.out.println("Errornya/fx   = "+abs(fx1));
             System.out.println("Iterasinya    = "+i);
         }
    }

    public static void biSection(float a, float b, double eS, int mIt)
    {
        float fa=fX(a);
        float fb=fX(b);
        float x=(float) 0.0;
        if((fa*fb)>0){
            System.out.println("Sorry bro no solusi");
        }
        else
        {
             int i=0;float fx1=(float) 100.0;
             while (abs(fx1)>eS){
                  x=(a+b)/2;
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
             System.out.println("Hasil Pendekatan FLOAT:");
             System.out.println("Salah satu akarnya adalah "+x);
             System.out.println("Errornya/fx   = "+abs(fx1));
             System.out.println("Iterasinya    = "+i);
         }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Pendekatan Biseksi dengan Tipe data Float dan Double,");
        double eS=0.0;
        float a,b;
	int mIt=0;
   
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Taksiran a = ");
        a=sc.nextFloat();
        
        System.out.print("Taksiran b = ");
        b=sc.nextFloat();
     
        System.out.print("Maksimum Iterasi mIt = ");
        mIt=sc.nextInt();
        
        System.out.print("Toleransi Galat = ");
        eS=sc.nextDouble();
        
        System.out.println();  
        

	System.out.println("Hasil Pendekatan dengan Double:");
        biSection((double)a,(double)b,eS,mIt);
        System.out.println(); 
        System.out.println("Hasil Pendekatan dengan Float:");
	biSection(a,b,eS,mIt);
	
    }
    
}
