public class Leetcode154 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left<right){
            int mid = (left+right)/2;
            while (left-1<right&&nums[left]==nums[left+1]){
                left++;
            }
            while (left-1<right&&nums[right]==nums[right-1]){
                right--;
            }

            if (nums[mid]<nums[right]){
                right = mid;
            }else if (nums[mid]>=nums[right]){
                left = mid+1;
            }
        }
        System.out.println(left);
        return nums[left];


//        int length = nums.length;
//        int left  = 0;
//        int right = length-1;
//
//
//        while (left<right){
//            int mid = (left+right)/2;
//            if (nums[right]>nums[mid]){
//                right = mid;
//            }else if (nums[right]<nums[mid]){
//                left = mid+1;
//            }else {
//                right--;
//            }
//        }
//        return nums[left];
    }
}
