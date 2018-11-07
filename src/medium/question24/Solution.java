package medium.question24;

import java.util.List;

/**
 * Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * @author yangkuan
 * @date 2018/11/07
 */
public class Solution {

    /**
     *  Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode node = new ListNode(0);
        ListNode result = node;
        node.next = head;
        while (node.next!=null&&node.next.next!=null){
            swap(node);
            node = node.next.next;
        }
        return result.next;
    }
    private void swap(ListNode node){
        ListNode node1 = node.next;
        ListNode node2 = node1.next;
        ListNode node3 = node2.next;
        node.next = node2;
        node2.next = node1;
        node1.next = node3;
    }
    public ListNode test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        return swapPairs(node1);
    }
    public static void main(String[] args) {
        ListNode head = new Solution().test();
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

}
