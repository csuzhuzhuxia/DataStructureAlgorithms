public class Leetcode209 {
    public int minSubArrayLen_baoli(int s, int[] nums) {
        int sum = 0;

        int res = nums.length+1;
        for(int i=0;i<nums.length;i++)
        {
            sum = 0;
            for(int j=i;j<nums.length;j++)
            {
                sum +=nums[j];
                if(sum>=s)
                    res = Math.min(j-i+1,res);
            }
        }
        return res == nums.length+1?0:res;
    }


    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int res = nums.length+1;
        int left =0;
        for(int i=0;i<nums.length;i++)
        {
            sum +=nums[i];
            while(sum>=s)
            {
                res = Math.min(res,i-left+1);
                sum-=nums[left++];
            }
        }
        return res == nums.length+1?0:res;
    }


}
