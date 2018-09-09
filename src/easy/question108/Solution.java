package easy.question108;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Convert Sorted Array to Binary Search Tree
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * @author yangkuan
 * @date 2018/09/09
 */
public class Solution {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return inorderTravel(nums,0,nums.length-1);
    }
    private TreeNode inorderTravel(int[] nums,int start,int endIndex){
        if(start>endIndex){
            return null;
        }

        TreeNode root = new TreeNode(nums[(start+endIndex)/2]);
        root.left = inorderTravel(nums,start,(start+endIndex)/2-1);
        root.right = inorderTravel(nums,(start+endIndex)/2+1,endIndex);

        return root;
    }
    public void test(){
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null){
                System.out.print("null ");
                continue;
            }
            System.out.print(node.val+" ");
            queue.add(node.left);
            queue.add(node.right);

        }
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
