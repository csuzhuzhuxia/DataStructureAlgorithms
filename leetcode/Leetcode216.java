import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Leetcode216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        findList(k,1,9,n,res,item);
        return  res;


    }

    private void findList(int k, int start, int end, int n, List<List<Integer>> res,List<Integer> item) {
        if(k==0||start>end||n<=0){
            if(n==0&&k==0){
                // System.out.println(item);
                ArrayList<Integer> item_new = new ArrayList<Integer>(item);
                res.add(item_new);
            }
            return ;
        }

        int min_sum = (int)((start*2+k-1)*((float)k/2));
        int max_sum = (int)((end*2-(k-1))*((float)k/2));
        // // System.out.print(min_sum+"--");
        // // System.out.print(max_sum+"---");

        if (n<min_sum||n>max_sum)
            return;

        if(k>0){
            item.add(start);
            findList(k-1,start+1,end,n-start,res,item);
            item.remove(item.size()-1);
            findList(k,start+1,end,n,res,item);
        }

    }
}
