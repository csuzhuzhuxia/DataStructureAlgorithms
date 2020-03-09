
import org.junit.Test;

public class Leetcode37 {


    public static void solveSudoku(char[][] board) {
        tryNextValue(board);

    }

    private static boolean tryNextValue(char[][] board) {
        int i=0,j=0;
        for(;i<9;i++)
        {
            for (;j<9;j++){
                if (board[i][j]=='.');
            }
        }
        return true;
    }






    private static boolean tryNextValue11(char[][] board) {
        //首先判断有没有填充完全
        int i=0,j=0;
        for (; i < board.length; i++) {
            for (; j < board.length; j++) {
                if (board[i][j]=='.'){
                    break;
                }
            }
            if (board[i][j]=='.'){
                break;
            }
        }
        if (i==9)
            return true;
        //此时我们得到i,j
        for (char num = '0'; num < '9'; num+=1) {
            if (isValidSudoku(board,i,j,num)){
                board[i][j] = num;
                if (tryNextValue(board)){
                    return true;
                }
                board[i][j]='.';
            }
        }
        return false;
    }

    public static boolean isValidSudoku(char[][] board,int i,int j,char c) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k]==c) return false;
            if (board[k][j]==c) return false;
            if (board[(i/3)*3+k/3][(j/3)*3+k%3]==c) return false;
        }
        return true;
    }

    public static boolean isValidSudoku2(boolean[][] colflag, boolean[][] rowflag, boolean[][] boardflag,int i,int j,int c) {

        if (colflag[j][c]|| rowflag[i][c]|| boardflag[3 * (i / 3) + j / 3][c])
            return false;
        return true;
    }




    public static void main(String[] args) {
        char[][] board = {
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'},
        };


        solveSudoku(board);
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                System.out.print(board[i][j]+"  ");
            }
            System.out.println("");
        }


    }



}
