import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> item = new ArrayList<>();
        int length = s.length();
        traceback(s,0,12-length,res,item);
        return res;
    }

    private void traceback(String s, int start,int left, List<String> res,  List<String> item) {
        if (item.size()==4){
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < item.size()-1; i++) {
                builder.append(item.get(i)).append(".");
            }
            builder.append(item.get(3));
            res.add(builder.toString());
            return;
        }
        if (start>=s.length()){
            return;
        }

        if (item.size()==3){
            if (isValid(s,start,s.length())){
                item.add(s.substring(start,s.length()));
                traceback(s,s.length(),0,res,item);
                item.remove(item.size()-1);
            }else {
                return;
            }
            return;
        }
        for (int j = (left<2?left:2) ; j >=0; j--) {
            if (isValid(s,start,start+(3-j))){
                item.add(s.substring(start,start+(3-j)));
                traceback(s,start+(3-j),left-j,res,item);
                item.remove(item.size()-1);
            }else {
                return;
            }
        }

    }

    public boolean isValid(String string,int start,int end){
        if (end>string.length()){
            return false;
        }
        int value = Integer.parseInt(string.substring(start,end));
        if (value>=0&&value<=255&&(!(string.charAt(start)=='0'&&(end-start>1)))){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode93 leetcode93 = new Leetcode93();
        System.out.println(leetcode93.restoreIpAddresses("25525511135"));
    }
}
