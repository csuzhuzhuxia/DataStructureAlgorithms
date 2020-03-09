import java.util.Arrays;

public class Leetcode45 {

    public int jump1(int[] nums) {
        int length = nums.length;
        int cur_max_length = 0;
        int next_max_length =  nums[0];
        int res =0;
        for (int i = 1; i < length; i++) {
            if (i>cur_max_length){
                res++;
                cur_max_length = next_max_length;
            }
            next_max_length = Math.max(next_max_length,nums[i]+i);
        }
        return res;


//        int length = nums.length;
//        int left=0,right=0,maxbound=0;
//        int jump_count=0;
//        while (right<length-1){
//            maxbound = right;
//            for (int i=left;i<=right;i++){
//                maxbound = Math.max(maxbound,nums[i]+i);
//            }
//            left=right+1;
//            right = maxbound;
//            jump_count++;
//        }
//        return jump_count;
    }

    public static void main(String[] args) {
        Leetcode45 leetcode45 = new Leetcode45();
        int[] nums = {2,3,1,1,4};
        System.out.println(leetcode45.jump2(nums));;
        System.out.println(leetcode45.getlevel(20));
    }

    public int getlevel(int num){
//        if (num==1)
//            return 1;
//        if (num==-2)
//            return 2;
//        return getlevel(num-1)+getlevel(num-2);
        int[] dp = new int[num+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < num+1; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[num];

    }

    public int jump2(int[] nums) {
        //假设到达位置i所需要的步数
        int[] dp = new int[nums.length];
        dp[0]= 0;
        int cur_max_length = 0;
        int next_max_length = nums[0];
        for (int i = 1; i <nums.length; i++) {
            if (i<=cur_max_length){
                dp[i] = dp[i-1];
                next_max_length = Math.max(next_max_length,nums[i]+i);
            }else {
                if (next_max_length>=i){
                    cur_max_length = next_max_length;
                    dp[i]=dp[i-1]+1;
                    next_max_length = Math.max(next_max_length,nums[i]+i);
                }else {
                    return -1;
                }
            }
        }
        return dp[nums.length-1];



//        //假设到达位置i所需要的步数
//        int [] dp = new int[nums.length];
////        Arrays.fill(dp, nums.length);  //初始化
//        dp[0] = 0;
//        for (int i = 1; i < dp.length; ++i) {
//            for (int j = 0; j < i; ++j) {
//                if (nums[j] + j >= i)
//                    dp[i] = Math.min(dp[i], dp[j]+1);
//            }
//        }
//        return dp[dp.length-1];
    }

    public int jump3(int[] nums) {
        int jump=0;
        int curend= 0;
        int farest=0;
        for (int i = 0; i < nums.length-1; i++) {
            farest=Math.max(farest,nums[i]+i);
            if (i==curend){
                curend = farest;
                jump++;
                if (farest>=nums.length-1) return jump;
            }
        }
        return jump;


    }
    public int jumpBFS(int[] nums) {
        if (nums.length<2)
            return 0;

        int jump = 0;
        int cur_max = 0;
        int next_max = 0;
        int i=0;
        while (cur_max+1-i>0){
            jump++;
            for (;i<=cur_max;i++){
                next_max = Math.max(next_max,nums[i]+i);
                if (next_max>=nums.length-1) return jump;
            }

            cur_max=next_max;
        }
        return 0;
    }


}
