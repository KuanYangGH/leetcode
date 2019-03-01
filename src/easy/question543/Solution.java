package easy.question543;

/**
 * Diameter of Binary Tree
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * Note: The length of path between two nodes is represented by the number of edges between them.
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

    /**
     * 二叉树的直径，其实就是根节点左右子树深度的和,以及左子树直径和右子树直径的最大值
     * 这种方法重复遍历节点了，不好
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter = 0;
        if (root != null) {
            diameter = depthOfBinaryTree(root.left) + depthOfBinaryTree(root.right);
            int leftDiameter = diameterOfBinaryTree(root.left);
            int rightDiameter = diameterOfBinaryTree(root.right);
            diameter = Math.max(diameter, leftDiameter);
            diameter = Math.max(diameter, rightDiameter);
        }
        return diameter;
    }

    private int depthOfBinaryTree(TreeNode root) {
        int depth = 0;
        if (root != null) {
            depth = 1 + Math.max(depthOfBinaryTree(root.left), depthOfBinaryTree(root.right));
        }
        return depth;
    }


    int maxDiameter = 0;

    /**
     * 好的方法，避免了重复遍历
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTreeWithOn(TreeNode root) {
        if (root == null) return 0;
        newDepthOfBinaryTree(root);
        return maxDiameter;
    }

    private int newDepthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = newDepthOfBinaryTree(root.left);
        int rightDepth = newDepthOfBinaryTree(root.right);
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
