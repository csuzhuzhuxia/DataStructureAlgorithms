public class Leetcode53 {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int max_nums=nums[0];
        for(int num:nums){
            if (sum>0){
                sum+=num;
            }else {
                sum=num;
            }
            max_nums = Math.max(sum,max_nums);
        }

        return max_nums;
    }

    public static void main(String[] args) {
        Leetcode53 leetcode53 = new Leetcode53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(leetcode53.maxSubArray(nums));;
    }
}
