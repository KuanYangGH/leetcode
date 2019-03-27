package medium.question236;

import java.util.ArrayList;
import java.util.List;

/**
 * Lowest Common Ancestor of a Binary Tree
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is
 * defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5,
 * since a node can be a descendant of itself according to the LCA definition.
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        findPath(root, p, path1);
        List<TreeNode> path2 = new ArrayList<>();
        findPath(root, q, path2);
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                return path1.get(i - 1);
            }
        }
        return path1.get(Math.min(path1.size(),path2.size())-1);
    }

    private boolean findPath(TreeNode root, TreeNode p, List<TreeNode> list) {
        if (p == root) {
            list.add(root);
            return true;
        }
        list.add(root);
        if (root.left != null && findPath(root.left, p, list)) return true;
        if (root.right != null && findPath(root.right, p, list)) return true;
        list.remove(list.size() - 1);
        return false;
    }

    public void test() {
        TreeNode node = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node.left = node1;
        node.right = node2;
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node2.left = node3;
        node2.right = node4;
        List<TreeNode> list = new ArrayList<>();
        System.out.println(lowestCommonAncestor(node, node, node4).val);
        System.out.println();
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
