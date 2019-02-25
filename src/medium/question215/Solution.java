package medium.question215;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array. Note that it
 * is the kth largest element in the sorted order, not the kth distinct element.
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                return maxHeap.poll();
            }
            maxHeap.poll();
        }
        return -1;
    }

    public int findKthLargestByPartition(int[] nums, int k) {
        int i = 0;
        int j = nums.length - 1;
        while (true) {
            int index = partition(nums, i, j);
            if (index + k < nums.length) {
                i = index + 1;
            } else if (index + k > nums.length) {
                j = index - 1;
            }
            else {
                return nums[index];
            }
        }
    }

    private int partition(int[] nums, int start, int end) {
        int i = start - 1;
        int x = nums[end];
        for (int j = start; j <= end; j++) {
            if (nums[j] < x) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, end);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(new Solution().findKthLargest(nums, 4));
        System.out.println(new Solution().findKthLargestByPartition(nums, 4));
    }
}
