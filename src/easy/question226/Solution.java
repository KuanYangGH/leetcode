package easy.question226;

/**
 * Invert Binary Tree
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

    public TreeNode invertTree(TreeNode root) {
        if(root!=null){
            // swap
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            // recursive
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
