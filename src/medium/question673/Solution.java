package medium.question673;

/**
 * Number of Longest Increasing Subsequence
 * Given an unsorted array of integers, find the number of longest increasing subsequence.
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1,
 * so output 5.
 * Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 *
 * @author yangkuan
 */
public class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int longest = 0;
        int[] len = new int[n];
        int[] cnt = new int[n];
        for (int i = 0; i < nums.length; i++) {
            len[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (len[i] == len[j] + 1) {
                        cnt[i] += cnt[j];
                    } else if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            longest = Math.max(longest, len[i]);
        }
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (len[i] == longest) {
                counter += cnt[i];
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println(new Solution().findNumberOfLIS(nums));
    }
}
