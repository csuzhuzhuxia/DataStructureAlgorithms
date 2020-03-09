import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res= new LinkedList<>();
        if (rowIndex==0)
            return res;
        res.add(1);
        if (rowIndex==1){
            return res;
        }
        for (int i = 1; i < rowIndex; i++) {
            updateItem(res);
        }


        return res;

    }

    private void updateItem( List<Integer> res) {
        int size = res.size();
        res.add(1);
        for (int j = 1; j < size; j++) {
            res.add(res.get(0)+res.get(1));
            res.remove(0);
        }
        res.remove(0);
        res.add(1);
    }

    public static void main(String[] args) {
        Leetcode119 leetcode119 = new Leetcode119();
        leetcode119.getRow(3);
        System.out.println("ss");
    }
}
