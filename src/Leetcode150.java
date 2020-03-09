import java.util.HashSet;
import java.util.Stack;

public class Leetcode150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        HashSet<String> set =new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for (String str:tokens) {
            if (set.contains(str)){
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (str){
                    case "+":
                        stack.push(num1+num2);
                        break;
                    case "-":
                        stack.push(num2-num1);
                        break;
                    case "*":
                        stack.push(num1*num2);
                        break;
                    case "/":
                        stack.push(num2/num1);
                        break;
                }
            }else {
                stack.push(Integer.parseInt(str));
            }

        }
        return stack.pop();
    }
}
