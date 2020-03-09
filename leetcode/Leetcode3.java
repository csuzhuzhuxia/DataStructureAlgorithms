import java.util.HashMap;

public class Leetcode3 {

    public int lengthOfLongestSubstring1(String s) {
        int[] index =new int[128];
        int length = s.length();
        int first_index = 0;
        int max_length = 0;
        for (int i = 0; i < length; i++) {
            first_index = Math.max(index[s.charAt(i)],first_index);
            index[s.charAt(i)]  = i+1;
            max_length = Math.max(max_length,i-first_index+1);
        }
        return max_length;

    }
    public int lengthOfLongestSubstring(String s) {
        int max_length = 0;
        int i=0,j=0;
        HashMap<Character,Integer> map = new HashMap<>();
        while (j<s.length()){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(i,map.get(s.charAt(j)));
            }
            map.put(s.charAt(j),j+1);
            max_length = Math.max(max_length,j-i+1);
            j++;
        }
        return max_length;
    }

    public static void main(String[] args) {
        Leetcode3 leetcode3 = new Leetcode3();
        System.out.println(leetcode3.lengthOfLongestSubstring("abcabcbb"));;
    }
}
