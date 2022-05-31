class langrange{
    static class Data{
        double x, y;
        public Data(double x, double y){
            super();
            this.x = x;
            this.y = y;
            
            System.out.println(this.x+"        "+this.y);
        }	
    }
    static double interpolate(Data f[], double xi, double n){
        double result = 0;
        for (int i = 0; i < n; i++){
            double term = f[i].y;
            for (int j = 0; j < n; j++){
                if (j != i)
                    term = term*(xi - f[j].x) / (f[i].x - f[j].x);
            }
            result += term;
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(" x     |     y");
        // Data f[] = {new Data(1, 1.5577), new Data(2, 1.2131),
        // 			new Data(3, 0.9447), new Data(4, 0.7358),
        // 			new Data(5, 0.5730), new Data(6, 0.4462),
        // 			new Data(7, 0.3476), new Data(8, 0.2706)};
        
        Data f[] = {
            new Data(5, 0.5730), new Data(6, 0.4462),
            new Data(7, 0.3476), new Data(8, 0.2706)};
            
        System.out.print("F(x=5.5) orde 4 : "+(double)interpolate(f, 5.5, 4)+"\n");
    }
}

