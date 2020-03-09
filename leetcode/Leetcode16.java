import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;

public class Leetcode16 {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int length =nums.length;
        int min_distance = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < length-2;) {
            int j = i+1;
            int k = length-1;
            while (i<k){
                int diff = nums[i]+nums[j]+nums[k]-target;
                if (diff==0)
                    return target;
                else if (diff>0){
                    res = min_distance<diff?res:target+diff;
                    min_distance = Math.min(diff,min_distance);
                    k--;
                    while (j<k&& nums[k]==nums[k+1]){
                        k--;
                    }
                }else {
                    res = min_distance>diff?res:target+diff;
                    min_distance = Math.min(-diff,min_distance);
                    j++;
                    while (j<k&& nums[j]==nums[j-1]){
                        j++;
                    }
                }
            }
            i++;
            while (i<length-2&&nums[i]==nums[i-1]){
                i++;
            }
        }
        return res;
        
//        Arrays.sort(nums);
//        int length = nums.length;
//        int min_distance = Integer.MAX_VALUE;
//        int res = 0;
//        for (int i = 0; i < length-2; ) {
//            int j = i+1;
//            int k = length-1;
//            while (j<k){
//                if (nums[i]+nums[j]+nums[k]==target){
//                    return target;
//                }else if (nums[i]+nums[j]+nums[k]<target){
//                    res =min_distance>target-nums[i]+nums[j]+nums[k]?nums[i]+nums[j]+nums[k]:res;
//                    min_distance = Math.min(min_distance,target-nums[i]+nums[j]+nums[k]);
//                    j++;
//                    while (nums[j]==nums[j-1]&&j<k){
//                        j++;
//                    }
//                }else {
//                    res =min_distance>nums[i]+nums[j]+nums[k]-target?nums[i]+nums[j]+nums[k]:res;
//                    min_distance = Math.min(min_distance,target-nums[i]+nums[j]+nums[k]);
//                    k--;
//                    while (nums[k]==nums[k+1]&&j<k){
//                        k--;
//                    }
//                }
//            }
//            i++;
//            while (nums[i]==nums[i-1]&&i<length-2){
//                i++;
//            }
//        }
//        return res;


    }

    public static void main(String[] args) {
        Leetcode16 leetcode16 = new Leetcode16();
        int[] nums ={0,1,2};
        System.out.println(leetcode16.threeSumClosest(nums,3));
    }
}
