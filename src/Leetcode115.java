public class Leetcode115 {
    public int numDistinct(String s, String t) {
        int source_length = s.length();
        int target_length = t.length();
        int[][] dp = new int[source_length+1][target_length+1];
        for (int i = 0; i < source_length+1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < target_length + 1; j++) {
            for (int i = 1; i < source_length+1 ; i++) {
                if (s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[source_length][target_length];
    }
}
