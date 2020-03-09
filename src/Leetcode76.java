import java.util.HashMap;
import java.util.Map;

public class Leetcode76 {
    public String minWindow1(String s, String t) {
        if (s.length()==0||t.length()==0){
            return "";
        }
        int[] source_num = new int[256];
        int[] target_num = new int[256];
        int count  = 0;
        int start  = 0;
        int min_length = s.length()+1;
        String result = "";
        for (int i = 0; i < t.length(); i++) {
            target_num[t.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            source_num[s.charAt(i)]++;
            while (source_num[s.charAt(i)]<=target_num[s.charAt(i)]){
                count++;
            }
            if (count==t.length()){
                if (target_num[s.charAt(start)]<source_num[s.charAt(start)]){
                    source_num[s.charAt(start)]--;
                    start++;
                }

                if (min_length>i-start+1){
                    min_length = i-start+1;
                    result = s.substring(start,i+1);
                }
                source_num[s.charAt(start)]--;
                start++;
                count--;
            }
        }
        if (min_length==s.length()+1){
            return "";
        }else {
            return result;
        }

    }

    public String minWindow(String s, String t) {
        if (s.length()==0||t.length()==0){
            return "";
        }

        Map<Character,Integer> source_map = new HashMap<>();
        Map<Character,Integer> target_map = new HashMap<>();

        for (int i=0;i<t.length();i++){
            target_map.put(t.charAt(i),target_map.containsKey(t.charAt(i))?target_map.get(t.charAt(i))+1:1);
        }

        int count = 0;
        int Min_length = s.length()+1;
        int start = 0;
        String result="";

        for (int i = 0; i < s.length(); i++) {
            source_map.put(s.charAt(i),source_map.containsKey(s.charAt(i))?source_map.get(s.charAt(i))+1:1);
            if (target_map.containsKey(s.charAt(i))&&source_map.get(s.charAt(i))<target_map.get(s.charAt(i))){
                count++;
            }
            if (count==t.length()){
                while (!target_map.containsKey(s.charAt(start))||source_map.get(s.charAt(start))>target_map.get(s.charAt(start))){
                    source_map.put(s.charAt(start),source_map.get(s.charAt(start))-1);
                    start--;
                }

                if (Min_length>i-start+1){
                    Min_length = i-start+1;
                    result = s.substring(start,i+1);
                }

                source_map.put(s.charAt(start),source_map.get(s.charAt(start))-1);
                start++;
                count--;
            }
        }

        return result;

    }


}
