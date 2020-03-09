import sun.jvm.hotspot.memory.LinearAllocBlock;

import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int type = nums.length;

        for (int i = 0; i <= type; i++) {
            combine(nums,i,result);
        }
        return result;
    }

    private void combine(int[] nums, int k, List<List<Integer>> result) {
        List<Integer> item = new ArrayList<>();
        traceBack(nums,0,k,result,item);

    }

    private void traceBack(int[] nums, int start, int k, List<List<Integer>> result, List<Integer> item) {
        if (item.size()==k){
            List<Integer> item_new = new ArrayList<>();
            for (Integer integer:item) {
                item_new.add(integer);
            }
            result.add(item_new);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            item.add(nums[i]);
            traceBack(nums,i+1,k,result,item);
            item.remove(new Integer(nums[i]));
        }

    }
}
