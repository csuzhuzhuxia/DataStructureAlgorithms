public class Leetcode198 {
    public int rob(int[] nums) {
//        int length = nums.length;
//        if (length==0)
//            return 0;
//        int[] dp = new int[length];
//        dp[0] = nums[0];
//
//        for (int i = 1; i < length; i++) {
//            dp[i] = Math.max(nums[i]+(i-2>=0?dp[i-2]:0),nums[i-1]+(i-3>=0?dp[i-3]:0));
//        }
//        return dp[length-1];






        int len = nums.length;
        int[] res = new int[len];
        res[0] = nums[0];
        res[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<len;i++){
            res[i] = Math.max(res[i-1],res[i-2]+nums[i]);
        }
        return res[len-1];


//        int length = nums.length;
//        if (length==0)
//            return 0;
//
//        // memo[i] 表示考虑抢劫 nums[i...n-1] 所能获得最大收益（不是说一定从 i 开始抢劫）
//        int[] dp = new int[length];
//        dp[length-1] = nums[length-1];
//        for (int i = length-2; i >=0 ; i--) {
//            dp[i] = Math.max(nums[i]+(i+2<length?dp[i+2]:0),nums[i]+(i+3<length?dp[i+3]:0));
//        }
//        return dp[0];

    }
}
