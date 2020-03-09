public class Leetcode58 {
    public int lengthOfLastWord(String s) {
        int length = s.length();
        if (length==0||s.trim().isEmpty()){
            return 0;
        }
        int k=s.length()-1;
        while (s.charAt(k)==' '){
            k--;
        }
        for (int i = k; i >=0 ; i--) {
            char c = s.charAt(i);
            if (c==' '){
                return (k-i);
            }
        }
        return k+1>=0?k+1:0;
    }

    public static void main(String[] args) {
        Leetcode58 leetcode58 = new Leetcode58();
        System.out.println(leetcode58.lengthOfLastWord("a"));;
    }
}
