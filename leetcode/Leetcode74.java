public class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0){
            return false;
        }


        int length = matrix.length*matrix[0].length;
        int size1 = matrix.length;
        int size2 = matrix[0].length;

        int left = matrix[0][0];
        int right= length;
        while (left<right){
            int mid = (left+right)/2;
            if (matrix[mid/size2][mid%size2-1]>target){
                right = mid-1;
            }else if (matrix[mid/size2][mid%size2-1]<target){
                left = mid+1;
            }else {
                return true;
            }
        }
        return false;



    }
}
