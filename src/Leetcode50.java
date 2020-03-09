public class Leetcode50 {
    public double myPow(double x, int n) {
        if (n==0){
            return 1;
        }

        if (n<0){
            return 1.0/positive_pow(x,-(long)n);
        }else {
            return positive_pow(x,Math.abs(n));
        }

    }

    private double positive_pow(double x, long n) {
        double result=1;
        for (long i = n; i > 0; i--) {
            if (i%2==0){
                x=x*x;
                i/=2;
            }
            result*=x;
        }
        return result;

    }

    public static void main(String[] args) {
        Leetcode50 leetcode50 = new Leetcode50();
        System.out.println(leetcode50.myPow(2.00000 ,-2147483648));
    }
}
