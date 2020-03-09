import java.util.Stack;

public class Leetcode135 {
    public int candy(int[] ratings) {
        if (ratings.length==0||ratings==null)
            return 0;
        int[] candys = new int[ratings.length];
        int length = ratings.length;
        for (int i = 0; i < length; i++) {
            candys[i] = 1;
        }

        for (int i = 1; i < length; i++) {
            if (ratings[i]>ratings[i-1]){
                candys[i] = candys[i-1]+1;
            }
        }

        for (int i = length-2; i >=0 ; i--) {
            if (ratings[i]>ratings[i+1]){
                if (candys[i]<=candys[i+1]){
                    candys[i] = candys[i+1]+1;
                }
            }
        }

        int res=0;
        for (int i:candys) {
            res+=i;
        }
        return res;

    }
}
