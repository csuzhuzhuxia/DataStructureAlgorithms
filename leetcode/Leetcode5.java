public class Leetcode5 {
    public String longestPalindrome(String s) {
        int lenth = 0;
        int start = 0,end = 0;
        int length = s.length();
        if (s==null||s.length()==0)
            return "";
        for (int i = 0; i < length ; i++) {
            int length1 = getLength(s,i,i);
            int length2 = getLength(s,i,i+1);
            length = Math.max(length,length2);
            if (length>end-start){
                start = i -(length-1)/2;
                end = i-(length)/2;
            }
        }
        return s.substring(start,end);

    }

    private int getLength(String s, int start, int end) {
        while (start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return end-start+1;
    }
}
