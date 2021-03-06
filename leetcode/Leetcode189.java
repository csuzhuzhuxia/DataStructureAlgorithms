public class Leetcode189 {

    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if (k==0)
            return;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = temp[i+nums.length-k];
        }
        for (int i = nums.length-1; i >=k ; i--) {
            nums[i] = nums[i-k];
        }
        for (int i = 0; i <k; i++) {
            nums[i] = temp[i];
        }

    }
}
