package medium.question309;

/**
 * Best Time to Buy and Sell Stock with Cooldown
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * @author yangkuan
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int len = prices.length;
        int b0 = -prices[0],b1 = b0;
        int s0 = 0,s1 = 0,s2 = 0;
        for(int i=1;i<len;i++){
            s2 = Math.max(s1,b0+prices[i]);
            b1 = Math.max(b0,s0-prices[i]);

            b0 = b1;
            s0 = s1;
            s1 = s2;
        }
        return s2;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(new Solution().maxProfit(prices));
    }
}
