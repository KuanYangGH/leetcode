package easy.question121;

/**
 * Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell
 * one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * @author yangkuan
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] leftMinPrice = new int[prices.length];
        leftMinPrice[0] = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
            leftMinPrice[i] = Math.min(leftMinPrice[i - 1], prices[i - 1]);
        }
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int profit = Math.max(0, prices[i] - leftMinPrice[i]);
            maxProfit = maxProfit > profit ? maxProfit : profit;
        }
        return maxProfit;
    }
    public int maxProfitWithOnePass(int[] prices){
        if (prices.length <= 1) return 0;
        int leftMinPrice = Integer.MAX_VALUE;
        int maxProfile = 0;
        for(int i=1;i<prices.length;i++){
            leftMinPrice = Math.min(prices[i-1],leftMinPrice);
            int currentProfile = Math.max(0,prices[i]-leftMinPrice);
            maxProfile = Math.max(currentProfile,maxProfile);
        }
        return maxProfile;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,3,4,6,5};
        System.out.println(new Solution().maxProfit(prices));
        System.out.println(new Solution().maxProfitWithOnePass(prices));
    }
}
