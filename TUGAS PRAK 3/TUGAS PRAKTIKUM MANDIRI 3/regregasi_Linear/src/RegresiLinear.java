import java.util.Scanner;
public class RegresiLinear{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double total_x=0, total_y=0, kali=0, x_kuadarat=0, h=0; 
        double a_1=0, a_0=0, reg=0, a=0, b=0, rata_x, rata_y ;
        double[] nilai_x ={1,2,3,4,5,6,7,8};
        double[] nilai_y ={1.5577, 1.2131, 0.9447, 0.7358, 0.5730, 0.4462, 0.3476, 0.2706};
           
            // Menampilkan data nilai x da y
            System.out.println("No   Nilai X    Nilai Y");
            for (int i = 0;i < nilai_x.length; i++ ){
                int z=i+1;
                System.out.print(z+"    ");
                System.out.print(nilai_x[i]+"        ");
                System.out.print(nilai_y[i]+"");
                System.out.println("");
            }

            // Menampilkan hasil Jumlah dan rata-rata nilai x
            for (int i = 0;i < nilai_x.length; i++ ){
                double x=nilai_x[i];
                total_x=x+total_x;
            }
            System.out.println("\n\nSigma X   = " + total_x);
            rata_x= total_x /nilai_x.length;

            // Menampilkan hasil Jumlah dan rata-rata nilai y
            for (int i = 0;i < nilai_y.length; i++ ){
                double y=nilai_y[i];
                total_y=y+total_y;
            }
            System.out.println("\nSigma Y   = " + total_y);
            rata_y= total_y /nilai_y.length;


            // Menampilkan hasil X ^ 2
            for (int i = 0;i < nilai_x.length; i++ ){
                double x=nilai_x[i]*nilai_x[i] ;
                x_kuadarat=x+x_kuadarat;
            }
            System.out.println("\nSigma X   = " + x_kuadarat);

            // Menampilkan hasil kali x dengan y
            for (int i = 0;i < nilai_x.length; i++ ){
                a= nilai_x[i];
                b = nilai_y[i];
                kali = (a*b) +kali;
            }
            System.out.println("\nSigma X.Y = "+kali);

            // a1
            int l = nilai_y.length;
            a_1 = (kali - ((total_y * total_x)/l)) / (x_kuadarat - ((total_x*total_x)/l));
            System.out.println("\na1        = "+a_1);

            // a0
            a_0 = rata_y - a_1 * rata_x;
            System.out.println("a0        = "+a_0+"\n");

            // // data ke 31           
            // System.out.print("\n\nInputkan data X ke 31        = ");
            // Double cari = sc.nextDouble();

            // // regresi linear f(x)
            // reg = a_0 + a_1 * cari;
            // System.out.println("Nilai f("+cari+")         = "+reg);
    }
}