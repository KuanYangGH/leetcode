package medium.question106;

/**
 * construct binary tree from inorder and post traversal
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * @author yangkuan
 * @date 2018/10/18
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null||inorder.length==0){
            return null;
        }
        return buildTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder,int inleft,int inright,int postleft,int postright){
        if(postleft>postright){
            return null;
        }
        if(postleft==postright){
            return new TreeNode(postorder[postright]);
        }
        TreeNode root = new TreeNode(postorder[postright]);
        int inIndex = findNode(inorder,postorder[postright],inleft,inright);
        root.left = buildTree(inorder,postorder,inleft,inIndex-1,postleft,postleft+(inIndex-1-inleft));
        root.right = buildTree(inorder,postorder,inIndex+1,inright,postleft+(inIndex-inleft),postright-1);
        return root;
    }
    public int findNode(int[] array,int target,int inleft,int inright){
        for(int i=inleft;i<=inright;i++){
            if(array[i]==target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder  = {9,15,7,20,3};
        new Solution().buildTree(inorder,postorder);
    }
}
