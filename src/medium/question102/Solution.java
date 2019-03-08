package medium.question102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  Binary Tree Level Order Traversal
 *  Given a binary tree, return the level order traversal of its nodes' values.
 *  (ie, from left to right, level by level).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rows = new ArrayList<>();
        if(root==null) return rows;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int length = 1;
        while(!queue.isEmpty()){
            List<Integer> row = new ArrayList<>();
            int tmpLength = 0;
            for(int i=0;i<length;i++){
                TreeNode node = queue.poll();
                row.add(node.val);
                if(node.left!=null) {
                    queue.add(node.left);
                    tmpLength++;
                }
                if(node.right!=null) {
                    queue.add(node.right);
                    tmpLength++;
                }
            }
            rows.add(row);
            length = tmpLength;
        }
        return rows;
    }
}
