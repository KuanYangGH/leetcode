package easy.question538;

/**
 * Convert BST to Greater Tree
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such
 * that every key of the original BST is changed to the original key plus
 * sum of all keys greater than the original key in BST.
 * Example:
 * Input: The root of a Binary Search Tree like this:
 * 5
 * /   \
 * 2     13
 * <p>
 * Output: The root of a Greater Tree like this:
 * 18
 * /   \
 * 20     13
 *
 * @author yangkuan
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

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        reverseInOrderTraversal(root);
        return root;
    }

    private void reverseInOrderTraversal(TreeNode root) {
        if(root.right!=null) reverseInOrderTraversal(root.right);
        sum += root.val;
        root.val = sum;
        if(root.left!=null) reverseInOrderTraversal(root.left);
    }
}
