package medium.question114;

import java.util.Stack;

/**
 * Flatten Binary Tree to Linked List
 * Given a binary tree, flatten it to a linked list in-place.
 * For example, given the following tree:
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 * @author yangkuan
 * @date 2019/03/10
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
     * 先序遍历
     * @param root
     */
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);

            // node.left = pre;
            node.left = null;
            if(pre!=null) pre.right = node;
            pre = node;
        }
    }
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        flatten(root);
        System.out.println("all over");
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
