package metnummateri;
public class matrix {
    private final int M;             // number of rows
    private final int N;             // number of columns
    private final double[][] data;   // M-by-N array

    // create M-by-N matrix of 0's
    public matrix(int M, int N) {
        this.M = M;
        this.N = N;
        data = new double[M][N];
    }
    
    public void setmatrixElement(int i, int j, double s){
    	data[i][j]=s;
    }
    
    public int rows(){
    	return M;
    }
    
    public int cols(){
    	return N;
    }
    
    public matrix clone(){
    	matrix A = new matrix(this);
    	return A;
    }
    
    public double getmatrixElement(int i, int j){
    	return(data[i][j]);
    }

    // create matrix based on 2d array
    public matrix(double[][] data) {
        M = data.length;
        N = data[0].length;
        this.data = new double[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                    this.data[i][j] = data[i][j];
    }

    // copy constructor
    private matrix(matrix A) { this(A.data); }

    // create and return a random M-by-N matrix with values between 0 and 1
    public static matrix random(int M, int N) {
        matrix A = new matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.data[i][j] = Math.random();
        return A;
    }

    // create and return the N-by-N identity matrix
    public static matrix identity(int N) {
        matrix I = new matrix(N, N);
        for (int i = 0; i < N; i++)
            I.data[i][i] = 1;
        return I;
    }

    // swap rows i and j
    void swap(int i, int j) {
        double[] temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // create and return the transpose of the invoking matrix
    public matrix transpose() {
        matrix A = new matrix(N, M);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.data[j][i] = this.data[i][j];
        return A;
    }

    // return C = A + B
    public matrix plus(matrix B) {
        matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        matrix C = new matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = A.data[i][j] + B.data[i][j];
        return C;
    }


    // return C = A - B
    public matrix minus(matrix B) {
        matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        matrix C = new matrix(M, N);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                C.data[i][j] = A.data[i][j] - B.data[i][j];
        return C;
    }

    // does A = B exactly?
    public boolean eq(matrix B) {
        matrix A = this;
        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                if (A.data[i][j] != B.data[i][j]) return false;
        return true;
    }

    // return C = A * B
    public matrix times(matrix B) {
        matrix A = this;
        if (A.N != B.M) throw new RuntimeException("Illegal matrix dimensions.");
        matrix C = new matrix(A.M, B.N);
        for (int i = 0; i < C.M; i++)
            for (int j = 0; j < C.N; j++)
                for (int k = 0; k < A.N; k++)
                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
        return C;
    }
    
    // return Invers matrix A
    public matrix invers() {
        if (this.N != this.M) throw new RuntimeException("Illegal matrix dimensions.");
        matrix A = this.clone();
        matrix C = matrix.identity(this.N);
        double c;
        for(int k=0;k<C.M;k++)
        {
            //A.show();System.out.println();
            c=A.data[k][k];
            for(int j=0;j<C.N;j++){
		A.data[k][j]=A.data[k][j]/c;
                C.data[k][j]=C.data[k][j]/c;
            }
            //A.show();System.out.println();
            for(int i=0;i<C.M;i++)
            {
		if (i!=k){
                    c=A.data[i][k] ;
                    for(int j=0;j<C.N;j++){
			A.data[i][j]-=c*A.data[k][j];
                        C.data[i][j]-=c*C.data[k][j];
                    }
		}
            }
            
        }
        return C;
    }
    
 // print matrix to standard output
    public void show() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) 
                System.out.printf("%9.4f ", data[i][j]);
            System.out.println();
        }
    }
    
    //time scalar
    public matrix timeScalar(double sc) {
        matrix A = this;
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.data[i][j] = this.data[i][j]*sc;
        return A;
    }
    
   //Sum rows of matrix
    public matrix sumCols() {
        matrix A = new matrix(M,1);
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                A.data[i][0] = A.data[i][0] +this.data[i][j];
        return A;
    }
    
    public static void main(String[] args) {
        double[][] a = { { 2, 1, 3 }, { 4, -1, 3 }, { -2, 5, 5} };
        matrix A = new matrix(a);
        A.show();        
        System.out.println();
        
        matrix A1=A.invers();
        A1.show();        
        System.out.println();
        //D.show();        
        //System.out.println();
        
        //D1=D1.times(D);
        //D1.show();        
        //System.out.println();
        
        double[][] x = { { 1 }, { -4}, { 9} };
        matrix X = new matrix(x);
        X.show();
        System.out.println();
                
        A1.times(X).show();
        System.out.println();
    }

}