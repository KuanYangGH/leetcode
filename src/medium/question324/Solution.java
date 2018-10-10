package medium.question324;

import java.util.Arrays;

/**
 * Wiggle Sort II
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * @author yangkuan
 * @date 2018/10/09
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length, m = (n+1)  >> 1;
        int[] copy = Arrays.copyOf(nums, n);
        findTopK(nums, m);
        int median = nums[m-1];

        for (int i = 0, j = 0, k = n - 1; j <= k;) {
            if (copy[j] < median) {
                swap(copy, i++, j++);
            } else if (copy[j] > median) {
                swap(copy, j, k--);
            } else {
                j++;
            }
        }
        print(copy);
        for (int i = m - 1, j = 0; i >= 0; i--, j += 2){
            nums[j] = copy[i];
        }
        for (int i = n - 1, j = 1; i >= m; i--, j += 2){
            nums[j] = copy[i];
        }
    }
    private void findTopK(int[] nums,int k){
        int beginIndex = 0;
        int endIndex = nums.length-1;
        k--;
        while (true){
            int partitionIndex=partition(nums,beginIndex,endIndex);
            if(partitionIndex<k){
                beginIndex = partitionIndex+1;
            }
            else if(partitionIndex>k){
                endIndex = partitionIndex-1;
            }
            else {
                return;
            }
        }
    }

    /*/**
     * partition the array to two part
     * @param nums
     * @param beginIndex
     * @param endIndex
     * @return
     */
    /*private int partition(int[] nums,int beginIndex,int endIndex){
        Random random = new Random();
        int index = beginIndex+random.nextInt(endIndex-beginIndex+1);
        swap(nums,index,endIndex);
        int tmp = nums[endIndex];
        int leftIndex=beginIndex;
        int rightIndex=endIndex;

        while (leftIndex<rightIndex){
            while (nums[leftIndex]<tmp&&leftIndex<rightIndex){
                leftIndex++;
            }
            while (nums[rightIndex]>=tmp&&leftIndex<rightIndex){
                rightIndex--;
            }
            if(nums[leftIndex]>tmp&&nums[rightIndex]<tmp){
                swap(nums,leftIndex,rightIndex);
            }
        }
        swap(nums,endIndex,leftIndex);
        return leftIndex;
    }*/

    private int partition(int[] nums, int l, int r) {
        int i = l;
        for (int j = l + 1; j <= r; j++) {
            if(nums[j] < nums[l]){
                swap(nums, ++i, j);
            }
        }
        swap(nums, l, i);
        return i;
    }

    private void swap(int[] nums,int idx1, int idx2){
        int tmp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = tmp;
    }

    private static void print(int[] nums){
        for(int num:nums){
            System.out.print(num+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
//        int[] nums = {1};
        int[] nums = {1, 5, 1, 1, 6, 4};
        System.out.println();
        new Solution().wiggleSort(nums);
        print(nums);
    }
}
