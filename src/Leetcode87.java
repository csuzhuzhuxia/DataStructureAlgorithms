import java.util.Arrays;

public class Leetcode87 {
    public boolean isScramble1(String s1, String s2) {
        if (s1.length()==0||s2.length()==0||s1.length()!=s2.length()){
            return false;
        }
        int length = s1.length();
        boolean[][][] res = new boolean[length][length][length+1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                res[i][j][1] = (s1.charAt(i)==s2.charAt(j)?true:false);
            }
        }

        for (int len = 2; len < length+1 ; len++) {
            for (int i = 0; i <= length-len; i++) {
                for (int j = 0; j <= length-len; j++) {
                    for (int k = 1; k < len; k++) {
                        if ((res[i][j][k]&&res[i+k][j+k][len-k])
                                ||(res[i][j+len-k][k]&&res[i+k][j][len-k])){
                            res[i][j][k]=true;
                        }
                    }
                }
            }
        }
        return res[0][0][length];
        
    }

    public boolean isScramble(String s1, String s2) {
        if (s1.length()==0||s2.length()==0||s1.length()!=s2.length()){
            return false;
        }

        if (s1.equals(s2)){
            return true;
        }

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        if(!String.valueOf(chars1).equals(String.valueOf(chars2))){
            return false;
        }

        int length = s1.length();
        for (int i = 1; i < length; i++) {
            String substring1_1 = s1.substring(0,i);
            String substring1_2 = s1.substring(i);

            String substring2_1 = s2.substring(0,i);
            String substring2_2 = s2.substring(i);

            if (isScramble(substring1_1,substring2_1)&&isScramble(substring1_2,substring2_2)){
                return true;
            }

            substring2_1 = s2.substring(length-i);
            substring2_2 = s2.substring(0,length-i);

            if (isScramble(substring1_1,substring2_1)&&isScramble(substring1_2,substring2_2)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[] chars = {'1','2'};
        char[] chars1 = {'1','2'};
        System.out.println(chars1.equals(chars));
    }
}
