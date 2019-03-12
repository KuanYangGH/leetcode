package hard.question124;

/**
 * Binary Tree Maximum Path Sum
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node
 * in the tree along the parent-child connections. The path must contain at least one node
 * and does not need to go through the root.
 * Example 1:
 * Input: [1,2,3]
 * 1
 * / \
 * 2   3
 * Output: 6
 * Example 2:
 * Input: [-10,9,20,null,null,15,7]
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * Output: 42
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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxPathSumCore(root);
        return maxSum;
    }

    private int maxPathSumCore(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0,maxPathSumCore(root.left));
        int right = Math.max(0,maxPathSumCore(root.right));

        int sum = left + right + root.val;
        maxSum = Math.max(sum, maxSum);
        return Math.max(left, right) + root.val;
    }

    public void test(){
        TreeNode node0 = new TreeNode(-10);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(-18);
        TreeNode node6 = new TreeNode(-14);

        node0.left = node1;
        node0.right = node2;
        node2.left = node3;
        node2.right = node4;
        node3.left = node5;
        node3.right = node6;

        maxPathSum(node2);
        System.out.println(maxSum);
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
