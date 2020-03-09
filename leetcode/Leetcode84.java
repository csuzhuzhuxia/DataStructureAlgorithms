import java.util.Stack;

public class Leetcode84 {
    public int largestRectangleArea1(int[] heights) {


        Stack<Integer> stack = new Stack<>();
        int length = heights.length;
        int res =0;
        for (int i = 0; i <= length ; i++) {
            int hei = (i==length?0:heights[i]);
            if (stack.isEmpty()||hei>=heights[stack.peek()]){
                stack.push(i);
            }else {
                while (!stack.isEmpty()&&hei<heights[stack.peek()]){
                    int peek = stack.pop();
                    res = Math.max(res,heights[peek]*(stack.isEmpty()?i:i-stack.peek()-1));
                }
            }

        }
        return res;









//        int res = 0;
//        Stack<Integer> stack = new Stack<>();
//        int n = heights.length;
//        int i=0;
//        while (i<n){
//            int height = i==n?0:heights[i];
//            if (stack.isEmpty()||stack.peek()<height){
//                i++;
//                stack.push(height);
//            }else {
//                int cur = stack.pop();
//                int cur_height = heights[cur];
//                res = Math.max(res,cur_height * (stack.isEmpty()?i:(i-stack.peek()-1)));
//            }
//        }
//        return res;


//        int res = 0;
//        Stack<Integer> stack = new Stack<Integer>();
//        int n = heights.length;
//        int i=0;
//        while (i<=n){
//            int height = (i==n?0:heights[i]);
//            if (stack.isEmpty()||heights[stack.peek()]<height){
//                stack.push(new Integer(i));
//                i++;
//                continue;
//            }
//            int cur = stack.pop();
//            int length = heights[cur];
//            res = Math.max(res,length*(stack.empty()?i:(i-stack.peek()-1)));
//        }
//        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        int res =0;
        for (int i = 0; i < size; i++) {
            if (i+1<size&&heights[i]<heights[i+1]){
                continue;
            }
            int minH = heights[i];
            for (int j = i; j >=0 ; j--) {
                minH = Math.min(minH,heights[j]);
                int width = i-j+1;
                res = Math.max(res,width*minH);
            }

        }
        return res;
    }




    private int getMinHeight(int[] heights, int left, int right) {
        int min_height = heights[left];
        int index = left;
        for (int i = left+1; i <=right ; i++) {
            if(min_height<heights[i]){
                min_height = heights[i];
                index = min_height;
            }
        }


        return index;
    }

    public static void main(String[] args) {
        Leetcode84 leetcode84 = new Leetcode84();
        int[] nums = {2,1,5,6,2,3};
        System.out.println(leetcode84.largestRectangleArea(nums));
    }


}
