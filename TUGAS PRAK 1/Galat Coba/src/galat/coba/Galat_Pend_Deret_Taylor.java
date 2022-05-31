/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galat.coba;
import static java.lang.Math.abs;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import java.util.Scanner;
/**
 *
 * @author USER
 */
public class Galat_Pend_Deret_Taylor {
    
    public static double lnDx(double x,int orde)
    {
            double pX=0;
            for (int i=1; i<=orde;i++)
            {
                    if (i%2==0)
                            pX=pX-pow(x-1,i)/i;
                    else
                            pX=pX+pow(x-1,i)/i;
            }
            return pX;
    }

    public static float lnFx(float x,int orde)
    {
            float pX=0;
            for (int i=1; i<=orde;i++)
            {
                    if (i%2==0)
                            pX=(float) (pX-pow(x-1,i)/i);
                    else
                            pX=(float) (pX+pow(x-1,i)/i);
            }
            return pX;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Simulasi Galat dari menghitung nilai ln(x),");
        System.out.println("Pendekatan deret taylor di x0 = 1.");
        double galatD=0.0;
        float galatF=(float) 0.0;
	int orde=0;
        double x;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Orde pendekatan n = ");
        orde=sc.nextInt();
     
        System.out.print("Nilai x = ");
        x=sc.nextDouble();
        System.out.println();  
        
	System.out.println("Hasil Pendekatan dengan Float:");
	float res=lnFx((float) x,orde);
	galatF=(float) (100*abs((log(x)-res)/log(x)));
	System.out.println("Nilai eksak      dari ln "+x+" = "+log(x));
	System.out.println("Nilai Pendekatan dari ln "+x+" = "+res);
	System.out.println(" Galat Mutlak= "+ abs(log(x)-res));
        System.out.println(" Galat Rel= " +galatF);
        
        System.out.println(); 
	System.out.println("Hasil Pendekatan dengan Double:");
	double res1=lnDx(x,orde);
	galatD=100*abs((log(x)-res1)/log(x));
	System.out.println("Nilai eksak      dari ln "+x+" = "+log(x));
	System.out.println("Nilai Pendekatan dari ln "+x+" = "+res1);
	System.out.println(" Galat Mutlak= "+ abs(log(x)-res1));
        System.out.println(" Galat Rel= " +galatD);
         
    }
    
}
