import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.Stack;

public class Leetcode155 {

    class MinStack {

        Stack<Integer> stack ;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()){
                stack.push(x);
                stack.push(x);
            }else {
                stack.push(x);
                int old_value = stack.peek();
                if (old_value<x){
                    stack.push(old_value);
                }else {
                    stack.push(x);
                }
            }
        }

        public void pop() {
            stack.pop();
            stack.pop();
        }

        public int top() {
            return stack.get(stack.size()-2);
        }

        public int getMin() {
            return stack.peek();
        }
    }
}
