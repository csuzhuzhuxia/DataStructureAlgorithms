public class Leetcode162 {

    public int findPeakElement(int[] nums) {
        if (nums.length==1)
            return 0;
        int right = nums.length,left = 0;

        while (left<right){
            int mid = (left+right)/2;
            if (nums[mid]>nums[mid+1]){
                right = mid;
            }else if (nums[mid]<nums[mid+1]){
                left = mid+1;
            }
        }
        return right;
    }
}
