public class Leetcode55 {
    public boolean canJump1(int[] nums) {

        int max_num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i<max_num) return false;
            max_num = Math.max(nums[i]+i,max_num);
            if (max_num>nums.length-1) return true;
        }
        
        return max_num>=nums.length-1;
    }
    public boolean canJump(int[] nums) {

//        //假设位置i(0≤i≤A.length)能够跳跃的最大长度为dp[i]
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (dp[i-1]>=i){
//                dp[i] = Math.max(dp[i-1],nums[i]+i);
//            }else {
//                dp[i] = 0;
//            }
//
//        }
//        return dp[nums.length-1]>=nums.length-1;
        int max_length = nums[0];

        for (int i = 1; i <nums.length; i++) {
            if (max_length<i)
                return false;
            else
                max_length = Math.max(max_length,nums[i]+i);
                if (max_length>=nums.length-1)
                    return true;
        }
        return max_length>nums.length-1;
    }
}
