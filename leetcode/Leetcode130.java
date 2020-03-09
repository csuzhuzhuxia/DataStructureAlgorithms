public class Leetcode130 {
    public void solve(char[][] board) {
        if (board.length==0||board[0].length==0)
            return;
        int length = board.length;
        int length_2 = board[0].length;
        for (int i = 0; i < length; i++) {
            if (board[i][0]=='0'){
                dfs(board,i,0);
            }

            if (board[i][length_2-1]=='0'){
                dfs(board,i,0);
            }
        }

        for (int i = 0; i < length_2; i++) {
            if (board[0][i]=='0'){
                dfs(board,0,i);
            }
            if (board[length-1][i]=='0'){
                dfs(board,0,i);
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length_2; j++) {
                if (board[i][j]=='#'){
                    board[i][j]='O';
                }else {
                    board[i][j]='X';
                }
            }
        }



    }

    private void dfs(char[][] board, int x, int y) {
        if (x<0||x>board.length-1||y<0||y>board[0].length-1){
            return;
        }
        if (board[x][y]=='#'){
            if (x>0){
                dfs(board,x-1,y);
            }
            if (x<board.length-1){
                dfs(board,x+1,y);
            }
            if (y>0){
                dfs(board,x,y-1);
            }
            if (y<board[0].length-1){
                dfs(board,x,y+1);
            }
        }
    }
}
