import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            LinkedList list = new LinkedList();
            for (int j = 0; j < res.size(); j++) {
                list.add((res.get(j)<<1));
            }
            for (int j = res.size()-1; j >=0; j--) {
                list.add((res.get(j)<<1)+1);
            }
            res = list;
        }

        return res;
    }
}
