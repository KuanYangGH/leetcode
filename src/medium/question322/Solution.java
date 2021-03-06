package medium.question322;

import java.util.Arrays;

/**
 * Coin Change
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * @author yangkuan
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if(dp[i-coin]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(new Solution().coinChange(coins, 11));
    }
}
