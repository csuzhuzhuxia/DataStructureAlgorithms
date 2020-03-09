import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode132 {
    public int minCut1(String s) {
        if (isParlindrom(s)){
            return 0;
        }
        int min_size = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (isParlindrom(temp)){
                    return min_size;
                }
                for (int j = 0 ; j < temp.length()-1; j++) {
                    if (isParlindrom(temp.substring(0,j+1))){
                        queue.add(temp.substring(j+1,temp.length()));
                    }
                }
            }
            min_size++;
        }
        return min_size;
    }


    private boolean isParlindrom(String s) {
        int start = 0;
        int end = s.length()-1;
        while (start<end){
            if (s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    public int minCut2(String s) {
        int size = s.length();
        boolean[][] dp = new boolean[size][size];
        for (int len = 0; len < size; len++) {
            for (int i = 0; i+len-1 < size; i++) {
                int j= i+len-1;
                if (j==i){
                    dp[i][j] = true;
                }else {
                    if (s.charAt(i)==s.charAt(j)&&(i==j-1||dp[i+1][j-1])){
                        dp[i][j] = true;
                    }
                }
            }
        }

        int[] dp2 = new int[size];
        for (int i = 0; i < size; i++) {
            dp2[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < size; i++) {
            if (dp[0][i])
                dp2[i] = 0;
            else {
                for (int j = 0; j < i; j++) {
                    if (dp[j+1][i]){
                        dp2[i] = Math.min(dp2[i],dp2[j]+1);
                        if (dp2[i]==1)
                            break;
                    }
                }
            }
        }
        return dp2[size];
    }

    public int minCut3(String s) {
        if (s.length()==0||s==null)
            return 0;
        int length = s.length();
        int[] dp = new int[length+1];
        for (int i = 1; i <= length; i++) {
            dp[i] = i-1;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j<i-1 && i+j<=length && s.charAt(i+j-1)==s.charAt(i-j-1); j++) {
                dp[i+j] = Math.min(dp[i+j],dp[i-j]+1);
            }
            for (int j = 0; j < i-1 && i+j+1<=length && s.charAt(i)==s.charAt(i-1) && s.charAt(i-j-1)==s.charAt(i+j); j++) {
                dp[i+j+1] = Math.min(dp[i+j+1],dp[i-j]+1);
            }
        }
        return dp[length];
    }


    public static void main(String[] args) {
        Leetcode132 leetcode132 = new Leetcode132();
        System.out.println(leetcode132.minCut1("abbab"));;
    }
}
