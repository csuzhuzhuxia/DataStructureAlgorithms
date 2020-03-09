public class Leetcode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int width =obstacleGrid[0].length;
        int[][] result = new int[height+1][width+1];
        boolean flag = true;
        for (int i = 1; i < height+1; i++) {
            if (obstacleGrid[i-1][0]==1){
                flag=false;
            }
            result[i][1]=flag?1:0;
        }

        flag = true;
        for (int i = 1; i < width+1; i++) {
            if (obstacleGrid[0][i-1]==1){
                flag=false;
            }
            result[1][i]=flag?1:0;
        }

        for (int i = 2; i < height+1; i++) {
            for (int j = 2; j < width+1; j++) {
                if (obstacleGrid[i-1][j-1]==1){
                    result[i][j]=0;
                }else {
                    result[i][j]=result[i-1][j]+result[i][j-1];
                }
            }
        }

        return result[height][width];



    }
}
