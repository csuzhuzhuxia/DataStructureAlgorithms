public class Leetcode171 {

    public int titleToNumber(String s) {
        int length = s.length();
        int res = 0;
        for (int i = 0; i < length; i++) {
            res = res * 26 +(s.charAt(i)-'A'+1);
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode171 leetcode171 = new Leetcode171();
        System.out.println(leetcode171.titleToNumber("AB"));;
    }
}
