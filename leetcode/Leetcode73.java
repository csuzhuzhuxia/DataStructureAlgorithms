public class Leetcode73 {
    public void setZeroes(int[][] matrix) {
        if (matrix.length==0||matrix[0].length==0){
            return;
        }



        boolean one_row_zeros = false,one_column_zeros=false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                if (matrix[i][j]==0){

                    if (i==0){
                        one_row_zeros=true;
                    }
                    if (j==0){
                        one_column_zeros = true;
                    }
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0]==0){
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j]=0;
                }
            }
        }

        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j]==0){
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j]=0;
                }
            }
        }

        if (one_row_zeros){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i]=0;
            }
        }
        if (one_column_zeros){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0]=0;
            }
        }


    }
}
