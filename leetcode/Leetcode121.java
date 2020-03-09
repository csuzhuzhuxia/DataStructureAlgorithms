public class Leetcode121 {
    public int maxProfit(int[] prices) {
        int min =Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min>prices[i])
                min=prices[i];
            result = Math.max(prices[i]-min,result);
        }
        return result;
    }
}
