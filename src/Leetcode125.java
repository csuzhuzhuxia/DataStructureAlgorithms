public class Leetcode125 {
    public boolean isPalindrome(String s) {


        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isValid(s.charAt(i))){
                if (s.charAt(i)>='a'&&s.charAt(i)<='z'){
                    builder.append((char)(s.charAt(i)-32));
                }else {
                    builder.append(s.charAt(i));
                }

            }
        }
        String str = builder.toString();
        int index_start= 0;
        int index_end = str.length()-1;
        while (index_start<index_end){
            char start_char = str.charAt(index_start++);
            char end_char = str.charAt(index_end--);
            if (start_char!=end_char)
                return false;
        }
        return true;
    }

    public boolean isValid(char c){
        if ((c>='a'&& c<='z')||(c>='A'&& c<='Z')||(c>='0'&&c<='9')){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode125 leetcode125 = new Leetcode125();
        String str = "A man, a plan, a canal: Panama";
        leetcode125.isPalindrome(str);
        System.out.println("hello");
    }
}
