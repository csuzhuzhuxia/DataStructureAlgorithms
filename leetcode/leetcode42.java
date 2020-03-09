import com.sun.javadoc.SeeTag;

import java.util.*;

public class leetcode42 {
    public int trap1(int[] height) {


        int area =0;
        Stack<int[]> stack = new Stack<>();
        int length = height.length;
        for (int i=0;i<length;i++){
            if (stack.isEmpty()||stack.peek()[0]>height[i]){
                int[] item = {height[i],i};
                stack.push(item);
            }else {
                while (!stack.isEmpty()&& stack.peek()[0]<=height[i]){
                    int[] item = stack.pop();
                    if (!stack.isEmpty())
                        area  +=(Math.min(stack.peek()[0],height[i])-item[0])*(i-stack.peek()[1]);
                }
                int[] item = {height[i],i};
                stack.push(item);
            }
        }
        return area;



//        int area = 0;
//        Stack<int[]> stack = new Stack<>();
//        int lenth = height.length;
//        for (int i = 0; i < lenth; i++) {
//            if (stack.isEmpty()||stack.peek()[0]>height[i]){
//                int[] item = {height[i],i};
//                stack.push(item);
//            }else{
//                while (!stack.isEmpty()&&stack.peek()[0]<=height[i]){
//                    int[] temp = stack.pop();
//                    if (!stack.isEmpty()){
//                        area+= (i-stack.peek()[1]-1) * (Math.min(stack.peek()[0],height[i])-temp[0]);
//                    }
//
//                }
//                int[] item = {height[i],i};
//                stack.push(item);
//            }
//        }
//        return area;


//        int area=0;
//        Stack<int[]> stack = new Stack<>();
//        int length = height.length;
//        for (int i = 0; i < length; i++) {
//            if (stack.isEmpty()||stack.peek()[0]>height[i]){
//                int[] pair ={height[i],i};
//                stack.push(pair);
//            }else {
//                while (!stack.isEmpty()&&stack.peek()[0]<=height[i]){
//                    int[] pair = stack.pop();
//                    if (!stack.isEmpty()){
//                        area += (i-stack.peek()[1]-1)*Math.min(height[i],stack.peek()[0])-pair[0];
//                    }
//                }
//                int[] pair ={height[i],i};
//                stack.push(pair);
//            }
//        }
//        return area;
    }


    public int trap(int[] height) {
        int idx=0;
        int size = height.length;
        int lefth=0,righth=0,right=size-1,left=0;
        int area =0;
        for (int i = 0; i < size; i++) {
            idx = (height[i]>height[idx]?i:idx);
        }

        for (; left < idx; left++) {
            if (lefth<height[left]){
                lefth = height[left];
            }else {
                area+=lefth -height[left];
            }
        }

        for (;right>idx;right--){
            if (righth<height[right]){
                righth = height[right];
            }else {
                area+=righth-height[right];
            }
        }

        return area;





    }



}
