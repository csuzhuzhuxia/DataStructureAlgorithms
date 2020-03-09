public class Leetcode152 {
    public int maxProduct(int[] nums) {

        int[] max_values = new int[nums.length];
        int[] min_values = new int[nums.length];

        max_values[0] = min_values[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max_values[i] = Math.max(Math.max(max_values[i-1]*nums[i],min_values[i-1]*nums[i]),nums[i]);
            min_values[i] = Math.min(Math.min(max_values[i-1]*nums[i],min_values[i-1]*nums[i]),nums[i]);
            max = Math.max(max_values[i],max);
        }
        return max;


    }
}
