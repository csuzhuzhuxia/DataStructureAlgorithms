import java.util.HashMap;

public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int longest = 1;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int num:nums) {
            if (!hashMap.containsKey(num)){
                hashMap.put(num,1);
                if (hashMap.containsKey(num+1)){
                    longest = Math.max(longest,merge(hashMap,num,num+1));
                }

                if (hashMap.containsKey(num-1)){
                    longest = Math.max(longest,merge(hashMap,num-1,num));
                }
            }
        }
        return longest;
    }

    private int merge(HashMap<Integer, Integer> hashMap, int num_left, int num_right) {
        int left = num_left-hashMap.get(num_left)+1;
        int right = num_right+hashMap.get(num_right)-1;
        int length = right-left+1;
        hashMap.put(left,length);
        hashMap.put(right,length);
        return length;
    }
}
