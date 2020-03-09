public class Leetcode33 {

    public static int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        int left =0,right = nums.length-1;
        while (left<right){
            int mid = (left+right)/2;
            if (nums[mid]<nums[right]){
                right = mid;
            }else {
                left = mid+1;
            }
        }

//        int ans = binary_search(nums,0,right)
        if (left==0)
            return binary_search(nums,0,nums.length-1,target);

        int mid = nums[nums.length-1];
        if (target>mid){
            return binary_search(nums,0,left-1,target);
        }else {
            return binary_search(nums,left,nums.length-1,target);
        }


//        if(nums.length==0){
//            return -1;
//        }
//        int left = 0,right = nums.length-1;
//        while (left<right){
//            int mid = (left+right)/2;
//            if (nums[mid]<nums[right]){
//                right = mid;
//            }else {
//                left = mid+1;
//            }
//        }
//        int ans = binary_search(nums,right,nums.length-1,target);
//        if (ans==-1){
//            ans = binary_search(nums,0,right-1,target);
//        }
//        return ans;
    }


    private static int binary_search(int[] nums, int start, int last,int target) {

        while (start<=last){
            int mid = (start+last)/2;
            if (nums[mid]<target){
                start = mid+1;
            }else if (nums[mid]>target){
                last = mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,0));;
    }
}
