public class Leetcode26 {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        for(int i=1;i<nums.length;i++){
            if (nums[i-1]!=nums[i]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Leetcode26 leetcode26 = new Leetcode26();
        int[] nums = {1,1,2,2,3,3,4,5};
        System.out.println(leetcode26.removeDuplicates(nums));
    }

}
