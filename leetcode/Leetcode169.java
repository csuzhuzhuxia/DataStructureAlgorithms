public class Leetcode169 {

    public int majorityElement(int[] nums) {
        int count = 1;
        int major = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (major==nums[i])
                count++;
            else {
                count--;
                if (count==0){
                    count=1;
                    major=nums[i];
                }
            }
        }
        return major;
    }
}
