public class Leetcode44 {
    public boolean isMatch(String s, String p) {
        boolean[][] flag = new boolean[s.length()+1][p.length()+1];
        flag[0][0] = true;
        for (int i = 0; i <=s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j-1)=='*')
                    flag[i][j] = flag[i][j-1]||(i>0&&flag[i-1][j]);
                else if(i>0&&flag[i-1][j-1]
                        && (s.charAt(i-1)==p.charAt(j-1)
                                ||p.charAt(j-1)=='?')
                        )
                    flag[i][j]=true;
            }
        }
        return flag[s.length()][p.length()];

    }

    public static void main(String[] args) {
        Leetcode44 leetcode44 = new Leetcode44();
        System.out.println(leetcode44.isMatch("a","*"));;
    }
}
