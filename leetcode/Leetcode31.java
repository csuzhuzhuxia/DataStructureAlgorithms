import java.lang.reflect.Array;
import java.util.Arrays;

public class Leetcode31 {
    public void nextPermutation(int[] nums) {

        int length = nums.length;
        int i=length-2;
        for (i = length-2; i >=0 ; i--) {
            if (nums[i]>=nums[i+1]){
                break;
            }
        }
        if (i<0){
            Arrays.sort(nums);
            return;
        }


        int j = length-1;
        for (; j >i ; j--) {
            if (nums[j]>nums[i]){
                break;
            }
        }

        int temp = nums[j];
        nums[j]=nums[i];
        nums[i]=temp;

        Arrays.sort(nums,i+1,length);




    }

    public static void main(String[] args) {
        int[] num ={1,2,4,2};
        Arrays.sort(num,2,4);
        for (int i:num){
            System.out.println(i);
        }
        System.out.println(num.toString());
    }
}
