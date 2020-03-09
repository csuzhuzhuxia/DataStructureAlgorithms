import java.util.ArrayList;
import java.util.List;

public class leetcode39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result =new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        addTrace(candidates,0,target,result,item);
        return  result;
    }

    private static void addTrace(int[] candidates, int start, int target, List<List<Integer>> result,List<Integer> item) {
        if (target==0){
            List<Integer> item_new = new ArrayList<>();
            for (int i=0;i<item.size();i++){
                item_new.add(item.get(i));
            }
            result.add(item_new);
            return;
        }

        if (target<0){
            return;
        }

        for (int i=start;i<candidates.length;i++){
            item.add(candidates[i]);
            addTrace(candidates,0,target-candidates[i],result,item);
            item.remove(new Integer(candidates[i]));
        }
    }

    public static void main(String[] args) {
        int[] nums={2,3,6,7};
        combinationSum(nums,7);
    }


}
