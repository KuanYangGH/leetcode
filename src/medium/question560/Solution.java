package medium.question560;

import java.util.HashMap;
import java.util.Map;

/**
 * Subarray Sum Equals K
 * Given an array of integers and an integer k, you need to find the total number of
 * continuous subarrays whose sum equals to k.
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *
 * @author yangkuan
 */
public class Solution {
    /**
     * 暴力求解的方法
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (sum(nums, i, j) == k) {
                    count++;
                }
            }
        }
        return count;
    }

    private int sum(int[] nums, int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            s += nums[k];
        }
        return s;
    }

    /**
     * 利用hashmap保存(sum,sum出现的次数)
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumWithHash(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        // 记录sum出现的次数
        Map<Integer, Integer> preSum = new HashMap<>();
        // 和为0出现过1次
        preSum.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                count += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] nums = {-174,703,438,871,-241,781,429,-215,177,273,-628,106,235,-410,145,-793,-451,913,807,596,-982,709,585,-629,966,623,947,-467,-405,552,-858,8,-252,-128,-659,-233,-836,588,324,-817,175,-329,510,-388,878,398,231,730,66,-528,857,383,928,-924,199,-750,-868,-652,-133,408,391,685,483,-31,-986,945,271,778,-96,677,-961,-130,990,-891,-431,-317,-676,479,-919,-20,-814,3,-89,34,-292,548,201,-119,-94,-442,-934,-491,208,-722,115,527,73,636,-681,857};
        int[] nums = {1, -1, 1};
        System.out.println(new Solution().subarraySum(nums, 0));
    }
}
