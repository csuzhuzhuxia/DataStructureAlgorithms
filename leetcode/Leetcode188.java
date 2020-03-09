public class Leetcode188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length==0)
            return 0;

        if(k >= prices.length/2){
            return quickSolver(prices);
        }

        int length = prices.length;
        int[] global = new int[k+1];
        int[] local = new int[k=1];
        for (int i = 1; i < length; i++) {
            int diff = prices[i]-prices[i-1];
            for (int j = k; j >=1 ; j--) {
                local[j] = Math.max(local[j-1]+diff,global[j-1]);
                global[j] = Math.max(global[j],local[j]);
            }
        }
        return global[k];

    }

    private int quickSolver(int[] prices) {
        int result_all=0;
        int result_one_day=0;
        for (int i = 0; i < prices.length-1; i++) {
            result_one_day = prices[i+1]-prices[i];
            if (result_one_day>0)
                result_all+=result_one_day;
        }
        return result_all;
    }

}
