import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        traceback(nums,0,nums.length-1,result);
        return result;

    }

    private void traceback(int[] nums, int start, int length, List<List<Integer>> res) {
        if (start==length){
            List<Integer> item = new ArrayList<>();
            for (int num:nums) {
                item.add(num);
            }
            res.add(item);
            return;
        }

        for (int i = start; i <=length; i++) {
            if(isDuplicate(nums,start,i)){
                swap(nums,start,i);
                traceback(nums,start+1,length,res);
                swap(nums,start,i);
            }
        }

    }

    private boolean isDuplicate(int[] nums, int start, int end) {
        for (int j = start+1; j <=end; j++) {
            if (nums[j]==nums[end]){
                return false;
            }
        }
        return true;
    }

    private void swap(int[] nums, int i, int start) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }
}
