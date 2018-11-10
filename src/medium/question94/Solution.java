package medium.question94;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Inorder Traversal
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * @author yangkuan
 * @date 2018/11/10
 */
public class Solution {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        list.addAll(inorderTraversal(root.left));
        list.add(visit(root));
        list.addAll(inorderTraversal(root.right));
        return list;
    }
    private Integer visit(TreeNode node){
        return node.val;
    }

    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right=node1;
        node1.left=node2;
        List<Integer> list = inorderTraversal(root);
        for(Integer integer:list){
            System.out.print(integer+" ");
        }
    }

    public static void main(String[] args) {
        new Solution().test();
    }
}
