public class Leetcode153 {
    public int findMin(int[] nums) {
//        int length = nums.length;
//        int left  = 0;
//        int right = length-1;
//
//
//        while (left<right){
//            int mid = (left+right)/2;
//            if (nums[right]>nums[mid]){
//                right = mid;
//            }else {
//                left = mid+1;
//            }
//        }
//        return nums[left];


        int length = nums.length-1;
        int left = 0,right = length-1;
        while (left<right){
            int mid = (left+right)/2;
            if (nums[mid]<nums[right]){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return nums[right];


    }


}
