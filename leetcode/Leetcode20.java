import java.util.HashMap;
import java.util.Stack;

public class Leetcode20 {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if(stack.isEmpty()||stack.pop()!=map.get(c)) return false;
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

//        HashMap<Character,Character> map = new HashMap<>();
//        map.put(')','(');
//        map.put(']','[');
//        map.put('}','{');
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i <s.length(); i++) {
//            if (map.containsKey(s.charAt(i))){
//                char c = stack.isEmpty()?'#':stack.pop();
//                if (c!=map.get(s.charAt(i))){
//                    return false;
//                }
//            }else {
//                stack.push(s.charAt(i));
//            }
//        }
//        return stack.isEmpty();

    }

}
