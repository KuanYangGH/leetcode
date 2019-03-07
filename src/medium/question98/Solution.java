package medium.question98;

import java.util.Stack;

/**
 * Validate Binary Search Tree
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * <p>
 * Input:
 * 2
 * / \
 * 1   3
 * Output: true
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 * is 5 but its right child's value is 4.
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

    /**
     * 中序遍历
     **/
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> stack = new Stack<>();

        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        TreeNode pre = null;
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();

            if(node.right!=null){
                TreeNode rightNode = node.right;
                while(rightNode!=null){
                    stack.push(rightNode);
                    rightNode = rightNode.left;
                }
            }
            if(pre!=null&&pre.val>=node.val) return false;

            pre = node;
        }
        return true;
    }
}
