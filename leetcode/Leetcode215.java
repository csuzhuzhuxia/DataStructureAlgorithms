public class Leetcode215 {

    public int findKthLargest(int[] nums, int k) {
        if (nums.length==1){
            return nums[0];
        }
        return find(nums,0,nums.length-1,nums.length-k);

    }

    private int find(int[] nums, int start, int end,int K) {
        if(start>end)
            return Integer.MAX_VALUE;
        int item = nums[end];
        int index = start;

        for(int i=start;i<end;i++)
        {
            if(nums[i]<=item){
                swap(nums,index++,i);
            }
        }
        swap(nums,index,end);
        if(index==K) {
            return nums[index];
        } else if (index<K){
            return find(nums,index+1,end,K);
        } else {
            return find(nums,start,index-1,K);
        }

    }

    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }


}
