public class Leetcode168 {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while (n>0){
            int value = n%26;
            n = n/26;
            if (value==0){
                builder.insert(0,'Z');
                n = n-1;
            }else {
                char c = (char)(value+64);
                builder.insert(0,c);
            }

        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Leetcode168 leetcode168 = new Leetcode168();
        System.out.println(leetcode168.convertToTitle(26));
        System.out.println(leetcode168.convertToTitle(27));
        System.out.println(leetcode168.convertToTitle(28));
        System.out.println((char)(65)+"");
    }
}
