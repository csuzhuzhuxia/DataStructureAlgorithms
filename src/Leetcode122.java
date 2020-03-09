public class Leetcode122 {
    public int maxProfit1(int[] prices) {
        int min =Integer.MAX_VALUE;
        int result_one = 0;
        int res_all=0;
        for (int i = 0; i < prices.length; i++) {
            if (min>prices[i])
                min=prices[i];
            if (result_one>prices[i]-min){
                res_all +=result_one;
                result_one = 0;
                min = prices[i];
            }else {
                result_one = Math.max(prices[i]-min,result_one);
            }
        }
        res_all+=result_one;
        return res_all;
    }

    public int maxProfit(int[] prices) {
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
