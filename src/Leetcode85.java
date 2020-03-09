public class Leetcode85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int res=0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]=='1')
                    height[j]+=1;
                else
                    height[j]=0;
            }
             res= Math.max(largestRectangleArea(height),res);
        }
        return res;
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
}
