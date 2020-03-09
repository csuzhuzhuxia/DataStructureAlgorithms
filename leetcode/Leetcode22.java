import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        traceBack("",0,0,list,n);

        return list;
    }

    private void traceBack(String s, int left, int right, List<String> list,int max) {
        if (s.length() == max * 2){
            list.add(s);
            return;
        }

        if (left<max){
            traceBack(s+'(',left+1,right,list,max);
        }

        if (right<left){
            traceBack(s+')',left,right+1,list,max);
        }
    }


}
