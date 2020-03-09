import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int types = nums.length;
        for (int i = 0; i <= types; i++) {
            combine(nums,i,res);
        }
        return res;
    }

    private void combine(int[] nums, int k, List<List<Integer>> res) {
        ArrayList<Integer> item = new ArrayList<>();
        traceback(nums,k,0,item,res);
    }

    private void traceback(int[] nums, int k, int start, ArrayList<Integer> item, List<List<Integer>> res) {
        if (item.size()==k){
            ArrayList<Integer> item_new = new ArrayList<>();
            for (Integer integer:item) {
                item_new.add(integer);
            }
            res.add(item_new);
            return;
        }


        for (int j = start; j <nums.length ; j++) {
            if(!isduplicate(nums,start,j)){
                item.add(nums[j]);
                traceback(nums,k,j+1,item,res);
                item.remove(new Integer(nums[j]));
            }

        }
    }

    private boolean isduplicate(int[] nums, int start, int j) {
        for (int i = start; i < j; i++) {
            if (nums[i]==nums[j]){
                return true;
            }
        }
        return false;
    }
}
