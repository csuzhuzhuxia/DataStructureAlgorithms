public class Leetcode174 {

    public int calculateMinimumHP(int[][] dungeon) {

        if (dungeon.length==0|| dungeon[0].length==0)
            return 0;
        int length1 = dungeon.length;
        int length2 = dungeon[0].length;
        int[][] dp = new int[length1][length2];
        dp[length1-1][length2-1] = Math.max(1-dungeon[length1-1][length2-1],1);

        for (int i = length1-2; i >=0 ; i--) {
            dp[i][length2-1] = Math.max(dp[i+1][length2-1]-dungeon[i][length2-1],1);
        }

        for (int i = length2-1; i >=0 ; i--) {
            dp[length1-1][i] = Math.max(dp[length1-1][i+1]-dungeon[length1-1][i],1);
        }

        for (int i = length1-2; i >=0 ; i--) {
            for (int j = length2-2; j >=0 ; j--) {
                int value1 = Math.max(dp[i+1][j]-dungeon[i][j],1);
                int value2 = Math.max(dp[i][j+1]-dungeon[i][j],1);
                dp[i][j] = Math.min(value1,value2);
            }
        }
        return dp[0][0];


//        if (dungeon.length==0||dungeon[0].length==0)
//            return 0;
//        int height = dungeon.length;
//        int width = dungeon[0].length;
//        int[][] dp = new int[height][width];
//        dp[height-1][width-1]=Math.max(1-dungeon[height-1][width-1],1);
//
//        for (int i = width-2; i >=0; i--) {
//            dp[height-1][i] = Math.max(dp[height-1][i+1]-dungeon[height-1][i],1);
//        }
//
//        for (int i = height-2; i >=0; i--) {
//            dp[i][width-1] = Math.max(dp[i+1][width-1]-dungeon[i][width-1],1);
//        }
//
//        for (int i = height-2; i >=0 ; i--) {
//            for (int j = width-2; j >=0 ; j--) {
//                dp[i][j] = Math.min(Math.max(dp[i][j+1]-dungeon[i][j],1),Math.max(dp[i+1][j]-dungeon[i][j],1));
//            }
//        }
//        return dp[0][0];

    }

    public static void main(String[] args) {
        Leetcode174 leetcode174 = new Leetcode174();
        int[][] nums = {{1,-4,5,-99},{2,-2,-2,-1}};
        leetcode174.calculateMinimumHP(nums);
    }
}
