import java.util.ArrayList;
import java.util.List;

public class Leetcode140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int maxSize = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            maxSize = Math.max(wordDict.get(i).length(),maxSize);
        }
        if (s==null||s.length()==0)
            return new ArrayList<>();
        int length = s.length();
        boolean[] dp = new boolean[length+1];
        dp[0] = true;
        for (int i = 0; i <length; i++) {
            for (int j = i; j >=0&&(i+1-j<=maxSize); j--) {
                if (dp[j]&&wordDict.contains(s.substring(j,i+1))){
                    dp[i+1] = true;
                    break;
                }
            }
        }
        if (!dp[s.length()]){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        traceback(s,0,wordDict,res,new ArrayList<String>(),maxSize);
        return res;
    }

    private void traceback(String s, int index, List<String> wordDict, List<String> res, ArrayList<String> strings, int maxSize) {
        if (index==s.length()){
            StringBuilder builder = new StringBuilder();
            for (String str:strings) {
                builder.append(str+" ");
            }
            res.add(builder.toString().trim());
        }
        for (int i = index; i <s.length()&&(i+1-index<=maxSize) ; i++) {
            if (wordDict.contains(s.substring(index,i+1))){
                strings.add(s.substring(index,i+1));
                traceback(s,i+1,wordDict,res,strings, maxSize);
                strings.remove(strings.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        String s = "ss ss ";
        System.out.println(s.trim().length());
    }
}
