public class Leetcode64 {
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[][] result = new int[height+1][width+1];
        result[1][1]=grid[0][0];
        for (int i = 2; i < height+1; i++) {
            result[i][1]=result[i-1][1]+grid[i-1][0];
        }

        for (int i = 2; i < width+1; i++) {
            result[1][i]=result[1][i-1]+grid[0][i-1];
        }

        for (int i = 2; i < height+1; i++) {
            for (int j = 2; j < width+1; j++) {
                result[i][j] = Math.min(result[i-1][j],result[i][j-1])+grid[i-1][j-1];
            }
        }
        return result[height][width];
    }
}
