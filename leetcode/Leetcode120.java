import java.util.List;

public class Leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size()==0)
            return 0;
        int levels = triangle.size();
        int length = triangle.get(levels-1).size();
        int[] dp = new int[length+1];
        for (int i = 0; i < length; i++) {
            dp[i] = triangle.get(levels-1).get(i);
        }
        for (int i = levels-2; i >=0 ; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];



    }
}
