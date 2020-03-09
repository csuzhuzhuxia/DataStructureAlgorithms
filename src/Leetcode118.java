import java.util.ArrayList;
import java.util.List;

public class Leetcode118 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        if (numRows==0)
            return res;
        List<Integer> item_1 = new ArrayList<>();
        item_1.add(new Integer(1));
        res.add(item_1);
        if (numRows==1)
            return res;

        for (int i = 1; i <numRows ; i++) {
            PutList(i,res);
        }
        return res;
    }

    private void PutList(int numRows, List<List<Integer>> res) {
        List<Integer> item = new ArrayList<>();
        item.add(1);
        List<Integer> last_item =res.get(numRows-1);
        for (int i = 0; i < last_item.size()-1; i++) {
            item.add(last_item.get(i)+last_item.get(i+1));
        }
        item.add(1);
        res.add(item);
    }

    public static void main(String[] args) {
        Leetcode118 leetcode118 = new Leetcode118();
        leetcode118.generate(5);
        System.out.println("he");
    }
}
