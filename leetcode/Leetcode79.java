public class Leetcode79 {
    public boolean exist(char[][] board, String word) {
        if (board.length==0||board[0].length==0){
            return false;
        }

        boolean[][] use = new boolean[board.length][board[0].length];
        for (int i = 0; i <board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (check(i,j,board,word,0,use)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(int i, int j, char[][] board, String word, int index, boolean[][] use) {
        if (board[i][j]==word.charAt(index)&&!use[i][j]){
                use[i][j]=true;
                if (index+1==word.length()){
                    return true;
                }
                boolean result = false;
                if (i>0){
                    result = check(i-1,j,board,word,index+1,use);
                }
                if (i<board.length-1){
                    result = (result||check(i+1,j,board,word,index+1,use));
                }
                if (j>0){
                    result = result||check(i,j-1,board,word,index+1,use);
                }
                if (j<board.length-1){
                    result = result||check(i,j+1,board,word,index+1,use);
                }
                use[i][j]=false;
                return result;

        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Leetcode79 leetcode79 = new Leetcode79();
        char[][] board = {{'a','a'}};
        leetcode79.exist(board,"aaa");
    }
}
