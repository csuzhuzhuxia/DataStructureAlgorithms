public class Leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if (nums.length==0)
            return result;
        int i = 0,j = nums.length-1;
        while (i<j){
            int mid = (i+j)/2;
            if (nums[mid]<target){
                i = mid+1;
            }else {
                j = mid;
            }
        }


        if (nums[i]==target)
            result[0] = i;
        else
            return result;

        j = nums.length-1;
        while (i<j){
            int mid = (i+j)/2;
            if (nums[mid]>target){
                j = mid-1;
            }else {
                i = mid;
            }
        }
        result[1] = j;
        return result;


//        int[] result = {-1,-1};
//        if(nums.length==0){
//            return result;
//        }
//
//        int i=0,j=nums.length-1;
//
//        while (i<j){
//            int mid = (i+j)/2;
//            if (nums[mid]<target){
//                i=mid+1;
//            }else {
//                j = mid;
//            }
//        }
//        if (nums[i]!=target)
//            return result;
//        else
//            result[0] = i;
//
//        j = nums.length-1;
//        while (i<j){
//            int mid = (i+j)/2+1;
//            if (nums[mid]>target){
//                j=mid-1;
//            }else {
//                i = mid;
//            }
//        }
//        result[1] = j;
//
//        return result;









    }

    public static void main(String[] args) {
        Leetcode34 leetcode34 = new Leetcode34();
        int[] nums = {1,2,4,4,4,4,6,7};
        leetcode34.searchRange(nums,4);
    }
}
