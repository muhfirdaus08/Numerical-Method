class regregasilinearclass {
    double x[] = {1,2,3,4,5,6,7,8};// variabel prediktor/bebas
    double y[] = {1.5577, 1.2131, 0.9447, 0.7358, 0.5730, 0.4462, 0.3476, 0.2706};//variabel respon/tak bebas
    double b_0, b_1;
    double r_square; 
    double s_e;
    double sig_x, sig_y, sig_xy, sig_x_square, sig_y_square;
    
    public void regrelinear (){
        for(int i = 0; i < x.length; i++){
            sig_x +=x[i];
            sig_y +=y[i];
            sig_xy +=x[i]*y[i];
            sig_x_square+=Math.pow(x[i], 2);
            sig_y_square+=Math.pow(y[i], 2);
        }
        
        //menghitung a0
        b_0 = ((sig_y*sig_x_square)-(sig_x*sig_xy))/
                ((x.length*(sig_x_square))-(Math.pow(sig_x, 2))); 
        
        //menghitung a1
        b_1 = ((x.length*sig_xy)-(sig_x*sig_y))/
                ((x.length*sig_x_square)-Math.pow(sig_x, 2)); 
        
        //menghitung error
        r_square = Math.pow(((x.length*sig_xy)-(sig_x*sig_y))/
                Math.sqrt(((double)(x.length*sig_x_square)-Math.pow(sig_x, 2))*
                        (double)((x.length*sig_y_square)-Math.pow(sig_y, 2))),2);
        
        //standart error
        s_e = Math.sqrt((sig_y_square-(b_0*sig_y)-(b_1*sig_xy))/(x.length-2));
    }

    public void print(){    
        System.out.println("\nSigma x   = "+sig_x);    
        System.out.println("Sigma y   = "+sig_y);    
        System.out.println("Sigma x^2 = "+sig_x_square);    
        System.out.println("Sigma x*y = "+sig_xy);  

        System.out.println("\n Persamaan regresi : \n Y = "+b_0+" + "+b_1+" X\n"
                + " Koefisien determinasi (R2) = "+r_square+"\n"
                + " Standard error (Se) = "+s_e+"\n");
    }
}

public class regregasi_Linear_lengkap {
    public static void main(String[] args) {
        regregasilinearclass reg_lin = new regregasilinearclass();
        reg_lin.regrelinear();
        reg_lin.print();
    }
}
