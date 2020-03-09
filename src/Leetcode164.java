import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode164 {
    public int maximumGap(int[] nums) {
        if (nums.length<2)
            return 0;
        int length = nums.length;
        int max = nums[0];
        int min = nums[length-1];
        for (int num:nums) {
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        boolean[] bool =new boolean[length];
        int[][] buket = new int[length][2];
        double size = (double) (max-min)/(double) (length-1);
        for (int i = 0; i < length; i++) {
            int index = (int)((nums[i]-min)/size);
            if (!bool[index]){
                bool[index]=!bool[index];
                buket[index][0]= i;
                buket[index][1]= i;
            }else {
                if (nums[buket[index][0]]>nums[i]){
                    buket[index][0]=i;
                }
                if (nums[buket[index][1]]<nums[i]){
                    buket[index][1]=i;
                }
            }
        }
        int last_buket_index = 0;
        int maximumGap=0;
        for (int i = 0; i < length; i++) {
            if (bool[i]){
                maximumGap = Math.max(0,nums[buket[i][0]]-nums[buket[last_buket_index][1]]);
                last_buket_index = i;
            }
        }
        return maximumGap;

    }


    public static void main(String[] args) {
        Leetcode164 leetcode164 = new Leetcode164();
        int[] nums= {3,6,9,1};
        leetcode164.maximumGap(nums);
    }
}
