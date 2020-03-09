public class Leetcode75 {
    public void sortColors(int[] nums) {
        int start_index = 0;
        int current_index = 0;
        int end_index = nums.length-1;
        while (current_index<end_index){
            if (nums[current_index]==0){
                nums[current_index] = nums[start_index];
                nums[start_index] = 0;
                start_index++;
                current_index++;
            }else if (nums[current_index]==2){
                nums[current_index] = nums[end_index];
                nums[end_index] = 2;
                end_index--;
            }else {
                current_index++;
            }
        }
    }

    public static void main(String[] args) {
        Leetcode75 leetcode75 = new Leetcode75();
        int[] nums = {2,0,1};
        leetcode75.sortColors(nums);
        for (int item:nums) {
            System.out.println("--"+item+"--");
        }
    }
}
