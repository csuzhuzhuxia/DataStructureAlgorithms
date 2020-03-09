import java.util.Arrays;

public class Leetcode123 {
    public int maxProfit1(int[] prices) {
        if (prices.length==0)
            return 0;

        int length = prices.length;
        int[] global = new int[3];
        int[] local = new int[3];
        for (int i = 1; i < length; i++) {
            int diff = prices[i]-prices[i-1];
            for (int j = 2; j >=0 ; j--) {
                local[j] = Math.max(local[j],global[j-1])+diff;
                global[j] = Math.max(local[j],global[j]);
            }
        }
        return global[2];
    }

    public int maxProfit(int[] prices) {
//        if (prices.length==0)
//            return 0;
//        int length = prices.length;
//        int[][] local = new int[3][length];
//        int[][] global = new int[3][length];
//
//        for (int i = 1; i < length; i++) {
//            int diff = prices[i] - prices[i-1];
//            for (int j = 1; j < 3; j++) {
//                local[j][i] = Math.max(global[j-1][i-1]+diff,local[j][i-1]+diff);
//                global[j][i] = Math.max(global[j][i-1],local[j][i]);
//            }
//        }
//        return global[2][length-1];

        if (prices.length==0)
            return 0;
        int length= prices.length;
        int[] local = new int[3];
        int[] global =  new int[3];
        for (int i = 1; i < length ; i++) {
            int diff = prices[i] - prices[i-1];
            for (int j = 2; j>=0; j--) {
                local[j] = Math.max(global[i-1],local[j])+diff;
                global[j] = Math.max(global[j],local[j]);
            }
        }
        return global[2];


//        if (prices.length==0)
//            return 0;
//        int length = prices.length;
//        int[][] global = new int[length][3];
//        int[][] local = new int[length][3];
//        for (int i = 1; i < length; i++) {
//            int diff = prices[i]-prices[i-1];
//            for (int j = 1; j < 3; j++) {
//                local[i][j] = Math.max(global[i][j-1]+Math.max(0,diff),local[i][j]+diff);
//                global[i][j] = Math.max(global[i-1][j],local[i][j]);
//            }
//        }
//        return global[length-1][2];

    }

    public static void main(String[] args) {
        Leetcode123 leetcode123 = new Leetcode123();
        int[] nums =  {3,3,5,0,0,3,1,4};

        System.out.println(nums.toString());
        leetcode123.maxProfit(nums);
    }

}
