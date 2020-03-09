public class Leetcode70 {

//    你有多少种不同的方法可以爬到n节楼顶
    public int climbStairs1(int n) {
        if (n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        return climbStairs1(n-1)+climbStairs1(n-2);
    }

    public int climbStairs(int n) {
        if (n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        int[] result = new int[n+1];
        result[1]=1;
        result[2]=2;
        for (int i = 3; i < n+1; i++) {
            result[i]=result[i-1]+result[i-2];
        }
        return result[n];

    }
}
