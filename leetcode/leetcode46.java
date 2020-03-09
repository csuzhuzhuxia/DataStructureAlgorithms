import java.util.ArrayList;
import java.util.List;

public class leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        traceback(nums,0,nums.length-1,res);
        return res;
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
            swap(nums,start,i);
            traceback(nums,start+1,length,res);
            swap(nums,start,i);
        }

    }

    private void swap(int[] nums, int i, int start) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }


}
