package medium.question769;

/**
 * Max Chunks To Make Sorted
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1],
 * we split the array into some number of "chunks" (partitions), and individually sort each chunk.
 * After concatenating them, the result equals the sorted array.
 * @author yangkuan
 * @date 2018/10/08
 */
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        if(arr==null||arr.length==0){
            return 0;
        }
        int[] maxs = new int[arr.length];
        maxs[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            maxs[i] = maxs[i-1]>arr[i]?maxs[i-1]:arr[i];
        }
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            if(maxs[i]==i){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,4};
        System.out.println(new Solution().maxChunksToSorted(arr));
    }
}
