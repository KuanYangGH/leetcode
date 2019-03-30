package exercise.question3;

import java.util.Arrays;

/**
 * 排序算法
 *
 * @author yangkuan
 */
public class Solution {
    public void quickSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int begin, int end) {
        if (begin < end) {
            int index = partition(nums, begin, end);
            quickSort(nums, begin, index - 1);
            quickSort(nums, index + 1, end);
        }
    }

    private int partition(int[] nums, int begin, int end) {
        int i = begin - 1;
        int x = nums[end];
        for (int j = begin; j < end; j++) {
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

    public void mergeSort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int begin, int end) {
        if(begin<end){
            int mid = (end+begin)/2;
            mergeSort(nums,begin,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,begin,mid,end);
        }
    }

    private void merge(int[] nums, int begin, int mid, int end) {
        int[] copy = Arrays.copyOfRange(nums, begin, end + 1);
        int i = begin, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                copy[k++] = nums[i++];
            } else {
                copy[k++] = nums[j++];
            }
        }
        while (i<=mid){
            copy[k++] = nums[i++];
        }
        while (j<=end){
            copy[k++] = nums[j++];
        }
        for(i=begin;i<=end;i++){
            nums[i] = copy[i-begin];
        }
    }

    public void heapSort(int[] nums){
        if(nums==null||nums.length==0) return;
        buildMaxHeap(nums);
        for(int i=0;i<nums.length;i++){
            swap(nums,0,nums.length-1-i);
            modifyHeap(nums,0,nums.length-2-i);
        }
    }

    private void buildMaxHeap(int[] nums){
        int len = nums.length;
        for(int i=len/2-1;i>=0;i--){
            modifyHeap(nums,i,nums.length-1);
        }
    }
    private void modifyHeap(int[] nums,int i,int end){
        while (2*i+1<=end){
            int k= 2*i+1;
            if(k+1<=end&&nums[k]<nums[k+1]){
                k++;
            }
            if (nums[i] > nums[k]) break;
            swap(nums,i,k);
            i = k;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 3, 6, 1, 7};
//        new Solution().quickSort(nums);
//        new Solution().mergeSort(nums);
        new Solution().heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
