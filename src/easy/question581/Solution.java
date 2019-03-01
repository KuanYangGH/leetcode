package easy.question581;

/**
 * Shortest Unsorted Continuous Subarray
 * Given an integer array, you need to find one continuous subarray that
 * if you only sort this subarray in ascending order, then the whole array
 * will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < nums.length - 1 && nums[l] <= nums[l + 1]) l++;
        if (l == nums.length - 1) return 0;
        while (r > 0 && nums[r] >= nums[r - 1]) r--;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            min = min < nums[i] ? min : nums[i];
            max = max < nums[i] ? nums[i] : max;
        }

        while (l >= 0 && nums[l] > min) l--;
        while (r <= nums.length - 1 && nums[r] < max) r++;
        return r - l - 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3,3};
        System.out.println(new Solution().findUnsortedSubarray(nums));
    }
}
