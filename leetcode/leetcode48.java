public class leetcode48 {
    public void rotate(int[][] matrix) {
//        斜着交换一下

        for (int i=0;i<matrix.length;i++){
            for (int j = i+1; j <matrix.length ; j++) {
                swap(matrix,i,j,j,i);
            }
        }
//        竖子交换一下
        for (int i=0;i<matrix.length;i++){
            for (int j = i+1; j <matrix.length/2 ; j++) {
                swap(matrix,i,j,i,matrix.length-1-j);
            }
        }

    }

    private void swap(int[][] matrix, int i, int j, int i1, int j1) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i1][j1];
        matrix[i1][j1] = temp;
    }


}
