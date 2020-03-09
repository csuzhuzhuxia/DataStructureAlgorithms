import java.util.ArrayList;
import java.util.List;

public class Leetcode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        ArrayList<String> item = new ArrayList<String>();
        traceback(s,item,res,0);
        return res;
    }

    private void traceback(String s, ArrayList<String> item, List<List<String>> res,int index) {
        if (index==s.length()){
            List<String> item_new = new ArrayList<>(item);
            res.add(item_new);
        }

        for (int i = index; i < s.length(); i++) {
            if (isParlindrom(s.substring(index,i+1))){
                item.add(s.substring(index,i+1));
                traceback(s,item,res,i+1);
                item.remove(item.size()-1);
            }
        }
    }

    private boolean isParlindrom(String s) {
        int start = 0;
        int end = s.length()-1;
        while (start<end){
            if (s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
