public class Leetcode35 {

    public static int searchInsert(int[] nums, int target) {
        int left=0,right =nums.length;
        while (left<right){
            int mid = (left+right)/2;
            if (nums[mid]<target){
                left = mid+1;
            }else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,5};

        System.out.println(searchInsert(nums,3));
        System.out.println(searchInsert(nums,4));
    }


}
