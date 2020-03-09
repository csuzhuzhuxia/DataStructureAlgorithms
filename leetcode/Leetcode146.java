import java.util.*;

public class Leetcode146 {

    class LRUCache {
        private HashMap<Integer,Integer> map;
        private Stack<Integer> stack;
        private int capacity=0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            stack = new Stack<>();
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            if (!stack.contains(key)){
                return -1;
            }
            stack.remove(Integer.valueOf(key));
            stack.push(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            if(map.containsKey(Integer.valueOf(key))){
                stack.remove(key);
            }else{
                if (stack.size()==capacity){
                    Integer remove_key = stack.remove(0);
                    map.remove(Integer.valueOf(remove_key));
                }
            }


            stack.push(key);
            map.put(Integer.valueOf(key),Integer.valueOf(value));
        }
    }
}
