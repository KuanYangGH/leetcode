package medium.question39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Combination Sum
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return combinations;
        }
        Arrays.sort(candidates);
        backTrack(candidates, 0, new LinkedList<>(), combinations, target);
        return combinations;
    }

    private void backTrack(int[] candidates, int start, LinkedList<Integer> combination
            , List<List<Integer>> combinations, int targrt) {
        if (targrt < 0) return;
        if (targrt == 0) {
            List<Integer> tmp = copy(combination);
            combinations.add(tmp);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            backTrack(candidates, i, combination, combinations, targrt - candidates[i]);
            combination.removeLast();
        }
    }

    private List<Integer> copy(List<Integer> copied) {
        List<Integer> copier = new ArrayList<>();
        for (Integer i : copied) {
            copier.add(i);
        }
        return copier;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = new Solution().combinationSum(candidates, target);
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
