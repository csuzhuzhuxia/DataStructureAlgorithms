public class Leetcode11 {
    public int maxArea(int[] height) {
        int area=0;
        int left=0,right=height.length-1;
        while (left<right){
            area = Math.max(area,(right-left)*Math.min(height[right],height[left]));
            if (height[right]>height[left]){
                left++;
            }else {
                right--;
            }
        }
        return area;
    }
}
