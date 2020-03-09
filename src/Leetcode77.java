import java.util.ArrayList;
import java.util.List;

public class Leetcode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        traceBack (1,n,k,result,item);
        return result;
    }

    private void traceBack(int start,int n, int k, List<List<Integer>> result, List<Integer> item) {
        if (item.size()==k){
            List<Integer> item_new = new ArrayList<>();
            for (Integer interge:item) {
                item_new.add(interge);
            }
            result.add(item_new);
            return;
        }

        for (int i = start; i <=n; i++) {
            item.add(i);
            traceBack(i+1,n,k,result,item);
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        Leetcode77 leetcode77 = new Leetcode77();
        leetcode77.combine(4,2);
    }
}
