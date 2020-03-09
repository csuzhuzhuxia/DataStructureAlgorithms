import java.util.ArrayList;
import java.util.List;

public class Leetcode51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] flag = new int[n+1];
        traceBack(flag,1,n+1,res);
        return res;
    }

    private void traceBack(int[] flag, int index, int length, List<List<String>> res) {
        if (index==length){//这个时候是全部填完了
            List<String> item = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i < length; i++) {
                builder.delete(0,length);
                for (int j = 1; j < length; j++) {
                    if (flag[i]==j){
                        builder.append("Q");
                    }else {
                        builder.append(".");
                    }
                }
                item.add(builder.toString());
            }
            res.add(item);
            return;
        }

        for (int i = 1; i <length; i++) {
            if(isValid(flag,index,i)){
                traceBack(flag,index+1,length,res);
            }
        }

    }

    private boolean isValid(int[] flag, int index, int col) {
        for (int j = 1; j < index; j++) {
            if (flag[j]==col||Math.abs(j-index)==Math.abs(flag[j]-col)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Leetcode51 leetcode51 = new Leetcode51();
        System.out.println(leetcode51.solveNQueens(8).size());;
    }
}
