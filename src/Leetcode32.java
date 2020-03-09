import java.util.HashMap;
import java.util.Stack;

public class Leetcode32 {
    public static int longestValidParentheses(String s) {

//        Stack<Integer> stack = new Stack<>();
//        HashMap<Character,Integer> map = new HashMap<>();
//        int res = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i)==')'&& !stack.isEmpty() && s.charAt(stack.peek())=='('){
//                stack.pop();
//                if (stack.isEmpty()){
//                    res = Math.max(res,i+1);
//                }else {
//                    res = Math.max(res,i-stack.peek());
//                }
//            }else {
//                stack.push(i);
//            }
//        }
//        return res;


        Stack<Integer> stack = new Stack<>();
        int length = s.length();
        int res = 0;
        for(int i=0;i<length;i++){
            if (s.charAt(i)==')'&&!stack.isEmpty()&&s.charAt(stack.peek())=='('){
                stack.pop();
                if (stack.isEmpty()){
                    res = Math.max(res,i+1);
                }else {
                    res = Math.max(res,i-stack.peek());
                }
            }
            stack.push(i);
        }
        return res;

//        1.需有一个变量start记录有效括号子串的起始下标，max表示最长有效括号子串长度，初始值均为0
//
//        2.遍历给字符串中的所有字符
//
    //        2.1若当前字符s[index]为左括号'('，将当前字符下标index入栈（下标稍后有其他用处），处理下一字符
    //
    //        2.2若当前字符s[index]为右括号')'，判断当前栈是否为空
        //
        //        2.2.1若栈为空，则start = index + 1，处理下一字符（当前字符右括号下标不入栈）
        //
        //        2.2.2若栈不为空，则出栈（由于仅左括号入栈，则出栈元素对应的字符一定为左括号，可与当前字符右括号配对），判断栈是否为空
        //
        //        2.2.2.1若栈为空，则max = max(max, index-start+1)
        //
        //        2.2.2.2若栈不为空，则max = max(max, index-栈顶元素值)


//      进行遍历
//      判断当前是否可以进行配对，如果可以配对的话，进行计算当前的最大长度
//      对于计算当前的最大长度
//           1、如果栈为空，就可以直接计算当前的序号长度
//           2、如果栈不为空，计算到之前一个未配对的序号之间的长度

//        int max = 0, start = 0;
//        if(null == s) return 0;
//
//        int len = s.length();
//
//        Stack<Integer> stack = new Stack<>();
//        for(int index = 0; index < len; index++){
//            //遇左括号(，压栈(栈中元素为当前位置所处的下标)
//            if('(' == s.charAt(index)){
//                stack.push(index);
//                continue;
//            } else {
//                if(stack.isEmpty()){
//                    start = index+1;
//                    continue;
//                } else {
//                    stack.pop();
//                    if(stack.isEmpty()){
//                        max = Math.max(max, index-start+1);
//                    } else {
//                        max = Math.max(max, index-stack.peek());
//                    }
//                }
//            }
//        }
//
//        return max;

//        int max = 0;
//        int start = 0;
//        int length = s.length();
//        Stack<Integer> stack1 = new Stack<>();
//        for (int i = 0; i < length; i++) {
//            if (s.charAt(i)==')'){
//                if (stack.empty()){
//                    start=i+1;
//                }else {
//                    stack.pop();
//                    if (stack.isEmpty()){
//                        max = Math.max(max,i-start+1);
//                    }else {
//                        max = Math.max(max,i-stack.peek());
//                    }
//                }
//            }else {
//                stack.push(i);
//            }
//        }
//        return max;
    }



    public int longestValidParentheses1(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==')'&&!stack.isEmpty()&&s.charAt(stack.peek())=='('){
                stack.pop();
                if (stack.isEmpty()){
                    max = i+1;
                }else {
                    max = Math.max(max,i-stack.peek());
                }
            }else {
                stack.push(i);
            }
        }
        return max;
        
//        Stack<Integer> stack= new Stack<>();
//        int max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i)==')'&&!stack.isEmpty()&&s.charAt(stack.peek())=='('){
//                stack.pop();
//                if (stack.isEmpty()){
//                    max = i+1;
//                }else {
//                    if (i-stack.peek()>max)
//                        max = i-stack.peek();
//                }
//            }else
//                stack.push(i);
//        }
//        return max;
    }



//    stack<int> ss;
//    int max=0;
//        //1、通过记录匹配括号的位置信息，来确认当前有效字串的最大长度  
//                //（由于记录了更多信息，所以能力更强）  
//                //2、当栈为空时，表示匹配至此处的整个字符串有效。  
//                int t;  
//                    for( int i= 0; i< s.size() ; i++){  
//            if( s[i] == ')' && !ss.empty() && s[ss.top()] == '('){  
//                ss.pop();  
//                if( ss.empty())  
//                    max = i+1;  
//                else  
//                    //记录当前子串有效长度  
//                    if( i - ss.top() > max)  
//                        max = i - ss.top();  
//            }  
//            else  
//                ss.push(i);  
//        }  
//                    return max;  



    public static void main(String[] args) {
        System.out.println(longestValidParentheses("((()"));
    }
}
