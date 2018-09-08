package medium.question109;

import java.util.*;

/**
 * Convert Sorted List to Binary Search Tree
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * @author yangkuan
 * @date 2018/09/08
 */
public class Solution {


    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

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
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head = head.next;
        }
        return sortedListToBSTCore(list,0,list.size()-1);
    }
    private TreeNode sortedListToBSTCore(List<Integer> list,int beginIndex, int endIndex){
        if(beginIndex>endIndex){
            return null;
        }
        else if(beginIndex==endIndex){
            return new TreeNode(list.get(beginIndex));
        }
        TreeNode root = new TreeNode(list.get((beginIndex+endIndex+1)/2));
        root.left = sortedListToBSTCore(list,beginIndex,(beginIndex+endIndex+1)/2-1);
        root.right = sortedListToBSTCore(list,(beginIndex+endIndex+1)/2+1,endIndex);
        return root;
    }

    public void test(){
        ListNode head = new ListNode(-10);
        ListNode node1 = new ListNode(-3);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(9);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        TreeNode root = sortedListToBST(node3);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null){
                System.out.print("null ");
                continue;
            }
            System.out.print(node.val+" ");
            queue.add(node.left);
            queue.add(node.right);

        }
    }

    public static void main(String[] args) {
        new Solution().test();
    }

}
