import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result =new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        Arrays.sort(candidates);
        traceback(candidates,0,target,item,result);
        return result;
    }

    private void traceback(int[] candidates, int start,int target, List<Integer> item, List<List<Integer>> result) {
        if (target==0){
            List<Integer> item_new = new ArrayList<>();
            for (int i = 0; i < item.size(); i++) {
                item_new.add(item.get(i));
            }
            result.add(item_new);
            return;
        }
        if (target<0){
            return;
        }

        for (int i=start;i<candidates.length;i++){
            if(i>start&&candidates[i]==candidates[i-1])
                continue;
            item.add(candidates[i]);
            traceback(candidates,i+1,target-candidates[i],item,result);
            item.remove(new Integer(candidates[i]));

        }
    }


}
