import org.junit.Assert;
import org.junit.Test;


public class Leetcode36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowflag=new boolean[9][9];
        boolean[][] colflag = new boolean[9][9];
        boolean[][] boardflag = new boolean[9][9];

        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]>='1'&&board[i][j]<='9'){
                    int c = board[i][j]-'1';
                    if (colflag[j][c]||rowflag[i][c]||boardflag[3*(i/3)+j/3][c])
                        return false;
                    colflag[j][c]=true;
                    rowflag[i][c]=true;
                    boardflag[3*(i/3)+j/3][c]=true;
                }

            }
        }
        return true;

    }

    @Test
    public void test() {
        char[][] a = {{'.', '8', '7', '6', '5', '4', '3', '2', '1'}, {'2', '.', '.', '.', '.', '.', '.', '.', '.'}, {'3', '.', '.', '.', '.', '.', '.', '.', '.'}, {'4', '.', '.', '.', '.', '.', '.', '.', '.'}, {'5', '.', '.', '.', '.', '.', '.', '.', '.'}, {'6', '.', '.', '.', '.', '.', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'8', '.', '.', '.', '.', '.', '.', '.', '.'}, {'9', '.', '.', '.', '.', '.', '.', '.', '.'}};
        Assert.assertEquals(true, isValidSudoku(a));
    }
}
