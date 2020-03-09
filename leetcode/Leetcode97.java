public class Leetcode97 {
    public boolean isInterleave(String s1, String s2, String s3) {

        int length1 = s1.length();
        int length2 = s2.length();
        int length3 = s3.length();
        if (length1+length2!=length3)
            return false;
        boolean[][] dp = new boolean[length1+1][length2+1];
        dp[0][0] = true;
        for (int i = 2; i <=length1; i++) {
            dp[i][0] = dp[i-1][0]&&(s1.charAt(i-1)==s3.charAt(i-1));
        }


        for (int i = 1; i <=length2; i++) {
            dp[0][0] = dp[i-1][0]&&(s2.charAt(i-1)==s3.charAt(i-1));
        }

        for (int i = 1; i <=length1; i++) {
            for (int j = 1; j <= length2; j++) {
                boolean down = dp[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1));
                boolean right = dp[i-1][j]&& (s1.charAt(i-1)==s3.charAt(i+j-1));
                dp[i][j] = down || right;
            }
        }
        return dp[length1][length2];


//        if (s3.length()!=s1.length()+s2.length()){
//            return false;
//        }
//        int length1 = s1.length();
//        int length2 = s2.length();
//        boolean dp[][] = new boolean[length1][length2];
//        dp[0][0]=true;
//        for (int i = 1; i <=length1; i++) {
//            dp[i][0]= dp[i-1][0]&&(s1.charAt(i-1)==s3.charAt(i-1));
//        }
//        for (int i = 1; i <= length2; i++) {
//            dp[0][i]=dp[0][i-1]&&(s2.charAt(i-1)==s3.charAt(i-1));
//        }
//
//        for (int i = 2; i <= length1; i++) {
//            for (int j = 2; j <= length2; j++) {
//                boolean down =dp[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i-1));
//                boolean right = dp[i][j-1]&&(s2.charAt(j-1)==s3.charAt(j-1));
//                dp[i][j]=down||right;
//            }
//        }
//        return dp[length1][length2];

    }
}
