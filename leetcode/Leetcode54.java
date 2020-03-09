import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        traceback(matrix,0,result);
        return result;
    }

    private void traceback(int[][] matrix, int index, List<Integer> result) {
        if (matrix.length<2*(index+1)-1||matrix[0].length<2*(index+1)-1){
            return;
        }

        if (matrix.length==2*(index+1)-1){
            for (int j = index; j < matrix[index].length-index; j++) {
                result.add(matrix[index][j]);
            }
            return;
        }

        if (matrix[0].length==2*(index+1)-1){
            for (int k = index; k < matrix.length-index; k++) {
                result.add(matrix[k][matrix.length-index-1]);
            }
            return;
        }


//最上面一层
        for (int j = index; j < matrix[index].length-index-1; j++) {
            result.add(matrix[index][j]);
        }
//最右面一层
        for (int k = index; k < matrix.length-index-1; k++) {
            result.add(matrix[k][matrix.length-index-1]);
        }
//最下面一层
        for (int j = matrix[index].length-index-1; j >=index ; j--) {
            result.add(matrix[matrix.length-1-index][j]);
        }
//最左面一层
        for (int j = index; j < matrix[index].length-index-1; j--) {
            result.add(matrix[j][index]);
        }

        traceback(matrix,index+1,result);




    }
}
