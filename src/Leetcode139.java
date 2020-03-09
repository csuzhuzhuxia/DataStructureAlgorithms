import java.util.HashSet;
import java.util.List;

public class Leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s==null||s.length()==0)
            return false;
        int length = s.length();
        boolean[] dp = new boolean[length+1];
        dp[0] = true;
        for (int i = 0; i <length; i++) {
            for (int j = i; j >=0; j++) {
                if (dp[j]&&wordDict.contains(s.substring(j,i+1))){
                    dp[i+1] = true;
                    break;
                }
            }
        }
        return dp[length];
    }

    public boolean isDictContain(String s, HashSet<String> set){
        if (set.contains(s)){
            return true;
        }
        return false;
    }
}
