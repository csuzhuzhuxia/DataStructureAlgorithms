public class Leetcode91 {
    public int numDecodings(String s) {

        int index = s.length()-1;
        int[] dp = new int[100000];
        int value = Integer.parseInt(s.substring(index,index+1));
        if (value>0&&value<=9){
            dp[1]=1;
        }else {
            dp[1]=0;
        }
        if (s.length()<2){
            return dp[1];
        }
        value = Integer.parseInt(s.substring(index-1,index+2));
        if (value>=11&&value<=26){
            dp[2]=2;
        }else {
            dp[1]=1;
        }



        for (int i = 3; i <=s.length(); i++) {
            value = Integer.parseInt(s.substring(index-i+1,index-i+2));
            if (value>0){
                dp[i]+=dp[i-1];
            }
            value = Integer.parseInt(s.substring(index-i+1,index-i+3));
            if (value>=10&&value<=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];
        
    }

    private int traceback(String s, int index) {
        int result=0;
        if (index==s.length()){
            return 1;
        }

        if (index+2<=s.length()){
            int value = Integer.parseInt(s.substring(index,index+2));
            if (value<=26&&value>0){
                result+=traceback(s,index+2);
            }
        }
        int value = Integer.parseInt(s.substring(index,index+1));
        if (value>0&&value<=26){
            result+=traceback(s,index+1);
        }

        return result;
    }
}
