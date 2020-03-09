import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {

//        Arrays.sort(nums);
//        List<List<Integer>> res = new ArrayList<>();
//        int length = nums.length;
//        for (int i = 0; i < length-2; i++) {
//            int j = i+1;
//            int k = length-1;
//            while(j<k){
//                if (nums[i]+nums[j]+nums[k]==0){
//                    List<Integer> item =  new ArrayList<>();
//                    item.add(i);
//                    item.add(j);
//                    item.add(k);
//                    res.add(item);
//                    j++;
//                    k--;
//                }else if (nums[i]+nums[j]+nums[k]<0){
//                    while (j+1<k&&nums[j]==nums[j+1]){
//                        j++;
//                    }
//                }else{
//                    while (j<k-1&&nums[k]==nums[k-1]){
//                        k--;
//                    }
//                }
//            }
//            while (i+1<length-2&&nums[i]==nums[i+1]){
//                i++;
//            }
//        }
//        return res;




//        排序
//        Arrays.sort(nums);
//////
////        List<List<Integer>> res = new ArrayList<>();
////        for (int i=0;i<nums.length-2;){
////            int j=i+1,k=nums.length-1;
////            while (j<k) {
////                if (nums[i] + nums[j] + nums[k] == 0) {
////                    List<Integer> list = new ArrayList<>();
////                    list.add(nums[i]);
////                    list.add(nums[j]);
////                    list.add(nums[k]);
////                    j++;
////                    while (nums[j] == nums[j - 1] && j < k) {
////                        j++;
////                    }
////                    k--;
////                    while (nums[k] == nums[k + 1] && j < k) {
////                        k--;
////                    }
////                    res.add(list);
////                } else if (nums[i] + nums[j] + nums[k] < 0) {
////                    j++;
////                    while (nums[j] == nums[j - 1] && j < k) {
////                        j++;
////                    }
////                } else {
////                    k--;
////                    while (nums[k] == nums[k + 1] && j < k) {
////                        k--;
////                    }
////                }
////            }
////            i++;
////            if (nums[i]==nums[i-1]&&i<nums.length-2){
////                i++;
////            }
////
////
////        }
////        return res;




        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i <length-2 ; i++) {
            if (i==0||nums[i]!=nums[i-1]){
                int lo = i+1 ,hi = length-1;
                int sum = -nums[i];
                while (lo<hi){
                    if (nums[lo]+nums[hi]==sum)
                    {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);list.add(nums[lo]);list.add(nums[hi]);
                        res.add(list);
                        lo++;hi--;
                    }else if (nums[lo]+nums[hi]>sum){
                        hi--;
                    }else {
                        lo++;
                    }
                }
            }
        }
        return res;




//        Arrays.sort(nums);
//        List<List<Integer>> res = new ArrayList<>();
//        int length = nums.length;
//        for (int i = 0; i < length-2; ) {
//            int j=i+1;
//            int k = length-1;
//            while (j<k){
//                if (nums[i]+nums[j]+nums[k]==0){
//                    List<Integer> list = new ArrayList<>();
//                    list.add(nums[i]);
//                    list.add(nums[j]);
//                    list.add(nums[k]);
//                    res.add(list);
//                    j++;
//                    k--;
//                    while (nums[j]==nums[j-1]&&j<k){
//                        j++;
//                    }
//                    while (nums[k]==nums[k+1]&&j<k){
//                        k--;
//                    }
//                }else if (nums[i]+nums[j]+nums[k]<0){
//                    j++;
//                    while (nums[j]==nums[j-1]&&j<k){
//                        j++;
//                    }
//                }else {
//                    k--;
//                    while (nums[k]==nums[k+1]&&j<k){
//                        k--;
//                    }
//                }
//            }
//            i++;
//            while (nums[i]==nums[i-1]&&i<nums.length-2){
//                i++;
//            }
//        }
//        return res;

    }

    public static void main(String[] args) {

    }
}
