public class Leetcode41 {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==i+1){
                i++;
            }else {
                if (nums[i]>1&&nums[i]<=nums.length&&nums[i]!=nums[nums[i]-1]){
                    int temp = nums[i];
                    nums[i] = nums[temp-1];
                    nums[temp-1] = temp;
                }else {
                    i++;
                }
            }
        }

        for (int i = 0; i <nums.length; i++) {
            if (nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
//        for (int i = 0; i < nums.length;) {
//            if (nums[i]==i+1){
//                i++;
//            }else {
//                if (nums[i]>=1&&nums[i]<=nums.length&&nums[i]!=nums[nums[i]-1]){
//
//
//                    int temp =nums[i];
//                    nums[i] = nums[temp-1];
//                    nums[temp-1] = temp;
//                }else {
//                    i++;
//                }
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i]!=i+1){
//                return i+1;
//            }
//        }
//        return nums.length+1;

    }
}
