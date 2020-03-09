import java.util.HashMap;
import java.util.HashSet;

public class Leetcode1 {

    public int[] twoSum(int[] nums, int target) {
//        HashMap<Integer,Integer> set = new HashMap<>();
//        int[] res = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            if (set.containsKey(target-nums[i])){
//                res[0]=i;
//                res[1]=set.get(target-nums[i]);
//                return res;
//            }
//            set.put(nums[i],i);
//        }
//        return res;

        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                res[0] = i;
                res[1] = map.get(target-nums[i]);
                return res;
            }
            map.put(nums[i],i);
        }
        return res;

    }
}
