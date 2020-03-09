public class Leetcode67 {
    public String addBinary(String a, String b) {
        int lengtha = a.length();
        int lengthb = b.length();
        int length = Math.max(lengtha,lengthb);
        int carry=0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <length; i++) {
            char ca='0',cb='0';
            if (i<lengtha){
                ca = a.charAt(lengtha-1-i);
            }
            if (i<lengthb){
                cb = b.charAt(lengthb-1-i);
            }
            int result = (int)(ca-'0')+(int)(cb-'0')+carry;
            stringBuilder.insert(0,result%2);
            carry = result/2;
        }
        if (carry>0)
            stringBuilder.insert(0,carry);

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Leetcode67 leetcode67 = new Leetcode67();
        System.out.println(leetcode67.addBinary("11","1"));
    }
}
