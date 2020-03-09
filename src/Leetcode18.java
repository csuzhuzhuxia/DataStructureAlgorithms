import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        List<List<Integer>> res = new ArrayList<>();
//        int length = nums.length;
//
//        int i,j,k,l;
//        for (i = 0; i < length - 3; ) {
//            for (j = i + 1; j < length - 2; ) {
//                k = i+1;
//                l = length-1;
//
//                while (k < l) {
//                    if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
//                        List<Integer> item = new ArrayList<>();
//                        item.add(nums[i]);
//                        item.add(nums[j]);
//                        item.add(nums[k]);
//                        item.add(nums[l]);
//                        res.add(item);
//                        k++;
//                        l--;
//                        while (nums[k] == nums[k - 1]&& k<l) {
//                            k++;
//                        }
//                        while ( nums[l] == nums[l + 1] && k<l) {
//                            l--;
//                        }
//                    } else if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
//                        k++;
//                        while (nums[k] == nums[k - 1]&& k<l) {
//                            k++;
//                        }
//                    } else {
//                        l--;
//                        while ( nums[l] == nums[l + 1] && k<l) {
//                            l--;
//                        }
//                    }
//                }
//                j++;
//                while (nums[j]==nums[j-1]&&j<length-2){
//                    j++;
//                }
//            }
//            i++;
//            while(nums[i]==nums[i-1]&&i<length-3){
//                i++;
//            }
//        }
//        return res;


        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < length-3;i++)
        {
            if (i==0||nums[i]!=nums[i-1])
            {
                for (int j = i+1; j < length-2; j++)
                {
                    if (j==i+1||nums[j]!=nums[j-1])
                    {
                        int lo =j+1,hi = length-1;
                        int sum=  target-nums[i]-nums[j];
                        while (lo<hi)
                        {
                            if (nums[lo]+nums[hi]==sum){
                                res.add(Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]));
                                while (lo<hi&&nums[lo]==nums[lo+1]){
                                    lo++;
                                }
                                while (lo<hi&&nums[hi]==nums[hi-1]){
                                    hi--;
                                }
                                lo++;
                                hi--;
                            }
                            else if (nums[lo]+nums[hi]>sum)
                            {
                                hi--;
                            }
                            else
                            {
                                lo++;
                            }
                        }
                    }
                }
            }
        }
        return res;

    }

}
