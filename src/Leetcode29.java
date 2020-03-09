public class Leetcode29 {

    public int divide(int dividend, int divisor) {
        if(divisor==0||(dividend==Integer.MAX_VALUE&&divisor==-1)||(dividend==Integer.MIN_VALUE&&divisor==1)){
            return Integer.MAX_VALUE;
        }
        int sign = ((dividend <0) ^ (divisor <0))?-1:1;
        long m = Math.abs(dividend);
        long n = Math.abs(divisor);
        int res=0;
        if (n==1) return  (int)(sign==1?m:-m);
        while(m>=n){

            long  t1 = 1;
            long t2 = n;

            while(m>= (t2<<1)){
                t1<<=1;
                t2<<=1;
            }

            res += t1;
            m -= t2;
        }
        return sign==1?res:-res;
    }

    public static void main(String[] args) {
        Leetcode29 leetcode29 = new Leetcode29();
//        leetcode29.divide()
    }
}
