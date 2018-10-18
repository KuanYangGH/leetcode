package medium.question105;

/**
 * construct binary tree from preorder and inorder traversal
 * Given preorder and inorder traversal of a tree, construct the binary tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0){
          return null;
        }
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder,int[] inorder,int preleft,int preright,int inleft,int inright){
          if(preleft>preright){
              return null;
          }
          if(preleft==preright){
              return new TreeNode(preorder[preleft]);
          }
          TreeNode root = new TreeNode(preorder[preleft]);
          int inIndex = findNode(inorder,preorder[preleft]);

          root.left = buildTree(preorder,inorder,preleft+1,preleft+(inIndex-inleft),inleft,inIndex-1);
          root.right = buildTree(preorder,inorder,preleft+(inIndex-inleft)+1,preright,inIndex+1,inright);
          return root;
    }

    public int findNode(int[] array,int target){
          for(int i=0;i<array.length;i++){
              if(array[i]==target){
                  return i;
              }
          }
          return -1;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9};
        int[] inorder = {9,3};
        new Solution().buildTree(preorder,inorder);
    }



}
