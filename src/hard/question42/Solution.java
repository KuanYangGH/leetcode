package hard.question42;

import java.util.ArrayList;
import java.util.List;

/**
 * Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 * Thanks Marcos for contributing this image!
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class Solution {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int trappedWater = 0;
        int leftMax = 0;
        int rightMax = 0;
        for (int i = 0, j = height.length - 1; i <= j; ) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);

            if (leftMax < rightMax) {
                trappedWater += (leftMax - height[i]);
                i++;
            } else {
                trappedWater += (rightMax - height[j]);
                j--;
            }
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(height));
    }
}
