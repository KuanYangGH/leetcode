package medium.question46;

import java.util.ArrayList;
import java.util.List;

/**
 *  Permutations
 *  Given a collection of distinct integers, return all possible permutations.
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Solution {
    /**
     *使用回溯法求解这个问题
     **/
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null){
            return result;
        }

        backTracking(nums,result,new ArrayList<Integer>());
        return result;

    }

    private void backTracking(int[] nums,List<List<Integer>> result, List<Integer> permutation){
        if(permutation.size()==nums.length){
            result.add(new ArrayList<>(permutation));
        }

        for(int i=0;i<nums.length;i++){
            if(!permutation.contains(nums[i])){
                permutation.add(nums[i]);
                backTracking(nums,result,permutation);
                permutation.remove(permutation.size()-1);
            }
        }

    }
}
