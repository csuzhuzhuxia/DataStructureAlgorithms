import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String,List<String>> map= new HashMap<>();
        for (String str:strs){
            char[] chars= str.toCharArray();
            Arrays.sort(chars);
            String  str_new = new String(chars);

            if (map.containsKey(str_new)){
                map.get(str_new).add(str);
            }else {
                List<String> item = new ArrayList<>();
                item.add(str);
                map.put(str_new,item);
            }
        }

        for (String str:map.keySet()){
            result.add(map.get(str));
        }

        return  result;

    }
}
