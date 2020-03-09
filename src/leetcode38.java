import java.util.HashMap;
import java.util.Map;

public class leetcode38 {
    public static String countAndSay1(int n) {
        if (n==1){
            return "1";
        }else if(n==2){
            return "11";
        }

        String str = countAndSay(n-1);
        Map<Character,Integer> map=new HashMap<>();
        StringBuilder result = new StringBuilder();
        char char_pre = str.charAt(0);
        map.put(char_pre,1);
        for (int i=1;i<str.length();i++){
            char c = str.charAt(i);
            if (c==char_pre){
                if (map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                }
            }else {

                int value = map.remove(char_pre);
                result.append(value).append(char_pre);


                if (map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                }else {
                    map.put(c,1);
                }
            }

            char_pre=c;
        }
        int value = map.remove(char_pre);
        result.append(value).append(char_pre);
        return result.toString();

    }

    public static String countAndSay(int n) {
        if (n==1){
            return "1";
        }
        String str = countAndSay(n-1);

        StringBuilder result = new StringBuilder();

        for (int i=1,k=0;i<=str.length();i++){
            if (i==str.length()||str.charAt(i)!=str.charAt(k)){
                result.append(i-k);
                result.append(str.charAt(k));
                k=i;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
