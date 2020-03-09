import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Leetcode30 {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        if (s.isEmpty()||words.length== 0 ) return result;
        int size= words.length;
        int length = words[0].length();
        HashMap<String,Integer> word_map = new HashMap<>();
        for (String word:words){
            word_map.put(word,1);
        }
        for (int i=0;i<s.length()-size*length;i++){

            word_map = new HashMap<>();
            for (String word:words){
                if(word_map.containsKey(word)){
                    word_map.put(word,word_map.get(word)+1);
                }else {
                    word_map.put(word,1);
                }
            }
            for (int j=0;j<length;j++){
                String sub_string = s.substring(i+j*length,i+j*length);
                if (!word_map.containsKey(sub_string)) break;
                if (word_map.get(sub_string)==1){
                    word_map.remove(sub_string);
                }else {
                    word_map.put(sub_string,word_map.get(sub_string)-1);
                }
            }
            if(word_map.isEmpty()){
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.isEmpty()||words==null) return null;
        int size = words.length;
        int word_length = words[0].length();
        HashMap<String,Integer> map = new HashMap<>();
        for (String str:words) {
            if (map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }else {
                map.put(str,1);
            }
        }



        for (int i = 0; i < Math.min(word_length,s.length()-word_length*size); i++) {
            findSub(s,i,word_length,size,map,result);
        }
        return result;
    }

    private void findSub(String str, int str_start, int word_length, int size, HashMap<String, Integer> map, List<Integer> result) {
        HashMap<String,Integer> new_map = new HashMap<>();

        for (String str_word:map.keySet()) {
            new_map.put(str_word,0);
        }

        for (int i = str_start; i <=str.length(); i+=word_length) {//进行一次滑动窗口的查找
                int index = 0;
                String word = str.substring(str_start,str_start+word_length);
                if (!map.containsKey(word)){
                    str_start = str_start+word_length;
                }else{
                    while (new_map.get(word) == map.get(word)){
                        String str_start_word = str.substring(str_start,str_start+word_length);
                        new_map.put(str_start_word,new_map.get(str_start_word)-1);
                        str_start += word_length;
                        index--;
                    }
                    new_map.put(word,new_map.get(word)+1);
                    index++;
                    if (index==size){
                        result.add(str_start);
                    }
                }
        }
        return;
    }

    private void findsubstringIndex(int i, String s, String[] words, List<Integer> result, int size, int length) {
        HashMap<String,Integer> word_map= new HashMap<>();
        HashMap<String,Integer> word_find = new HashMap<>();
        for (String word:words) {
            if (word_map.containsKey(word)){
                word_map.put(word,word_map.get(word)+1);
            }else {
                word_map.put(word,+1);
            }
        }

        int str_start = i,word_start = i;
        while (str_start+size*length<=s.length()){
            if (word_start+length>s.length())
                return;
            String word = s.substring(word_start,word_start+length);
            word_start+=length;
            if (word_map.containsKey(word)){
                if (word_find.containsKey(word)){
                    word_find.put(word,word_find.get(word)+1);
                }else {
                    word_find.put(word,1);
                }


                while (word_map.get(word)<word_find.get(word)){
                    String str_start_word = s.substring(str_start,str_start+length);
                    word_find.put(str_start_word,word_find.get(str_start_word)-1);
                    str_start+=length;
                }

                if (word_start-str_start==size*length){
                    result.add(str_start);
                }
            }else {
                str_start = word_start;
                word_find = new HashMap<>();
            }
        }

    }

    private void findsubstringIndex1(int i, String s, String[] words, List<Integer> result, int size, int length) {
        HashMap<String,Integer> word_map= new HashMap<>();
        for (String word:words){
            if(word_map.containsKey(word)){
                word_map.put(word,word_map.get(word)+1);
            }else {
                word_map.put(word,1);
            }
        }


        int str_start=i,word_start=i;
        String word_string;
        HashMap<String,Integer> word_map_find= new HashMap<>();

        while(str_start+length*size<=s.length()){


            word_string = s.substring(word_start,word_start+length);
            word_start+=length;

            if (!word_map.containsKey(word_string)){
                str_start+=length;
                word_map_find = new HashMap<>();
                continue;
            }else {
                if (word_map_find.containsValue(word_string)){
                    word_map_find.put(word_string,word_map_find.get(word_string)+1);
                }else {
                    word_map_find.put(word_string,1);
                }

                while (word_map.get(word_string)<word_map_find.get(word_string)){
                    String string_string = s.substring(str_start,str_start+length);
                    word_map_find.put(string_string,word_map_find.get(string_string)-1);
                    str_start+=length;
                }

                if (word_start-str_start==length*size){
                    result.add(str_start);
                }
            }
        }
    }



    public static void main(String[] args) {
        Leetcode30 leetcode30 = new Leetcode30();
        String[] strings= {"word","good","best","good"};
        leetcode30.findSubstring2("wordgoodgoodgoodbestword",strings);
    }
}
