package easy.question111;

/**
 * Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min;
        if(root.left!=null&&root.right!=null){
            int leftDepth = minDepth(root.left);
            int rightDepth = minDepth(root.right);
            min = leftDepth < rightDepth ? leftDepth + 1 : rightDepth + 1;
        }
        else if(root.right!=null){
            min = minDepth(root.right)+1;
        }
        else {
            min = minDepth(root.left)+1;
        }
        return min;
    }

    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        int min = minDepth(node1);
        System.out.print(min);
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
