/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metnummandiri;
import java.util.Scanner;
import static java.lang.Math.abs;
import static java.lang.Math.exp;

/**
 *
 * @author Muh. Firdaus
 */
public class MetnumMandiri {
    static double fx(double x){
        //double fx1 = x*x-2*x+1
        //double fx2 = x*x*x-(x+2)*exp(-2*x)+1
        //double fx1 = fx2 (titik potong terpenuhi)
        //double fx = fx1 - fx2 = 0
        //double y = fx = x*x-x*x*x-2*x+x*exp(-2*x)+2*exp(-2*x)
        double y = x*x-x*x*x-2*x+x*exp(-2*x)+2*exp(-2*x);
        return y;
    }
    
    static double fx1(double x){
        double y = x*x-2*x+1;
        return y;
    }
    
    public static void main(String[] args) {
        double a, b, eS, fa, fb;
        int max_iterasi;
        
        Scanner input = new Scanner (System.in);
        System.out.println("\t    ==Metode Biseksi== ");
        System.out.print("Masukan nilai a      : ");
        a = input.nextDouble();
        System.out.print("Masukan nilai b      : ");
        b = input.nextDouble();
        System.out.print("Masukan iterasi maks : ");
        max_iterasi = input.nextInt();
        System.out.print("Masukan nilai eS     : ");
        eS = input.nextDouble();
        
        double x = 0.0;
        double fx = 10.0;
        fa = fx(a);
        fb = fx(b);
        
        if ((fa*fb)>0){
            System.out.println("Tidak Ada Akar");
        }else {
            int j;
            //System.out.println("|Iterasi ke-  | a | b | x | fa | fb | error |");
            for ( j = 0; j < max_iterasi; j++) {
                x = (a+b)/2;
                fx = fx(x);
                if(abs(fx)>eS){
                    if ((fx*fa)<0){
                        b = x;
                        fb = fx;
                    }else {
                        a = x;
                        fa = fx;
                    }
                }else{
                    break;
                }
                //System.out.println("| "+j+"           | "+a+" | "+b+" | "+x+" |"+fa+" | "+fb+" | "+fx+" | ");
            }
//            while(abs(fx)>eS){
//                x = (a+b)/2;
//                fx = fx(x);
//                if ((fx*fa)<0){
//                    b = x;
//                    fb = fx;
//                }else {
//                    a = x;
//                    fa = fx;
//                }
                //if (abs(fx)<eS){ break; }
//                i++;
                //System.out.println("| "+i+"           | "+a+" | "+b+" | "+x+" |"+fa+" | "+fb+" | "+fx+" | ");
//            }
            //Mencari nilai y (memasukan nilai x ke fx1 = x*x-2*x+1)
            double y = fx1(x);
            
            System.out.println("\nAkarnya (nilai x)    : "+x);
            System.out.println("Errornya             : "+abs(fx));
            System.out.println("Iterasi ke           : "+j);
            System.out.println("Titik potong (x,y)   : ("+x+","+y+")");
        }          
    }    
}
